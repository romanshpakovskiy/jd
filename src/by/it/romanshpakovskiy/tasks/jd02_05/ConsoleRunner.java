package by.it.romanshpakovskiy.tasks.jd02_05;

import java.util.Locale;
import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Parser parser = new Parser();
        Printer printer = new Printer();
        while (true) {
            String expression = scanner.nextLine();
            if (expression.equals("end")) {
                break;
            }
            if(expression.equals("ru")){
                ResourceManager.changeLocale(new Locale("ru","RU"));
            }
            if(expression.equals("en")){
                ResourceManager.changeLocale(Locale.ENGLISH);
            }
            Var result;
            try {
                result = parser.calculateExpression(expression);
                printer.print(result);
            } catch (CalcException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}