package Pojo;

import java.util.*;


/**
 * Created by Eric.Johnson on 7/5/2017.
 */
public class Shipment implements Iterable<Product> {

    private static final int LIGHT_VAN_MAX_WEIGHT = 20;
    final int PRODUCT_NOT_PRESENT = -1;

    public final List<Product> products = new ArrayList<>();
    private List<Product> lightVanProducts;
    private List<Product> heavyVanProducts;

    public void add(Product product) {
        products.add(product);
    }

    public void replace(Product oldProduct, Product newProduct) {
        final int index = products.indexOf(oldProduct);

        if (index != PRODUCT_NOT_PRESENT) {
            products.set(index, newProduct);
        }
    }

    public void prepare() {

        //sort list by weight
        products.sort(Product.BY_WEIGHT);

        // find the product index that needs the heavy van
        int splitpoint = findSplitPoint();

        // assign the views of the product list for heavy or light
        lightVanProducts = products.subList(0, splitpoint);
        heavyVanProducts = products.subList(splitpoint, products.size());
    }

    private int findSplitPoint() {
        for (int i = 0; i < products.size(); i++) {
            final Product product = products.get(i);
            if (product.getWeight() > LIGHT_VAN_MAX_WEIGHT) {
                return i;
            }
        }
        return 0;
    }

    public List<Product> getHeavyVanProducts() {
        return heavyVanProducts;
    }

    public List<Product> getLightVanProducts() {
        return lightVanProducts;
    }


    @Override
    public Iterator<Product> iterator() {
        return products.iterator();
    }
}
