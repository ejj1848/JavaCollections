package Pojo;

import java.util.*;
import static Pojo.Product.BY_WEIGHT;

/**
 * Created by Eric.Johnson on 7/5/2017.
 */
public class ProductCatalogue implements Iterable<Product> {

//    private final Set<Product> products = new HashSet<>();

    private final SortedSet<Product> products = new TreeSet<>(BY_WEIGHT);

    public Set<Product> lightVanProducts(){
        Product heaviestLightVanProduct = findHeaviestLightVanProduct();
        return products.headSet(heaviestLightVanProduct);
    }

    public Set<Product> heavyVanProducts(){
        Product heaviestLightVanProduct = findHeaviestLightVanProduct();
        return products.headSet(heaviestLightVanProduct);
    }


    private Product findHeaviestLightVanProduct() {
        for(Product product: products){
            if(product.getWeight()>20)
            {
                return product;
            }
        }
        return products.last();
    }


    public void isSuppliedBy(Supplier supplier)
    {
        products.addAll(supplier.products());
    }


    @Override
    public Iterator<Product> iterator() {
        return products.iterator();
    }
}
