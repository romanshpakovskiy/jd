package by.it.romanshpakovskiy.tasks.jd01_08;

abstract class Var implements Operation {
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
