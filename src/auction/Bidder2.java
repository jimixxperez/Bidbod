package auction;

/**
 * Created by user on 14.07.17.
 */
public class Bidder2 implements BidActions{

    private int quantity, cash;
    private float p;
    private int bid0, bid1;
    private int idx = 0;
    private int[] bids;
    private int quantity_won;

    private int[] own_serie;
    private int[] other_serie;

    public void init(int quantity, int cash) {

    }

    public int placeBid() {
        return 0;
    }

    public void bids(int own, int other) {

    }
}
