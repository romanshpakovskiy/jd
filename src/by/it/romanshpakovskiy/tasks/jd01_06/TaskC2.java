package by.it.romanshpakovskiy.tasks.jd01_06;

import java.util.Random;
import java.util.regex.Pattern;

public class TaskC2 {
    public static void main(String[] args) {
        System.out.println(slow(Poem.text));

    }

    public static String slow(String text) {
        Pattern pattern = Pattern.compile("[а-яА-ЯёЁ] + ");
        String[] str = pattern.split(text);
        String s = "";
        Random rand = new Random(1);
        while (s.length() < 100000) {
            s += str[rand.nextInt(str.length)] + " ";
        }
        return s;
    }

    public static StringBuilder fast(String text){
        Pattern pattern = Pattern.compile("[а-яА-ЯёЁ] + ");
        String[] str = pattern.split(text);
        StringBuilder s = new StringBuilder();
        Random rand = new Random(1);
        while (s.length() < 100000) {
            s.append(rand.nextInt(str.length)).append(" ");
        }
        return s;
    }
}
