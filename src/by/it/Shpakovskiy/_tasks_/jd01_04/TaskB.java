package by.it.Shpakovskiy._tasks_.jd01_04;

import java.util.Scanner;

public class TaskB {

    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.print("n: ");
        int n = scanner.nextInt();
        System.out.println();
        String[] ppl = new String[n];

        for(int i = 0; i < n; i++){
            Scanner m = new Scanner(System.in);
            ppl[i] = m.nextLine();
        }

        for(int i = 0; i < n; i++){
            System.out.println(ppl[i]);
        }

        int sum = 0;
        int k = 0;
        int[][] salary = new int[n][4];
        for(int i = 0; i < n; i++){
            for(int j = 0; j < 4; j++){
                Scanner qSalary = new Scanner(System.in);
                salary[i][j] = qSalary.nextInt();
                sum += salary[i][j];
                k++;
            }
            System.out.println();
        }

        double average =(double)sum / k;

        System.out.printf("%-13s%-10s%-10s%-10s%-10s%-10s%n","Фамилия","Квартал1","Квартал2","Квартал3","Квартал4","Итого");
        System.out.println("--------------------------------------------------------------------------------------");
        System.out.println();

        for(int i = 0; i < n; i++){
            int s = salary[i][0] + salary[i][1] + salary[i][2] + salary[i][3];
            System.out.printf("%-13s%-10d%-10d%-10d%-10d%-10d%n", ppl[i], salary[i][0],salary[i][1],salary[i][2],salary[i][3],s);
            System.out.println();
        }

        System.out.println("--------------------------------------------------------------------------------------");
        System.out.printf("%-6s%-9d%n","Итого",sum);
        System.out.printf("%-7s%-9.4f%n","Средняя",average);
    }
}
