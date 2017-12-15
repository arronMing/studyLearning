package designModel.buildModel;

public class Durector {

    private Builder builder;

    public Durector(Builder builder) {
        this.builder = builder;
    }

    public void construct() {

        builder.makeTitle("Greeting");
        builder.makeString("从早上至下午");
        builder.makeItems(new String[]{"早上好", "下午好"});
        builder.makeString(" 晚睡");
        builder.makeItems(new String[]{"晚上好", "晚安", "再见"});


    }
}
