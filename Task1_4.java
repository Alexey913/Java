/*Дан массив двоичных чисел, например [1,1,0,1,1,1],
вывести максимальное количество подряд идущих 1
 */

package Seminar1;

import java.util.Random;

public class Task1_4 {
    public static void main (String [] Args) {
        int[] array_bin = new int[15];
        for (int i = 0; i < array_bin.length; i++){
            array_bin[i] = new Random().nextInt(0,2);
            System.out.print(array_bin[i]);
        }
        int count = 0;
        int max_count = 0;
        for (int i = 0; i < array_bin.length; i++){
            if (array_bin[i] == 1) count+=1;
            else {
                if (max_count < count) max_count = count;
                count = 0;
            }
            }
        System.out.println("\n"+max_count);
    }
    
}
