package concurrent.threadpoolconn1;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class usethreadpool {


    public static void main(String args[]) {

        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 2, 60,
                TimeUnit.SECONDS, new ArrayBlockingQueue<Runnable>(3),
                //new ThreadPoolExecutor.DiscardPolicy()
                new Mypolice());


        myTask myTask1 = new myTask(1, "task1");
        myTask myTask2 = new myTask(2, "task2");
        myTask myTask3 = new myTask(3, "task3");
        myTask myTask4 = new myTask(4, "task4");
        myTask myTask5 = new myTask(5, "task5");
        myTask myTask6 = new myTask(6, "task6");
        myTask myTask7 = new myTask(7, "task7");

        threadPoolExecutor.execute(myTask1);
        threadPoolExecutor.execute(myTask2);
        threadPoolExecutor.execute(myTask3);
        threadPoolExecutor.execute(myTask4);
        threadPoolExecutor.execute(myTask5);
        threadPoolExecutor.execute(myTask6);
        threadPoolExecutor.execute(myTask7);
        threadPoolExecutor.shutdown();


    }

}
