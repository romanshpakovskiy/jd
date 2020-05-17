package by.it.romanshpakovskiy.tasks.jd02_02;

import java.util.ArrayList;
import java.util.List;

public class Buyer extends Thread implements IBuyer, IUseBasket {
    boolean pensioneer;
    private final Store store;
    private Basket basket;
    private List<String> product;

    Buyer(Store store, int buyerNum) {
        this.setName("Buyer №" + buyerNum + " ");
        this.store = store;
        product = new ArrayList<>();
        basket = new Basket();
        pensioneer = Math.random() < 0.25;
        start();
    }

    public boolean isPensioner() {
        return pensioneer;
    }

    public void sleepBuyer(int from, int to) {
        if (pensioneer)
            to = (int) (to * 1.5);
        Helper.getRandomValue(from, to);
    }

    @Override
    public void run() {
        while (enterToTheMarket()) {
            takeBasket();
            chooseGoods();
            putGoodsToTheBasket();
            getInQueue();
            goOut();
        }
    }

    @Override
    public boolean enterToTheMarket() {
        int actualBuyersCount = store.enterTheStore(this);
        if (actualBuyersCount >= 0) {
            if (!Runner.AS_A_TABLE) System.out.println(this + " entered the store");
            return true;
        } else {
            if (!Runner.AS_A_TABLE) System.out.println(this + " didn't visit the store");
            return false;
        }
    }

    @Override
    public void takeBasket() {
        if (!Runner.AS_A_TABLE) System.out.println(this + " waits for basket");
        while (true) {
            basket = store.getBasket();
            if (basket != null) {
                break;
            }
            Thread.yield();
        }
        if (!Runner.AS_A_TABLE) System.out.println(this + " took basket");
        sleepBuyer(500, 2000);
    }

    @Override
    public void chooseGoods() {
        int basketGoods = Helper.getRandomValue(1, 4);
        if (!Runner.AS_A_TABLE) System.out.println(this + " started choosing of goods");
        for (int i = 0; i < basketGoods; i++) {
            product.add(store.getRandomGoods());
            sleepBuyer(125, 500);
        }
        if (!Runner.AS_A_TABLE) System.out.println(this + " finished choosing of goods");
    }

    @Override
    public void putGoodsToTheBasket() {
        for (String s : product) {
            basket.putGoods(s);
            sleepBuyer(125, 500);
        }
        if (!Runner.AS_A_TABLE) System.out.println(this + " put" + product + " at basket");
    }

    @Override
    public void getInQueue() {
        store.enterBuyersQueue(this);
        if (!Runner.AS_A_TABLE) System.out.println(this + " stood in queue");
        synchronized (this) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        sleepBuyer(500, 2000);
    }

    synchronized Basket getGoods() {
        if (!Runner.AS_A_TABLE) System.out.println(this + " took goods");
        sleepBuyer(500, 2000);
        return basket;
    }

    @Override
    synchronized public void goOut() {
        store.putBasketBack(basket);
        store.leaveStore(this);
        if (!Runner.AS_A_TABLE) System.out.println(this + " gone");
    }

    @Override
    public String toString() {
        return this.getName();
    }
}