// Проверка разнинцы в заполнении Deque, LinkedList, ArrayList

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.ArrayDeque;
import java.time.Duration;
import java.time.LocalTime;

public class Task4_1 {
    public static void main(String[] args) {
        Deque <Integer> dq = new ArrayDeque<>();
        ArrayList <Integer> arrList = new ArrayList<>();
        LinkedList <Integer> linkl = new LinkedList<>();
        LocalTime TimeStart = LocalTime.now();

        for (int i = 0; i < 10000000; i++) {
            dq.add(i);
        }
        LocalTime TimeFinish = LocalTime.now();

        System.out.println("Время Deque: " + Duration.between(TimeFinish, TimeStart));
    
        LocalTime TimeStartL = LocalTime.now();
            for (int i = 0; i < 10000000; i++) {
                linkl.add(i);
            }
            LocalTime TimeFinishL = LocalTime.now();
    
            System.out.println("Время LinkedList: " + Duration.between(TimeFinishL, TimeStartL));

        LocalTime TimeStartA = LocalTime.now();
            for (int i = 0; i < 10000000; i++) {
                arrList.add(i);
            }
            LocalTime TimeFinishA = LocalTime.now();
    
            System.out.println("Время ArrayList: " + Duration.between(TimeFinishA, TimeStartA));
        }
}
