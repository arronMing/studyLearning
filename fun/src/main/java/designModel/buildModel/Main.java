package designModel.buildModel;

public class Main {

    public static void main(String args []){






            TextBuilder builder = new TextBuilder();
            Durector durector = new Durector(builder);
            durector.construct();;
            String result = builder.getResult();
            System.out.println(result);
            HtmlBuilder htmlBuilder = new HtmlBuilder();
            Durector durector1 = new Durector(htmlBuilder);
            durector.construct();
            String result1 = htmlBuilder.getResult();
            System.out.println(result1);
    }

}
