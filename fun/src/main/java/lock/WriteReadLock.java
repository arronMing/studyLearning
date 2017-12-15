package lock;

import java.util.concurrent.locks.ReentrantReadWriteLock;

public class WriteReadLock {


    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();

    private ReentrantReadWriteLock.ReadLock readLock = lock.readLock();

    private ReentrantReadWriteLock.WriteLock writeLock = lock.writeLock();


    public void read() {

        readLock.lock();
        System.out.println("当前线程:" + Thread.currentThread().getName() + "进入...");
        try {
            Thread.sleep(3000);
            System.out.println("当前线程:" + Thread.currentThread().getName() + "退出...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            readLock.unlock();
        }

    }

    public void write() {

        writeLock.lock();
        System.out.println("当前线程:" + Thread.currentThread().getName() + "进入...");
        try {
            Thread.sleep(3000);
            System.out.println("当前线程:" + Thread.currentThread().getName() + "退出...");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            writeLock.unlock();
        }

    }

    public static void main(String args[]) {


        final WriteReadLock urrw = new WriteReadLock();

        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                urrw.read();
            }
        }, "t1");
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                urrw.read();
            }
        }, "t2");
        Thread t3 = new Thread(new Runnable() {
            @Override
            public void run() {
                urrw.write();
            }
        }, "t3");
        Thread t4 = new Thread(new Runnable() {
            @Override
            public void run() {
                urrw.write();
            }
        }, "t4");

//        t1.start();
//        t2.start();

//        t3.start();
//        t4.start();

        t1.start();
        t3.start();

    }

}
