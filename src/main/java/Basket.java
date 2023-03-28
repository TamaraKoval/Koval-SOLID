import java.util.Map;

public class Basket {

    protected Purchase[] purchases;
    protected final int SIZE;

    public Basket(int priceLength) {
        SIZE = priceLength;
        purchases = new Purchase[SIZE];
    }

    public void addPurchase(String title, int count) {
        for (int i = 0; i < purchases.length; i++) {
            if (purchases[i] == null) {
                purchases[i] = new Purchase(title, count);
                return;
            }
            if (purchases[i].title.equals(title)) {
                purchases[i].count += count;
                return;
            }
        }
    }

    public long sum(Map<String, Integer> prices) {
        long sum = 0;
        System.out.println("КОРЗИНА:");
        for (int i = 0; i < purchases.length; i++) {
            if (purchases[i] == null) continue;
            Purchase purchase = purchases[i];
            long purchaseValue = (long) purchase.count * prices.get(purchase.title);
            System.out.println("\t" + purchase.title + " " + purchase.count + " шт. в сумме " + purchaseValue + " руб.");
            sum += purchaseValue;
        }
        return sum;
    }
}
