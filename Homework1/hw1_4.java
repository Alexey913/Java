// /* *+Задано уравнение вида q + w = e, q, w, e >= 0. 
// Некоторые цифры могут быть заменены знаком вопроса, например 2? + ?5 = 69.
// Требуется восстановить выражение до верного равенства. Предложить хотя бы одно решение или сообщить, что его нет.*/

// import java.util.Scanner;
// import java.lang.Math;
// public class hw1_4
// {
//     public static void main(String[] args) {
// 	    System.out.println ("Введите через пробел выражение для подсчета и нажмите Enter\n(Например, 2? + ?7 = 69)");
// 	    Scanner enterData = new Scanner(System.in);
//         String data = enterData.nextLine();
//         String [] data_elem = data.split(" ");
//         StringBuilder temp_1 = new StringBuilder(data_elem[0]);
//         StringBuilder temp_2 = new StringBuilder(data_elem[2]);
//         StringBuilder temp_3 = new StringBuilder(data_elem[4]);
//         int len_1 = temp_1.length();
//         int len_2 = temp_2.length();
//         int len_3 = temp_3.length();
//         int maxLen = Math.max(Math.max(len_1, len_2), len_3);
//         System.out.println (maxLen);
//         temp_1 = transformToMaxLen (maxLen, len_1, temp_1);
//         temp_2 = transformToMaxLen (maxLen, len_2, temp_2);
//         temp_3 = transformToMaxLen (maxLen, len_3, temp_3);
//         System.out.println (temp_1);
//         // int dig = Integer.parseInt(temp_1.toString());
//         // System.out.println (dig);

//         for (int i = 0; i < maxLen*3; i++) {
//             if (temp_1.indexOf("?") == i) {
//                 for (int j = 0; j < 10; j++) {
//                     repla

//                     }
//                 }
//             }
//         }



//         }

//     static StringBuilder transformToMaxLen (int maxLen, int len, StringBuilder data) {
//         if (len < maxLen) {
//             int count = maxLen - len;
//             while (count>0) {
//                 data = data.insert(0, "0");
//                 count--;
//             }
//         }
//         return data;
//     }
// }





/* *+Задано уравнение вида q + w = e, q, w, e >= 0. 
Некоторые цифры могут быть заменены знаком вопроса, например 2? + ?5 = 69.
Требуется восстановить выражение до верного равенства. Предложить хотя бы одно решение или сообщить, что его нет.*/

import java.util.Scanner;
import java.lang.Math;
import java.io.*;
public class hw1_4
{
    public static void main(String[] args) {
	    System.out.println ("Введите через пробел выражение для подсчета и нажмите Enter\n(Например, 2? + 7? = 69)");
	    Scanner enterData = new Scanner(System.in);
        String data = enterData.nextLine();
        String [] data_elem = data.split(" ");
        String [] temp_1 = data_elem[0].split("");
        String [] temp_2 = data_elem[2].split("");
        String [] temp_3 = data_elem[4].split("");
        int maxLen = Math.max(Math.max(temp_1.length, temp_2.length), temp_3.length);
        String [] numOne = tempToArr (maxLen, temp_1);
        String [] numTwo = tempToArr (maxLen, temp_2);
        String [] numThree = tempToArr (maxLen, temp_3);
        for (int i = maxLen-1; i >= 0; i--) {
            int tempDigOne = 0;
            int tempDigTwo = 0;
            int tempDigThree = 0;
            // int jStart=0, kStart=0, mStart=0;
            // if (numOne[i].equals("0")) {
            //     jStart = 1;
            // }
            // else {
            //     jStart = 0;
            // }
            // if (numTwo[i].equals("0")) {
            //     kStart = 1;
            // }
            // else {
            //     kStart = 0;
            // }
            // if (numThree[i].equals("0")) {
            //     mStart = 1;
            // }
            // else {
            //     mStart = 0;
            // }
            // int charge = 0;
            for (int j = 9; j <= 0; j--) {
                if (!(numOne[i].equals("?"))) {
                    tempDigOne = Integer.parseInt(numOne[i]);
                    // System.out.printf("tempDigOne %d = %d\n", i, tempDigOne);
                }
                else {
                    tempDigOne = j;
                    // System.out.printf("tempDigOne %d = %d\n", i, tempDigOne);
                }
                for (int k = 9; k <= 0; k--) {
                    if (!(numTwo[i].equals("?"))) {
                        tempDigTwo = Integer.parseInt(numTwo[i]);
                        // System.out.printf("tempDigTwo %d = %d\n", i, tempDigTwo);
                    }
                    else {
                    tempDigTwo = k;
                    // System.out.printf("tempDigTwo %d = %d\n", i, tempDigTwo);
                    }
                    for (int m = 9; m <= 0; m--) {                        
                        if (!(numThree[i].equals("?"))) {
                            tempDigThree = Integer.parseInt(numThree[i]);
                            // System.out.printf("tempDigThree %d = %d\n", i, tempDigThree);
                        }
                        else {
                            tempDigThree = m;
                            // System.out.printf("tempDigThree %d = %d\n", i, tempDigThree);
                        }
                        if ((tempDigOne + tempDigTwo) == tempDigThree) {
                            numOne[i] = String.valueOf(tempDigOne);
                            // System.out.printf("\n"+numOne[i]);
                            numTwo[i] = String.valueOf(tempDigTwo);
                            // System.out.printf("\n"+numTwo[i]);
                            // if ((Integer.parseInt(numOne[i+1]) + Integer.parseInt(numTwo[i+1]))%10 == (Integer.parseInt(numOne[i+1]) + Integer.parseInt(numTwo[i+1]))) {
                            numThree[i] = String.valueOf(tempDigThree);
                            // }
                            // else {
                            //     numThree[i] = String.valueOf(tempDigThree+1);
                            // }
                            // System.out.printf("\n"+numThree[i]);
                            // if (((tempDigOne + tempDigTwo)%10) < (tempDigOne + tempDigTwo)) {
                            //     charge = 0;
                            // }
                            // else {
                            //     charge = 1;
                            // }
                            // break;
                        }
                    }
                }
            }
        }
        for (String i: numOne) {
            System.out.printf(""+i+"");
        }
        System.out.println();
        for (String i: numTwo) {
            System.out.printf(""+i+"");
        }
        System.out.println();
        for (String i: numThree) {
            System.out.printf(""+i+"");
        }
    }





        //         try {
        //             tempDigOne = Integer.parseInt (numOne[i]);
        //         }
        //         catch (NumberFormatException e) {
        //             tempDigOne = j;
        //         }
        //         System.out.printf ("цифра первого числа %d\n", tempDigOne);
        //         for (int k = 0; k <= 9; k++) {
        //             try {
        //                 tempDigTwo = Integer.parseInt (numTwo[i]);
        //             }
        //             catch (NumberFormatException e) {
        //                 tempDigTwo = k;
        //             }
        //             System.out.printf ("цифра второго числа %d\n", tempDigTwo);
        //             for (int m = 0; m <= 9; m++) {
        //                 try {
        //                     tempDigThree = Integer.parseInt (numThree[i]);
        //                 }
        //                 catch (NumberFormatException e) {
        //                     tempDigThree = m;
        //                 }
        //                 System.out.printf ("цифра третьего числа %d\n", tempDigThree);
        //                 if (tempDigOne + tempDigTwo == tempDigThree) {
        //                     numOne[i] = String.valueOf(tempDigOne);
        //                     numTwo[i] = String.valueOf(tempDigTwo);
        //                     numThree[i] = String.valueOf(tempDigThree);
        //                 }
        //         }
        //     }
        // }
        // }
        //         double result_1 = Integer.parseInt (numOne[0]);
        //         double result_2 = Integer.parseInt (numTwo[0]);
        //         double result_3 = Integer.parseInt (numThree[0]);
        //         for (int i = 1; i < numOne.length; i++) {
        //             double degree = Math.pow(10,numOne.length-i-1);
        //             double tempOne = Integer.parseInt(numOne[i]);
        //             double tempTwo = Integer.parseInt(numTwo[i]);
        //             double tempThree = Integer.parseInt(numThree[i]);
        //             result_1+=tempOne*degree;
        //             result_2+=tempTwo*degree;
        //             result_3+=tempThree*degree;
        //     System.out.printf ("%f + %f = %f", result_1, result_2, result_3);
    


    static String[] tempToArr(int len, String[] temp) {
        String [] temp_array = new String [len];
        int lenTemp = temp.length;
        for (int i = 0; i<len; i++) {
                if (i < len - lenTemp) {
                    temp_array [i] = "0";
                }
                else {
                    temp_array [i] = temp[i - (len - lenTemp)];
                }
                // System.out.println (temp_array[i]);
            }
        return temp_array;
}
}