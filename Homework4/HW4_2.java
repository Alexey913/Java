// Реализуйте очередь с помощью LinkedList со следующими методами: enqueue() - помещает элемент в конец очереди,
// dequeue() - возвращает первый элемент из очереди и удаляет его, first() - возвращает первый элемент из очереди, не удаляя.

import java.util.Deque;
import java.util.InputMismatchException;
import java.util.LinkedList;
import java.util.Random;
import java.util.Scanner;


public class HW4_2 {
    public static void main(String[] args) {
        Random rnd = new Random();
        int size = rnd.nextInt(5,15);
        Deque <Integer> listForSort = new LinkedList<>();
        for (int i = 0; i < size; i++) {
            listForSort.add(rnd.nextInt(-size, size));
        }
        System.out.println("Исходный список: " + listForSort + "\n");
        int repeat = 1;
        while (repeat == 1) {
            System.out.println("Какое действие желаете выполнить?\n1 - Поместить элемент в конец очереди\n2 - Вывести первый элемент очереди и удалить его\n3 - Вывести первый элемент без удаления");
            Scanner sc = new Scanner(System.in);
            boolean flag = sc.hasNextInt();
            if (flag == true) {
                int answer = sc.nextInt();
                switch (answer){
                    case 1:
                        enqueue(listForSort);
                        break;
                    case 2:
                        dequeue(listForSort);
                        break;
                    case 3:
                        first(listForSort);
                        break;
                    default:
                        System.out.println ("Ошибка ввода!\nСписок не изменен! ");
                        break;
                }
                System.out.println(listForSort);
                }            
            else {
                System.out.printf ("Ошибка ввода!\nСписок не изменен! ");
            }
            System.out.println("\nЖелаете повторить?\n1 - Да\nДля выхода введите любой символ");
            Scanner rep = new Scanner(System.in);
            boolean flag2 = rep.hasNextInt();
            if (flag2 == true) {
                repeat = rep.nextInt();
                if (repeat != 1) {
                    System.out.printf ("Программа завершена!");
                }
            }
            else {
                System.out.printf ("Программа завершена!");
                repeat = 0;
            }
        }
    }

    static Deque <Integer> enqueue (Deque <Integer> list) {      //помещает элемент в конец очереди
        System.out.println("Введите элемент, который хотите поместить в конец");
        Scanner sc = new Scanner(System.in);
        try {
            int elem = sc.nextInt();
            System.out.println("\nВходной список: " + list + "\n");
            list.add(elem);
            System.out.print ("Обновленный список: ");
            return list;
            }
            catch (NumberFormatException e) {
                System.out.println ("Ошибка ввода! Список не изменен!");
            }
            catch (InputMismatchException e) {
                System.out.println ("Ошибка ввода! Список не изменен!");
            }
        return list;
        }

    static Deque <Integer> dequeue (Deque <Integer> list) {       //возвращает первый элемент из очереди и удаляет его
        System.out.println("\nВходной список: " + list + "\n");
        System.out.println("Удаляем первый элемент очереди: " + list.pollFirst() + "\n");
        return list;
    }

    static Deque <Integer> first (Deque <Integer> list) {      //возвращает первый элемент из очереди, не удаляя
        System.out.println("\nВходной список: " + list + "\n");
        System.out.println("Первый элемент очереди: " + list.getFirst() + "\n");
        System.out.print("Удалять ничего не будем! ");
        return list;
    }
}