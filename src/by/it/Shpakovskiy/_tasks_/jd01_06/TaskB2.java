package by.it.Shpakovskiy._tasks_.jd01_06;

import java.util.regex.Pattern;

public class TaskB2 {
    public static void main(String[] args) {
        Pattern pattern  = Pattern.compile("[.!?]");
        String str = Poem.text.replaceAll("\n", " ");
        str = str.replaceAll("[-,;:]", "");
        String[] sent = pattern.split(str);
        for(int i = 0; i < sent.length; i++){
            sent[i] = sent[i].trim();
        }

        for(int i = 0; i < sent.length - 1; i++){
            for(int j = i + 1; j < sent.length; j++){
                if(sent[i].length() > sent[j].length()){
                    String temp = sent[i];
                    sent[i] = sent[j];
                    sent[j] = temp;
                }
            }
        }

        for(String s: sent){
            System.out.println(s);
        }
    }

    
}
