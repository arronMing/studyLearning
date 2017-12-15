package mutlThread;

public class DirtyReadThread  {

    private int count = 4;

    public synchronized  void print(String data) throws InterruptedException {

        if ("a".equals(data)) {

            Thread.sleep(4000);
            count = 100;
            System.out.println("aaaa" + count);
        } else {
            count = 200;
            System.out.println("bbbb" + count);
        }


    }

    public synchronized  int  getCount() {
       return  count;
    }

    public static void main(String args[]) throws InterruptedException {


        final DirtyReadThread ddd = new DirtyReadThread();
        Thread thread = new Thread(new Runnable() {
            public void run() {
                try {
                    ddd.print("a");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
    thread.start();
    Thread.sleep(2000);
    System.out.println(ddd.getCount());


    }

}
