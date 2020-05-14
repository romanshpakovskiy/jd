package by.it.Shpakovskiy._tasks_.jd01_12;

import java.util.*;

public class TaskA2 {
    private static Set<Integer> getCross(Set<Integer> a, Set<Integer> b) {
        Set<Integer> res = new HashSet<>(a);
        res.retainAll(b);
        return res;
    }

    private static Set<Integer> getUnion(Set<Integer> a, Set<Integer> b){
        Set<Integer> res = new HashSet<>(a);
        res.addAll(b);
        return res;
    }

    public static void main(String[] args) {
        Set<Integer> hashSet = new HashSet<>(Arrays.asList(1, 2, 3, 4, 5, 6));
        Set<Integer> treeSet = new TreeSet<>(Arrays.asList(5, 6, 7, 8, 9));
        System.out.println(getCross(treeSet, hashSet));
        System.out.println(getUnion(treeSet, hashSet));
    }
}