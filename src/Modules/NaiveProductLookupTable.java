package Modules;

import Pojo.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Eric.Johnson on 7/6/2017.
 */
public class NaiveProductLookupTable implements ProductLookupTable {

    private List<Product> products = new ArrayList<>();

    @Override
    public Product lookupById(int id) {
        for(Product product: products){
            if(product.getId() == id){
                return  product;
            }
        }
        return null;
    }

    @Override
    public void addProduct(Product productToAdd) {
       for(Product product: products){
           if(product.getId() == productToAdd.getId()){
               throw new IllegalArgumentException("Unable to add , product already Exists: " + productToAdd);
           }
       }
        products.add(productToAdd);
    }

    @Override
    public void clear() {
        products.clear();
    }
}
