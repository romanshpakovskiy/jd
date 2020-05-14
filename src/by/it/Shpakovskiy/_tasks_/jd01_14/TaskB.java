package by.it.Shpakovskiy._tasks_.jd01_14;

import java.io.*;

public class TaskB {
    public static void main(String[] args) {
        String path = "src/by/it/Shpakovskiy/_tasks_/jd01_14/textIn.txt";
        String strp = fileToSb();
        stringToFile(strp, path);
        System.out.println(strp);
    }

    private static String fileToSb() {
        String str = "";
        int countMark = 0;
        int countWords = 0;
        try (BufferedReader bf = new BufferedReader(new FileReader("src/by/it/Shpakovskiy/_tasks_/jd01_14/poem.txt"))) {
            while (bf.ready()) {
                str = bf.readLine();
                countMark += numberOfPunctuationMarks(str);
                countWords += numberOfWords(str);
            }
            str = "words = " + countWords + ", punctuation marks = " + countMark;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return str;
    }

    private static int numberOfPunctuationMarks(String string) {
        String resultString = string.replaceAll("[a-zA-Zа-яА-ЯёЁ1-9 ]+", "");
        return resultString.length();
    }

    private static int numberOfWords(String string) {
        String[] arrString = string.split("[^a-zA-Zа-яА-ЯёЁ1-9]+");
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
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))) {
            bw.write(string);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
