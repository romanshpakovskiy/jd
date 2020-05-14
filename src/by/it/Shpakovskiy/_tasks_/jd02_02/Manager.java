package by.it.Shpakovskiy._tasks_.jd02_02;

import java.util.ArrayList;
import java.util.List;

public class Manager extends Thread {
    List<Cashier> cashiers;
    Store store;
    boolean endWork;

    Manager(Store store) {
        this.store = store;
        Thread thread = new Thread("Store Manager");
        thread.start();
    }

    @Override
    public void run() {
        synchronized (this) {
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            while (!endWork) {
                cashiersManaging();
                if(store.isClose){
                   store.closeTheStore();
                   endWork = true;
                }
            }
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
        int actualQueueSize = BuyersQueue.getSize();
        int workingCashiers = 0;
        ArrayList<String> workingCashiersNames = new ArrayList<>();
        for (Cashier cashier : cashiers) {
            if (!cashier.isWaiting()) {
                workingCashiersNames.add(cashier.toString());
                workingCashiers++;
            }
        }

        if (necessaryCashiers(actualQueueSize) > workingCashiers) {
            while (necessaryCashiers(actualQueueSize) <= workingCashiers) {
                for (Cashier cashier : cashiers) {
                    for (String cashiersName : workingCashiersNames) {
                        if (!cashier.toString().equals(cashiersName))
                            cashier.wake();
                    }
                }
            }
        }
    }
}
