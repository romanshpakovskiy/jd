package by.it.romanshpakovskiy.tasks.jd02_03;

import java.util.LinkedList;

public class Runner {
    static int countOfBuyers = 0;
    static final boolean AS_A_TABLE = true;
    static final int CHAR_IN_COLUMN = 23;
    static final String EMPTY_COL = "                                           ".
            substring(0, CHAR_IN_COLUMN);

    public static void main(String[] args) {
        LinkedList<Buyer> buyers = new LinkedList<>();
        Store store = new Store(50);
        for (int second = 1; countOfBuyers < 120; second++) {
            int c = getCountOfBuyersPerTime(second);
            while (store.buyersCount() < c && store.isBasket() && countOfBuyers < 120) {
                buyers.add(new Buyer(store, ++countOfBuyers));
            }
            Helper.sleep(1000);
        }
        buyers.forEach(buyer -> {
            try {
                buyer.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
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
