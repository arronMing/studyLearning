package designModel.AbstractFactory.factory;

import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public abstract class Page {

    protected String title;

    protected String author;

    protected List content = new ArrayList();


    public Page(String title, String author) {

        this.title = title;
        this.author = author;
    }

    public void add(Item item) {
        content.add(item);
    }

    public void output() {

        String fileName = title + ".html";
        try {
            Writer writer = new FileWriter(fileName);
            writer.write(this.makeHTML());
            writer.close();
            System.out.println(fileName + "编写完成");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public abstract String makeHTML();


}
