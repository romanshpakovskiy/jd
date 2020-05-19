package by.it.romanshpakovskiy.tasks.jd02_02;

import java.util.ArrayList;
import java.util.List;

public class Cashier extends Thread {
    private static final int MAX_CASHIERS = 5;
    private static final int COLUMN_COUNT = 7;
    Store store;
    boolean waiting;
    private final String name;
    int number;
    boolean endOfWork;
    final Object inTableMonitor = new Object();

    Cashier(Store store, int number) {
        this.store = store;
        this.number = number;
        name = "Cashier №" + number;
        Thread thread = new Thread(this, name);
        thread.start();
    }

    boolean isWaiting() {
        return waiting;
    }

    private synchronized void pause() {
        waiting = true;
        if (!isWaiting()) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    synchronized void wake() {
        if (isWaiting()) {
            waiting = false;
            notify();
            if (!Runner.AS_A_TABLE) System.out.println(this + " started working");
        }
    }

    private void serve(Buyer buyer, int lineSize) {
        if (!Runner.AS_A_TABLE) System.out.println(this + " serves " + buyer.toString());
        check(this, buyer, lineSize);
        buyer.sleepBuyer(2000, 5000);
        synchronized (buyer) {
            buyer.notify();
        }
    }

    synchronized void closeCashier() {
        endOfWork = true;
        notify();
        if (!Runner.AS_A_TABLE) System.out.println(this + " closed");
    }

    @Override
    public void run() {
        while (!endOfWork) {
            Buyer buyer = store.getBuyer();
            if (buyer != null)
                serve(buyer, store.getBuyersQueueSize());
            else pause();
        }
    }

    public int getNumber() {
        synchronized (this) {
            return number;
        }
    }

    @Override
    public String toString() {
        return name;
    }

    String tableMarkUp(String product, Double price, Cashier cashier, int lineSize) {
        String emptyColumn = "                              ";
        String upLine = "┌-----------------------------";
        StringBuilder sb = new StringBuilder();
        sb.append(upLine.repeat(COLUMN_COUNT)).append("┐\n|");
        for (int i = 0; i < MAX_CASHIERS; i++) {
            if (i == cashier.getNumber()) {
                sb.append(String.format("%13s %6.2f", product, price)).append("|");
            } else {
                sb.append(emptyColumn).append("|");
            }
        }
        sb.append(String.format("line size: " + "%6s", lineSize));
        sb.append(String.format("Total:%10s", price));
        return sb.toString();
    }

    void check(Cashier cashier, Buyer buyer, int lineSize) {
        Basket basket = buyer.getGoods();
        String prod = basket.getProd();
        List<String> inTable = new ArrayList<>();
        double totalSum = 0;
        while (prod != null) {
            double price = store.product.getPrice(prod);
            if (Runner.AS_A_TABLE) {
                inTable.add(tableMarkUp(prod, price, cashier, lineSize));
            }
            prod = basket.getProd();
            totalSum += price;
        }
        if (Runner.AS_A_TABLE) {
            inTable.add(tableMarkUp(null + "Total: ", totalSum, cashier, lineSize));
        }
        synchronized (inTableMonitor) {
            inTable.forEach(System.out::println);
        }
    }
}
