package by.it.romanshpakovskiy.tasks.jd01_05;
import java.util.Scanner;

public class Dif {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        System.out.println("1_______________________________________________");
    }

    public static void str1(String[] str){
        int min = 0, max = 0;
        String strmax = null, strmin = null;
        for(String a : str){
            System.out.println(a);
            if(a.length() < min){
                min = a.length();
                strmin = a;
            }
            if(a.length() > max){
                max = a.length();
                strmax = a;
            }
        }
        System.out.println("Max num = " + strmax + "Min num = " + strmin);
        System.out.println("Max strnum = " + max + "Min strnum = " + min);
    }

    public static void str2(String[] str){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] mas = new String [n];
        Scanner sc = new Scanner(System.in);
        for(int i = 0; i < n; i++){
            mas[i] = sc.nextLine();
        }


    }
}
