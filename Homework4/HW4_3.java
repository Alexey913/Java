/* Написать программу, определяющую правильность расстановки скобок в выражении.
a+(d*3) - истина
\[a+(1*3) - ложь
\[6+(3*3)] - истина
{a}\[+\]{(d*3)} - истина
<{a}+{(d*3)}> - истина
{a+]}{(d*3)} - ложь */

import java.util.Scanner;
import java.util.LinkedList;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;

public class HW4_3 {
    public static void main(String[] args) {
        Map <String, Integer> openCheck = new HashMap<>(); // Создаем HashMap для проверки количества открывающихся скобок
        Map <String, Integer> closeCheck = new HashMap<>(); // Создаем HashMap для проверки количества закрывающихся скобок
        // Ключами в них будет та или иная скобка, а значением - 0
        String [] symbols = new String [] {"(", "[", "{", "<", ")", "]", "}", ">"}; // Массив скобок, в первой половине - открывающиеся скобки, во второй - закрывающиеся, в том же порядке
        
        // Вносим открывающиеся и закрывающиеся скобки по ключу в соответствующие HashMap
        for (int i = 0; i < symbols.length; i++) {
            if (i<symbols.length/2) {
                openCheck.put(symbols[i], 0);
            }
            else {
                closeCheck.put(symbols[i], 0);
            }
        }
        
        // Создаем очереди, в которые будем "Складывать" открывающиеся и закрывающиеся скобки, соответственно
        Deque <String> openDeq = new LinkedList<>();
        Deque <String> closeDeq = new LinkedList<>();
        
        // Вводим выражение и удаляем из него все символы, кроме скобок
        System.out.println("Введите выражение для проверки:");
        Scanner sc = new Scanner(System.in);
        ArrayList <String> expression = new ArrayList<>();
        String [] temp = sc.nextLine().split("");
        for (int i = 0; i< temp.length; i++) {
            if (closeCheck.containsKey(temp[i]) || openCheck.containsKey(temp[i])) {
                expression.add(temp[i]);
            }
        }
        System.out.println(expression);
        

        boolean result = false; // Результат проверки правильности расстановки скобок
        
        /*
        Прогоняем цикл по ArrayList со скобками.
        Если скобка открывается - калдем ее в соответствующий список
        Если скобка закрывающаяся - проверяем условие, какая скобк перед ней - открывающаяся или закрывающаяся
        Данная проверка нужна, чтобы определить, куда положить скобку - в начало или конец очереди
        Если ее не сделать, то при выражении типа []() порядок закрывающихся и открывающихся скобок в очереди не совпадет
        */
        int count = 0;
        for (int i = 0; i < expression.size(); i++) {
            if (openCheck.containsKey(expression.get(i)) == true) {
                openDeq.addLast(expression.get(i));
                // System.out.println(openDeq);
            }
            else if (closeCheck.containsKey(expression.get(i)) == true) {
                closeDeq.addFirst(expression.get(i));
                // System.out.println(closeDeq);
            }
            System.out.println(openDeq);
            System.out.println(closeDeq);
            // if (openCheck.get(openDeq.peekLast()) == closeCheck.get(closeDeq.peekFirst())) {
            //     result = true;
            //     openDeq.pollLast();
            //     closeDeq.pollFirst();
            //     }
            //     else {
            //         result = false;
            //     }
                }

        /*
        Сравниваем порядок в очереди для открывающихся и закрывающихся скобок
        по совпадению значений на основании ключей в HasMap-ах.
        Если не совпадает, то результатом будет false
        */
        // if (openDeq.size()!=closeDeq.size()) {
        //     result = false;
        // }
        // else{
        //     while (!(openDeq.isEmpty()) || !(closeDeq.isEmpty())) {
        //         if (openCheck.get(openDeq.pop())==closeCheck.get(closeDeq.pop())) {
        //             result = true;
        //         }
        //         else {
        //             result = false;
        //             break;
        //         }
        //     }
            if (result == true) {
                System.out.println("Скобки в выражении расставлены верно!");
            }
            else{
                System.out.println("Ошибка в расстановке скобок!");
            }
        }
    }
