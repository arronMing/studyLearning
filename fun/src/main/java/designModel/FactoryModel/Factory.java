package designModel.FactoryModel;

public abstract class Factory {


    abstract Product createProduct(String name);

    abstract void registerProduct(Product product);

    public final Product create(String name) {

        Product p = createProduct(name);
        registerProduct(p);
        return p;

    }


}
