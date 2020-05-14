package by.it.Shpakovskiy._tasks_.jd01_09;

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
    public Var add(Var other){
        System.out.println("Sum operation " + this + "+" + other + " unreal");
        return null;
    }

    public Var sub(Var other){
        System.out.println("Sub operation " + this + "-" + other + " unreal");
        return null;
    }

    public Var mul(Var other){
        System.out.println("Mul operation " + this + "*" + other + " unreal");
        return null;
    }

    public Var div(Var other){
        System.out.println("Div operation " + this + "/" + other + " unreal");
        return null;
    }
}
