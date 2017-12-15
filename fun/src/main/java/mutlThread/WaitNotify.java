package mutlThread;

import java.util.ArrayList;
import java.util.List;

public class WaitNotify {


    private volatile List<String> list = new ArrayList<String>();

    public void add() {
        list.add("adafa");
    }

    public int getSize() {
        return list.size();
    }

    public static void main(String args[]) {

        final Object lock = new Object();
        final WaitNotify list1 = new WaitNotify();
        Thread thread1 = new Thread(new Runnable() {
            public void run() {
                synchronized (lock) {
                    System.out.println(Thread.currentThread().getName() + "开始了");
                    for (int i = 0; i < 10; i++) {
                        list1.add();
                        System.out.println(Thread.currentThread().getName() + "添加");
                        try {
                            Thread.sleep(500);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                        if (list1.getSize() == 5) {
                            System.out.println("已经发出通知..");
                            lock.notify();
                        }
                    }


                }


            }
        });

        Thread thread2 = new Thread(new Runnable() {
            public void run() {
                synchronized (lock) {
                    System.out.println(Thread.currentThread().getName() + "开始了");
                    if (list1.getSize() != 5) {
                        try {
                            lock.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                    }
                    System.out.println("当前线程：" + Thread.currentThread().getName() + "收到通知线程停止..");
                    throw new RuntimeException();
                }
            }
        });
        thread2.start();
        thread1.start();

    }


}
