package Modules;

import Pojo.Product;
import Pojo.ProductFixtures;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by Eric.Johnson on 7/10/2017.
 */
public class ViewsOVerMaps {
    public static void main(String[] args) {

        final Map<Integer, Product> idToProduct = new HashMap<>();
        idToProduct.put(1, ProductFixtures.door);
        idToProduct.put(2, ProductFixtures.floorPanel);
        idToProduct.put(3, ProductFixtures.window);

        System.out.println(idToProduct);
        System.out.println();

        final Set<Integer> ids = idToProduct.keySet();
        System.out.println(ids);

        //remove by id , cant Add
        ids.remove(1);
        System.out.println(ids);
        System.out.println(idToProduct);

        final Collection<Product> products = idToProduct.values();
        System.out.println(products);

        //remove by value , cant Add
        products.remove(ProductFixtures.floorPanel);
        System.out.println(products);
        System.out.println(ids);

        final Set<Map.Entry<Integer,Product>> entries = idToProduct.entrySet();
        for(Map.Entry<Integer, Product> entry :entries){
            System.out.println(entry);
        }
    }
}
