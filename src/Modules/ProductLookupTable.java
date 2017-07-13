package Modules;

import Pojo.Product;

/**
 * Created by Eric.Johnson on 7/6/2017.
 */
public interface ProductLookupTable {

    Product lookupById(int id);

    void addProduct(Product productToAdd);

    void clear();

}
