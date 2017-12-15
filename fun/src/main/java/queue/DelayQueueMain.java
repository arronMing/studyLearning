package queue;

import java.util.concurrent.DelayQueue;

public class DelayQueueMain implements Runnable {

    private DelayQueue<DelayQueueInfo> queue = new DelayQueue<DelayQueueInfo>();

    private boolean running = true;

    public void shangji(String name, String id, int money) {
        DelayQueueInfo info = new DelayQueueInfo(name, id, 1000 * money + System.currentTimeMillis());
        this.queue.add(info);
        System.out.println("姓名" + name + "身份证号码" + id + "交钱" + money + "开始上机");
    }

    public void xiaji(DelayQueueInfo info) {
        System.out.println("姓名" + info.getName() + "身份证号码" + info.getName() + "时间到下机");

    }

    public void run() {
        while (running) {

            try {
                DelayQueueInfo inf = queue.take();
                xiaji(inf);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }

    public static void main(String args[]) {

        DelayQueueMain delayQueueMain = new DelayQueueMain();
        Thread thread = new Thread(delayQueueMain);
        thread.start();

        delayQueueMain.shangji("小明", "111", 1);
        delayQueueMain.shangji("小王", "222", 10);
        delayQueueMain.shangji("小李", "333", 5);

    }

}
