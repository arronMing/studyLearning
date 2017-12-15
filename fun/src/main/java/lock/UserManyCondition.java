package lock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class UserManyCondition {


    private ReentrantLock lock = new ReentrantLock();

    private Condition condition1 = lock.newCondition();

    private Condition condition2 = lock.newCondition();

    public void m1() {

        lock.lock();
        System.out.println("当前线程" + Thread.currentThread().getName() + "进入方法m1等待");
        try {
            condition1.await();
            System.out.println("当前线程" + Thread.currentThread().getName() + "进入方法m1继续");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }


    }

    public void m2() {
        lock.lock();
        System.out.println("当前线程" + Thread.currentThread().getName() + "进入方法m2等待");
        try {
            condition1.await();
            System.out.println("当前线程" + Thread.currentThread().getName() + "进入方法m2继续");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void m3() {
        lock.lock();
        System.out.println("当前线程" + Thread.currentThread().getName() + "进入方法m3等待");
        try {
            condition2.await();
            System.out.println("当前线程" + Thread.currentThread().getName() + "进入方法m3继续");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }

    public void m4() {
        lock.lock();
        try {
            condition1.signalAll();
            System.out.println("当前线程" + Thread.currentThread().getName() + "进入方法m4唤醒");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }


    public void m5() {
        lock.lock();
        try {
            condition2.signal();
            System.out.println("当前线程" + Thread.currentThread().getName() + "进入方法m5唤醒");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }


    public static void main(String args[]) {

        final UserManyCondition userManyCondition = new UserManyCondition();
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                userManyCondition.m1();
            }
        }, "m1");
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                userManyCondition.m2();
            }
        }, "m2");
        Thread thread3 = new Thread(new Runnable() {
            @Override
            public void run() {
                userManyCondition.m3();
            }
        }, "m3");
        Thread thread4 = new Thread(new Runnable() {
            @Override
            public void run() {
                userManyCondition.m4();
            }
        }, "m4");
        Thread thread5 = new Thread(new Runnable() {
            @Override
            public void run() {
                userManyCondition.m5();
            }
        }, "m5");

        thread1.start();
        thread2.start();
        thread3.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread4.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        thread5.start();


    }


}
