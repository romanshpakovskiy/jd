package by.it.romanshpakovskiy.tasks.jd01_04;

public class TaskC {
    public static void main(String[] args) {
        int[] array = new int[] {64, 42, 73, 41, 32, 53, 16, 24, 57, 42, 74, 55, 36};
        System.out.println(arrayToString(array));
        array = mergeSort(array);
    }
    public static void merge(int[] mas1, int mas1_ind, int[] mas2, int mas2_ind, int[] mas, int mas_index, int size ){
        int i1 = mas1_ind;
        int i2 = mas2_ind;

        int mas1_end = Math.min(mas1_ind + size, mas1.length);
        int mas2_end = Math.min(mas2_ind + size, mas2.length);

        int itr = mas1_end - i1 + mas2_end - i2;

        for(int i = mas_index; i < mas_index + itr; i++){
            if(i1 < mas1_ind && (i2 >= mas2_end || mas1[i1] < mas2[i2])){
                mas[i] = mas1[i1];
                i1++;
            }
            else{
                mas[i] = mas2[i2];
                i2++;
            }
        }
    }

    public static int[] mergeSort(int[] arr){
        int[] temp;
        int[] curMas = arr;
        int[] curArr = new int[arr.length];
        int size = 1;

        while(size < arr.length){
            for(int i = 0; i < arr.length; i += 2 * size){
                merge(curMas, i, curMas, i + size, curArr, i, size);
            }

            temp = curMas;
            curMas = curArr;
            curArr = temp;

            size *= 2;

            System.out.println(arrayToString(curArr));
        }
        return curArr;
    }

    private static String arrayToString(int[] array) {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < array.length; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(array[i]);
        }
        sb.append("]");
        return sb.toString();
    }


}
