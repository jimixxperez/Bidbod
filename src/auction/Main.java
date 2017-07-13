package auction;
import auction.Bidder;

import java.util.Arrays;

/**
 * Created by user on 10.07.17.
 */
public class Main {

    public static void main(String [] args){

        int quantity, cash, bid1, bid2;
        float p1, p2;
        Bidder bidder1, bidder2;

        cash  = 200;
        quantity = 100;

        p1 = 0.5f;
        p2 = 0.5f;

        bidder1 = new Bidder();
        bidder1.init(quantity,cash, p1);
        bidder2 = new Bidder();
        bidder2.init(quantity,cash, p2);

        int idx = 1;
        while(quantity > 0) {
            bid1 = bidder1.placeBid();
            bid2 = bidder2.placeBid();
            bidder1.bids(bid1,bid2);
            bidder2.bids(bid2,bid1);
            quantity -= 2;
            System.out.println(idx);
            idx += 1;
        }
        System.out.println("Results");
        System.out.println(bidder1.getQuantity_won());
        System.out.println(bidder2.getQuantity_won());

        System.out.println(Arrays.toString(bidder1.getBids()));
        System.out.println(Arrays.toString(bidder2.getBids()));
    }
}
