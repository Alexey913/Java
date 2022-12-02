//(НЕОБЯЗАТЕЛЬНО) Дана json строка (можно сохранить в файл и читать из файла)
//        [{"фамилия":"Иванов","оценка":"5","предмет":"Математика"},{"фамилия":"Петрова","оценка":"4","предмет":"Информатика"},{"фамилия":"Краснов","оценка":"5","предмет":"Физика"}]
//        Написать метод(ы), который распарсит json и, используя StringBuilder, создаст строки вида: Студент [фамилия] получил [оценка] по предмету [предмет].
//
//        Пример вывода:
//        Студент Иванов получил 5 по предмету Математика.
//        Студент Петрова получил 4 по предмету Информатика.
//        Студент Краснов получил 5 по предмету Физика.

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.lang.*;


public class HW2_0 {
    public static void main(String[] args) {
        try(FileReader fr = new FileReader("HW2_0.json"))
        {
            String[] pattern = {"Студент "," получил "," по предмету "};
            List <String> rows = new ArrayList<>();
            Scanner data = new Scanner(fr);
            while (data.hasNextLine()) {
                String json = data.nextLine();
                StringBuilder str = new StringBuilder();
                String [] value = json.split(",");
                for (int i = 0; i<value.length; i++) {
                    str.append(value[i].substring(value[i].indexOf(':')+2, value[i].lastIndexOf('}')+1));
                    str.append(" ");
                }
                rows.add(str.toString());
                for (String i: rows) {
                    System.out.println(i);
                }
                // System.out.println(rows);
                // System.out.println(json);
            }
        }
            
        catch(IOException ex)
        {
            System.out.println(ex.getMessage());
        }
    }
}
