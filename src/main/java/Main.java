import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int countBread = 56;
        int countButter = 153;
        int countSausage = 211;
        int countPatty = 45;

        HashMap<String, Integer> products = new PriceBuilder()
                .add("Хлеб", countBread)
                .add("Масло", countButter)
                .add("Колбаса", countSausage)
                .add("Пирожок", countPatty)
                .build();

        System.out.println("В МАГАЗИНЕ В НАЛИЧИИ");
        for (Map.Entry<String, Integer> productAndPrice : products.entrySet()) {
            System.out.println(productAndPrice.getKey() + " за " + productAndPrice.getValue() + " руб./шт.");
        }

        Basket basket = new Basket(products.size());

        System.out.println("Введите два слова: название товара и количество через пробел. Или end");
        Scanner scanner = new Scanner(System.in);
        try {
            while (true) {
                String line = scanner.nextLine();
                if ("end".equals(line)) break;
                String[] parts = line.split(" ");
                String product = parts[0];
                int count = Integer.parseInt(parts[1]);
                basket.addPurchase(product, count);
            }
            long sum = basket.sum(products);
            System.out.println("ИТОГО: " + sum);
        } catch (NumberFormatException exception) {
            System.out.println("Вы вводите не цифры, а что-то другое! Повторите попытку");
        }
    }
}