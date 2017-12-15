package designModel.AbstractFactory.implement;

import designModel.AbstractFactory.factory.Factory;
import designModel.AbstractFactory.factory.Link;
import designModel.AbstractFactory.factory.Page;
import designModel.AbstractFactory.factory.Tray;

public class ListFactory extends Factory {
    public Link createLink(String caption, String url) {
        return new ListLink(url, caption);
    }

    public Tray createTray(String caption) {
        return new ListTray(caption);
    }

    public Page createPage(String title, String author) {
        return new ListPage(title, author);
    }
}
