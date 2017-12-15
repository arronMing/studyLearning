package concurrent;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledThreadPool {

    public static void main(String args[]) {

        ScheduledExecutorService service = Executors.newScheduledThreadPool(1);
        temp command = new temp();
        service.scheduleWithFixedDelay(command, 2, 4, TimeUnit.SECONDS);


    }
}

class temp implements Runnable {


    @Override
    public void run() {
        System.out.println("aiaiia");
    }
}