package designModel.template;

public class StringDisplay extends AbstractDisplay {

    private String data;

    private int width;

    public StringDisplay(String data) {

        this.data = data;
        this.width = data.length();
    }


    void open() {
        printLine();
    }

    void print() {
        System.out.println("|" + data + "|");
    }

    void close() {
        printLine();
    }

    private void printLine() {

        System.out.print("+");
        for (int i = 0; i < width; i++) {
            System.out.print("#");
        }
        System.out.println("+");


    }
}
