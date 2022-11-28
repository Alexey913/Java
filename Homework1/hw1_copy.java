// /* *+Задано уравнение вида q + w = e, q, w, e >= 0. 
// Некоторые цифры могут быть заменены знаком вопроса, например 2? + ?5 = 69.
// Требуется восстановить выражение до верного равенства. Предложить хотя бы одно решение или сообщить, что его нет.*/

import java.util.Scanner;
import java.lang.Math;
import java.io.*;
public class Main
{
    public static void main(String[] args) {
	    System.out.println ("Введите через пробел выражение для подсчета и нажмите Enter\n(Например, 2? + 7? = 69)");
	    Scanner enterData = new Scanner(System.in);
        String data = enterData.nextLine();
        String [] data_elem = data.split(" ");
        String [] temp_1 = data_elem[0].split("");
        String [] temp_2 = data_elem[2].split("");
        String [] temp_3 = data_elem[4].split("");
        int [] numOne = numVariosy(temp_1, data_elem[0]);
        for (int i: numOne) {
            System.out.println(i);
        }
    }

    static int [] numVariosy (String [] arr, String str) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals("?")) {
                count++;
            }
        }
        if (count == 0) {
            int [] arrayNum = new int [] {Integer.parseInt(str)};
            return arrayNum;
        }
        else {
            int quant = (int) Math.pow(10, count);
            String [] arrayStr = new String [quant];
            for (int i = 0; i < quant; i++) {
                arrayStr[i] = str;
            }
            int count2 = count;
            while (count2>0) {
                for (int k = 0; k < arr.length; k++) {
                    if (arr[k].equals("?")) {
                        for (int j = 0; j<10; j++) {
                            char newChar = (char) (j+'0');
                            char[] chars = arrayStr[j+(int) Math.pow(10, k)].toCharArray();
                            chars[k] = newChar;
                            arrayStr[j+(int) Math.pow(10, k)] = String.valueOf(chars);
                            // System.out.println(arr[i]);
                            // System.out.println(arrayStr[count2*j]);
                        }
                        count2--;
                    }
                }
            }
            for (String i: arrayStr) {
                System.out.println(i);
            }
            int [] arrayNum = new int [] {1111111};
            return arrayNum;
        }
    }

    public static boolean isNumeric(String str) { 
        try {  
            Integer.parseInt(str);
            return true;
        }
        catch(NumberFormatException e){  
            return false;  
        }  
    }
}
