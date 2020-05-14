package by.it.Shpakovskiy._tasks_.jd01_08;

import java.util.Arrays;
import java.util.regex.Pattern;

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
        if(other instanceof Vector) {
            double[] resVector = Arrays.copyOf(value, value.length);
            if (this.value.length == ((Vector) other).getValue().length) {
                for (int i = 0; i < resVector.length; i++) {
                    resVector[i] += ((Vector) other).value[i];
                }
            }
            return new Vector(resVector);
        }

        if(other instanceof Scalar){
            double[] resVector = Arrays.copyOf(value, value.length);
            for(int i = 0; i < value.length; i++){
                resVector[i] += ((Scalar) other).getValue();
            }
            return new Vector(resVector);
        }

        else return super.add(other);
    }

    @Override
    public Var sub(Var other) {
        if(other instanceof Vector) {
            double[] resVector = Arrays.copyOf(value, value.length);
            if (this.value.length == ((Vector) other).getValue().length) {
                for (int i = 0; i < resVector.length; i++) {
                    resVector[i] -= ((Vector) other).value[i];
                }
            }
            return new Vector(resVector);
        }

        if(other instanceof Scalar){
            double[] resVector = Arrays.copyOf(value, value.length);
            for(int i = 0; i < value.length; i++){
                resVector[i] -= ((Scalar) other).getValue();
            }
            return new Vector(resVector);
        }

        else return super.sub(other);
    }

    @Override
    public Var mul(Var other) {
        if (other instanceof Vector) {
            double res = 0;
            if (this.value.length == ((Vector) other).getValue().length) {
                for (int i = 0; i < value.length; i++) {
                    res += value[i] * ((Vector) other).value[i];
                }
            }
            return new Scalar(res);
        }

        if (other instanceof Scalar) {
            double[] resVector = Arrays.copyOf(value, value.length);
            for (int i = 0; i < value.length; i++) {
                resVector[i] *= ((Scalar) other).getValue();
            }
            return new Vector(resVector);
        }

        else return super.mul(this);
    }

    @Override
    public Var div(Var other) {
        if(other instanceof Scalar){
            double[] resVector = Arrays.copyOf(value, value.length);
            for (int i = 0; i < value.length; i++) {
                resVector[i] /= ((Scalar) other).getValue();
            }
            return new Vector(resVector);
        }

        return super.div(this);
    }
}
