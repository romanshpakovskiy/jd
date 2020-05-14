package by.it.Shpakovskiy._tasks_.jd01_11;

import java.util.List;
import java.util.Set;

public class Runner {
    public static void main(String[] args) {
        List<Integer> listA = new ListA<>();
        listA.add(1);
        listA.add(2);
        listA.add(3);
        listA.add(4);
        listA.add(5);
        System.out.println(listA.toString());
        List<Integer> listB = new ListB<>();
        listB.add(1);
        listB.add(2);
        listB.add(3);
        listB.add(4);
        listB.add(5);
        System.out.println(listB.toString());
        Set<Integer> setC = new SetC<>();
        setC.add(1);
        setC.add(2);
        setC.add(3);
        setC.add(4);
        setC.add(5);
        System.out.println(setC.toString());
    }
}
