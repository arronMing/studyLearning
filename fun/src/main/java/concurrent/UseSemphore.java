package concurrent;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

public class UseSemphore {


    public static void main(String args []){

        final Semaphore semaphore = new Semaphore(5);
        ExecutorService service = Executors.newCachedThreadPool();
        for(int i=0;i<20;i++){

            final int  no = i;
            Runnable run = new Runnable() {
                @Override
                public void run() {
                    try {
                        semaphore.acquire();
                        System.out.println("线程"+no);
                        Thread.sleep(5000);
                        semaphore.release();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            };
            service.execute(run);


        }
        service.shutdown();



    }
}
