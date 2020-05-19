package by.it.romanshpakovskiy.tasks.jd02_02;

import java.util.*;

public class Product {
    private final Map<String, Double> goods;

    Product() {
        goods = new HashMap<>();
        goods.put("potato", 3.0);
        goods.put("salad", 3.5);
        goods.put("pasta", 2.5);
        goods.put("tomato", 3.5);
        goods.put("cucumber", 1.5);
        goods.put("carrot", 2.8);
        goods.put("milk", 2.3);
        goods.put("banana", 3.2);
    }

    public String getRandomGoods() {
        List<String> keysList = new ArrayList<>(goods.keySet());
        int randomKeys = new Random().nextInt(keysList.size());
        return keysList.get(randomKeys);
    }

    public double getPrice(String product) {
        for (Map.Entry<String, Double> entry : goods.entrySet()) {
            if (entry.getKey().equals(product)) {
                return entry.getValue();
            }
        }
        return 0;
    }
}
