package designModel.FactoryModel;

public class main {

    public static void main(String args[]) {

        Factory factory = new IdcardFactory();
        Product card1 = factory.create("小明");
        Product card2 = factory.create("小刚");
        card1.use();
        card2.use();


    }

}
