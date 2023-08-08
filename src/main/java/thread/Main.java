package thread;

public class Main {
    public static void main(String[] args) {
        Processor p = new Processor();
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    p.produce();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    p.consume();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
            }
        });
        t1.start();
        t2.start();
    }
}

class Processor{
    public void produce() throws InterruptedException{
        synchronized (this){
            System.out.println("started producing...");
            wait();
            System.out.println("ended producing...");
        }
    }
    public void consume() throws InterruptedException{
        synchronized (this){
            System.out.println("started consuming...");
            notify();
            Thread.sleep(2000);
            System.out.println("ended consuming...");
        }
    }
}