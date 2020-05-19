package by.it.romanshpakovskiy.tasks.jd02_02;

import java.util.ArrayList;

public class Manager extends Thread {
    Store store;
    private boolean endWork;
    private boolean work;

    Manager(Store store) {
        this.store = store;
        this.setName("Manager");
        start();
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

            while (!endWork) {
                cashiersManaging();
                if (store.close()) {
                    store.closeTheStore();
                    break;
                }
            }
            endWork = true;
        }
    }

    synchronized static int necessaryCashiers(int queueSize) {
        if (queueSize <= 5)
            return 1;
        else if (queueSize <= 10)
            return 2;
        else if (queueSize <= 15)
            return 3;
        else if (queueSize <= 20)
            return 4;
        else return 5;
    }

    void cashiersManaging() {
        int workingCashiers = 0;
        ArrayList<String> workingCashiersNames = new ArrayList<>();
        for (Cashier cashier : store.cashiers) {
            if (!cashier.isWaiting()) {
                workingCashiersNames.add(cashier.toString());
                workingCashiers++;
            }
        }

        int actualQueueSize = store.getBuyersQueueSize();
        if (necessaryCashiers(actualQueueSize) > workingCashiers) {
            while (necessaryCashiers(actualQueueSize) <= workingCashiers) {
                for (Cashier cashier : store.cashiers) {
                    for (String cashiersName : workingCashiersNames) {
                        if (!cashier.toString().equals(cashiersName))
                            cashier.wake();
                    }
                }
            }
        }
    }
}
