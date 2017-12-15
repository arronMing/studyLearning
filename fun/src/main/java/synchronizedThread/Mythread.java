package synchronizedThread;

public class Mythread extends Thread {


    private static int count = 5;

    private static Object lock = new Object();

    public static void main(String args[]) {

        Mythread mythread = new Mythread();
        Thread thread1 = new Thread(mythread, "11");
        Thread thread2 = new Thread(mythread, "112");
        Thread thread3 = new Thread(mythread, "1143");
        Thread thread4 = new Thread(mythread, "115");
        Thread thread5 = new Thread(mythread, "1154");
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
        thread5.start();

    }


    @Override
    public void run() {
        synchronized (lock) {
            count--;
            System.out.println(count);
        }

    }
}
