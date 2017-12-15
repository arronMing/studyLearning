package designModel.AdapterModel.delegationAdapter;

public class PrintBanner implements Print {

    private Banner banner;


    public PrintBanner(String name) {
        this.banner = new Banner(name);
    }


    @Override
    public void printWeak() {
        banner.showWithAster();
    }

    @Override
    public void printStrong() {
        banner.showWithParen();
    }
}
