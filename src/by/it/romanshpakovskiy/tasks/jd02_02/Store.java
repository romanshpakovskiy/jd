package by.it.romanshpakovskiy.tasks.jd02_02;

import java.util.*;

public class Store {
    List<Cashier> cashiers;
    boolean isClose;
    private final Set<Buyer> buyers;
    private final LinkedList<Basket> baskets;
    final Manager manager;
    BuyersQueue buyersQueue;
    Product product;

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

        product = new Product();
    }

    String getProduct() {
        return product.getRandomGoods();
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

    public boolean close() {
        return buyers.size() == 0;
    }
}