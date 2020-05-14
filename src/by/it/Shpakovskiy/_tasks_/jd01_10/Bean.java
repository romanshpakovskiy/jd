package by.it.Shpakovskiy._tasks_.jd01_10;

public class Bean {

    @Param(a = 1, b = 2)
    double sum(int a, int b){
        return a + b;
    }

    @Param(a = 2, b = 3)
    double avg(int a, int b){
        return (a + b) / 2.0;
    }

    @Param(a = 3, b = 4)
    static double min(int a, int b){
        return Math.min(a, b);
    }

    static double max(int a, int b){
        return Math.max(a, b);
    }
}
