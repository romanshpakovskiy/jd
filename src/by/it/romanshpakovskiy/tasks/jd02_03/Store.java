package by.it.romanshpakovskiy.tasks.jd02_03;

import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class Store {
    private final ArrayList<Cashier> cashiers;
    private final ConcurrentHashMap<String, Double> goods;
    private AtomicBoolean isClosed = new AtomicBoolean(false);
    private final CopyOnWriteArraySet<Buyer> buyers;
    private final ConcurrentLinkedDeque<Basket> baskets;
    private final Manager manager;
    static final int CASHIERS_COUNT = 5;
    private final BuyersQueue buyersQueue;
    private AtomicInteger revenue = new AtomicInteger(0);
    private AtomicInteger totalBuyersCount = new AtomicInteger(0);
    ReentrantLock lock = new ReentrantLock();
    ExecutorService executorService;

    public Store(int countOfTheBasket) {
        manager = new Manager(this);
        buyers = new CopyOnWriteArraySet<>();
        baskets = new ConcurrentLinkedDeque<>();
        buyersQueue = new BuyersQueue();
        cashiers = new ArrayList<>();

        for (int i = 0; i < countOfTheBasket; i++) {
            baskets.add(new Basket());
        }

        executorService = Executors.newCachedThreadPool();
        for (int i = 0; i < CASHIERS_COUNT; i++) {
            Cashier cashier = new Cashier(this, i + 1);
            cashiers.add(cashier);
            executorService.execute(cashier);
        }
        executorService.shutdown();

        goods = new ConcurrentHashMap<>();
        goods.put("potato", 3.0);
        goods.put("salad", 3.5);
        goods.put("pasta", 2.5);
        goods.put("tomato", 3.5);
        goods.put("cucumber", 1.5);
        goods.put("carrot", 2.8);
        goods.put("milk", 2.3);
        goods.put("banana", 3.2);
    }

    public ArrayList<Cashier> getCashiers() {
        return cashiers;
    }

    int getTotalBuyersCount() {
        return totalBuyersCount.get();
    }

    public double getRevenue() {
        return revenue.doubleValue();
    }

    double setRevenue(double revenue) {
        return this.revenue.addAndGet((int) revenue);
    }

    Buyer getBuyer() {
        return buyersQueue.nextBuyer();
    }

    Basket getBasket() {
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

    void enterBuyersQueue(Buyer buyer) {
        if (!manager.isWork() && buyers.size() <= 20) {
            synchronized (manager) {
                manager.notify();
            }
        }
        buyersQueue.enterQueue(buyer);
    }

    synchronized int enterTheStore(Buyer buyer) {
        if (!isClosed.get()) {
            buyers.add(buyer);
            totalBuyersCount.incrementAndGet();
            return buyers.size();
        } else return -1;
    }

    public int buyersCount() {
        return buyers.size();
    }

    void leaveStore(Buyer buyer) {
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
                e.printStackTrace();
            }
        });
    }

    void putBasketBack(Basket basket) {
        baskets.add(basket);
    }

    boolean isBasket() {
        return !baskets.isEmpty();
    }

    boolean isClosed() {
        if (buyers.size() == 0) {
            isClosed.getAndSet(true);
            return true;
        }
        return false;
    }
}
