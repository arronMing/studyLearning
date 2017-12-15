package designModel.bridgeModel;

public class test {

    public static void main(String args []){

        DisplayImpl display = new StringDisplayImpl("aimingkun");
        Display d = new Display(display);
        d.display();
        Display dd = new CountDisplay(display );
        CountDisplay countDisplay = new CountDisplay(display);
        countDisplay.multipleDisplay(5);

    }
}
