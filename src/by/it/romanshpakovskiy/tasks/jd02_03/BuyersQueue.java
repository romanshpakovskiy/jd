package by.it.romanshpakovskiy.tasks.jd02_03;

import java.util.concurrent.ConcurrentLinkedQueue;

public class BuyersQueue {
    private ConcurrentLinkedQueue<Buyer> youngGeneration;
    private ConcurrentLinkedQueue<Buyer> oldGeneration;

    BuyersQueue() {
        youngGeneration = new ConcurrentLinkedQueue<>();
        oldGeneration = new ConcurrentLinkedQueue<>();
    }

    synchronized void enterQueue(Buyer buyer) {
        if (buyer.isPensioneer())
            oldGeneration.add(buyer);
        else
            youngGeneration.add(buyer);
    }

    synchronized Buyer nextBuyer() {
        if (!oldGeneration.isEmpty())
            return oldGeneration.poll();
        else
            return youngGeneration.poll();
    }

    synchronized int getSize() {
        return youngGeneration.size() + oldGeneration.size();
    }
}
