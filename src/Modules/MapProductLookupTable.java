package Modules;

import Modules.ProductLookupTable;
import Pojo.Product;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Eric.Johnson on 7/10/2017.
 */
public class MapProductLookupTable implements ProductLookupTable {

    private final Map<Integer, Product> idToProduct = new HashMap<>();

    @Override
    public void addProduct(final Product productToAdd){

        final int id = productToAdd.getId();

        if(idToProduct.containsKey(id)){
            throw new IllegalArgumentException("Product already Exists: " + productToAdd);
        }
        idToProduct.put(id, productToAdd);

    }

    @Override
    public  Product lookupById(final int id){
        return idToProduct.get(id);
    }
    @Override
    public void clear(){
        idToProduct.clear();
    }
}
