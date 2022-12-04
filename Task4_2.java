import java.util.LinkedList;
import java.util.Scanner;

/* Реализовать консольное приложение, которое:
1. Принимает от пользователя строку вида text~num

1. Нужно рассплитить строку по ~, сохранить text в связный список на позицию num.
2. Если введено print~num, выводит строку из позиции num в связном списке и удаляет её из списка.
 */

public class Task4_2 {
    public static void main(String[] args) {
        System.out.println ("Введите строку\n(Например, Текст~10)");
	    Scanner enterData = new Scanner(System.in);
        String data = enterData.nextLine();
        LinkedList <String> linkl= new LinkedList<>();
        String [] data_elem = data.split("~");
        int index_str = Integer.parseInt(data_elem[1]);
        for (int i = 0; i < index_str*2; i++) {
            linkl.add("Строка " + i);
        }

        System.out.println(linkl);

        if (data_elem[0].equals("print")) {
            // System.out.println(linkl.get(index_str));
            System.out.println(linkl.remove(index_str));
        }
        else {
            linkl.add(index_str, data_elem[0]);
        }
        System.out.println(linkl);
    }
    
}
