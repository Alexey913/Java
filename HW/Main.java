/*
+Подумать над структурой класса Ноутбук для магазина техники - выделить поля и методы.
+Реализовать в java.
+Создать множество ноутбуков.
Написать метод, который будет запрашивать у пользователя критерий (или критерии) фильтрации
и выведет ноутбуки, отвечающие фильтру. Критерии фильтрации можно хранить в Map.
Например: “Введите цифру, соответствующую необходимому критерию:
1 - ОЗУ
2 - Объем ЖД
3 - Операционная система
4 - Цвет …
Далее нужно запросить минимальные значения для указанных критериев -
сохранить параметры фильтрации можно также в Map.
Отфильтровать ноутбуки из первоначального множества и вывести проходящие по условиям.
 */


import java.util.*;


public class Main {
    public static void main(String[] args) {
        // System.out.println(setNote());
        printParam();
    }
    
    public static Set <Notebooks> setNote () {
        
        //Массивы для заполнения характеристик ноутбуков
        String [] names = new String [] {"HP", "MSI", "Lenovo", "Acer", "Asus", "Samsung", "Apple"};
        String [] systems = new String [] {"Windows", "DOS", "Linux", "Ubuntu", "Unix", "Mac OS"};
        String [] colors = new String [] {"Белый", "Серый", "Корраловый", "Красный", "Черный", "Серебристый"};
        int [] rams = new int [] {1, 2, 3, 4, 6, 8, 12, 16, 32};
        int [] hdds = new int [] {256, 512, 1024, 2048, 4096};
        double [] monitors = new double [] {12.0, 13.0, 14.0, 15.6, 16, 17.3};
        Random rnd = new Random();
        
        //Создаем множество ноутбуков (из 10 ноутбуков)
        Set <Notebooks> notes = new HashSet <> ();
        int quanNote = 10;
        while (quanNote>0) {
            notes.add (new Notebooks(names[rnd.nextInt(names.length-1)]+"-"+String.valueOf(quanNote+30*quanNote), 
            rams[rnd.nextInt(rams.length-1)], hdds[rnd.nextInt(hdds.length-1)],
            systems[rnd.nextInt(systems.length-1)], monitors[rnd.nextInt(names.length-1)],
            colors[rnd.nextInt(colors.length-1)]));
            quanNote--;
        }
        return notes;
    }
    
    public static void printParam () {
        Map <Integer, String> param = new HashMap <> ();
        Map <Integer, String> param = new HashMap <> ();
        param.put (1, "Марка ноутбука");
        param.put (2, "Оперативная память");
        param.put (3, "Жесткий диск");
        param.put (4, "Операционная система");
        param.put (5, "Размер монитора");
        param.put (6, "Цвет ноутбука");
        System.out.println("Введите номер необходимого критерия. Для продолжения введите 0");
        for (var elem : param.entrySet()) {
        System.out.println(elem.getKey() + " - " + elem.getValue());
        int answer = inputData();
        switch (answer){
            case 1:
            System.out.println("Введите марку ноутбука: ");    
        }
        }
    }
    
    public static int inputDataInt () {
        Scanner enterNum = new Scanner(System.in);
        boolean flag = enterNum.hasNextInt();
		if (flag == true) {
            int answer = enterNum.nextInt();
            return answer;
		}
        else{
            System.out.printf ("Ошибка ввода! Повторите! \n");
            return -1;
		}
    }
    
    public static String inputDataString () {
        Scanner enterData = new Scanner(System.in);
        int data = enterData.nextLine();
        return data;
	}
}
