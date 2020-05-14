package by.it.Shpakovskiy._tasks_.jd01_12;

import java.util.*;

public class TaskB3 {
    static String process(ArrayList<String> people) {
        int count = 1;
        while (people.size() > 1) {
            Iterator<String> iterator = people.iterator();
            while (iterator.hasNext()) {
                iterator.next();
                if (count++ % 2 == 0) {
                    iterator.remove();
                }
            }
        }
        return people.get(0);
    }

    static String process1(LinkedList<String> people) {
        int count = 1;
        while (people.size() > 1) {
            Iterator<String> iterator = people.iterator();
            while (iterator.hasNext()) {
                iterator.next();
                if (count++ % 2 == 0) {
                    iterator.remove();
                }
            }
        }
        return people.get(0);
    }

    static String process(LinkedList<String> people){
        while(people.size() > 1){
            people.addLast(people.pollFirst());
            people.removeFirst();
        }
        return people.getFirst();
    }

    public static void main(String[] args) {
        ArrayList<String> arrayList = new ArrayList<>();
        LinkedList<String> linkedList = new LinkedList<>();
        for (int i = 1; i < 26; i++) {
            String e = "chel" + i;
            arrayList.add(e);
            linkedList.add(e);
        }
        process(arrayList);
        process(linkedList);
    }
}

