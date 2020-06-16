package by.it.romanshpakovskiy.tasks.jd02_04;

import java.util.HashMap;
import java.util.Map;

abstract class Var implements Operation {
    static Var createVar(String operand){
        operand = operand.trim().replace("\\s+", "");
        if(operand.matches((Patterns.Scalar))){
            return new Scalar(operand);
        }

        if(operand.matches((Patterns.Vector))){
            return new Vector(operand);
        }

        if(operand.matches((Patterns.Matrix))){
            return new Matrix(operand);
        }
        return null;
    }

    public Var add(Var other) throws CalcException {
        System.out.println("Sum operation " + this + "+" + other + " unreal");
        return null;
    }

    public abstract Var add(Vector other);

    public abstract Var add(Scalar other);

    public abstract Var add(Matrix other);

    public Var sub(Var other){
        System.out.println("Sub operation " + this + "-" + other + " unreal");
        return null;
    }

    public abstract Var sub(Vector other);

    public abstract Var sub(Scalar other);

    public abstract Var sub(Matrix leftOperand);

    public Var mul(Var other){
        System.out.println("Mul operation " + this + "*" + other + " unreal");
        return null;
    }

    public abstract Var mul(Vector other);

    public abstract Var mul(Scalar other);

    public abstract Var mul(Matrix other);

    public Var div(Var other) throws CalcException {
        System.out.println("Div operation " + this + "/" + other + " unreal");
        return null;
    }

    public abstract Var div(Scalar other) throws CalcException;

    public abstract Var div(Vector other) throws CalcException;

    public abstract Var div(Matrix other) throws CalcException;
}
