package designModel.AbstractFactory.implement;

import designModel.AbstractFactory.factory.Link;

public class ListLink extends Link {


    public ListLink(String url, String caption) {
        super(url, caption);
    }

    public String makeHTML() {


        return "<li><a href=\"" + url + "\">" + caption + "</a></li>\n";
    }
}
