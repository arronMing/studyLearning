package designModel.AbstractFactory;

import designModel.AbstractFactory.factory.Factory;
import designModel.AbstractFactory.factory.Link;
import designModel.AbstractFactory.factory.Page;
import designModel.AbstractFactory.factory.Tray;

public class main {


    public static void main(String args[]) {


        Factory factory = Factory.getFactory("AbstractFactory.implement.ListFactory");

        Link people = factory.createLink("人民日报", "wwwwwwwwwww");
        Link gmw = factory.createLink("光明日报", "wwwaaaa");

        Link yahu = factory.createLink("雅虎", "wwwwwwwwwww");
        Link sohu = factory.createLink("搜狐", "wwwaaaa");


        Tray traynews = factory.createTray("日报");
        traynews.add(people);
        traynews.add(gmw);

        Tray traysousuo = factory.createTray("搜索引擎");
        traysousuo.add(yahu);
        traysousuo.add(sohu);

        Page page = factory.createPage("LinkPage", "arron");
        page.add(traynews);
        page.add(traysousuo);

        page.output();

    }
}
