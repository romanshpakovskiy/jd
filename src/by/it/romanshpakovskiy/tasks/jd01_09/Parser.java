package by.it.romanshpakovskiy.tasks.jd01_09;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    Var calc(String exp){
        String[] operand = exp.split(Patterns.Operation);
        Var one = Var.createVar(operand[0]);
        Var two = Var.createVar(operand[1]);
        if(one == null || two == null) return null;
        Pattern pattern = Pattern.compile(Patterns.Operation);
        Matcher matcher = pattern.matcher(exp);
        if(matcher.find()){
            String operation = matcher.group();
            switch (operation){
                case "+": return one.add(two);
                case "-": return one.sub(two);
                case "*": return one.mul(two);
                case "/": return one.div(two);
            }
        }
        return null;
    }
}
