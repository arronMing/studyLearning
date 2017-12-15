package designModel.bridgeModel;

public class Display {

    public Display(DisplayImpl imp){
        this.imp = imp;
    }

    private DisplayImpl imp;

    public void open(){
        imp.rawOpen();
    }

    public void cloes(){
        imp.rawClose();
    }

    public void pring(){
        imp.rawPrint();
    }

    public void display(){
        open();
        pring();
        cloes();

    }
}


