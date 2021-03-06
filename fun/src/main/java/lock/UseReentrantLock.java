package lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class UseReentrantLock {

    private Lock lock = new ReentrantLock();

    public void method1(){

        try {

            lock.lock();
            System.out.println("当前线程:" + Thread.currentThread().getName() + "进入method1..");
            Thread.sleep(1000);
            System.out.println("当前线程:" + Thread.currentThread().getName() + "退出method1..");
            Thread.sleep(1000);

        }catch (Exception e){

        }finally {
            lock.unlock();
        }



    }

    public void method2(){

        try {
            lock.lock();
            System.out.println("当前线程:" + Thread.currentThread().getName() + "进入method2..");
            Thread.sleep(2000);
            System.out.println("当前线程:" + Thread.currentThread().getName() + "退出method2..");
            Thread.sleep(1000);
        }catch (Exception e){

        }finally {
            lock.unlock();
        }

    }

    public static void main(String args []){

        final UseReentrantLock useReentrantLock = new UseReentrantLock();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                useReentrantLock.method1();
                useReentrantLock.method2();
            }
        });
        thread.start();

    }




}
