/*
Напишите метод, который составит строку,
состоящую из 100 повторений слова TEST и метод,
который запишет эту строку в простой текстовый файл,
обработайте исключения.
*/
import java.io.FileWriter;
import java.io.IOException;

public class Task2_3 {
    public static void main (String [] args) {

        try (FileWriter fw = new FileWriter("task2_3.txt", false)) {
            String text = "TEST ";
            StringBuilder str = new StringBuilder();
            for (int i = 0; i < 100; i++) {
                str.append(text);
            }
            // fw.write("line 1");
            fw.append(str);
            fw.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
