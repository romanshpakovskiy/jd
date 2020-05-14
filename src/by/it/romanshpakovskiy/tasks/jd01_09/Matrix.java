package by.it.romanshpakovskiy.tasks.jd01_09;

class Matrix extends Var {
    private double[][] value;

    public double[][] getValue() {
        return value;
    }

    Matrix(double[][] value){
        this.value = new double[value.length][value[0].length];
        for(int i = 0; i < value.length; i++){
            System.arraycopy(value[i], 0, this.value[i], 0, value[i].length);
        }
    }

    Matrix(Matrix matrix){
        value = matrix.value;
    }

    Matrix(String strMatrix){
        strMatrix = strMatrix.replaceAll("[{|}]{2,}", "");
        String[] stringValue = strMatrix.split("[}][\\s]?,[\\s]?[{]");
        value = new double[stringValue.length][];
        for(int i = 0; i < stringValue.length; i++){
            String[] valueStr = stringValue[i].trim().split(",");
            double[] valStr = new double[valueStr.length];
            for(int j = 0; j < valueStr.length; j++){
                valStr[j] =  Double.parseDouble(valueStr[j]);
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
        if(other instanceof Matrix){
            Matrix otherMatrix = (Matrix) other;
            if (otherMatrix.value.length == value.length && value[0].length == ((Matrix) other).value[0].length) {
                double[][] result = new double[value.length][value[0].length];
                for (int i = 0; i < value.length; i++) {
                    for (int j = 0; j < value[i].length; j++) {
                        result[i][j] = value[i][j] + otherMatrix.value[i][j];
                    }
                }
                return new Matrix(result);
            }
        }

        if(other instanceof Scalar){
            double[][] result = new double[value.length][value[0].length];
            for (int i = 0; i < value.length; i++) {
                for (int j = 0; j < value[i].length; j++) {
                    result[i][j] = value[i][j] + ((Scalar) other).getValue();
                }
            }
            return new Matrix(result);
        }
        return super.add(other);
    }

    @Override
    public Var sub(Var other) {
        if(other instanceof Matrix){
            Matrix otherMatrix = (Matrix) other;
            if (otherMatrix.value.length == value.length && value[0].length == ((Matrix) other).value[0].length) {
                double[][] result = new double[value.length][value[0].length];
                for (int i = 0; i < value.length; i++) {
                    for (int j = 0; j < value[i].length; j++) {
                        result[i][j] = value[i][j] - otherMatrix.value[i][j];
                    }
                }
                return new Matrix(result);
            }
        }

        if(other instanceof Scalar){
            double[][] result = new double[value.length][value[0].length];
            for (int i = 0; i < value.length; i++) {
                for (int j = 0; j < value[i].length; j++) {
                    result[i][j] = value[i][j] - ((Scalar) other).getValue();
                }
            }
            return new Matrix(result);
        }
        return super.mul(other);
    }

    @Override
    public Var mul(Var other) {
        if(other instanceof Scalar){
            double[][] res = new double[value.length][value.length];
            for(int i = 0; i < res.length; i++){
                for(int j = 0; j < res.length; j++){
                    res[i][j] = value[i][j] * ((Scalar) other).getValue();
                }
            } return new Matrix(res);
        }

        if(other instanceof Matrix){
            double[][] res = new double[value.length][value[0].length];
            if(this.getValue().length == ((Matrix) other).value.length){
                for(int i = 0; i < ((Matrix) other).value.length; i++){
                    for(int j = 0; j < value[0].length; j++){
                        for(int k = 0; k < value.length; k++){
                            res[i][j] += value[i][k] * ((Matrix) other).getValue()[k][j];
                        }
                    }
                }
            }
            return new Matrix(res);
        }

        if(other instanceof Vector){
            if(value[0].length == ((Vector) other).getValue().length) {
                double[] res = new double[value.length];
                for(int i = 0; i < value.length; i++){
                    for(int j = 0; j < value[0].length; j++){
                        res[i] += ((Vector) other).getValue()[j] * value[i][j];
                    }
                }
                return new Vector(res);
            }
        }

        return super.mul(other);
    }

    @Override
    public Var div(Var other) {
        return super.div(other);
    }
}
