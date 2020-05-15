package by.it.romanshpakovskiy.tasks.jd02_02;

import java.util.ArrayDeque;
import java.util.Queue;

public class Runner {
    static int countOfBuyers = 0;
    static final boolean AS_A_TABLE = false;
    static final int buyersLimit = 20;

    public static void main(String[] args) {
        Queue<Buyer> buyers = new ArrayDeque<>();
        Store store = new Store(20);

        for (int sec = 0; sec < 120; sec++) {
            int k = getCountOfBuyersPerTime(sec);
            while (countOfBuyers < k && store.isBasket() && countOfBuyers < buyersLimit) {
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
        int h = second / 60;
        int s = second - h * 60;
        if (s <= 30) return Helper.getRandomValue(1, 9);
        else return Helper.getRandomValue(30, 40);
    }
}
