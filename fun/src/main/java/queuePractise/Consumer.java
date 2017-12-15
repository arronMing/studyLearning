package queuePractise;

import java.util.Random;
import java.util.concurrent.BlockingQueue;

public class Consumer implements Runnable {


    private BlockingQueue<Data> blockingQueue;

    private static Random random = new Random();

    public Consumer(BlockingQueue<Data> blockingQueue) {
        this.blockingQueue = blockingQueue;
    }


    public void run() {

        while (true) {

            try {
                Data data = blockingQueue.take();
                Thread.sleep(random.nextInt(1000));
                System.out.println("当前消费线程：" + Thread.currentThread().getName() + "， 消费成功，消费数据为id: " + data.getId());

            } catch (InterruptedException e) {
                e.printStackTrace();
            }


        }


    }
}
