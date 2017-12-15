package designModel.FactoryModel;

public class IdCard extends Product {

    private String name;

    public IdCard(String name) {
        this.name = name;
        System.out.println("生成实例" + name);

    }

    void use() {
        System.out.println(" 使用实例" + name);

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
