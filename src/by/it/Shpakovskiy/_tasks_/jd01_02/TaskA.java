package by.it.Shpakovskiy._tasks_.jd01_02;

import java.util.Scanner;

public class TaskA {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] mas = new int[10];
        for (int i = 0; i < 10; i++) {
            mas[i] = scanner.nextInt();
        }
        step1(mas);
        step2(mas);
        System.out.println();
        step3(mas);
    }

    static void step1(int[] mas) {
        int min = mas[0];
        int max = mas[0];
        for (int i = 1; i < mas.length; i++) {
            if (min > mas[i]) {
                min = mas[i];
            }
            if (max < mas[i]) {
                max = mas[i];
            }
        }

        System.out.println(min + " " + max);
    }

    static void step2(int[] mas) {
        double d;
        int sum = mas[0];
        for (int i = 1; i < mas.length; i++) {
            sum += mas[i];
        }
        d = (double) sum / mas.length;
        for (int a :
                mas) {
            if ((double) a < d) {
                System.out.print(a + " ");
            }
        }
    }

    static void step3(int[] mas) {
        int min = mas[0];
        for (int i = 1; i < mas.length; i++) {
            if (min > mas[i]) {
                min = mas[i];
            }
        }
        for (int i = mas.length - 1; i >= 0; i--) {
            if (min == mas[i]) {
                System.out.print(i + " ");
            }
        }
    }
}
