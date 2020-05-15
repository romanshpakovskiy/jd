package by.it.romanshpakovskiy.tasks.jd02_02;

import java.util.ArrayDeque;

public class BuyersQueue {
    private ArrayDeque<Buyer> youngGeneration;
    private ArrayDeque<Buyer> oldGeneration;

    BuyersQueue(){
        youngGeneration = new ArrayDeque<>();
        oldGeneration = new ArrayDeque<>();
    }

    void enterQueue(Buyer buyer) {
        synchronized (this) {
            if (buyer.isPensioner())
                oldGeneration.add(buyer);
            else
                youngGeneration.add(buyer);
        }
    }

    Buyer nextBuyer() {
        synchronized (this) {
            if (!oldGeneration.isEmpty())
                return oldGeneration.pollFirst();
            else
                return youngGeneration.pollFirst();
        }
    }

    int getSize() {
        synchronized (this) {
            return youngGeneration.size() + oldGeneration.size();
        }
    }
}
