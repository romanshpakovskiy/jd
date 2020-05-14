package by.it.Shpakovskiy._tasks_.jd01_08;

public class Runner {
    static void print (Var var){
        System.out.println(var);
    }
    public static void main(String[] args) {
        Var val1 = new Scalar(3.1415);
        System.out.println(val1);
        Var val2 = new Vector("{1.0, 2.0, 3.0}");
        System.out.println(val2);
        Var val3 = new Matrix(new double[][] {{1.0, 2.0}, {3.0, 4.0}});
        /* Уровень сложности A (калькулятор) */
        print(val1.add(val1)); //выведет в консоль 6.0
        print(val1.sub(val1)); //выведет в консоль 0.0
        print(val1.mul(val1)); //выведет в консоль 9.0
        print(val1.div(val1)); //выведет в консоль 1.0
        /* Уровень сложности B (векторные операции) закомментируйте, если не реализовали */
        print(val2.add(val2)); //выведет в консоль {2.0, 4.0, 6.0}
        print(val2.sub(val2)); //выведет в консоль {0.0, 0.0, 0.0}
        print(val2.mul(val2)); //выведет в консоль 14.0
        print(val2.div(val2)); //сообщит о невозможности операции
/* Уровень сложности C (матричные операции и умножение на вектор)
закомментируйте, если не реализовали */
        print(val3.add(val3)); //{{2.0, 4.0, 6.0}, {8.0, 10.0, 12.0}, {14.0, 16.0, 18.0}}
        print(val3.sub(val3)); //{{0.0, 0.0, 0.0}, {0.0, 0.0, 0.0}, {0.0, 0.0, 0.0}}
        print(val3.mul(val3)); //{{30.0, 36.0, 42.0}, {66.0, 81.0, 96.0}, {102.0, 126.0, 150.0}}
        print(val3.mul(val2)); //{14.0, 32.0, 50.0}
    }
}
