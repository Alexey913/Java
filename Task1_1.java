/*Настроить проект, вывести в консоль “Hello world!”.
Вывести в консоль системные дату и время.
 */

package Seminar1;

import java.time.LocalDateTime;
import java.time.LocalTime;
public class Task1_1 {
    public static void main (String [] args){
        System.out.println("Hello, World!");
        LocalDateTime nowTime = LocalDateTime.now();
        System.out.println(nowTime);
    }
    
}
