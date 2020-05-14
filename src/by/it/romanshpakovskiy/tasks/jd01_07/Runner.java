package by.it.romanshpakovskiy.tasks.jd01_07;

public class Runner {
    public static void main(String[] args) {
        Var val1 = new Scalar(3.1415);
        System.out.println(val1);
        Var val2 = new Vector("{1.0, 2.0, 3.0}");
        System.out.println(val2);
        Var val3 = new Matrix(new double[][] {{1.0, 2.0}, {3.0, 4.0}});
    }
}
