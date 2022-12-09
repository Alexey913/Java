/*Реализуйте структуру телефонной книги с помощью HashMap,
учитывая, что 1 человек может иметь несколько телефонов
*/

import java.util.*;
import java.io.*;
public class HW5_1 {
    
    public static void main (String[] args) throws IOException {
        mainMenu();
    }
    
// Главное меню, выгрузка данных из файла в HasMap
	public static void mainMenu() throws IOException {
	    
	    Map <String, String> readList = new HashMap <> ();
		
		try (FileReader fr = new FileReader("HW5_1.txt")) {
		    System.out.println("Что хотите сделать?\n1 - Вывести перечень контактов на экран\n2 - Создать новую запись\nДля выхода введите любой символ");
            Scanner data = new Scanner(fr);
            while (data.hasNextLine()) {
                String str = data.nextLine();
                String [] value = str.split(": ");
                readList.put (value[1], value[0]);
                }
                
		    int answer = inputAnswer();
		    switch (answer) {
		        case 1:
		            printing(readList);
		            break;
		        case 2:
		            writing(readList);
		            break;
		        default:
		            System.out.println("Выполнение программы завершено");
		            break;
		    }
        }
        catch(IOException ex)
        {
            System.out.println("Справочника не существует! Добавить новую запись?\n1 - Добавить запись\nДля выхода введите любой символ");
            int answer = inputAnswer();
		    switch (answer) {
		        case 1: 
		            writing(readList);
		            break;
		        default:
		            System.out.println("Выполнение программы завершено");
		            break;
		    }
        }
	}
	
	
//Метод для перехода в меню
	public static int inputAnswer () {
		Scanner sc = new Scanner(System.in);
		boolean flag = sc.hasNextInt();
		if (flag == true) {
            int answer = sc.nextInt();
            return answer;
		}
        else{
            return -1;
		}
	}
	
	
// Метод вывода справочника на экран
    public static void printing (Map <String, String> read) throws IOException {
	    LinkedList <String> check = new LinkedList <> ();
	    
	    for (String value : read.values()) {
            check.add(value);
        }
        
        for (int i = 0; i < check.size(); i++) {
            
            for (int j = 0; j < check.size(); j++) {
                if (check.get(j).equals(check.get(i)) && j>i) check.remove(j);
                }
            
            System.out.println (check.get(i));
            for (var el : read.entrySet()) {
                if (el.getValue().equals(check.get(i))) System.out.println("\t" + el.getKey());
                }
            }
        repeatMenu();
        }
        
        
// Метод создания контакта
	public static void writing (Map <String, String> read) throws IOException {
	    System.out.printf ("Введите имя контакта\n");
        String nameCont = inputData();
        System.out.printf ("Введите номер телефона\n");
        String numPhone = inputData();
        if (read.containsKey(numPhone) == true) {
            System.out.println ("Номер телефона " + numPhone + " существует для контакта " +
read.get(numPhone) + "!\nПерезаписать его для контакта " + nameCont + "?\n1 - Да\nДля отмены введите любой символ");
            int answer = inputAnswer();
            switch (answer) {
	            case 1: 
	                read.put(numPhone, nameCont);
	                break;
	            default: 
	                writing(read);
            }
        }
        else {
            read.put(numPhone, nameCont);
        }
        System.out.printf ("Контакт успешно сохранен!\n");
        FileWriter fw = new FileWriter("HW5_1");
        for (var el : read.entrySet()) {
            fw.write(el.getValue() + ": " + el.getKey() + "\n");
        }
        fw.flush();
        fw.close();
        repeatMenu();
    }
	   
	   
// Метод для выполнения повторной операции
    public static void repeatMenu () throws IOException {   
    System.out.println("Желаете выполнить другую операцию?\n1 - Да\nДля выхода введите любой символ");
    int answer = inputAnswer();
    switch (answer) {
        case 1: 
            mainMenu();
            break;
        default:
            System.out.println("Выполнение программы завершено");
            break;
	    }
    }
	    
	// Метод воода данных для контакта
	public static String inputData () {
	    String encoding = System.getProperty("consle.encoding", "cp866");
		Scanner sc = new Scanner(System.in, encoding);
		String str = sc.nextLine();
		return str;
	}
}

