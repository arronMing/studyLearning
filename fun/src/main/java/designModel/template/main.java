package designModel.template;

public class main {

    public static void main(String args[]) {


        AbstractDisplay charDispaly = new CharDisplay('H');
        AbstractDisplay StringDisplay = new StringDisplay("Hello,world");
        charDispaly.display();
        StringDisplay.display();
    }
}
