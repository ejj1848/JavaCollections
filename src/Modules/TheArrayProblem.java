package Modules;

import Pojo.Product;

import java.util.Arrays;

/**
 * Created by Eric.Johnson on 7/5/2017.
 */
public class TheArrayProblem {
    public static void main(String[] args) {

        Product door = new Product(1, "Wooden Door", 35);
        Product floorPanel = new Product(2, "Floor Panel", 25);

        //Create
        Product[] products = {door, floorPanel};
        //Print
        System.out.println(Arrays.toString(products));
        //Add
        final Product window = new Product(1, "Window", 15);
        products = add(window,products);
        System.out.println(Arrays.toString(products));
        //Duplicate (Cant Create Constraints of Uniqueness)
        products= add(window, products);
        System.out.println(Arrays.toString(products));

    }

    private static Product[] add(Product product, Product[] array){
        int length = array.length;
        Product[] newArray = Arrays.copyOf(array, length + 1);
        newArray[length] = product;
        return newArray;
    }

}
