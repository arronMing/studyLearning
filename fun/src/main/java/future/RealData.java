package future;

public class RealData implements Data {

    private String result;

    public RealData(String data) {

        System.out.println("根据" + data + "进行查询，这是一个很耗时的按操作");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("查询结束");
        result = "我是返回结果";
    }

    public String getRequest() {
        return result;
    }
}
