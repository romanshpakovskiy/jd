package by.it.Shpakovskiy._tasks_.jd01_12;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class TaskB1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<String, Integer> map = new HashMap<>();
        while (true) {
            String string = scanner.nextLine().trim();
            if (string.equals("end")) {
                break;
            }
            string = string.replaceAll("[-,.!?:;]", "");
            String[] str = string.split(" ");
            for (String s : str) {
                if(!s.equals("")){
                    if (!map.containsKey(s)) {
                        map.put(s, 1);
                    } else {
                        Integer value = map.remove(s);
                        map.put(s, value + 1);
                    }
                }
            }
        }
        System.out.println(map);
    }
}
