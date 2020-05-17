package by.it.romanshpakovskiy.tasks.jd02_02;

import java.util.ArrayDeque;

public class BuyersQueue {
    private ArrayDeque<Buyer> youngGeneration;
    private ArrayDeque<Buyer> oldGeneration;

    BuyersQueue() {
        youngGeneration = new ArrayDeque<>();
        oldGeneration = new ArrayDeque<>();
    }

    synchronized void enterQueue(Buyer buyer) {
        if (buyer.isPensioner())
            oldGeneration.add(buyer);
        else
            youngGeneration.add(buyer);
    }

    synchronized Buyer nextBuyer() {
        if (!oldGeneration.isEmpty())
            return oldGeneration.pollFirst();
        else
            return youngGeneration.pollFirst();
    }

    synchronized int getSize() {
        return youngGeneration.size() + oldGeneration.size();
    }
}
