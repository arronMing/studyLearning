package future;

public class main {


    public static void main(String args[]) {


        FutureClient client = new FutureClient();
        Data data = client.request("我市请求参数");
        System.out.println("做其他事情");
        String result = data.getRequest();
        System.out.println(result);


    }
}
