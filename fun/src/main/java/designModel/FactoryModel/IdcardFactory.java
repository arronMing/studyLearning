package designModel.FactoryModel;

import java.util.ArrayList;
import java.util.List;

public class IdcardFactory extends Factory {

    private List<String> list = new ArrayList<String>();

    Product createProduct(String name) {
        return new IdCard(name);
    }

    void registerProduct(Product product) {
        list.add(((IdCard) product).getName());
    }
}
