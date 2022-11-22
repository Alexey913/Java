/*Задан массив чисел: 3, 7, 2, 4, 9, 1, 0
 * Написать программу, которая будет принимать от пользователя число,
 * и в случае, если оно равно элементу массива,
 * переместить этот элемент в конец массива.
 */


package Seminar1;

import java.util.Scanner;

public class Task1_5 {
    public static void main (String [] Args){
        int[] array = new int [] {3,7,2,4,9,1,0};
        Scanner scan = new Scanner(System.in);
        int num = scan.nextInt();
        for (int i = 0; i < array.length-1; i++){
            if (array[i] == num) {
                int temp = array[i];
                array[i] = array[i+1];
                array[i+1] = temp;
            }
        }
        for (int i: array) {
            System.out.print(i+" ");
        }
    }
}