package by.it.romanshpakovskiy.tasks.jd02_04;

import java.util.Scanner;

public class ConsoleRunner {
    public static void main(String[] args) throws CalcException {
        Scanner scanner = new Scanner(System.in);
        String line;

        Parser parser = new Parser();
        Printer printer = new Printer();

        while(!(line = scanner.nextLine()).equals("end")){
            Var result = parser.parseExpression(line);
            printer.print(result);
        }
    }
}
