package designModel.buildModel;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class HtmlBuilder implements Builder {

    private String fileName;
    private PrintWriter printWriter;

    public void makeTitle(String title) {
        fileName = title + ".html";
        try {
            printWriter = new PrintWriter(new FileWriter(fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }

        printWriter.println("<html><head><title>" + title + "</title></head><body>");
        printWriter.println("<h1>" + title + ">h1<");
    }

    public void makeString(String data) {
        printWriter.println("<p>" + data + "<p>");
    }

    public void makeItems(String[] items) {


        printWriter.println("<u1>");
        for (String item : items) {

            printWriter.println("<li>" + item + "</li>");
        }

        printWriter.println("<u1>");


    }

    public void cloes() {


        printWriter.println("</body></html>");
        printWriter.close();
    }

    public String getResult() {
        return fileName;
    }
}
