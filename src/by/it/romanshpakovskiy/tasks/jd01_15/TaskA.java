package by.it.romanshpakovskiy.tasks.jd01_15;

import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class TaskA {
    public static void main(String[] args) {
        int[][] mas = new int[6][4];
        for (int i = 0; i < mas.length; i++) {
            for (int j = 0; j < mas[0].length; j++) {
                mas[i][j] = (int) (Math.random() * 15) - 15;
            }
        }

        String fileName = "src/by/it/Shpakovskiy/_tasks_/jd01_15/arrayFile.txt";
        String string = arrayToString(mas);
        try (PrintWriter printWriter = new PrintWriter(fileName)) {
            printWriter.print(string);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    static String arrayToString(int[][] mas) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int[] m : mas) {
            for (int mass : m) {
                stringBuilder.append(String.format("%3d ", mass));
                System.out.print(mass);
            }
            stringBuilder.append("\n");
        }
        return stringBuilder.toString();
    }
}
