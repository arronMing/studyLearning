package designModel.AbstractFactory.implement;

import designModel.AbstractFactory.factory.Item;
import designModel.AbstractFactory.factory.Tray;

import java.util.Iterator;

public class ListTray extends Tray {

    public ListTray(String caption) {
        super(caption);
    }

    public String makeHTML() {

        StringBuilder sb = new StringBuilder();
        sb.append("<li>\n");
        sb.append(caption + "\n");
        sb.append("<ul>\n");
        Iterator iterator = tray.iterator();
        while (iterator.hasNext()) {
            Item item = (Item) iterator.next();
            sb.append(item.makeHTML());
        }

        sb.append("</ul>\n");
        sb.append("</li>\n");

        return sb.toString();
    }
}
