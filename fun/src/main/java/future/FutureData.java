package future;

public class FutureData implements Data {

    private RealData realData;

    private boolean isReady = false;

    public synchronized void setRealData(RealData data) {

        if (isReady) {
            return;
        }

        this.realData = data;
        isReady = true;
        notify();


    }


    public synchronized String getRequest() {

        while (!isReady) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }

        return this.realData.getRequest();
    }
}
