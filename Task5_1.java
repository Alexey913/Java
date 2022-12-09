// Создать структуру для хранения Номеров паспортов и Фамилий сотрудников организации.
// 123456 Иванов
// 321456 Васильев
// 234561 Петрова
// 234432 Иванов
// 654321 Петрова
// 345678 Иванов
// Вывести данные по сотрудникам с фамилией Иванов.
import java.util.*;;

public class Task5_1 {
    public static void main(String[] args) {
        Map <Integer, String> list = new HashMap<>();
        String encoding = System.getProperty("console.encoding", "cp866");
        Scanner sc = new Scanner(System.in, encoding);
        for (int i = 0; i < 3; i++) {
            System.out.println("Введите номер паспорта и фамилию:");
            String str = sc.nextLine();
            String [] data = str.split(" ");
            list.put(Integer.parseInt(data[0]), data[1]);
        }
        System.out.println(list);
        for (var el : list.entrySet()) {
            System.out.println(el.getKey() + " " + el.getValue() + "\n");
        }
        for (var el : list.entrySet()) {
            if (el.getValue().equals("Иванов"))
            System.out.println(el.getKey() + " " + el.getValue() + "\n");
        }
    }
}