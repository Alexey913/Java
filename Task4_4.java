import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class Task4_4 {
    public static void main(String[] args) {
        String [] base = {"one", "two", "three", "four", "five"};
        Queue <String> queueArray = new LinkedList<>(Arrays.asList(base));
        Deque <String> dequeArray = new LinkedList <> (Arrays.asList(base));
        System.out.println("Очередь: ");
        while (!queueArray.isEmpty()) {
            System.out.print(queueArray.poll() + " ");
        }
        System.out.println("\nСтэк: ");
        while (!dequeArray.isEmpty()) {
            System.out.print(dequeArray.pollLast() + " ");
        }
    }
}