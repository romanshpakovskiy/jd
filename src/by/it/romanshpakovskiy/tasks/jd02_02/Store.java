package by.it.romanshpakovskiy.tasks.jd02_02;

import java.util.*;

public class Store {
    List<Cashier> cashiers;
    private final Map<String, Double> goods;
    boolean isClose;
    private Set<Buyer> buyers;
    private LinkedList<Basket> baskets;
    final Manager manager;
    BuyersQueue buyersQueue;

    public Store(int countOfTheBasket) {
        manager = new Manager(this);
        buyers = new HashSet<>();
        baskets = new LinkedList<>();
        buyersQueue = new BuyersQueue();
        cashiers = new ArrayList<>();

        for (int i = 0; i < countOfTheBasket; i++) {
            baskets.add(new Basket());
        }

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

    synchronized Buyer getBuyer() {
        return buyersQueue.nextBuyer();
    }

    synchronized Basket getBasket() {
        if (!baskets.isEmpty()) {
            Basket basket = baskets.iterator().next();
            if (basket != null) {
                baskets.remove(basket);
                return basket;
            }
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

    void enterBuyersQueue(Buyer buyer) {
        if (!manager.isWork()) {
            synchronized (manager) {
                manager.notify();
            }
        }
        buyersQueue.enterQueue(buyer);
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

    int getBuyersQueueSize() {
        return buyersQueue.getSize();
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

    synchronized void putBasketBack(Basket basket) {
        baskets.add(basket);
    }

    synchronized boolean isBasket() {
        return !baskets.isEmpty();
    }
}
