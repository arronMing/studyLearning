package mutlThread;

import java.util.ArrayList;
import java.util.List;

public class Volatile {

    private volatile List<String> list = new ArrayList<String>(20);

    public void add() {
        list.add("ada");
    }

    public int getSize() {
        return list.size();
    }

    public static void main(String args[]) {

        final Volatile list1 = new Volatile();
        Thread thread1 = new Thread(new Runnable() {
            public void run() {
                for (int i = 0; i < 10; i++) {

                    list1.add();
                    System.out.println("这是第" + i + "个元素");
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }


            }
        });

        Thread thread2 = new Thread(new Runnable() {
            public void run() {

                while (true) {
                    if (list1.getSize() == 5) {
                        System.out.println("线程" + Thread.currentThread().getName());
                        throw new RuntimeException();

                    }
                }

            }
        }, "aaaaa");


        thread1.start();
        thread2.start();


    }


}
