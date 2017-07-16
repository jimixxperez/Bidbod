package auction;

import java.util.Random;
import java.util.stream.IntStream;

/**
 * Created by user on 14.07.17.
 */
public class BinaryBidder2 extends BinaryBidder {


    public BinaryBidder2(float p, int bid0) {
        this.p = p;
        this.bid0 = bid0;
    }


    @Override
    public void init(int quantity, int cash) {
        this.quantity = quantity;
        this.cash = cash;
        this.p = p;
        this.bid0 = bid0;
        this.bid1 = (int) (cash * 2/ (quantity * p)) - (int) ((1.0f-p) * bid0/p) ;
        this.bids = new int[(int) (quantity/2)];

        for (int i=0; i < (int) quantity/2; i++) {
            if (i < p * quantity/2) {
                this.bids[i] = this.bid1;
            } else {
                this.bids[i] = this.bid0;
            }
        }
        Random random = new Random();
        IntStream.range(0,random.nextInt(15)).forEach(n -> BinaryBidder.shuffleArray(this.bids));

    }

}
