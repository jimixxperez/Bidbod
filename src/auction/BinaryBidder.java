package auction;

import java.util.Random;
import java.util.stream.IntStream;

/**
 * Created by user on 10.07.17.
 *
 */
interface BidActions {
    public void init(int quantity, int cash);
    public int placeBid();
    public void bids(int own, int other);
}



public class BinaryBidder implements BidActions{

    protected int quantity, cash;
    protected float p;
    protected int bid0, bid1;
    protected int idx = 0;
    protected int[] bids;
    protected int quantity_won;


    public void init(int quantity, int cash) {
        this.quantity = quantity;
        this.cash = cash;
        this.p = 0.6f;
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

    public void init(int quantity, int cash, float p) {
        this.quantity = quantity;
        this.cash = cash;
        this.p = p;
        this.bid0 = 0;
        this.bid1 = (int) (cash * 2/ (quantity * p));
        this.bids = new int[(int) (quantity/2)];

        for (int i=0; i < (int) quantity/2; i++) {
            if (i <= p * quantity/2) {
                this.bids[i] = bid1;
            } else {
                this.bids[i] = bid0;
            }
        }

        Random random = new Random();
        System.out.println(random.nextInt(15));
        IntStream.range(0,random.nextInt(15)).forEach(n -> BinaryBidder.shuffleArray(bids));
    }

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


    public void bids(int own, int other){
        /*System.out.print(own);
        System.out.print(other);*/
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

