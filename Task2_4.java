// Напишите метод, который вернет содержимое текущей папки в виде массива строк. Напишите метод, который запишет массив, возвращенный предыдущим методом в файл.
// Обработайте ошибки с помощью try-catch конструкции. В случае возникновения исключения, оно должно записаться в лог-файл.

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.lang.System.Logger;
 
public class Task2_4 {
 
    public static void main(String[] args) {
        String path = "C:\\Alex\\GB\\Java\\Seminar2";
        try {
            File dir = new File(path);
            String [] arrayDyrectory = getNamesFiles(dir);
            for (String i: arrayDyrectory) {
                System.out.println(i);
            }
            recInFile(arrayDyrectory);
        }
        catch (Exception e) {
            System.out.println("Ошибка открытия файла");
        }
    }
    // Метод, обновляющий массив и добавляющий новую строку с содержимым папки 
    static String [] fillArray (String [] array, String string) {
        int len = array.length;
        String [] temp = new String[len + 1];
        System.arraycopy(array, 0, temp, 0, len);
        temp [len] = string;
        return temp;
    }

    // Метод добавляет каждый каталог/файл в массив
    static String [] getNamesFiles (File myDyrectory) {
        String [] inFolder = new String [0]; // Задаем нулевой массив
        if(myDyrectory.isDirectory())
        {
            for(File item : myDyrectory.listFiles()){ //Собираем содержимое папки
                String newString = "";  //В зависимости, каталог или файл,  
                if(item.isDirectory()){
                    newString = (item.getName() + "\t folder");
                }
                else{
                    newString = (item.getName() + "\t file");
                }
                inFolder = fillArray(inFolder, newString); //записываем информацию в наш массив с помощью метода fillArray
            }
        }
        return inFolder;
    }

    // Метод, записывает массив с содержимым каталога в файл
    static void recInFile (String [] array) {
        try (FileWriter fileWrite = new FileWriter("task2_4.txt", false)) {
            for (String i: array) {
                fileWrite.append(i+"\n");
                fileWrite.flush();
            }
        }
        catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}















// import java.io.FileWriter;
// import java.io.IOException;
// import java.nio.file.DirectoryStream;
// import java.nio.file.Files;
// import java.nio.file.Path;

// public class Task2_4 {
//     public static void main (String [] args) {
//         list_files();

//         // try (FileWriter fw = new FileWriter("task2_4.txt", false)) {
//         //     int [] array = new int [100];
//         //     for (int i = 0; i < 100; i++) {
//         //         array [i] = i;
//         //     }
//         //     for (int i = 0; i < array.length; i++) {
//         //         fw.write(array[i]);
//         //         fw.append('\n');
//         //         fw.flush();
//         //     }
//         // }
//         // catch (IOException ex) {
//         //     System.out.println(ex.getMessage());
//         // }
//     }

//     static String [] list_files () {
//         Path path = Path.of("c:\\windows");

//         try (DirectoryStream<Path> files = Files.newDirectoryStream(path)) {
//            for (Path path: files)
//               System.out.println(path);
//         }
//     } 
// }

// /*
// Дорешать задачу 4 семинара 2
// Задачи ДЗ2
// Дорешать задачи ДЗ1
// Методы, типы, классы, объекты, переменные - разобраться в классификации
// */