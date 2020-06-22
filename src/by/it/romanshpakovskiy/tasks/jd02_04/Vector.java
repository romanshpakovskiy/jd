package by.it.romanshpakovskiy.tasks.jd02_04;

import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Vector extends Var {
    private double[] value;

    Vector(double[] value) {
        this.value = new double[value.length];
        for (int i = 0; i < value.length; i++) {
            System.arraycopy(value, 0, this.value, 0, value.length);
        }
    }

    Vector(Vector vector){
        this.value = vector.value;
    }

    public double[] getValue() {
        return value;
    }

    Vector(String strVector) {
        Pattern pattern = Pattern.compile("\\{(.*)}");
        Matcher matcher = pattern.matcher(strVector);
        if (matcher.find()) {
            String[] arr = matcher.group(1).replace(" ", "")
                    .split(",");
            value = new double[arr.length];
            for (int i = 0; i < arr.length; i++) {
                value[i] = Double.parseDouble(arr[i]);
            }
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
    public Var add(Var other) throws CalcException {
        return other.add(this);
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
    public Var add(Vector other) throws CalcException {
        double[] resVector = Arrays.copyOf(value, value.length);
        if (this.value.length == other.getValue().length) {
            for (int i = 0; i < resVector.length; i++) {
                resVector[i] += other.value[i];
            }
            return new Vector(resVector);
        }
        return super.sub(other);
    }

    @Override
    public Var sub(Var other) throws CalcException {
        return other.sub(this);
    }

    @Override
    public Var sub(Vector other) throws CalcException {
        if (this.value.length == other.getValue().length) {
            double[] resVector = Arrays.copyOf(other.value, other.value.length);
            for (int i = 0; i < resVector.length; i++) {
                resVector[i] -= value[i];
            }
            return new Vector(resVector);
        }
        return super.sub(other);
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
    public Var mul(Var other) throws CalcException {
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
    public Var mul(Matrix other) throws CalcException {
        double[] vector = this.value;
        double[][] matrix = other.getValue();
        if (matrix[0].length == vector.length) {
            double[] result = new double[matrix.length];
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[0].length; j++) {
                    result[i] = result[i] + matrix[i][j] * vector[j];
                }
            }
            return new Vector(result);
        }
        return super.mul(other);
    }

    @Override
    public Var div(Var other) throws CalcException {
        return other.div(this);
    }

    @Override
    public Var div(Scalar other) throws CalcException {
        return super.div(other);
    }

    @Override
    public Var div(Vector other) throws CalcException {
        return super.div(other);
    }

    @Override
    public Var div(Matrix other) throws CalcException {
        return super.div(other);
    }
}
