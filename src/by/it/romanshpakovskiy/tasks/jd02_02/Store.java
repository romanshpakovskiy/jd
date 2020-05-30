package by.it.romanshpakovskiy.tasks.jd02_02;

import java.util.*;

public class Store {
    private List<Cashier> cashiers;
    private final Map<String, Double> goods;
    boolean isClosed;
    private Set<Buyer> buyers;
    private LinkedList<Basket> baskets;
    final Manager manager;
    static final int CASHIERS_COUNT = 5;
    BuyersQueue buyersQueue;
    private double revenue;
    private int totalBuyersCount;

    public Store(int countOfTheBasket) {
        manager = new Manager(this);
        buyers = new HashSet<>();
        baskets = new LinkedList<>();
        buyersQueue = new BuyersQueue();
        cashiers = new ArrayList<>();

        for (int i = 0; i < countOfTheBasket; i++) {
            baskets.add(new Basket());
        }

        for (int i = 0; i < CASHIERS_COUNT; i++) {
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

    public List<Cashier> getCashiers() {
        return cashiers;
    }

    int getTotalBuyersCount() {
        return totalBuyersCount;
    }

    public double getRevenue() {
        return revenue;
    }

    synchronized double setRevenue(double revenue) {
        return this.revenue += revenue;
    }

    synchronized Buyer getBuyer() {
        return buyersQueue.nextBuyer();
    }

    synchronized Basket getBasket() {
        if (!baskets.isEmpty()) {
            return baskets.pollFirst();
        }
        return null;
    }

    public String getRandomGoods() {
        int num = Helper.getRandomValue(0, goods.size() - 1);
        Iterator<String> it = goods.keySet().iterator();
        for (int i = 0; i < num; i++) {
            it.next();
        }
        return it.next();
    }

    public double getPrice(String product) {
        for (Map.Entry<String, Double> entry : goods.entrySet()) {
            if (entry.getKey().equals(product)) {
                return entry.getValue();
            }
        }
        return 0;
    }

    synchronized void enterBuyersQueue(Buyer buyer) {
        if (!manager.isWork()) {
            synchronized (manager) {
                manager.notify();
            }
        }
        buyersQueue.enterQueue(buyer);
    }

    synchronized int enterTheStore(Buyer buyer) {
        if (!isClosed) {
            buyers.add(buyer);
            totalBuyersCount++;
            return buyers.size();
        } else return -1;
    }

    public synchronized int buyersCount() {
        return buyers.size();
    }

    synchronized void leaveStore(Buyer buyer) {
        buyers.remove(buyer);
    }

    int getBuyersQueueSize() {
        return buyersQueue.getSize();
    }

    void closeTheStore() {
        cashiers.forEach(cashier -> {
            Thread thread = cashier.getThread();
            try {
                while (thread.isAlive()) {
                    thread.join(10);
                    cashier.closeCashier();
                }
            } catch (InterruptedException e) {
                System.err.println("InterruptedException " + e.getMessage());
            }
        });
    }

    synchronized void putBasketBack(Basket basket) {
        baskets.add(basket);
    }

    synchronized boolean isBasket() {
        return !baskets.isEmpty();
    }

    boolean closed() {
        if (buyers.size() == 0) {
            isClosed = true;
            return true;
        }
        return false;
    }

}
