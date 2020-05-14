package by.it.Shpakovskiy._tasks_.jd02_02;

import java.util.ArrayList;
import java.util.List;

public class Cashier extends Thread implements Runnable {
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
        name = "Cashier-" + number;
        Thread thread = new Thread(this, name);
        thread.start();
    }

    boolean isWaiting() {
        return waiting;
    }

    private synchronized void pause() {
        waiting = true;
        if (isWaiting()) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    synchronized void wake() {
        synchronized (this) {
            waiting = false;
            notify();
        }
    }

    private synchronized void serve(Buyer buyer, int lineSize) {
        synchronized (this) {
            check(this, buyer, lineSize);
            buyer.notify();
        }
    }

    synchronized void closeCashier() {
        endOfWork = true;
        interrupt();
    }

    @Override
    public void run() {
        Buyer buyer = BuyersQueue.nextBuyer();
        while (!endOfWork) {
            if (buyer != null)
                serve(buyer, BuyersQueue.getSize());
            else
                pause();
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

    static String tableMarkUp(String product, Double price, Cashier cashier, int lineSize) {
        StringBuilder sb = new StringBuilder();
        String emptyColumn = "                              ";
        String upLine = "┌-----------------------------";
        sb.append(upLine.repeat(COLUMN_COUNT)).append("┐\n");
        sb.append("|");
        for (int i = 0; i < 5; i++) {
            sb.append(String.format("%18s%d%11s", "Cashier №", i + 1, "|"));
        }
        sb.append(String.format("%19s%11s", "queue size", "|"));
        sb.append(String.format("%19s%11s", "Total sum", "|")).append("\n");
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
            double price = store.getPrice(prod);
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
