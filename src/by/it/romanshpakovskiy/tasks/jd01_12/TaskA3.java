package by.it.romanshpakovskiy.tasks.jd01_12;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TaskA3 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int pos = 0;
        while (true){
            String string = scanner.next();
            if(string.equals("end")){
                break;
            }
            Integer val = Integer.valueOf(string);
            if(val > 0)
                list.add(pos++, val);
            else if(val == 0)
                list.add(pos, 0);
            else
                list.add(val);
        }
        System.out.println(list.toString());
    }
}
