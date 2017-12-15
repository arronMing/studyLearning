package concurrent;

public class CountDownLatch {


    static class Runner1 implements Runnable{

        private java.util.concurrent.CountDownLatch countDownLatch;

        public Runner1(java.util.concurrent.CountDownLatch countDownLatch) {
            this.countDownLatch = countDownLatch;
        }

        @Override
        public void run() {

            try {
                System.out.println("线程一进入");
                countDownLatch.await();
                System.out.println("线程一继续执行");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
    static class Runner2 implements Runnable{

        private java.util.concurrent.CountDownLatch countDownLatch;

        public Runner2 (java.util.concurrent.CountDownLatch countDownLatch) {
            this.countDownLatch = countDownLatch;
        }

        @Override
        public void run() {

            System.out.println("线程二进入");
            countDownLatch.countDown();
            System.out.println("线程二继续执行");

        }
    }
    static class Runner3 implements Runnable{

        private java.util.concurrent.CountDownLatch countDownLatch;

        public Runner3 (java.util.concurrent.CountDownLatch countDownLatch) {
            this.countDownLatch = countDownLatch;
        }

        @Override
        public void run() {

            System.out.println("线程3进入");
            countDownLatch.countDown();
            System.out.println("线程3继续执行");

        }
    }

    public  static void main(String args []){

        java.util.concurrent.CountDownLatch countDownLatch = new java.util.concurrent.CountDownLatch(2);
        Thread thread1 = new Thread(new Runner1(countDownLatch));
        Thread thread2 = new Thread(new Runner2(countDownLatch));
        Thread thread3 = new Thread(new Runner3(countDownLatch));
        thread1.start();
        thread2.start();
        thread3.start();


    }

}
