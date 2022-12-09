/* Пусть дан список сотрудников.
Написать программу, которая найдет и выведет повторяющиеся имена с количеством повторений.
Отсортировать по убыванию популярности.
*/


import java.util.*;
import java.io.*;

public class HW5_2 {
	public static void main(String[] args) {
        Map <String, Integer> HW5_2 = new HashMap <> ();
        TreeMap <Integer, String> print = new TreeMap <> ();
        
        HW5_2 = creatingMap();
        System.out.println("Полный перечень сотрудников\n");
        for (var el : HW5_2.entrySet()) {
            System.out.println(el.getKey());
            if (el.getValue()!=1) {
                print.put(el.getValue(), el.getKey());
            }
        }
        
        System.out.println("\nПеречень наиболее популярных сотрудников\n");
        for (var el : sortByKeys(print).entrySet()) {
        System.out.println(el.getValue() + ": популярность - " + el.getKey());
        }
	}


    //Метод для выгрузки списка из файла в HashMap
    public static Map creatingMap () {
		Map <String, Integer> listMap = new HashMap <> ();
		try(FileReader fr = new FileReader("HW5_2.txt")) {
		int countString = 0;
		Scanner data = new Scanner(fr);
            while (data.hasNextLine()) {
                String str = data.nextLine();
                countString++;
                if (listMap.containsKey(str) == true) {
                    listMap.put (str, listMap.get(str)+1);
                }
                else {
                    listMap.put (str, 1);
                }
            }
        }
        catch(IOException ex)
        {
            System.out.println(ex.getMessage());
        }
        return listMap;
	}
	
	
    // Метод для сортировки Map по обратному порядку ее ключей
    public static <K extends Comparable, V> Map<K, V> sortByKeys(Map<K, V> map) {
        Map<K, V> treeMap = new TreeMap<>(new Comparator<K>() {
            @Override
            public int compare(K a, K b) {
                return b.compareTo(a);
            }
        });
        treeMap.putAll(map);
        return treeMap;
    }
}