package by.it.Shpakovskiy._tasks_.jd01_03;

import java.util.Scanner;
public class InOut {
    public static void main(String[] args) {

        InOut io = new InOut();
        System.out.println("---------------------------------------------------------------------------");
        System.out.println("Line: ");
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        System.out.println("Name: ");
        String name = scanner.nextLine();
        System.out.println("ColumnCount: ");
        int columnCount = scanner.nextInt();
        System.out.println();
        io.getArray(line);
        io.printArray(getArray(line), name, columnCount);
        io.printArray(getArray(line));

    }

    static double[] getArray(String line){
        line = line.trim();
        String[] elStr = line.split("");
        double[] mas = new double[elStr.length];
        for(int i = 0; i < elStr.length; i++){
            mas[i] = Integer.parseInt(elStr[i]);
        }
        return mas;
    }

    static void printArray(double[] mas, String name, int columnCount){
        for(int i = 0; i < mas.length; i++){
            System.out.printf("[% - 3d] = %-4d", name, i, mas[i]);
            if((i + 1)%columnCount == 0 || i + 1 == mas.length){
                System.out.println();
            }
        }
    }

    static void printArray(double[] mas){
        for(double m: mas){
            System.out.print(m + " ");
        }
    }
}