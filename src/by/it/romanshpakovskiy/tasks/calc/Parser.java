package by.it.romanshpakovskiy.tasks.calc;import java.util.*;import java.util.regex.Matcher;import java.util.regex.Pattern;public class Parser {    private static final Map<String, Integer> priority = new HashMap<>();    private static void priorityInitializer() {        priority.put("=", 0);        priority.put("+", 1);        priority.put("-", 1);        priority.put("*", 2);        priority.put("/", 2);    }    static {        priorityInitializer();    }    private int getIndex(List<String> operations) {        int index = 0;        int curPriority = 0;        for (int i = 0; i < operations.size(); i++) {            String op = operations.get(i);            if (priority.get(op) > curPriority) {                index = i;                curPriority = priority.get(op);            }        }        return index;    }    Var calculateExpression(String expression) throws CalcException {        String[] operandParts = expression.split(Patterns.Operation);        List<String> operands = new ArrayList<>(Arrays.asList(operandParts));        List<String> operations = new ArrayList<>();        Pattern operationPattern = Pattern.compile(Patterns.Operation);        Matcher matcher = operationPattern.matcher(expression);        while (matcher.find()) {            String operation = matcher.group();            operations.add(operation);        }        if (operations.size() == 0)            return Var.createVar(expression);        while (operations.size() > 0) {            int index = getIndex(operations);            String operation = operations.remove(index);            String first = operands.remove(index);            String second = operands.remove(index);            Var result = operation(first, second, operation);            operands.add(index, result.toString());        }        return Var.createVar(operands.get(0));    }    private Var operation(String first, String second, String operation) throws CalcException {        Var sec = Var.createVar(second);        if (operation.equals("=")) {            Var.saveVar(first, sec);            return sec;        }        Var ft = Var.createVar(first);        if (ft != null && sec != null) {            switch (operation) {                case "+":                    return ft.add(sec);                case "-":                    return ft.sub(sec);                case "*":                    return ft.mul(sec);                case "/":                    return ft.div(sec);            }        }        throw new CalcException("Incorrect operation!");    }}