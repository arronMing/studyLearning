package future;

public class FutureClient {


    public Data request(final String requestData) {

        final FutureData futureData = new FutureData();
        new Thread(new Runnable() {
            public void run() {
                RealData realData = new RealData(requestData);
                futureData.setRealData(realData);

            }
        }).start();
        return futureData;
    }

}
