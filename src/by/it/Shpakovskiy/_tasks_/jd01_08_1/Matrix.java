package by.it.Shpakovskiy._tasks_.jd01_08_1;

public class Matrix extends Var {
    private double[][] value;

    Matrix(double[][] value) {
        this.value = new double[value.length][value[0].length];
        for (int i = 0; i < value.length; i++) {
            System.arraycopy(value[i], 0, this.value[i], 0, value[i].length);
        }
    }

    Matrix(Matrix matrix) {
        this(matrix.value);
    }

    Matrix(String strMatrix) {
        strMatrix = strMatrix.replaceAll("[{|}]{2,}", "");
        String[] stringValue = strMatrix.split("[}][\\s]?,[\\s]?[{]");
        value = new double[stringValue.length][];
        for (int i = 0; i < stringValue.length; i++) {
            String[] valueStringNumber = stringValue[i].trim().split(",");
            double[] tempArr = new double[valueStringNumber.length];
            for (int j = 0; j < valueStringNumber.length; j++) {
                tempArr[j] = Double.parseDouble(valueStringNumber[j]);
                value[i] = tempArr;
            }
        }
    }

    public double[][] getValue() {
        return value;
    }

    public void setValue(double[][] value) {
        this.value = value;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder("{{");
        String s = "";
        for (double[] aValue : value) {
            for (double v : aValue) {
                stringBuilder.append(s).append(v);
                s = ", ";
            }
            stringBuilder.append("}");
            s = ", {";
        }
        stringBuilder.append("}");
        return stringBuilder.toString();
    }

    @Override
    public Var add(Var other) {
        return other.add(this);
    }

    @Override
    public Var add(Scalar other) {
        return super.add(other);
    }

    @Override
    public Var add(Vector other) {
        return super.add(other);
    }

    @Override
    public Var add(Matrix other) {
        return super.add(other);
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
