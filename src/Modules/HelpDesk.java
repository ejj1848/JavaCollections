package Modules;

import Pojo.Category;
import Pojo.Customer;
import Pojo.Enquiry;

import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.function.Predicate;

/**
 * Created by Eric.Johnson on 7/6/2017.
 */
public class HelpDesk {

    Comparator<Enquiry> BY_CATEGORY =
            (Enquiry eq1,  Enquiry eq2) ->
            eq1.getCategory().compareTo(eq2.getCategory());


    private Queue<Enquiry> enquiries = new PriorityQueue<>(BY_CATEGORY);
    // Deque
//    private  Queue<Enquiry> enquiries = new ArrayDeque<>();

    public boolean enquire(final Customer customer, final Category category){

        return enquiries.offer(new Enquiry(customer, category));
    }

    public void processPrinterEnquiry(){
        processEnquiry(
                enq -> enq.getCategory() == Category.PRINTER,
                "Is it out of Paper");
    }

    public void processGeneralEnquiry(){

        processEnquiry(
                enq -> enq.getCategory() != Category.PRINTER,
                "Have you tried doing something else?");

    }

    private void processEnquiry(Predicate<Enquiry> predicate, String message) {
        final Enquiry enquiry = enquiries.peek();
        if(enquiry != null && predicate.test(enquiry)){
            enquiries.remove();

            enquiry.getCustomer().reply(message);
        }
        else {
            System.out.println("No work to do, lets go to lunch");
        }
    }

    public void processAllEnquiries(){

        final String message = "Have you tried doing something better?";
        Enquiry enquiry;

        while ((enquiry = enquiries.poll()) != null){
            enquiry.getCustomer().reply(message);
        }

        // remove vs poll
//        while(!enquiries.isEmpty()) {
//            final Enquiry enquiry = enquiries.remove();
//            enquiry.getCustomer().reply("Have you tried turning it on and off?");
//        }
    }

    public static void main(String[] args) {
        HelpDesk helpDesk = new HelpDesk();

        helpDesk.enquire(Customer.JACK , Category.PHONE);
        helpDesk.enquire(Customer.JILL , Category.PRINTER);
        helpDesk.enquire(Customer.MARY , Category.COMPUTER);

        helpDesk.processAllEnquiries();
    }
}
