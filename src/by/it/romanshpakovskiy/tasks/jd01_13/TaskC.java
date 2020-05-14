package by.it.romanshpakovskiy.tasks.jd01_13;

import java.util.ArrayList;
import java.util.Scanner;

public class TaskC {
    private static Scanner scanner;
    private static void readData() throws Exception {
        ArrayList<Double> arrayList = new ArrayList<>();
        int count = 0;
        String string = scanner.nextLine();
        while(true){
            try {
                arrayList.add(Double.parseDouble(scanner.next()));
            } catch (Exception e){
                count++;
                Thread.sleep(100);
                for (int i = arrayList.size() - 1 ; i >= 0  ; i--) {
                    System.out.print(arrayList.get(i) + " ");
                }
                if(count == 5){
                    throw new Exception(e);
                }
            }
        }
    }
    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        readData();
    }

}
