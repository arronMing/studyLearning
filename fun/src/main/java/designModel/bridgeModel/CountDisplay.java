package designModel.bridgeModel;

public class CountDisplay extends Display
{
    public CountDisplay(DisplayImpl display){
        super(display);
    }

    public void multipleDisplay(int times){
        open();
        for(int i=0;i<times;i++){

            pring();
        }
        cloes();

    }

}
