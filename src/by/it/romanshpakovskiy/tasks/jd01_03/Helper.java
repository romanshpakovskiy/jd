package by.it.romanshpakovskiy.tasks.jd01_03;

public class Helper {

    public static void main(String[] args) {
        double[] mas = {1, 5, -5, -9, 4, 6, 8};
        for(int i = 0; i < mas.length; i++){
            System.out.print(mas[i] + " ");
        }

        Helper helper = new Helper();
        InOut io = new InOut();
        System.out.println("min: ");
        helper.findMin(mas);
        System.out.println("max: ");
        helper.findMax(mas);
        System.out.println();
        helper.bubbleSort(mas);
        helper.MiniMax(mas);

    }

    private static void printMas(double[] mas){
        for(double m: mas) System.out.print(m + " ");
        System.out.println();
    }


    static double findMin(double[] mas){
        double min = mas[0];
        for(int i = 0; i  < mas.length; i++){
            if(min > mas[i]) min = mas[i];
        }
        return min;
    }

    static double findMax(double[] mas){
        double max = mas[0];
        for(int i = 0; i  < mas.length; i++){
            if(max < mas[i]) max = mas[i];
        }
        return max;
    }

    static double[] bubbleSort(double[] mas){
        System.out.println("Before:");
        printMas(mas);
        int l = mas.length - 1;
        boolean swap;
        do{
            swap = false;
            for(int j = 0; j < l; j++){
                if (mas[j] > mas[j + 1]) {
                    double buf = mas[j];
                    mas[j] = mas[j + 1];
                    mas[j + 1] = buf;
                }
            }
            l--;
        }
        while(swap);
        return mas;
    }

    static double[] MiniMax(double[] mas){
        for(int i = 0; i < mas.length - 1; i++){
            for(int j = i + 1; j < mas.length; j++){
                if((mas[i] > mas[j]) || (mas[i] < mas[j])){
                    double m = mas[i];
                    mas[i] = mas[j];
                    mas[j] = m;
                }
            }
        }
        return mas;
    }

}
