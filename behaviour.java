import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class Trades {
    enum Pairs {
        EURJPY(19), AUDJPY(25), OILUSD(290), USDJPY(400);

        private final int profit;

        Pairs(int profit) {
            this.profit = profit;
        }

        public int getProfit() {
            return profit;
        }
    }

    public interface TradesPredicate {
        boolean test(Trades trades);
    }

    public static class MuchLow implements TradesPredicate {
        public boolean test(Trades trades) {
            return trades.getProfit() < 50;
        }
    }

    public static class Higher implements TradesPredicate {
        public boolean test(Trades trades) {
            return trades.getProfit() > 100;
        }
    }

    public static List<Trades> filterTrades(List<Trades> inventory, TradesPredicate p) {
        List<Trades> result = new ArrayList<>();
        for (Trades trades : inventory) {
            if (p.test(trades)) {
                result.add(trades);
            }
        }
        return result;
    }

    public static void main(String[] args) {
       List<Trades> inventory = new ArrayList<>();
       
inventory.add(new Trades());


        List<Trades> good = filterTrades(inventory, new Higher());
        for(Trades trade:good)
            System.out.println("Better profit is " + trade.getProfit());
      
    }

    private int profit;

    public Trades() {
        this.profit = Pairs.EURJPY.getProfit(); // Example initialization, modify as needed
    }

    public int getProfit() {
        return profit;
    }
}
