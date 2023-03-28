import java.util.HashMap;

public class PriceBuilder {

    HashMap<String, Integer> productsMap;

    public PriceBuilder() {
        productsMap = new HashMap<>();
    }

    public PriceBuilder add(String title, int value) {
        productsMap.put(title, value);
        return this;
    }

    public HashMap<String, Integer> build() {
        return productsMap;
    }
}
