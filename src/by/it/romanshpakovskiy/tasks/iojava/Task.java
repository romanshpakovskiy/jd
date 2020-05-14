package by.it.romanshpakovskiy.tasks.iojava;

import java.io.*;

public class Task {
    public static void main(String[] args) {
        String path = "src/by/it/Shpakovskiy/_tasks_/iojava/textIn.txt";
        StringBuilder sb = fileToSb();
        String strp = "punctuation marks = " + numberOfPunctuationMarks(sb)+", ";
        String strw = "words = " + numberOfWords(sb);
        stringToFile(strp, path);
        stringToFile(strw, path);
    }

    private static StringBuilder fileToSb() {
        StringBuilder sb = new StringBuilder();
        try (BufferedReader bf = new BufferedReader(new FileReader("src/by/it/Shpakovskiy/_tasks_/iojava/text.txt"))) {
            String str;
            while ((str = bf.readLine()) != null) {
                sb.append(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return sb;
    }

    private static int numberOfPunctuationMarks(StringBuilder stringBuilder) {
        String string = stringBuilder.toString();
        String resultString = string.replaceAll("[a-zA-Zа-яА-ЯёЁ1-9 ]+", "");
        return resultString.length();
    }

    private static int numberOfWords(StringBuilder stringBuilder) {
        String[] arrString = stringBuilder.toString().split("[^a-zA-Zа-яА-ЯёЁ1-9]+");
        int count = 0;
        for (String s : arrString) {
            if (!s.equals("")) {
                System.out.println(s);
                count++;
            }
        }
        return count;
    }

    private static void stringToFile(String string, String path) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path,true))) {
            bw.write(string);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
