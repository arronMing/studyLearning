package designModel.prototype;

import java.util.HashMap;
import java.util.Map;

public class Manager {

    private Map<String, Product> map = new HashMap<String, Product>();

    public void register(String name, Product product) {

        map.put(name, product);

    }

    public Product create(String name) {

        Product p = map.get(name);
        return p.createClone();

    }


}
