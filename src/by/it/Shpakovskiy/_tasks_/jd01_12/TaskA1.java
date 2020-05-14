package by.it.Shpakovskiy._tasks_.jd01_12;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class TaskA1 {
    private List<Integer> list= new ArrayList<>();
    private void clearBad(List<Integer> grades){
        Iterator<Integer> iterator = grades.iterator();
        while (iterator.hasNext()){
            int grade = iterator.next();
            if(grade < 4)
                iterator.remove();
        }
    }
    public static void main(String[] args) {
        TaskA1 mark = new TaskA1();
        for(int i = 0; i < 15; i++ ) {
            mark.list.add((int) Math.ceil(Math.random() * 10));
        }
        System.out.println(mark.list);
        mark.clearBad(mark.list);
        System.out.println(mark.list);
    }
}
