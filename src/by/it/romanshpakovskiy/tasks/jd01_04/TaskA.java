package by.it.romanshpakovskiy.tasks.jd01_04;

import java.io.IOException;
import java.util.Scanner;

public class TaskA {
    public static void main(String[] args) throws IOException {
        printMulTable();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter line: ");
        String line = scanner.nextLine();
        System.out.println();
        buildOneDimArray(line);
    }

    static void printMulTable(){
        for(int i = 2; i <= 9; i++){
            for(int j = 2; j <= 9; j++){
                System.out.printf("%1d*%1d=%-2d ", i, j, i*j);
            }
            System.out.println();
        }
    }

    static void buildOneDimArray(String line) throws IOException {
        line = line.trim();
        String[] elStr = line.split("");
        double[] mas = new double[elStr.length];
        for(int i = 0; i < elStr.length; i++){
            mas[i] = Integer.parseInt(elStr[i]);
        }

        String name = "V";
        for(int i = 0; i <= 5; i++){
            for(int j = 0; j < mas.length; j++){
                System.out.printf("%1c%[% - 1d] = %-2d", name, i, mas[i]);
            }
            System.out.println();
        }

        for(int i = 0; i < mas.length - 1; i++){
            for(int j = i + 1; j < mas.length; j++ ){
                if (mas[i] > mas[j]) {
                    double temp = mas[i];
                    mas[i] = mas[j];
                    mas[j] = temp;
                }
            }
        }

        for(int i = 0; i <= 4; i++){
            for(int j = 0; j < mas.length; j++){
                System.out.printf("%1c%[% - 3d] = %-4d", name, i, mas[i]);
            }
            System.out.println();
        }

        for(int i = 0; i < mas.length; i++){
            if(mas[i] == mas[0]){
                System.out.println("Index of 1st el = " + i);
            }

            if(mas[i] == mas[mas.length - 1]){
                System.out.println("Index of last el = " + i);
            }
        }
    }
}
