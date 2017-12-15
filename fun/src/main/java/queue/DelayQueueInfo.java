package queue;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class DelayQueueInfo implements Delayed {


    private String name;

    private String id;

    private long endTime;

    private TimeUnit timeUnit = TimeUnit.SECONDS;

    public DelayQueueInfo(String name, String id, long endTime) {
        this.name = name;
        this.id = id;
        this.endTime = endTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(long endTime) {
        this.endTime = endTime;
    }

    public long getDelay(TimeUnit unit) {
        return getEndTime() - System.currentTimeMillis();
    }

    public int compareTo(Delayed o) {
        DelayQueueInfo delayQueueInfo = (DelayQueueInfo) o;
        return this.getDelay(this.timeUnit) - delayQueueInfo.getDelay(this.timeUnit) > 0 ? 1 : 0;
    }
}
