package by.it.romanshpakovskiy.tasks.jd01_08_1;

import java.util.Arrays;

class Vector extends Var{
    private double[] value;
    Vector(double[] value){
        this.value = new double[value.length];
        for(int i = 0; i < value.length; i++){
            System.arraycopy(value, 0 , this.value, 0, value.length);
        }
    }

    Vector(Vector vector){
        value = vector.value;
    }

    public double[] getValue() {
        return value;
    }

    Vector(String strVector){
        strVector = strVector.replaceAll("[{|}]", "");
        String[] strVal = strVector.split(",");
        value = new double[strVal.length];
        for(int i = 0; i < strVal.length; i++){
            value[i] = Double.parseDouble(strVal[i].trim());
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        String del = "";
        for(double el: value){
            sb.append(del).append(el);
            del = ", ";
        }
        sb.append("}");
        return sb.toString();
    }

    @Override
    public Var add(Var other) {
        System.out.println(getClass().getName()+" Var add(Var other)");
        return other.add(this);
    }

    @Override
    public Var add(Scalar other) {
        System.out.println(getClass().getName()+" Var add(Scalar other)");
        double[] result = Arrays.copyOf(value, value.length);
        for (int i = 0; i < result.length; i++) {
            result[i] += other.getValue();
        }
        return new Vector(result);
    }

    @Override
    public Var add(Vector other) {
        System.out.println(getClass().getName()+" Var add(Vector other)");
        if (this.value.length == other.value.length) {
            double[] result = Arrays.copyOf(value, value.length);
            for (int i = 0; i < result.length; i++) {
                result[i] += other.value[i];
            }
            return new Vector(result);
        }
        return super.mul(other);
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
