package by.it.Shpakovskiy._tasks_.jd01_08_1;

public class Runner {
    public static void main(String[] args) {
        Var scalarVar = new Scalar(2.5);
        Scalar scalar = new Scalar(5.0);
        Var vector = new Vector(new double[]{5.3, 7.9});
        System.out.println(scalarVar.add(scalarVar));
        System.out.println("______________________");
        System.out.println(vector.add(scalarVar));
        System.out.println("_____________________");
        System.out.println(vector.add(vector));
    }
}
