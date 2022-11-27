// Дано четное число N (>0) и символы c1 и c2.
// Написать метод, который вернет строку длины N,
// которая состоит из чередующихся символов c1 и c2, начиная с c1.

import java.util.Scanner;
public class Task2_1 {
    public static void main (String [] Args) {
        char c1 = 'a';
        char c2 = 'b';
        Scanner ent = new Scanner(System.in);
        int n = ent.nextInt();

        StringBuilder build = new StringBuilder();
        if (n%2 == 0) {
            for (int i = 0; i < n; i++) {
                if (i%2 == 0) {
                    build.append(c1);
                }
                else {
                    build.append(c2);
                }
            }
            System.out.println(build);
        }
        else System.out.println("Увы... Нечетное число");
    
    }
    
}
