package Pojo;


/**
 * Created by Eric.Johnson on 7/6/2017.
 */
public class Customer {

    public static final Customer JACK = new Customer("Jack");
    public static final Customer JILL = new Customer("Jill");
    public static final Customer MARY = new Customer("Mary");
    private final String name;

    public Customer(String name) {
        this.name = name;
    }

    public void reply(final String message){
        System.out.printf("%s: %s\n", name, message);
    }
}
