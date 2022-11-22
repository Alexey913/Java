/*
В консоли запросить имя пользователя. В зависимости
от текущего времени, вывести приветствие вида
"Доброе утро, <Имя>!", если время от 05:00 до 11:59
"Добрый день, <Имя>!", если время от 12:00 до 17:59;
"Добрый вечер, <Имя>!", если время от 18:00 до 22:59;
"Доброй ночи, <Имя>!", если время от 23:00 до 4:59

 * 
 */

package Seminar1;

import java.time.LocalTime;
import java.util.Scanner;

public class Task1_3 {
    public static void main (String [] args) {
        System.out.println("Введите Ваше имя:");
        Scanner iScanner = new Scanner(System.in);
        String name = iScanner.nextLine();
        int nowTime = LocalTime.now().getHour();
        // int nowTime = LocalTime.of(12,0,0).getHour();
        if (nowTime>=5 && nowTime<12) {System.out.printf("Доброе утро, %s!", name);}
        if (nowTime>=12 && nowTime<18) {System.out.printf("Добрый день, %s!", name);}
        if (nowTime>=18 && nowTime<23) {System.out.printf("Добрый вечер, %s!", name);}
        if ((nowTime>=23 || nowTime<5)) {System.out.printf("Доброй ночи, %s!", name);}
        }
}
