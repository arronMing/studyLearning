package concurrent;

import java.util.Random;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Cyclebarrier {

    static class Runner implements Runnable {

        private CyclicBarrier barrier;

        private String name;

        public Runner(CyclicBarrier barrier, String name) {
            this.barrier = barrier;
            this.name = name;
        }

        @Override
        public void run() {

            try {
                Thread.sleep(1000 * (new Random().nextInt(5)));
                System.out.println(name + "准备就绪");
                barrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
            System.out.println(name + "开始");
        }
    }

    public static void main(String args[]) {

        ExecutorService service = Executors.newFixedThreadPool(3);
        CyclicBarrier cyclicBarrier = new CyclicBarrier(3);
        Runner runner1 = new Runner(cyclicBarrier, "11111");
        Runner runner2 = new Runner(cyclicBarrier, "22222");
        Runner runner3 = new Runner(cyclicBarrier, "33333");
        service.execute(runner1);
        service.execute(runner2);
        service.execute(runner3);
        service.shutdown();

    }


}
