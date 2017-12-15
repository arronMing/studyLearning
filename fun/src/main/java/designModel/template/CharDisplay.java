package designModel.template;

public class CharDisplay extends AbstractDisplay {

    private char data;

    public CharDisplay(char data) {
        this.data = data;
    }

    void open() {
        System.out.print("<<");
    }

    void print() {
        System.out.print(data);
    }

    void close() {
        System.out.println(">>");
    }
}
