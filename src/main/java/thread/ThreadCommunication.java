package thread;

public class ThreadCommunication {
    public static void main(String[] args) {
        try{
            Process p = new Process();
            Thread t1 = new Thread(new Runnable(){
                @Override
                public void run() {
                    try {
                        System.out.println("started thread-"+Thread.currentThread().getName());
                        p.produce();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            });
            Thread t2 = new Thread(new Runnable(){
                @Override
                public void run() {
                    try {
                        System.out.println("started thread-"+Thread.currentThread().getName());
                        p.consume();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                }
            });
            t1.start();
            t2.start();
//            t1.join();
//            t2.join();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
class Process{

    public void produce() throws InterruptedException{
        synchronized (this){
            System.out.println("started producing");
            wait();
            System.out.println("ended producing");
        }
    }

    public void consume() throws InterruptedException{
        synchronized (this){
            System.out.println("started consuming");
            Thread.sleep(1000);
            notify();
            System.out.println("ended consuming");
        }
    }
}