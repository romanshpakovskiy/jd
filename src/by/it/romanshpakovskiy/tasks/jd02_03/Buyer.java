package by.it.romanshpakovskiy.tasks.jd02_03;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Buyer extends Thread implements IBuyer, IUseBasket {
    boolean pensioneer;
    private final Store store;
    private Basket basket;
    private String product;
    ReentrantLock buyersLock = new ReentrantLock();
    Condition servedCondition = buyersLock.newCondition();

    Buyer(Store store, int buyerNum) {
        this.setName("Buyer №" + buyerNum + " ");
        this.store = store;
        pensioneer = Math.random() < 0.25;
        start();
    }

    public boolean isPensioneer() {
        return pensioneer;
    }

    public void sleepBuyer(int from, int to) {
        if (pensioneer) to = (int) (to * 1.5);
        Helper.getRandomValue(from, to);
    }

    @Override
    public void run() {
        if (enterToTheMarket()) {
            takeBasket();
            int countGoods = Helper.getRandomValue(1, 4);
            for (int i = 0; i < countGoods; i++) {
                chooseGoods();
                putGoodsToTheBasket();
            }
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
        if (!Runner.AS_A_TABLE) System.out.println(this + " started choosing");
        product = store.getRandomGoods();
        sleepBuyer(125, 500);
        if (!Runner.AS_A_TABLE) System.out.println(this + " finished choosing");
    }

    @Override
    public void putGoodsToTheBasket() {
        basket.putGoods(product);
        sleepBuyer(125, 500);
        if (!Runner.AS_A_TABLE) System.out.println(this + " put " + product + " at basket " + basket.getSize());
    }

    @Override
    public void getInQueue() {
        buyersLock.lock();
        try {
            store.enterBuyersQueue(this);
            if (!Runner.AS_A_TABLE) System.out.println(this + " stood in queue");
            servedCondition.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            buyersLock.unlock();
        }
    }

    Basket getGoods() {
        if (!Runner.AS_A_TABLE) System.out.println(this + " took goods");
        return basket;
    }

    @Override
    public void goOut() {
        store.putBasketBack(basket);
        store.leaveStore(this);
        if (!Runner.AS_A_TABLE) System.out.println(this + " gone");
    }

    @Override
    public String toString() {
        return this.getName();
    }
}