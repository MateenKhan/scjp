import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class InnerSingleton {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i = 0; i < 10; i++) {

            System.out.println(i);
            executorService.submit(() -> Singleton.getInstance());
        }
        executorService.shutdown();

    }
}

class Singleton {
    private Singleton instance;

    private static class Helper {
        static Singleton parent = new Singleton();
    }

    private Singleton() {
        System.out.println("constructor invoked");
    }

    public static Singleton getInstance() {
        return Helper.parent;
    }
}

