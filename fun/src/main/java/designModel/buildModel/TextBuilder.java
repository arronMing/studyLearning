package designModel.buildModel;

public class TextBuilder implements Builder {


    private StringBuffer sb = new StringBuffer();

    public void makeTitle(String title) {

        sb.append("=============\n");
        sb.append("["+title+"]\n");
        sb.append("\n");

    }

    public void makeString(String data) {

        sb.append("#"+data+"\n");
        sb.append("\n");

    }

    public void makeItems(String[] items) {

        for(String item:items){
            sb.append("  '"+item+"\n");
        }
        sb.append("\n");

    }

    public void cloes() {

        sb.append("=============\n");

    }

    public String getResult(){
        return sb.toString();
    }
}
