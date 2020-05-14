package by.it.Shpakovskiy._tasks_.jd02_02;

import java.util.ArrayDeque;

public class BuyersQueue {
    private final static ArrayDeque<Buyer> youngGeneration = new ArrayDeque<>();
    private final static ArrayDeque<Buyer> oldGeneration = new ArrayDeque<>();
    static final Object buyersQueueMonitor = new Object();

    static void enterQueue(Buyer buyer) {
        synchronized (buyersQueueMonitor) {
            if (buyer.isPensioner())
                oldGeneration.add(buyer);
            else
                youngGeneration.add(buyer);
        }
    }

    static Buyer nextBuyer() {
        synchronized (buyersQueueMonitor) {
            if (!oldGeneration.isEmpty())
                return oldGeneration.pollFirst();
            else
                return youngGeneration.pollFirst();
        }
    }

    static int getSize() {
        synchronized (buyersQueueMonitor) {
            return youngGeneration.size() + oldGeneration.size();
        }
    }
}
