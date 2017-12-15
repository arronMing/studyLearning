package concurrent;

import java.util.concurrent.*;

public class UseFuture implements Callable<String> {
    @Override
    public String call() throws Exception {

        Thread.sleep(6000);

        return "aaaaaaaaaa";
    }

    public static void main(String args[]) throws ExecutionException, InterruptedException {

        UseFuture future = new UseFuture();
        ExecutorService service = Executors.newFixedThreadPool(1);
        FutureTask<String> task = new FutureTask<String>(future);
        Future future1 = service.submit(task);
        System.out.println("111111111");
        System.out.println(task.get());
        service.shutdown();


    }

}
