package designModel.AdapterModel.inheritAdapter;

public class PrintBanner extends Banner implements Print {

    public PrintBanner(String name) {
        super(name);
    }


    @Override
    public void printWeak() {
        showWithAster();
    }

    @Override
    public void printStrong() {
        showWithParen();
    }
}
