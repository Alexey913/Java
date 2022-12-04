/*Реализовать консольное приложение, которое:

1. Принимает от пользователя и “запоминает” строки.
2. Если введено print, выводит строки так, чтобы последняя введенная была первой в списке, а первая - последней.
3. Если введено revert, удаляет предыдущую введенную строку из памяти */

import java.util.*;
public class Task4_3 {
    public static void main(String[] args) {
	    Scanner sc = new Scanner(System.in);
        Deque <String> array = new ArrayDeque<>();
        while (true) {
            System.out.println ("\nВведите строку");
            String lineL = sc.nextLine();
            if (lineL.equals("")) {
                break;
            }
            else if (lineL.equals("print")) {
                while (!array.isEmpty()) {
                    System.out.print(array.removeLast() + " ");
                }
            }
            else if (lineL.equals("revert")) {
                array.removeLast();
            }
            else {
                array.add(lineL);
            }
        }
        System.out.print(array);
    }
}

