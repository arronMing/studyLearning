package queue;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;

public class ConcurrentLinkedQueue {

    public static void main(String args []){


        java.util.concurrent.ConcurrentLinkedQueue<String> concurrentLinkedQueue = new java.util.concurrent.ConcurrentLinkedQueue<String>();

        concurrentLinkedQueue.offer("a");
        concurrentLinkedQueue.add("b");
        System.out.println(concurrentLinkedQueue.poll());

        ArrayBlockingQueue<String> arrayBlockingQueue = new ArrayBlockingQueue<String>(2);
        arrayBlockingQueue.add("a");
        arrayBlockingQueue.offer("b");
        System.out.println(arrayBlockingQueue.peek());

        LinkedBlockingQueue<String> linkedBlockingQueue = new LinkedBlockingQueue<String>();
        linkedBlockingQueue.add("c");
        System.out.println(linkedBlockingQueue.poll());


        final SynchronousQueue<String> synchronousQueue = new SynchronousQueue<String>();
        Thread thread1 = new Thread(new Runnable() {
            public void run() {
                try {
                    System.out.println(synchronousQueue.take());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread1.start();
        Thread thread2 = new Thread(new Runnable() {
            public void run() {
                synchronousQueue.add("a1");
            }
        });

        thread2.start();

    }
}
