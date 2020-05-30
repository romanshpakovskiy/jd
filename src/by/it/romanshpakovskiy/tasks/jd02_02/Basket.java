package by.it.romanshpakovskiy.tasks.jd02_02;

import java.util.*;

public class Basket {

    private LinkedList<String> goods;

    public Basket() {
        goods = new LinkedList<>();
    }

    public void putGoods(String prod) {
        goods.add(prod);
    }

    public String getProd(){
        return goods.pollFirst();
    }

    public int getSize(){
        return goods.size();
    }
}
