package by.it.romanshpakovskiy.tasks.jd02_03;

import java.util.ArrayList;
import java.util.List;

public class Manager implements Runnable {
    Store store;
    private boolean endWork;
    private boolean work;

    Manager(Store store) {
        this.store = store;
        Thread thread = new Thread(this, "Manager");
        thread.start();
    }

    boolean isWork() {
        return work;
    }

    @Override
    public void run() {
        synchronized (this) {
            try {
                wait();
                work = true;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        printTitleLine();
        while (!endWork) {
            cashiersManaging();
            if (store.isClosed()) {
                store.closeTheStore();
                endWork = true;
                break;
            }
        }
        if (Runner.AS_A_TABLE) {
            String s = "│ Total buyers count: " + String.format("%4d", store.getTotalBuyersCount()) +
                    ". Total revenue: $" + String.format("%6.2f", store.getRevenue()) + "." +
                    " ".repeat(116) + "│\n" +
                    "└" + "─".repeat(167) + "┘";
            System.out.println(s);
        }
    }

    private void printTitleLine() {
        int w = Runner.CHAR_IN_COLUMN;
        StringBuilder sb = new StringBuilder();
        sb.append("┌").append("—".repeat(167)).append("┐\n");
        sb.append("|");
        for (int i = 0; i <  Store.CASHIERS_COUNT; i++) {
            sb.append(String.format("%" + (w - 3) + "s%d  ", "cashier N", i + 1)).append('│');
        }
        sb.append(String.format("%" + (w - 2) + "s  ", "count queue")).append('│');
        sb.append(String.format("%" + (w - 2) + "s  ", "revenue")).append('│');
        sb.append("\n").append("├").append("—".repeat(167)).append("┤");
        System.out.println(sb);
    }

    synchronized static int necessaryCashiers(int queueSize) {
        if (queueSize > 20)
            return 5;
        if (queueSize > 15)
            return 4;
        if (queueSize > 10)
            return 3;
        if (queueSize > 5)
            return 2;
        if (queueSize > 0)
            return 1;
        return 0;
    }

    private int[] getRandomNumbers(int length) {
        List<Integer> list = new ArrayList<>(length);
        boolean add;
        while (list.size() < length) {
            add = false;
            int v = (int) (Math.random() * length);
            while (!add) {
                if (!list.contains(v)) {
                    list.add(v);
                    add = true;
                } else {
                    v++;
                    if (v >= length) v = 0;
                }
            }
        }
        int[] r = new int[length];
        for (int i = 0; i < length; i++) {
            r[i] = list.get(i);
        }
        return r;
    }

    void cashiersManaging() {
        int working = 0;
        List<Cashier> cashiers = store.getCashiers();
        for (Cashier cashier : cashiers) {
            if (!cashier.isWaiting()) working++;
        }

        int count = store.getBuyersQueueSize();
        int necessaryCashiers = necessaryCashiers(count);
        if (necessaryCashiers > working) {
            int[] ran = getRandomNumbers(cashiers.size());
            for (int i = 0; i < cashiers.size(); i++) {
                if (cashiers.get(ran[i]).wake()) {
                    if (!Runner.AS_A_TABLE) System.out.println("Manager opened " + cashiers.get(ran[i]));
                    if (++working == necessaryCashiers) break;
                }
            }
        }
    }
}
