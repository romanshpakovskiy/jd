package by.it.romanshpakovskiy.tasks.jd01_12;

import java.util.*;

public class TaskC1 {
    public static void main(String[] args) {
        Map<Integer, String> map = new TreeMap<>();
        Scanner scanner = new Scanner(System.in);
        while (true) {
            String string = scanner.nextLine();
            if (string.equals("end")) {
                break;
            }
            map.put((int) System.nanoTime(), string);
        }

        Set<String> set = new HashSet<>(map.size());
        map.values().removeIf(v->!set.add(v));
        System.out.println(map);
    }
}
