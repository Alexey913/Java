/*Напишите метод, который принимает на вход строку (String)
и определяет является ли строка палиндромом (возвращает boolean значение).*/

public class Task2_2 {
    public static void main (String [] Args) {
        String st = "арозаупаланалапуазора";
        if (palindrom(st) == true) {
            System.out.println("Ну, конечно, это палиндром!");
        }
        else {
            System.out.println("Неа, ни фига не палиндром...");
        }
    }

public static boolean palindrom (String word) {
    boolean answer = true;
    String str = word;
    char [] array = str.toCharArray();
    for (int i = 0; i < array.length/2; i++) {
        if (array [i] == array[array.length - 1 - i]) {
            answer = true;
        }
        else {
            answer = false;
            break;
        }
    }
    return answer;
}
}