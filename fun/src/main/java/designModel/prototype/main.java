package designModel.prototype;

public class main {


    public static void main(String args[]) {


        Manager manager = new Manager();
        MessageBox box1 = new MessageBox("*");
        MessageBox box2 = new MessageBox("#");
        UnderlinePen underlinePen = new UnderlinePen("_");
        manager.register("box1", box1);
        manager.register("box2", box2);
        manager.register("under", underlinePen);
        manager.create("box1").use("hello world");
        manager.create("box2").use("hello world");
        manager.create("under").use("hello world");


    }

}
