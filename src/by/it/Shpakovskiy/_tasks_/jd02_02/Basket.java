package by.it.Shpakovskiy._tasks_.jd02_02;

import java.util.*;

public class Basket {
    LinkedList<String> goods;

    public Basket() {
        goods = new LinkedList<>();
    }

    public void putGoods(String prod) {
        goods.add(prod);
    }

    String getProd(){
        return goods.pollFirst();
    }
}
