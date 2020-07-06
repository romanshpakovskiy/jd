package by.it.romanshpakovskiy.tasks.calc;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

abstract class Var implements Operation {
    private static Map<String, Var> varMap = new HashMap<>();

    static Var createVar(String operand) throws CalcException {
        operand = operand.replaceAll(" ", "");
        if (operand.matches((Patterns.Scalar)))
            return new Scalar(operand);
        else if (operand.matches((Patterns.Vector)))
            return new Vector(operand);
        else if (operand.matches((Patterns.Matrix)))
            return new Matrix(operand);
        else if (varMap.containsKey(operand))
            return varMap.get(operand);
        throw new CalcException("Unknown operand: " + operand);
    }

    static String printVars() {
        StringBuilder retValue = new StringBuilder();
        if (varMap.isEmpty())
            System.out.println("no variables defined");
        Set<Map.Entry<String, Var>> entries = varMap.entrySet();
        for (Map.Entry<String, Var> varMapValue : entries) {
            retValue.append(varMapValue.getKey()).append("=");
            retValue.append(varMapValue.getValue().toString());
            retValue.append('\n');
        }
        return retValue.toString();
    }

    static void saveVar(String key, Var var) {
        varMap.put(key, var);
        try {
            saveVarToFile();
        } catch (CalcException e) {
            e.printStackTrace();
        }
    }

    static void saveVarToFile() throws CalcException {
        try (PrintWriter writer = new PrintWriter("src/by/it/romanshpakovskiy/tasks/jd02_04/vars.txt")) {
            varMap.forEach((key, value) -> writer.printf("%s=%s\n", key, value));
        } catch (FileNotFoundException e) {
            throw new CalcException("Saving to file error");
        }
    }

    @Override
    public Var add(Var rightOperand) throws CalcException {
        return null;
    }

    public Var add(Scalar operand) throws CalcException {
        throw new CalcException("Operation " + operand + " + " + this + " impossible");
    }

    public Var add(Vector operand) throws CalcException {
        throw new CalcException("Operation " + operand + " + " + this + " impossible");
    }

    public Var add(Matrix operand) throws CalcException {
        throw new CalcException("Operation " + operand + " + " + this + " impossible");
    }

    @Override
    public Var sub(Var operand) throws CalcException {
        throw new CalcException("Operation " + this + " - " + operand + " impossible");
    }

    public Var sub(Scalar operand) throws CalcException {
        throw new CalcException("Operation " + operand + " - " + this + " impossible");
    }

    public Var sub(Vector operand) throws CalcException {
        throw new CalcException("Operation " + operand + " - " + this + " impossible");
    }

    public Var sub(Matrix operand) throws CalcException {
        throw new CalcException("Operation " + operand + " - " + this + " impossible");
    }

    @Override
    public Var mul(Var operand) throws CalcException {
        return null;
    }

    public Var mul(Scalar operand) throws CalcException {
        throw new CalcException("Operation " + operand + " * " + this + " impossible");
    }

    public Var mul(Vector operand) throws CalcException {
        throw new CalcException("Operation " + operand + " * " + this + " impossible");
    }

    public Var mul(Matrix operand) throws CalcException {
        throw new CalcException("Operation " + operand + " * " + this + " impossible");
    }

    @Override
    public Var div(Var operand) throws CalcException {
        return null;
    }

    public Var div(Scalar operand) throws CalcException {
        throw new CalcException("Operation " + operand + " / " + this + " impossible");
    }

    public Var div(Vector operand) throws CalcException {
        throw new CalcException("Operation " + operand + " / " + this + " impossible");
    }

    public Var div(Matrix operand) throws CalcException {
        throw new CalcException("Operation " + operand + " / " + this + " impossible");
    }
}
