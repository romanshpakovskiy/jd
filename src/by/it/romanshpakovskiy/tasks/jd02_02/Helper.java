package by.it.romanshpakovskiy.tasks.jd02_02;

import java.util.Random;

class Helper {
    static final int K_SPEED = 50;

    static final Random random = new Random(System.nanoTime());

    static int getRandomValue(int from, int to) {
        return from + random.nextInt(to - from + 1);
    }

    static void sleep(int millis) {
        try {
            Thread.sleep(millis / K_SPEED);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
