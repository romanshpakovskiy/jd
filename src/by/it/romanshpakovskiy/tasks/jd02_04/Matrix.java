package by.it.romanshpakovskiy.tasks.jd02_04;

class Matrix extends Var {
    private double[][] value;

    public double[][] getValue() {
        return value;
    }

    Matrix(double[][] value) {
        this.value = new double[value.length][value[0].length];
        for (int i = 0; i < value.length; i++) {
            System.arraycopy(value[i], 0, this.value[i], 0, value[i].length);
        }
    }

    Matrix(String strMatrix) {
        strMatrix = strMatrix.replaceAll("[{|}]{2,}", "");
        String[] stringValue = strMatrix.split("[}][\\s]?,[\\s]?[{]");
        value = new double[stringValue.length][];
        for (int i = 0; i < stringValue.length; i++) {
            String[] valueStr = stringValue[i].trim().split(",");
            double[] valStr = new double[valueStr.length];
            for (int j = 0; j < valueStr.length; j++) {
                valStr[j] = Double.parseDouble(valueStr[j]);
                value[i] = valStr;
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("{{");
        String s = "";
        for (double[] val : value) {
            for (double v : val) {
                sb.append(s).append(v);
                s = ", ";
            }
            sb.append("}");
            s = ", {";
        }
        sb.append("}");
        return sb.toString();
    }

    @Override
    public Var add(Var other) {
        return other.add(this);
    }

    @Override
    public Var add(Matrix other) {
        double[][] result = new double[value.length][value[0].length];
        if (other.value.length == value.length && value[0].length == other.value[0].length) {
            for (int i = 0; i < value.length; i++) {
                for (int j = 0; j < value[i].length; j++) {
                    result[i][j] = value[i][j] + other.value[i][j];
                }
            }
        }
        return new Matrix(result);
    }

    @Override
    public Var add(Scalar other) {
        double[][] result = new double[value.length][value[0].length];
        for (int i = 0; i < value.length; i++) {
            for (int j = 0; j < value[i].length; j++) {
                result[i][j] = value[i][j] + other.getValue();
            }
        }
        return new Matrix(result);
    }

    @Override
    public Var sub(Var other) {
        return other.sub(this);
    }

    @Override
    public Var sub(Matrix other) {
        double[][] result = new double[value.length][value[0].length];
        if (other.value.length == value.length && value[0].length == other.value[0].length) {
            for (int i = 0; i < value.length; i++) {
                for (int j = 0; j < value[i].length; j++) {
                    result[i][j] = value[i][j] - other.value[i][j];
                }
            }
        }
        return new Matrix(result);
    }

    @Override
    public Var sub(Scalar other) {
        double[][] result = new double[value.length][value[0].length];
        for (int i = 0; i < value.length; i++) {
            for (int j = 0; j < value[i].length; j++) {
                result[i][j] = value[i][j] - other.getValue();
            }
        }
        return new Matrix(result);
    }

    @Override
    public Var mul(Var other) {
        return other.mul(this);
    }

    @Override
    public Var mul(Scalar other) {
        double[][] res = new double[value.length][value.length];
        for (int i = 0; i < res.length; i++) {
            for (int j = 0; j < res.length; j++) {
                res[i][j] = value[i][j] * other.getValue();
            }
        }
        return new Matrix(res);
    }

    @Override
    public Var mul(Matrix other) {
        double[][] res = new double[value.length][value[0].length];
        if (this.getValue().length == other.value.length) {
            for (int i = 0; i < other.value.length; i++) {
                for (int j = 0; j < value[0].length; j++) {
                    for (int k = 0; k < value.length; k++) {
                        res[i][j] += value[i][k] * other.getValue()[k][j];
                    }
                }
            }
        }
        return new Matrix(res);
    }

    @Override
    public Var mul(Vector other) {
        double[] res = new double[value.length];
        if (value[0].length == other.getValue().length) {
            for (int i = 0; i < value.length; i++) {
                for (int j = 0; j < value[0].length; j++) {
                    res[i] += other.getValue()[j] * value[i][j];
                }
            }
        }
        return new Vector(res);
    }

    @Override
    public Var div(Var other) throws CalcException {
        return other.div(this);
    }
}
