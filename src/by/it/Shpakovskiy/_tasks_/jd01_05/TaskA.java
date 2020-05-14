package by.it.Shpakovskiy._tasks_.jd01_05;
import java.util.Scanner;
import static java.lang.Math.*;

public class TaskA {
    public static void main(String[] args) {
        sa1();
        sa2();
        sa3();
    }

    public static void sa1(){
        double x = 0.3, a = 756.13;
        double z = cos(pow((pow(x, 2) + PI/6), 5)) - sqrt(x * pow(a, 3)) - abs(log((a - 1.12 * x) / 4));
        System.out.println(z);
    }

    public static void sa2(){
        double a = 1.21, b = 0.371;
        double y = pow(tan(a + b), 2) - pow((a + 1.5), 1/3) + a * pow(b, 5) - b/(log(pow(a, 2)));
        System.out.println(y);
    }

    public static void sa3(){
        double x = 12.1;
        for(double a = -5; a <= 12; a += 3.75){
            double f = exp(a * x) - 3.45 * a;
            System.out.printf(" a =%6.2f f= %g\n", a, f);
        }
    }
}
