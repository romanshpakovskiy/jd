package by.it.romanshpakovskiy.tasks.jd01_07;

class Vector extends Var {
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
}
