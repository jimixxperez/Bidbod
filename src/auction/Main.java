package auction;


import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Created by user on 10.07.17.
 */

// Main programm used for the purpose of testing the bidders with different parameters.
public class Main {

    public static void main(String [] args){

        int quantity, cash, bid1, bid2;
        float p1, p2, p3;
        BinaryBidder2 bidder1, bidder2;

        cash  = 400;
        quantity = 100;

        p1 = 0.6f;
        p2 = 0.6f;

        bidder1 = new BinaryBidder2();
        bidder1.init(quantity,cash);
        
        bidder2 = new BinaryBidder2(p2,4);
        bidder2.init(quantity,cash);

        BinaryBidder bidder = new BinaryBidder(0.5f);

        int idx = 1;
        while(quantity > 0) {
            bid2 = bidder2.placeBid();
            bid1 = bidder1.placeBid();
            bidder2.bids(bid2,bid1);
            bidder1.bids(bid1,bid2);
            quantity -= 2;
            System.out.println(idx);
            idx += 1;
        }
        System.out.println("Results");
        System.out.println(bidder1.getQuantity_won());
        // System.out.println(IntStream.of(bidder1.getBids()).sum());
        System.out.println(bidder2.getQuantity_won());
        // System.out.println(IntStream.of(bidder1.getBids()).sum());

        System.out.println(Arrays.toString(bidder1.getBids()));
        System.out.println(Arrays.toString(bidder2.getBids()));
    }
}
