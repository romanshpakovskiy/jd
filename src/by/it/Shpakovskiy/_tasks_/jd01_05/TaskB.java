package by.it.Shpakovskiy._tasks_.jd01_05;

import static java.lang.Math.*;
import java.util.Scanner;

public class TaskB {

    public static void main(String[] args) {
        sb1();

    }

    public static void sb1(){
        double sum = 0;
        for(int x = 1; x <= 6; x++){
            for(int a = 0; a < 2; a += 0.2){
                sum += pow(7, a) - cos(x);
            }
        }
        System.out.println("Sum: ");
        System.out.print(sum);
    }
}
