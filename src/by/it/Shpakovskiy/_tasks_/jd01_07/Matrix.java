package by.it.Shpakovskiy._tasks_.jd01_07;

class Matrix extends Var {
    private double[][] value;
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
}
