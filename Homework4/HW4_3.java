/* Написать программу, определяющую правильность расстановки скобок в выражении.

a+(d*3) - истина
\[a+(1*3) - ложь
\[6+(3*3)] - истина
{a}\[+\]{(d*3)} - истина
<{a}+{(d*3)}> - истина
{a+]}{(d*3)} - ложь */


import java.util.Scanner;
import java.util.Stack;

public class HW4_3 {
    public static void main(String[] args) {
        Stack <String> inList = new Stack<>();
        System.out.println("Введите выражение для проверки:");
        Scanner sc = new Scanner(System.in);
        String [] forList = sc.nextLine().split("");
        String [] symbols = new String [] {"(", "[", "{", "<", ")", "]", "}", ">"};
        boolean result = true;
        int [] check = new int [symbols.length];
        int [] count = new int [symbols.length/2];
        for (int i = 0; i < forList.length; i++) {
            inList.add(forList[i]);
        }
        while (!inList.isEmpty()) {
            for (int i = 0; i < symbols.length/2; i++) {
                if (inList.firstElement().equals(symbols[i])) {
                    check[i]++;
                }
                else if (inList.firstElement().equals(symbols[i+symbols.length/2])) {
                    check[i+symbols.length/2]++;
                    count[i]--; // попробовать через MAP (типа словаря сделать, и под каждую скобку добавлять или убавлять 1)
                }
                System.out.println(check[i] + "-" + symbols[i] + "; " + check[i+symbols.length/2]+ "-" + symbols[i+symbols.length/2] +"; " + count[i]);
            }
            for (int j = 1; j < count.length; j++) {
                if ((count[j]<count[j-1])) {
                    result = false;
                    break;
                }
            }
            System.out.println("----------");
            // System.out.println(result);
            inList.remove(inList.firstElement());
        }

        if (result==true) {
            for (int i = 0; i < check.length/2; i++) {
                if (check[i]==check[i+symbols.length/2]) {
                    result = true;
                }
                else {
                    result = false;
                    break;
                }
            }
        }
// for (int i = 0; i < check.length; i++) {
//     System.out.println(symbols[i] + ": " + check[i]);
// }
        System.out.println(result);
    }
}




















// /* Написать программу, определяющую правильность расстановки скобок в выражении.

// a+(d*3) - истина
// \[a+(1*3) - ложь
// \[6+(3*3)] - истина
// {a}\[+\]{(d*3)} - истина
// <{a}+{(d*3)}> - истина
// {a+]}{(d*3)} - ложь */


// import java.util.HashMap;
// import java.util.Map;
// import java.util.Scanner;
// import java.util.Stack;

// public class HW4_3 {
//     public static void main(String[] args) {
//         Stack <String> inList = new Stack<>();
//         System.out.println("Введите выражение для проверки:");
//         Scanner sc = new Scanner(System.in);
//         String [] toSymb = sc.nextLine().split("");
//         String [] symbols = new String [] {"(", "[", "{", "<", ")", "]", "}", ">"};
//         Map <String, Integer> check = new HashMap<>();
//         for (int i = 0; i < symbols.length; i++) {
//             check.put(symbols[i], 0);
//         }
//         boolean result = true;
//         for (int i = 0; i < toSymb.length; i++) {
//             inList.add(toSymb[i]);
//         }
//         while (!inList.isEmpty()) {
//             for (int i = 0; i < symbols.length/2; i++) {
//                 if (inList.firstElement().equals(symbols[i])) {
//                     check.put(symbols[i], check.get(symbols[i])+1);
//                 }
//                 else if (inList.firstElement().equals(symbols[i+symbols.length/2])) {
//                     check.put(symbols[i+symbols.length/2], check.get(symbols[i+symbols.length/2])+1);
//                 }
//             }
//             System.out.println(check);
//             inList.remove(inList.firstElement());
//         }
//     }
// }