package auction;

import java.util.Random;
import java.util.stream.IntStream;

/**
 * Created by user on 10.07.17.
 *
 */

// Methods that needs to be implemented in the class
interface BidActions {
    public void init(int quantity, int cash);
    public int placeBid();
    public void bids(int own, int other);
}


 // BinaryBidder: A bidder that generates a distribution of two possible bid values:
 // bid0 = 0 and bid1 whose value depends on the set probability p.
public class BinaryBidder implements BidActions{

    protected int quantity, cash;
    protected float p;
    protected int bid0, bid1;
    protected int idx = 0;
    protected int[] bids; // Array containing all bid values for the entire game
    protected int quantity_won;

    // Constructor with default parameters
    public BinaryBidder() {
        this.p = 0.6f;
    }

    // Alternative constructor
    public BinaryBidder(float p) {
        this.p = p;
    }

    // Initiate important state parameters and bids array,
    // followed by a shuffle of the array
    public void init(int quantity, int cash) {
        this.quantity = quantity;
        this.cash = cash;
        this.bid0 = 0;
        this.bid1 = (int) (cash/ (quantity * p));
        this.bids = new int[(int) (quantity/2)];

        for (int i=0; i < (int) quantity/2; i++) {
            if (i <= p * quantity/2) {
                this.bids[i] = this.bid1;
            } else {
                this.bids[i] = this.bid0;
            }
        }
        Random random = new Random();
        IntStream.range(0,random.nextInt(15)).forEach(n -> BinaryBidder.shuffleArray(bids));
    }

    // Places bids for each turn
    public int placeBid() {
        int bid;
        if (this.cash - this.bids[this.idx] >= 0) {
            bid = this.bids[this.idx];
        } else {
            bid = 0;
        }
        this.idx += 1;
        this.cash -= bid;
        this.quantity -= 2;
        return bid;
    }

    // Update the number of won quantities on each turn
    public void bids(int own, int other){
        if (own > other) {
            this.quantity_won += 2;
        } else if (own == other){
            this.quantity_won += 1;
        } else {

        }
    }

    public int getCash(){
        return this.cash;
    }

    public int getQuantity_won() { return this.quantity_won;}

    public int getQuantity(){
        return this.quantity;
    }

    public int[] getBids(){
        return this.bids;
    }

    // Fisher-Yates shuffle function
    public static void shuffleArray(int[] array)
    {
        int index;
        Random random = new Random();
        for (int i = array.length - 1; i > 0; i--)
        {
            index = random.nextInt(i + 1);
            if (index != i)
            {
                array[index] ^= array[i];
                array[i] ^= array[index];
                array[index] ^= array[i];
            }
        }
    }

}

