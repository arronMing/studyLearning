package designModel.prototype;

public class MessageBox implements Product {

    private String data;

    public MessageBox(String data) {
        this.data = data;
    }

    public void use(String s) {

        int length = s.length();

        for (int i = 0; i < length + 4; i++) {
            System.out.print(data);
        }
        System.out.println("");
        System.out.println(data + " " + s + " " + data);
        for (int i = 0; i < length + 4; i++) {
            System.out.print(data);
        }
        System.out.println("");

    }

    public Product createClone() {


        Product p = null;
        try {
            p = (Product) this.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return p;
    }
}
