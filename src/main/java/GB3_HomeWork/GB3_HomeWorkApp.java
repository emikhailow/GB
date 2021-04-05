package GB3_HomeWork;

import java.util.Arrays;
import java.util.Random;

public class GB3_HomeWorkApp {

    public static void main(String[] args) {

        Task1(10);
        Task2();
        Task3();
        Task4(6);
        Task5(5, 23);
        Task6(10, 100);
        Task7(new int[] {1,1,1});
        Task8(6, 2);
    }

    public static void Task1(int n) {

        System.out.println("Задание 1:");
        int array[] = new int[n];
        Random random = new Random(System.currentTimeMillis());
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(2);
        }
        System.out.println("Исходный массив: " + Arrays.toString(array));
        for (int i = 0; i < array.length; i++) {
            array[i] = (array[i] + 1) % 2;
        }
        System.out.println("Конечный массив: " + Arrays.toString(array));

    }

    public static void Task2() {

        System.out.println("Задание 2:");
        int array[] = new int[100];
        for (int i = 0; i < array.length; i++) {
            array[i] = i + 1;
        }
        System.out.println(Arrays.toString(array));

    }

    public static void Task3() {

        System.out.println("Задание 3:");
        int array[] = new int[]{1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        for (int i = 0; i < array.length; i++) {
            if (array[i] < 6) {
                array[i] = array[i] * 2;
            }
        }
        ;
        System.out.println(Arrays.toString(array));

    }

    public static void Task4(int n) {

        System.out.println("Задание 4:");

        int matrix[][] = new int[n][n];

        for(int i =0; i < n; i++){
            for(int j = 0; j < n; j++){

                if(i == j || i == n - j - 1){
                    matrix[i][j] = 1;
                };

            }
        }
        for(int i=0; i < n; i++){
           System.out.println(Arrays.toString(matrix[i]));
        };

    }

    public static void Task5(int len, int initialValue){

        System.out.println("Задание 5:");
        System.out.println(Arrays.toString(createArray(5, 23)));

    }

    public static int[] createArray(int len, int initialValue){

        int array[] = new int[len];
        Arrays.fill(array, initialValue);
        return array;

    }

    public static void Task6(int n, int maxValue){

        System.out.println("Задание 6:");

        int array[] = new int[n];
        Random random = new Random(System.currentTimeMillis());
        for (int i = 0; i < array.length; i++) {
            array[i] = random.nextInt(maxValue) * (random.nextBoolean()? -1: 1);
        }
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for(int i = 0; i < n; i++){

            if(array[i] > max){
                max = array[i];
            }
            if(array[i] < min){
                min = array[i];
            }

        }
        System.out.println("Массив: " + Arrays.toString(array));
        System.out.printf("Максимальный элемент %d, минимальный элемент %d \n", max, min);

    }

    public static void Task7(int[] array){

        System.out.println("Задание 7:");
        System.out.println(arrayHasEqualParts(array));

    }

    public static boolean arrayHasEqualParts(int[] array){

        for(int n = 0; n < array.length - 1; n++){

            int sum1 = 0;
            for(int i = 0; i <= n; i++){
                sum1 += array[i];
            }
            int sum2 = 0;
            for(int j = n + 1; j < array.length; j++){
                sum2 += array[j];
            };
            if(sum1 == sum2){
                return true;
            }

        }
        return false;

    }

    public static void Task8(int n, int shift){

        System.out.println("Задание 8:");
        int maxValue = 100;
        int array[] = new int[n];
        Random random = new Random(System.currentTimeMillis());
        for (int i = 0; i < array.length; i++) {
           array[i] = random.nextInt(maxValue);
        }
        System.out.println("Исходный массив:");
        System.out.println(Arrays.toString(array));
        cycleShift(array, shift);
        System.out.printf("Массив со сдвигом на %d позиций:\n", shift);
        System.out.println(Arrays.toString(array));
    }

    public static void cycleShift(int[] array, int shift){

        int realShift = shift;
        while(realShift < 0){
            realShift += array.length;
        }

        int index = 0;
        int newValue;
        int startIndex = 0;
        int tmp = array[0];
        for(int i = 0; i < array.length; i++){

            index = (index + realShift) % array.length;

            newValue = tmp;
            tmp = array[index];
            array[index] = newValue;

            if(index == startIndex){

               index = ++startIndex % array.length;
               tmp = array[index];

            }

        }

    }

}
