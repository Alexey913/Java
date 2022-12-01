import java.io.IOException;
import java.util.Scanner;
import java.util.logging.*;

public class HW2_2 {
    private static Logger log = Logger.getLogger(HW2_2.class.getName());

	public static void main(String[] args) throws SecurityException, IOException {

    Handler fh  = null;
    fh = new FileHandler("HW2_2.txt" + "run.log",  1000000, 1, true);
    // log.addHandler(fh);
    SimpleFormatter sFormat = new SimpleFormatter();
    fh.setFormatter(sFormat);
    
    log.log(Level.INFO, "Запуск калькулятора \n");
    
    int excep = 0;
    while (excep == 0) {
        try{
            excep = main_menu();
        }
        catch (NumberFormatException e) {
            System.out.println ("Ошибка ввода! Повторите! \n");
            log.log(Level.WARNING, "Ошибка ввода! Неверный формат!\n");
        }
        catch (ArrayIndexOutOfBoundsException e) {
            System.out.println ("Ошибка ввода! Повторите! \n");
            log.log(Level.WARNING, "Ошибка ввода! Неверное число элементов!\n");
        }
    }
}
        
	static String[] inputData() throws SecurityException, IOException {
	    System.out.println ("Введите через пробел выражение для подсчета и нажмите Enter\n(Например, 8.5 + 10)");
	    Scanner enterData = new Scanner(System.in);
        String data = enterData.nextLine();
        String [] data_elem = data.split(" ");
        
        // Logger log = Logger.getLogger(HW2_1.class.getName());
        FileHandler fh = new FileHandler("HW2_2.txt" + "run.log", 1000000, 1, true);
        log.addHandler(fh);
        SimpleFormatter sFormat = new SimpleFormatter();
        fh.setFormatter(sFormat);
            
        log.log(Level.INFO, "Введено значение " + data + "\n");
        return data_elem;
	}
	
	static int calculator (float numOne, float numTwo, String symbol) throws SecurityException, IOException {
	    switch (symbol) {
            case "+":
                System.out.printf ("Сумма чисел %f и %f равна %f", numOne,numTwo, numOne+numTwo);
                break;
            case "-":
                System.out.printf ("Разность чисел %f и %f равна %f", numOne,numTwo, numOne-numTwo);
                break;
            case "*":
                System.out.printf ("Произведение чисел %f и %f равно %f", numOne,numTwo, numOne*numTwo);
                break;
            case "/":
                if (numTwo != 0) {
                    System.out.printf ("Частное %f и %f равно %f", numOne,numTwo, numOne/numTwo);
                }
                else {
                    System.out.println ("Ошибка! На 0 делить нельзя!");
                }
                break;
            case "%":
                System.out.printf ("Остаток от деления числа %f на число %f равно %f", numOne,numTwo, numOne%numTwo);
                break;
            case "^":
                float result = numOne;
                if (numTwo%1 == 0) {
                    if (numTwo>0) {
                        for (int i = 1; i < numTwo; i++) result*=numOne;
                    }
                    else {
                        for (int i = 1; i < -numTwo; i++) result*=numOne;
                        result = 1/result;
                    }
                    if (numTwo == 0) result = 1;
                    System.out.printf ("Число %f в степени %f равно %f", numOne,numTwo, result);
                }
                else {
                    System.out.println ("Ошибка! Степень должна быть целым числом!");
                }
                break;
            default:
                System.out.print ("Я не знаю такого действия!");
                break;
	    }
        System.out.printf ("\n\nЖелаете еще что-нибудь посчитать? \n1 - Повторить операцию с числами %f и %f\n2 - Выполнить новую операцию\n3 - Выход\n", numOne, numTwo);
        Scanner answer = new Scanner(System.in);
        String user_answ = answer.nextLine();
        int excep = repeat_operation(user_answ, numOne, numTwo);
        return excep;
	}
	
	
	static int main_menu() throws SecurityException, IOException {
    	String [] elements = inputData();
        while (elements.length>3) {
            System.out.printf ("Ошибка ввода! Повторите! \n");
            elements = inputData();
        }
        float num_1 = Float.parseFloat (elements[0]);
        float num_2 = Float.parseFloat (elements[2]);
        int excep = calculator(num_1, num_2, elements[1]);
        return excep;
	}
	
	
	static int repeat_operation (String answ, float numOne, float numTwo) throws SecurityException, IOException {
    switch (answ) {
        case "1":
            System.out.println ("Какое действие будем использовать?\nВведите одно из предложенных действий\n+ - * / % ^\n");
            Scanner act = new Scanner(System.in);
            String action = act.nextLine();
            int excep = calculator (numOne, numTwo, action);
            return excep;
        case "2":
            excep = main_menu();
            return excep;
        case "3":
            System.out.println ("Приходите еще!");
            return 1;
	    default:
	        System.out.println ("Не понял Вас. Давайте попробуем в следующий раз!");
	        return 1;
        }
	}
}    