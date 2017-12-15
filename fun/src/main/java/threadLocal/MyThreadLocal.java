package threadLocal;

public class MyThreadLocal {

    private ThreadLocal<String> local = new ThreadLocal<String>();

    public void setLocal(String data) {
        local.set(data);
    }

    public String getLocal() {
        return local.get();
    }


    public static void main(String args[]) {

        final MyThreadLocal local1 = new MyThreadLocal();

        Thread thread = new Thread(new Runnable() {


            public void run() {

                local1.setLocal("name");
                System.out.println(local1.getLocal());

            }
        });


        Thread thread1 = new Thread(new Runnable() {
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(local1.getLocal());
            }
        });

        thread.start();
        thread1.start();


    }


}
