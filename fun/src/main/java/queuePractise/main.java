package queuePractise;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;

public class main {


    public static void main(String args[]) {

        BlockingQueue<Data> blockingQueue = new LinkedBlockingDeque<Data>(10);
        Provider provider1 = new Provider(blockingQueue);
        Provider provider2 = new Provider(blockingQueue);
        Provider provider3 = new Provider(blockingQueue);

        Consumer consumer1 = new Consumer(blockingQueue);
        Consumer consumer2 = new Consumer(blockingQueue);
        Consumer consumer3 = new Consumer(blockingQueue);

        ExecutorService service = Executors.newCachedThreadPool();
        service.execute(provider1);
        service.execute(provider2);
        service.execute(provider3);
        service.execute(consumer1);
        service.execute(consumer2);
        service.execute(consumer3);

        try {
            Thread.sleep(3000);
            provider1.stop();
            provider2.stop();
            provider3.stop();
            Thread.sleep(2000);


        } catch (InterruptedException e) {
            e.printStackTrace();
        }


    }

}
