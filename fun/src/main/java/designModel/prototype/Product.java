package designModel.prototype;

public interface Product extends Cloneable {


    void use(String s);

    public Product createClone();

}
