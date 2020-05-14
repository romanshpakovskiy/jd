package by.it.Shpakovskiy._tasks_.jd02_02;

import java.util.Random;

class rand {

    static final Random random = new Random(System.nanoTime());

    static int getRandomValue(int from, int to) {
        return from + random.nextInt(to - from + 1);
    }

}
