package by.it.romanshpakovskiy.tasks.jd02_02;

import java.util.ArrayList;
import java.util.List;

public class Buyer extends Thread implements IBuyer, IUseBasket, Runnable {
    int buyerNum;
    boolean pensioneer;
    private final Store store;
    Basket basket;
    List<String> product;

    Buyer(Store store, int buyerNum) {
        this.buyerNum = buyerNum;
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
        return actualBuyersCount >= 0;
    }

    @Override
    public void takeBasket() {
        if (store.getBasketsSize() == 0) {
            Thread.yield();
        }
        basket = store.getBasket(basket);
    }

    @Override
    public void chooseGoods() {
        int basketGoods = Helper.getRandomValue(1, 4);
        for (int i = 0; i < basketGoods; i++) {
            product.add(store.getRandomGoods());
            sleepBuyer(30, 70);
        }
    }

    @Override
    public void putGoodsToTheBasket() {
        for (String s : product) {
            basket.putGoods(s);
            sleepBuyer(30, 50);
        }
    }

    @Override
    public void getInQueue() {
        store.inQueue(this);
        synchronized (this) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    synchronized Basket getGoods() {
        sleepBuyer(100, 200);
        return basket;
    }

    @Override
    synchronized public void goOut() {
        store.putBasketBack(basket);
        store.leaveStore(this);
    }

    @Override
    public String toString() {
        return this.getName();
    }
}