package by.it.romanshpakovskiy.tasks.jd01_06;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskA2 {
    public static String[] mas = {};
    public static int[] count = {};

    public static int position(String word){
        for(int i = 0; i < mas.length; i++){
            if(mas[i].equals(word)) return i;
        }
        return -1;
    }

    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("[^a-zA-Zа-яА-ЯёЁ1-9 ]+");
        StringBuilder sb = new StringBuilder(Poem.text);
        Matcher matcher = pattern.matcher(sb);
        while (matcher.find()) {
            String word = matcher.group();
            int p = position(word);
            if (p >= 0) {
                count[p]++;
            } else {
                int last = mas.length;
                mas = Arrays.copyOf(mas, last + 1);
                mas[last] = word;
                count = Arrays.copyOf(count, last + 1);
                count[last] = 1;
            }
        }
        for (int i = 0; i < mas.length; i++) {
            System.out.println(mas[i]+"="+count[i]);
        }
    }
}
