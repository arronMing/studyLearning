package queue;

import java.util.LinkedList;
import java.util.concurrent.atomic.AtomicInteger;

public class MyQueue {

    private final LinkedList<Object> list = new LinkedList<Object>();

    private final Object lock = new Object();

    private final AtomicInteger count = new AtomicInteger(0);

    private final int maxSize;

    private final int minSize = 0;


    public MyQueue(int maxSize) {
        this.maxSize = maxSize;
    }

    public void put(Object object) {

        synchronized (lock) {
            while (count.get() == maxSize) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }

            list.add(object);
            System.out.println("添加一个元素" + object);
            count.getAndIncrement();
            lock.notify();


        }

    }


    public Object take() {

        synchronized (lock) {

            while (count.get() == minSize) {
                try {
                    lock.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            Object object = list.getFirst();
            System.out.println("去除一个元素" + object);
            count.getAndDecrement();
            lock.notify();

            return object;
        }

    }

    public int size() {
        return count.get();
    }

    public static void main(String args[]) {

        final MyQueue queue = new MyQueue(5);
        queue.put("a");
        queue.put("b");
        queue.put("c");
        queue.put("d");
        queue.put("e");
        System.out.println("当前元素个数" + queue.size());

        Thread thread = new Thread(new Runnable() {
            public void run() {
                queue.put("f");
                queue.put("g");
            }
        });

        Thread thread1 = new Thread(new Runnable() {
            public void run() {

                try {
                    Thread.sleep(1000);
                    Object object1 = queue.take();
                    Thread.sleep(1000);
                    queue.take();

                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        });

        thread.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread1.start();

    }

}
