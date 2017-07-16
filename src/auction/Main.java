package auction;


import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Created by user on 10.07.17.
 */
public class Main {

    public static void main(String [] args){

        int quantity, cash, bid3, bid4;
        float p1, p2, p3;
        BinaryBidder bidder1, bidder2;

        cash  = 400;
        quantity = 200;

        p1 = 0.4f;
        p2 = 0.4f;
        p3 = 0.5f;


        BinaryBidder2 bidder3 = new BinaryBidder2(p2,2);
        bidder3.init(quantity,cash);

        BinaryBidder2 bidder4 = new BinaryBidder2(p3,3);
        bidder4.init(quantity,cash);

        BinaryBidder bidder = new BinaryBidder(0.5f);

        int idx = 1;
        while(quantity > 0) {
            bid4 = bidder4.placeBid();
            bid3 = bidder3.placeBid();
            bidder4.bids(bid4,bid3);
            bidder3.bids(bid3,bid3);
            quantity -= 2;
            System.out.println(idx);
            idx += 1;
        }
        System.out.println("Results");
        System.out.println(bidder3.getQuantity_won());
        /*System.out.println(IntStream.of(bidder1.getBids()).sum());*/
        System.out.println(bidder4.getQuantity_won());
        /*System.out.println(IntStream.of(bidder3.getBids()).sum());*/

        System.out.println(Arrays.toString(bidder4.getBids()));
        System.out.println(Arrays.toString(bidder3.getBids()));
    }
}
