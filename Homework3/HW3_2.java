// 2. Пусть дан произвольный список целых чисел, удалить из него четные числа

import java.util.ArrayList;
import java.util.Random;


public class HW3_2 {
    public static void main(String[] args) {
        ArrayList <Integer> arrForDel = fillArr();
        System.out.println("Входной список:");
        System.out.println(arrForDel);
        delEven(arrForDel);
        System.out.println("Список с удаленными четными числами:");
        System.out.println(arrForDel);
    }
              
    static ArrayList <Integer> fillArr() {
        Random rnd = new Random();
        int size = rnd.nextInt(3, 20);
        ArrayList <Integer> array = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            array.add(rnd.nextInt(-size*2, size*2));
        } 
        return array;
    }

    static ArrayList <Integer> delEven(ArrayList <Integer> entArr) {
        for (int i = 0; i < entArr.size(); i++) {
            if (entArr.get(i)%2 == 0) {
                entArr.remove(i);
                i--;
            }
        }
        return entArr;
    }    
}