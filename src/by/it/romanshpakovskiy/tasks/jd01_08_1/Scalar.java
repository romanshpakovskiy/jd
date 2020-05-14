package by.it.romanshpakovskiy.tasks.jd01_08_1;

public class Scalar extends Var{
    private double value;

    public double getValue() {
        return value;
    }

    Scalar(double value){
        this.value = value;
    }

    Scalar(Scalar scalar){
        this.value = scalar.value;
    }

    Scalar(String strScalar){
        this.value = Double.parseDouble(strScalar);
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }



    @Override
    public Var add(Var other) {
        System.out.println(getClass().getName()+" Var add(Var other)");
        return other.add(this);
    }

    @Override
    public Var add(Scalar other) {
        System.out.println(getClass().getName()+" Var add(Scalar other)");
        return new Scalar(this.value+other.value);
    }

    @Override
    public Var add(Vector other) {
        System.out.println(getClass().getName()+" Var add(Vector other)");
        return other.add(this);
    }

    @Override
    public Var add(Matrix other) {
        return other.add(this);
    }

    @Override
    public Var sub(Var other) {
        return super.sub(other);
    }

    @Override
    public Var sub(Scalar other) {
        return super.sub(other);
    }

    @Override
    public Var sub(Vector other) {
        return super.sub(other);
    }

    @Override
    public Var sub(Matrix other) {
        return super.sub(other);
    }

    @Override
    public Var mul(Var other) {
        return super.mul(other);
    }

    @Override
    public Var mul(Scalar other) {
        return super.mul(other);
    }

    @Override
    public Var mul(Vector other) {
        return super.mul(other);
    }

    @Override
    public Var mul(Matrix other) {
        return super.mul(other);
    }

    @Override
    public Var div(Var other) {
        return super.div(other);
    }

    @Override
    public Var div(Scalar other) {
        return super.div(other);
    }

    @Override
    public Var div(Vector other) {
        return super.div(other);
    }

    @Override
    public Var div(Matrix other) {
        return super.div(other);
    }
}
