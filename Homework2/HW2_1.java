/*
 * Реализуйте алгоритм сортировки пузырьком числового массива,
 * результат после каждой итерации запишите в лог-файл.
 */

import java.io.IOException;

import java.util.Scanner;

import java.util.logging.*;

public class HW2_1 {
    public static void main (String [] Args) throws SecurityException, IOException {
        System.out.println("Введите массив целых чисел через пробел");
        int [] arrayForSort = enterData();
        for (int i: arrayForSort) {
            System.out.printf(i+ " ");
        }
        int [] sortArray = sortMethod(arrayForSort);
        System.out.println("\n");
        for (int i: sortArray) {
            System.out.printf(i + " ");
        }
    }
//Метод ввода элементов массива для сортировки
    static int [] enterData() throws SecurityException, IOException {
        Scanner sc = new Scanner(System.in);
        String dataForArray = sc.nextLine();
        logging("Ввод данных пользователя");
        String [] stringArray = dataForArray.split(" ");
        int len = stringArray.length;
        int [] array = new int [len];
        for (int i = 0; i < len; i++) {
            try {
                array[i] = Integer.parseInt(stringArray[i]);
                // logging("Преобразование данных пользователя");
            }
            catch (Exception e) {
                System.out.printf("Вы ввели какую-то дичь для %d элемента. Я заменил его на 0\n", i+1);
                // logging("Ошибка преобразования данных пользователя. Замена на 0");
                array[i] = 0;
            }
        }
        return array;
    }

    static int [] sortMethod (int [] arrayForSort) {
        int len = arrayForSort.length;
        for (int i = 0; i < len; i++) {
            int booble = arrayForSort[0];
            for (int j = 1; j < len; j++) {
                if (arrayForSort[j] < arrayForSort[j-1]) {
                    arrayForSort[j-1] = arrayForSort[j];
                    arrayForSort[j] = booble;
                    booble = arrayForSort[j];
                }
                else {
                    booble = arrayForSort[j];
                }
            }
        }
        return arrayForSort;
    }

//Кривой метод логирования
    public static void logging (String msg) throws SecurityException, IOException {
        Logger logger = Logger.getLogger(HW2_1.class.getName());
        FileHandler fh = new FileHandler("HW2_1.txt", true);
        logger.addHandler(fh);
        SimpleFormatter sFormat = new SimpleFormatter();
        fh.setFormatter(sFormat);
        logger.log(Level.INFO, msg);
    }
}