import java.util.Arrays;
import java.util.Scanner;

// 1. Реализовать алгоритм сортировки слиянием - 65 строк

public class HW3_1 {
    public static void main(String[] args) {
        System.out.println("Введите элементы массива через пробел:");
        int [] ArrForSort = enterData();
        System.out.println("Введеннный массив: " + Arrays.toString(ArrForSort));
        int [] sortingArr = sortArray(ArrForSort);
        System.out.println("Отсортированный массив: " + Arrays.toString(sortingArr));
    }

    public static int[] sortArray(int[] arrayIn){ 

        if (arrayIn.length < 2) {
            return arrayIn;
        }

        int [] arrayOne = new int[arrayIn.length / 2];
        System.arraycopy(arrayIn, 0, arrayOne, 0, arrayIn.length/2);

        int [] arrayTwo = new int[arrayIn.length - arrayOne.length];
        System.arraycopy(arrayIn, arrayOne.length, arrayTwo, 0, arrayIn.length - arrayOne.length);

        arrayOne = sortArray(arrayOne);
        arrayTwo = sortArray(arrayTwo);

        return mergeArray(arrayOne, arrayTwo);
    }

    public static int [] mergeArray(int [] arrayOne, int [] arrayTwo) {

        int [] arrayOut = new int[arrayOne.length + arrayTwo.length];
        int pos1 = 0;
        int pos2 = 0;
        
        for (int i = 0; i < arrayOut.length; i++) {
            if (pos1 >= arrayTwo.length) {
                arrayOut[i] = arrayOne[i - pos1];
                pos2++;
                }
            else if (pos2 >= arrayOne.length) {
                arrayOut[i] = arrayTwo[i - pos2];
                pos1++;
                }
            else if (arrayOne[i - pos1] < arrayTwo[i - pos2]) {
                arrayOut[i] = arrayOne[i - pos1];
                pos2++;
                }
            else {
                arrayOut[i] = arrayTwo[i - pos2];
                pos1++;
                }
        }
        return arrayOut;
    }

    static int [] enterData() {
        Scanner sc = new Scanner(System.in);
        String dataForArray = sc.nextLine();
        String [] stringArray = dataForArray.split(" ");
        int len = stringArray.length;
        int [] array = new int [len];
        for (int i = 0; i < len; i++) {
            try {
                array[i] = Integer.parseInt(stringArray[i]);
            }
            catch (Exception e) {
                System.out.printf("Вы ввели какую-то дичь для %d элемента. Я заменил его на 0\n", i+1);
                array[i] = 0;
            }
        }
        return array;
    }
}