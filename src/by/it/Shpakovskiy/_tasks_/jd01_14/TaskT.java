package by.it.Shpakovskiy._tasks_.jd01_14;

import java.io.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TaskT {
    public static void main(String[] args) {
        String fileName = "src/by/it/Shpakovskiy/_tasks_/jd01_14/poem.txt";
        StringBuilder stringBuilder = new StringBuilder();
        readFileInStringBuilder(fileName, stringBuilder);
        int countWords = getCountWords(stringBuilder);
        int countMarks = getCountMarks(stringBuilder);
        String result = "words=" + countWords + ", punctuation marks=" + countMarks;
        System.out.println(result);
        String resultFileName = "src/by/it/Shpakovskiy/_tasks_/jd01_14/resultTaskB.txt";
        printStringToFile(resultFileName, result);
    }

    static void printStringToFile(String fileName, String line) {
        try (PrintWriter printWriter = new PrintWriter(fileName)) {
            printWriter.println(line);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    static int getCountMarks(CharSequence charSequence) {
        return getCount(charSequence, "[^а-яёА-ЯЁa-zA-Z\\s]+");
    }

    static int getCountWords(CharSequence charSequence) {
        return getCount(charSequence, "[а-яА-ЯёЁa-zA-Z]+");
    }

    static int getCount(CharSequence charSequence, String regex) {
        Matcher matcher = Pattern.compile(regex).matcher(charSequence);
        int count = 0;
        while (matcher.find())
            count++;
        return count;
    }


    static void readFileInStringBuilder(String fileName, StringBuilder stringBuilder) {
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line).append("\n");
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
