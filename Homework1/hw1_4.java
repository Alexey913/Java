// /* *+Задано уравнение вида q + w = e, q, w, e >= 0. 
// Некоторые цифры могут быть заменены знаком вопроса, например 2? + ?5 = 69.
// Требуется восстановить выражение до верного равенства. Предложить хотя бы одно решение или сообщить, что его нет.*/

import java.util.Scanner;
import java.lang.Math;
public class hw1_4
{
    public static void main(String[] args) {
        int excep = 0;
        while (excep == 0) {
            try{
                excep = main_menu();
            }
            catch (NumberFormatException e) {
                System.out.println ("Ошибка ввода! Повторите! \n");
                excep = 0;
            }
            catch (ArrayIndexOutOfBoundsException e) {
                System.out.println ("Ошибка ввода! Повторите! \n");
                excep = 0;
            }
        }
    }

    
    static int main_menu() {
        String [] elements = inputData();
        while ((elements.length != 5)||(!elements[1].equals("+"))||(!elements[3].equals("="))) {
            System.out.printf ("Ошибка ввода! Повторите! \n");
            elements = inputData();
        }
        String [] temp_1 = elements[0].split("");
        String [] temp_2 = elements[2].split("");
        String [] temp_3 = elements[4].split("");
        int [] numOne = numVariosy(temp_1, elements[0]);
        int [] numTwo = numVariosy(temp_2, elements[2]);
        int [] numThree = numVariosy(temp_3, elements[4]);
        int excep = selectSol(numOne, numTwo, numThree);
        return excep;
    }


    static String[] inputData() {
	    System.out.println ("Введите через пробел выражение для подсчета и нажмите Enter\n(Например, 2? + ?7 = 69)");
	    Scanner enterData = new Scanner(System.in);
            String data = enterData.nextLine();
            String [] data_elem = data.split(" ");
            return data_elem;
	}


    static int [] numVariosy (String [] arr, String str) {
        int count = 0;
        int [] arrayPos = new int [arr.length];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i].equals("?")) {
                count++;
                arrayPos[i] = 1;
            }
            else {
                arrayPos[i] = 0;
            }
        }
        if (count == 0) {
            int [] arrayNum = new int [] {Integer.parseInt(str)};
            return arrayNum;
        }
        else {
            int quant = (int) Math.pow(10, count);
            String [] arrayStr = new String [quant];
            String [] arrayNumFor = new String [quant];
            for (int i = 0; i < quant; i++) {
                arrayStr[i] = str;
                int lenNum = String.valueOf(i).length();
                int delta = count - lenNum;
                if (lenNum<count) {
                    arrayNumFor[i] = "0".repeat(delta)+String.valueOf(i);
                }
                else {
                    arrayNumFor[i] = String.valueOf(i);
                }
            }
            int count2 = 0;
            for (int k = 0; k < arr.length; k++) {
                if (arrayPos[k] == 1) {
                    for (int j = 0; j<quant; j++) {
                        char[] charsStart = arrayNumFor[j].toCharArray();
                        char newChar = charsStart[count2];
                        char[] charsFinish = arrayStr[j].toCharArray();
                        charsFinish[k] = newChar;
                        arrayStr[j] = String.valueOf(charsFinish);
                    }
                    count2++;
                }
            }
            int [] arrayNum = new int [quant];
            for (int i = 0; i<quant; i++) {
                arrayNum[i] = Integer.parseInt(arrayStr[i]);
            }
        return arrayNum;
        }
    }

    // public static boolean isNumeric(String str) { 
    //     try {  
    //         Integer.parseInt(str);
    //         return true;
    //     }
    //     catch(NumberFormatException e){  
    //         return false;  
    //     }  
    // }

    public static int selectSol (int [] arr1, int [] arr2, int [] arr3) {
        int count = 1;
        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                for (int k = 0; k < arr3.length; k++) {
                    if (arr1[i] + arr2[j] == arr3[k]) {
                        System.out.printf("Решение %d: %d + %d = %d\n", count, arr1[i], arr2[j], arr3[k]);
                        count++;
                    }
                }
            }
        }
        if (count == 1) {
            System.out.printf("Решений нет!");
        }
        return 1;
    }
}
