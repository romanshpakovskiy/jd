package by.it.romanshpakovskiy.tasks.jd01_13;

import java.util.Scanner;

public class TaskB {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double result = 0;
        while(true){
            String str = scanner.next();
            if(str.equals("END")){
                break;
            }
            try{
                double num = Double.parseDouble(str);
                System.out.println("enter: " + num);
                result += num;
                double afn = Math.sqrt(result);
                if(Double.isNaN(afn)){
                    throw new ArithmeticException();
                }
                System.out.println("sqrt: " + afn);
            } catch (NumberFormatException | ArithmeticException e){
                StackTraceElement[] stackTrace = e.getStackTrace();
                for (StackTraceElement stackTraceElement : stackTrace) {
                    if(TaskB.class.getName().equals(stackTraceElement.getClassName())) {
                        System.out.println(stackTraceElement);
                        String name = e.getClass().getName();
                        String className = stackTraceElement.getClassName();
                        int num = stackTraceElement.getLineNumber();
                        System.out.printf(
                                "name: %s\n" +
                                        "class: %s\n" +
                                        "line: %d\n",
                                name, className, num);
                        break;
                    }
                }
            }
        }
    }
}
