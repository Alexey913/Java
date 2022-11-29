import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

/* Заполнить список десятью случайными числами.
Отсортировать список методом sort() и вывести его на экран. */


public class Task3_1 {
    public static void main (String [] Args) {
        Random rnd = new Random();
        // ArrayList <Integer> intArray = new ArrayList<>(Arrays.asList(1, 2, 3, 4));
        ArrayList <Integer> intArray = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            intArray.add(rnd.nextInt(100));
        }
        printArray(intArray);
        Collections.sort(intArray);
        System.out.println(intArray);
        printArray(intArray);
    }

    static void printArray(ArrayList<Integer> array) {
        System.out.println(String.join(",",String.valueOf(array)));
        // for (Integer number: array) {
        //     System.out.print(number + ", ");
        }
    }
