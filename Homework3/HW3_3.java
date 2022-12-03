// 3. Задан целочисленный список ArrayList. Найти минимальное, максимальное и среднее из этого списка.

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;


public class HW3_3 {
    public static void main(String[] args) {
        ArrayList <Integer> arrForDel = fillArr();
        System.out.println("Входной список:");
        System.out.println(arrForDel);
        Collections.sort(arrForDel);

        System.out.printf("Минимум равен: %d\nМаксимум равен: %d\nСреднее из списка: %.2f", arrForDel.get(0), arrForDel.get(arrForDel.size()-1), findMid(arrForDel));
    }
              
    static ArrayList <Integer> fillArr() {
        Random rnd = new Random();
        int size = rnd.nextInt(10);
        ArrayList <Integer> array = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            array.add(rnd.nextInt(-size, size));
        } 
        return array;
    }

    static float findMid(ArrayList <Integer> entArr) {
        float sum = 0;
        float size = entArr.size();
        for (int i = 0; i < size; i++) {
            sum+=entArr.get(i);
        }
        System.out.println(sum);
        float middle = sum/size;
        return middle;
    }    
}