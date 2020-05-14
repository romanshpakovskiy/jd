package by.it.Shpakovskiy._tasks_.jd02_02;

import java.util.*;

public class Store {
    private final Map<String, Double> goods;
    List<Cashier> cashiers;
    boolean isClose;
    Set<Buyer> buyers;
    Set<Basket> baskets;
    Manager manager;

    public Store(int countOfTheBasket) {
        manager = new Manager(this);
        buyers = new HashSet<>();
        baskets = new HashSet<>();

        for (int i = 0; i < countOfTheBasket; i++) {
            baskets.add(new Basket());
        }

        cashiers = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            cashiers.add(new Cashier(this, i + 1));
        }

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

    boolean isClose() {
        return buyers.size() == 0;
    }

    synchronized Basket getBasket(Basket basket) {
        if (!baskets.isEmpty()) {
            baskets.remove(basket);
            return basket;
        }
        return null;
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

    synchronized int enterTheStore(Buyer buyer) {
        if (!isClose) {
            buyers.add(buyer);
            return buyers.size();
        } else return -1;
    }

    synchronized void leaveStore(Buyer buyer) {
        buyers.remove(buyer);
    }

    void closeTheStore() {
        for (Cashier cashier : cashiers) {
            try {
                cashier.join(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            cashier.closeCashier();
        }
    }
}
