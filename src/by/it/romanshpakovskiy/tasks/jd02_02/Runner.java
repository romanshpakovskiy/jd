package by.it.romanshpakovskiy.tasks.jd02_02;

import java.util.ArrayDeque;
import java.util.Queue;

public class Runner {
    static int countOfBuyers = 0;
    static final boolean AS_A_TABLE = true;
    static final int buyersLimit = 20;

    public static void main(String[] args) {
        Queue<Buyer> buyers = new ArrayDeque<>();
        Store store = new Store(20);

        for (int sec = 0; sec < 120; sec++) {
            int k = getCountOfBuyersPerTime(sec);
            while (countOfBuyers < k - 10 && !store.isClose() && countOfBuyers < buyersLimit) {
                buyers.add(new Buyer(store, ++countOfBuyers));
            }
        }
        buyers.forEach(buyer -> {
            try {
                buyer.join();
            } catch (InterruptedException e) {
                System.err.println("InterruptedException " + e.getMessage());
            }
        });
    }

    private static int getCountOfBuyersPerTime(int second) {
        while (second < 120) {
            if (second < 30 || (second > 60 && second < 90)) {
                return second + 10;
            } else return 40 - (30 - second);
        }
        return 0;
    }
}
