package by.it.romanshpakovskiy.tasks.jd01_06;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskB1 {
    private static char[] vowel = {'а', 'о', 'у', 'ы', 'и', 'э', 'е', 'ё', 'ю', 'я'};

    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("[а-яА-ЯёЁ]+");
        Matcher matcher = pattern.matcher(Poem.text);
        while(matcher.find()){
            if(matcher.group().length() > 1 ){
                if(b1(matcher.group().toLowerCase())){
                    System.out.println(matcher.group());
                }
            }
        }
    }

    private static boolean b1(String word){
        boolean fReg = true;
        boolean lReg = false;
        char fl = word.charAt(0);
        char ll = word.charAt(word.length() - 1);
        for(char ch: vowel){
            if(fl == ch) {
                fReg = false;
                break;
            }
        }

        for(char ch: vowel){
            if(ll == ch){
                lReg = true;
                break;
            }
        }

        return fReg && lReg;
    }
}
