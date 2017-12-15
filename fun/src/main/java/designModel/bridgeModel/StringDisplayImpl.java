package designModel.bridgeModel;

public class StringDisplayImpl extends DisplayImpl {


    private String data;

    private int width;

    public StringDisplayImpl(String data ){
        this.data =data;
        width = data.length();
    }

    @Override
    public void rawOpen() {
printLine();
    }

    @Override
    public void rawClose() {
        printLine();
    }

    @Override
    public void rawPrint() {
        System.out.println("|"+data+"|");
    }

    private void printLine(){
        System.out.print("+");
        for(int i=0;i<width;i++){
            System.out.print("-");
        }

        System.out.println("+");


    }
}
