package Pojo;

/**
 * Created by Eric.Johnson on 7/5/2017.
 */
public class ProductFixtures {

    public static Product door = new Product(1, "Wooden Door", 35);
    public static Product floorPanel = new Product(2, "Floor Panel", 35);
    public static Product window = new Product(3, "Glass Window", 35);

    public  static Supplier bobs = new Supplier("Bob's household supplies");
    public  static Supplier kates = new Supplier("Kate's Home Goods");

    static
    {
        bobs.products().add(door);
        bobs.products().add(floorPanel);

        kates.products().add(floorPanel);
    }
}
