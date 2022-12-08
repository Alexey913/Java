/* Написать программу, определяющую правильность расстановки скобок в выражении.
a+(d*3) - истина
\[a+(1*3) - ложь
\[6+(3*3)] - истина
{a}\[+\]{(d*3)} - истина
<{a}+{(d*3)}> - истина
{a+]}{(d*3)} - ложь */


import java.util.Scanner;
import java.util.Deque;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.lang.Math;;

public class Main {
    public static void main (String[] args) {
        System.out.println("Введите выражение для проверки:");
        Scanner sc = new Scanner(System.in);
        String [] inputString = sc.nextLine().split("");
        
        if (checking(inputString) == true) System.out.println("Скобки в выражении расставлены верно!");
        
        else System.out.println("Ошибка в расстановке скобок!");
    }
        
    public static boolean checking (String [] inputData) {
        String [] symbols = new String [] {"(", "[", "{", "<", ")", "]", "}", ">"};
        int size = symbols.length/2;
        
        ArrayList <String> input = new ArrayList <> ();
        for (int i = 0; i < inputData.length; i++) {
            for (int j = 0; j < size*2; j++) {
                if (inputData[i].equals(symbols[j])) {
                    input.add(inputData[i]);
                }
            } 
        }
        
        Map <String, Integer> check = new HashMap <> ();
        for (int i = 0; i < size; i++) {
            check.put(symbols[i]+symbols[i+size],i);
        }
        int count = 1;
        while (count<input.size()) {
                if (check.containsKey(input.get(count-1)+input.get(count))) {
                    input.remove(count);
                    input.remove(count-1);
                    count=1;
                }
                else count++;
            }
        if (input.isEmpty()) return true;
        else return false;
    }
}
