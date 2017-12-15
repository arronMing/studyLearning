package queuePractise;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class Provider implements Runnable {

    private BlockingQueue<Data> blockingQueue;

    private static Random random = new Random();

    private volatile boolean isrunning = true;

    private static AtomicInteger count = new AtomicInteger();

    public Provider(BlockingQueue<Data> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }

    public void run() {

        while (isrunning) {

            try {
                Thread.sleep(1000);
                int id = count.incrementAndGet();
                Data data = new Data("name" + id, String.valueOf(id));
                System.out.println("当前线程:" + Thread.currentThread().getName() + ", 获取了数据，id为:" + id + ", 进行装载到公共缓冲区中...");
                if (!blockingQueue.offer(data, 2, TimeUnit.SECONDS)) {
                    System.out.println("提交缓冲区数据失败....");
                }


            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }

    }

    public void stop() {
        isrunning = false;
    }


}
