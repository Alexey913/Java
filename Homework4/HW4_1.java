// Пусть дан LinkedList с несколькими элементами. Реализуйте метод, который вернет “перевернутый” список.

import java.util.LinkedList;
import java.util.Random;

public class HW4_1 {
    public static void main(String[] args) {
        Random rnd = new Random();
        int size = rnd.nextInt(5,15);
        LinkedList <Integer> listForSort = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            listForSort.add(i);
        }
        System.out.println("Входной список: " + listForSort);
        for (int i = 0; i < size; i++) {
            listForSort.add(i, listForSort.pollLast());
        }
        System.out.println("Перевернутый список: " + listForSort);
    }
}
