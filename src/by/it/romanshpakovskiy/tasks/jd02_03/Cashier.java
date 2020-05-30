package by.it.romanshpakovskiy.tasks.jd02_03;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Cashier implements Runnable {
    private static final int MAX_CASHIERS = 5;
    Store store;
    Thread thread;
    private boolean waiting;
    private final String name;
    int number;
    boolean endOfWork;
    final Object inTableMonitor = new Object();
    Lock cashiersLock = new ReentrantLock();

    Cashier(Store store, int number) {
        name = "Cashier №" + number;
        this.store = store;
        this.number = number;
        thread = new Thread(this, name);
        thread.start();
    }

    private synchronized void pause() {
        waiting = true;
        while (waiting) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    synchronized boolean wake() {
        if (waiting) {
            waiting = false;
            notify();
            if (!Runner.AS_A_TABLE) System.out.println(this + " started working");
            return true;
        } else return false;
    }

    private void serve(Buyer buyer, int lineSize) {
        buyer.buyersLock.lock();
        try {
            if (!Runner.AS_A_TABLE) System.out.println(this + " serves " + buyer.toString());
            check(this, buyer, lineSize);
            Helper.sleep(3000);
            buyer.servedCondition.signal();
        } finally {
            buyer.buyersLock.unlock();
        }
    }

    synchronized void closeCashier() {
        waiting = false;
        endOfWork = true;
        notify();
        if (!Runner.AS_A_TABLE) System.out.println(this + " closed");
    }

    @Override
    public void run() {
        while (!endOfWork) {
            Buyer buyer = store.getBuyer();
            if (buyer != null) {
                serve(buyer, store.getBuyersQueueSize());
            } else {
                pause();
            }
        }
    }

    public int getNumber() {
        synchronized (this) {
            return number;
        }
    }

    public Thread getThread(){
        return thread;
    }

    boolean isWaiting() {
        return waiting;
    }

    @Override
    public String toString() {
        return name;
    }

    String tableMarkUp(String product, Double price, Cashier cashier, int lineSize, boolean flag) {
        int n = cashier.getNumber() - 1;
        int w = Runner.CHAR_IN_COLUMN;
        StringBuilder sb = new StringBuilder();
        sb.append("│");
        for (int i = 0; i < MAX_CASHIERS; i++) {
            if (i == n) {
                sb.append(String.format(" %" + (w - 9) + "s %6.2f ", product, price)).append('│');
            } else {
                sb.append(Runner.EMPTY_COL).append('│');
            }
        }

        if (flag) {
            sb.append(String.format(" buyers count: %" + (w - 15) + "d", lineSize)).append('│');
            sb.append(String.format(" Total: %" + (w - 9) + ".2f ", store.setRevenue(price))).append('│');
            sb.append("\n").append("├").append("—".repeat(167)).append("┤");
        } else {
            sb.append(Runner.EMPTY_COL).append('│');
            sb.append(Runner.EMPTY_COL).append('│');
        }
        return sb.toString();
    }

    void check(Cashier cashier, Buyer buyer, int lineSize) {
        Basket basket = buyer.getGoods();
        String product = basket.getProd();
        List<String> output = new ArrayList<>();
        double totalSum = 0;
        while (product != null) {
            double money = store.getPrice(product);
            if (!Runner.AS_A_TABLE)
                System.out.println(cashier + " get from " + buyer + " $" + money + " per " + product);
            if (Runner.AS_A_TABLE) output.add(tableMarkUp(product, money, cashier, lineSize, false));
            totalSum += money;
            product = basket.getProd();
        }
        if (!Runner.AS_A_TABLE) System.out.println("Totally " + buyer + " spent $" + totalSum);
        if (Runner.AS_A_TABLE) output.add(tableMarkUp("Total:", totalSum, cashier, lineSize, true));
        synchronized (inTableMonitor) {
            output.forEach(System.out::println);
        }
    }
}
