package designModel.prototype;

public class UnderlinePen implements Product {


    private String data;

    public UnderlinePen(String data) {
        this.data = data;
    }


    public void use(String s) {

        int length = s.length();
        System.out.println(s);
        for (int i = 0; i < length; i++) {
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
