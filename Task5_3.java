import java.util.TreeMap;

/*
Взять набор строк, например,
Мороз и солнце
День чудесный
Еще ты дремлешь
друг прелестный
Пора красавица проснись.
Написать метод, который отсортирует эти строки
по длине с помощью TreeMap.
Строки с одинаковой длиной не должны “потеряться”.
*/


// Колхозный вариант
public class Task5_3 {
    public static void main(String[] args) {
    String str = "Мороз и солнце День чудесный Еще ты дремлешь друг прелестный Пора красавица проснись.";
    TreeMap <Double, String> list = new TreeMap<>();
    String [] sMas = str.split(" ");
    for (int i = 0; i < sMas.length; i++) {
        if (list.containsKey((double)sMas[i].length())) {
            list.put (sMas[i].length()+i*0.01, sMas[i]);
        }
        else{
            list.put ((double) sMas[i].length(), sMas[i]);
        }
        System.out.println(list);
    }
    for (var el : list.entrySet()) {
        System.out.println((el.getKey() + " " + el.getValue() + "\n"));
    }
    }
}



// А этот вообще не работает
// public class Task5_3 {
//     public static void main(String[] args) {
//     String str = "Мороз и солнце День чудесный Еще ты дремлешь друг прелестный Пора красавица проснись.";
//     TreeMap <String, Integer> list = new TreeMap<>();
//     TreeMap <Integer, String> sort = new TreeMap<>();
//     String [] sMas = str.split(" ");
//     for (int i = 0; i < sMas.length; i++) {
//             list.put (sMas[i], sMas[i].length());
//         }
//     // for (var el : list.entrySet()) {
//     //     System.out.println((el.getKey() + " " + el.getValue() + "\n"));
//     // }
//     int count = 0;
//     for (int i = 0; i < sMas.length; i++) {
//         for (int j = 0; j < (15); j++) {
//             if (sMas[i].length() == j) {
//                 if (sort.containsKey(sMas[i].length())) {
//                     count++;
//                 }
//                 sort.put (j+count, sMas[i]);
//         }
//         System.out.println(sort);
//     }
// }
//     for (var el : sort.entrySet()) {
//         System.out.println((el.getKey() + " " + el.getValue() + "\n"));
//     }
//     }
// }