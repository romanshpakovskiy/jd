package by.it.romanshpakovskiy.tasks.jd02_04;

import java.util.Arrays;

class Vector extends Var {
    private double[] value;

    Vector(double[] value) {
        this.value = new double[value.length];
        for (int i = 0; i < value.length; i++) {
            System.arraycopy(value, 0, this.value, 0, value.length);
        }
    }

    public double[] getValue() {
        return value;
    }

    Vector(String strVector) {
        strVector = strVector.replaceAll("[{|}]", "");
        String[] strVal = strVector.split(",");
        value = new double[strVal.length];
        for (int i = 0; i < strVal.length; i++) {
            value[i] = Double.parseDouble(strVal[i].trim());
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{");
        String del = "";
        for (double el : value) {
            sb.append(del).append(el);
            del = ", ";
        }
        sb.append("}");
        return sb.toString();
    }

    @Override
    public Var add(Var other) {
        return other.add(this);
    }

    @Override
    public Var add(Vector other) {
        double[] resVector = Arrays.copyOf(value, value.length);
        if (this.value.length == other.getValue().length) {
            for (int i = 0; i < resVector.length; i++) {
                resVector[i] += other.value[i];
            }
        }
        return new Vector(resVector);
    }

    @Override
    public Var add(Scalar other) {
        double[] resVector = Arrays.copyOf(value, value.length);
        for (int i = 0; i < value.length; i++) {
            resVector[i] += other.getValue();
        }
        return new Vector(resVector);
    }

    @Override
    public Var sub(Var other) {
        return other.sub(this);
    }

    @Override
    public Var sub(Vector other) {
        double[] resVector = Arrays.copyOf(value, value.length);
        if (this.value.length == other.getValue().length) {
            for (int i = 0; i < resVector.length; i++) {
                resVector[i] -= other.value[i];
            }
        }
        return new Vector(resVector);
    }

    @Override
    public Var sub(Scalar other) {
        double[] resVector = Arrays.copyOf(value, value.length);
        for (int i = 0; i < value.length; i++) {
            resVector[i] -= other.getValue();
        }
        return new Vector(resVector);
    }

    @Override
    public Var mul(Var other) {
        return other.mul(this);
    }

    @Override
    public Var mul(Vector other) {
        double res = 0;
        if (this.value.length == other.getValue().length) {
            for (int i = 0; i < value.length; i++) {
                res += value[i] * other.value[i];
            }
        }
        return new Scalar(res);
    }

    @Override
    public Var mul(Scalar other) {
        double[] resVector = Arrays.copyOf(value, value.length);
        for (int i = 0; i < value.length; i++) {
            resVector[i] *= other.getValue();
        }
        return new Vector(resVector);
    }

    @Override
    public Var div(Var other) throws CalcException {
        return other.div(this);
    }
}
