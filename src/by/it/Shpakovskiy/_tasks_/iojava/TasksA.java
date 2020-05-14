package by.it.Shpakovskiy._tasks_.iojava;

import java.io.*;

public class TasksA {
    public static void main(String[] args) {
        String string = "src/by/it/Shpakovskiy/_tasks_/iojava/sometext.txt";
        makeTasks(string);
    }

    static void makeTasks(String path) {
        String str = null;
        int numberOfWordsBeginningWithVowel;
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {
            while (bufferedReader.ready()) {
                str = bufferedReader.readLine();
                numberOfWordsBeginningWithVowel=numberOfWordsBeginningWithVowel(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void stringToFile(String string, String path) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(path, true))) {
            bw.write(string);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static int numberOfWordsBeginningWithVowel(String string) {
        int count = 0;
        String[] vowelMassive = {"а,о,у,ы,и,э,е,ё,ю,я"};
        String[] str = string.split("[^a-zA-Zа-яА-ЯёЁ0-9]+");
        for (String st : str) {
            for (String vm : vowelMassive) {
                if (st.startsWith(vm) || st.startsWith(vm.toUpperCase()))
                    count++;
            }
        }
        return count;
    }
}