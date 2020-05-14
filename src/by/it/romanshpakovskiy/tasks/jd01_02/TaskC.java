package by.it.romanshpakovskiy.tasks.jd01_02;

import java.util.Scanner;

public class TaskC {
    public static int[][] step1(int n) {
        boolean isNumbers = false;
        int[][] result = null;
        while (!isNumbers) {
            boolean flagPos = false;
            boolean flagNeg = false;
            result = new int[n][n];
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    result[i][j] = randomNumber(n);

                    if (!flagPos && result[i][j] == n) {
                        flagPos = true;
                    }
                    if (!flagNeg && result[i][j] == -n) {
                        flagNeg = true;
                    }
                }
            }
            isNumbers = flagPos && flagNeg;
        }
        printMatrix(result);
        return result;
    }

    private static int randomNumber(int sizeMass) {
        return (int) (Math.random() * (sizeMass * 2 + 1)) - sizeMass;
    }

    private static void printMatrix(int[][] mass) {
        for (int[] ints : mass) {
            for (int j = 0; j < mass[0].length; j++) {
                System.out.print(ints[j] + " ");
            }
            System.out.print("\n");
        }
    }

    public static int step2(int[][] mas) {
        int sum = 0;
        for (int i = 0; i < mas.length; i++) {
            int a = -1, b = -1;
            for (int j = 0; j < mas[i].length; j++) {
                if (mas[i][j] > 0) {
                    if (a == -1 && b == -1) {
                        a = j;
                    } else if (a != -1 && b == -1) {
                        b = j;
                    }
                }
            }
            if (a != -1 && b != -1 && a + 1 != b) {
                for (int j = a + 1; j < b; j++) {
                    sum += mas[i][j];
                }
            }
        }
        System.out.println(sum);
        return sum;
    }

    public static int[][] step3(int[][] mas) {
        int max = mas[0][0];
        for (int i = 0; i < mas.length; i++) {
            for (int j = 1; j < mas[i].length; j++) {
                if (max < mas[i][j]) {
                    max = mas[i][j];
                }
            }
        }
        int[] indicesJMax = new int[mas.length];
        int[] indicesIMax = new int[mas.length];
        for (int i = 0; i < mas.length; i++) {
            indicesIMax[i] = i;
            indicesJMax[i] = i;
        }
        for (int i = 0; i < mas.length; i++) {
            for (int j = 1; j < mas[i].length; j++) {
                if (max == mas[i][j]) {
                    indicesJMax[j] = -1;
                    indicesIMax[i] = -1;
                }
            }
        }
        int countI = 0;
        int countJ = 0;
        for (int i = 0; i < mas.length; i++) {
            if (indicesJMax[i] != -1) {
                countJ++;
            }
            if (indicesIMax[i] != -1) {
                countI++;
            }
        }
        int[] iMax = new int[countI];
        int[] jMax = new int[countJ];
        int a = 0;
        int b = 0;
        for (int i = 0; i < mas.length; i++) {
            if (indicesIMax[i] != -1) {
                iMax[a] = indicesIMax[i];
                a++;
            }
            if (indicesJMax[i] != -1) {
                jMax[b] = indicesJMax[i];
                b++;
            }
        }
        int[][] masResult = new int[countI][countJ];
        for (int i = 0; i < masResult.length; i++) {
            for (int j = 0; j < masResult[i].length; j++) {
                masResult[i][j] = mas[iMax[i]][jMax[j]];
            }
        }
        System.out.println("step3");
        printMatrix(masResult);
        return masResult;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] mass = step1(n);
        step2(mass);
        step3(mass);
    }
}
