package by.it.romanshpakovskiy.tasks.calc;

import java.text.DateFormat;
import java.util.Date;
import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) {
        Logger logger = Logger.getInstance();
        Scanner scanner = new Scanner(System.in);
        Parser parser = new Parser();
        Printer printer = new Printer();
        while (true) {
            String expression = scanner.nextLine();
            if (expression.equals("end")) {
                try {
                    Var.saveVarToFile();
                } catch (CalcException e) {
                    System.out.println(e.getMessage());
                    logger.printLog(e.getMessage());
                }
                System.out.println("Goodbye!!!");
                break;
            }
            logger.printLog(expression);
            if(expression.equals("printvar")){
                String stringVars = Var.printVars();
                System.out.println(stringVars);
                logger.printLog(stringVars);
            }
            try {
                Var result = parser.calculateExpression(expression);
                printer.print(result);
                logger.printLog(result.toString());
            } catch (CalcException e) {
                System.out.println(e.getMessage());
                logger.printLog(e.getMessage());
            }
        }
    }
}