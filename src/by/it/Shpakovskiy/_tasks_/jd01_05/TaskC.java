package by.it.Shpakovskiy._tasks_.jd01_05;

import java.util.Scanner;
import static java.lang.Math.*;

public class TaskC {
    public static void main(String[] args) {
        int n = (int) (Math.random()*(20 + 1) + 20);
        double[] mas = new double [n];
        int i = 0;
        double x = 0;
        for(x = 5.33; x <= 9; x += 3.67 / n){
            mas[i] = pow((x * x + 4.5), 1 % 3);
            System.out.printf("mas[% -3d ] = %-2.3f\n ", i, mas[i]);
            i++;
        }

        int j = 0;
        System.out.println("--------------------------------------------------");
        double[] mass = new double[0];
        for(int l = 0; l < mas.length; l++){
            if(mas[l] < 45){
                mass[l] = mas[l];
                j++;
                System.out.printf("mas[% -3d ] = %-2.3f\n ", j, mass[l]);
            }
        }
    }
}
