package Modules;

import Pojo.Product;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * Created by Eric.Johnson on 7/5/2017.
 */
public class CollectionConcepts {
    public static void main(String[] args) {

        Product door = new Product(1, "Wooden Door", 35);
        Product floorPanel = new Product(2, "Floor Panel", 25);
        Product window = new Product(3, "Glass Window", 10);

        Collection<Product> products = new ArrayList<>();
        products.add(door);
        products.add(floorPanel);
        products.add(window);

        // outdated , no need to do this unless you need to modify at same time
        final Iterator<Product> productIterator = products.iterator();
        while (productIterator.hasNext()) {
            Product product = productIterator.next();
            if (product.getWeight() > 20) {
                System.out.println(product);
            } else {
                productIterator.remove();
            }
        }
        System.out.println("Final List" + products);
        System.out.println(products.size());
        System.out.println(products.isEmpty());
        System.out.println(products.contains(window));
        System.out.println(products.contains(door));

        Collection<Product> otherProducts = new ArrayList<>();
        otherProducts.add(window);
        otherProducts.add(door);

        products.removeAll(otherProducts);

        System.out.println(products);


        // For each built in , remaining products however, if using this to modify, you will run into concurrent exceptions
        for (Product product : products) {
            System.out.println(product);
        }

    }
}


