import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

import javax.swing.text.html.FormView;

/*На шахматной доске расставить 8 ферзей так, чтобы они не били друг друга
*/
    /*
    -----------------------------------------
    | a8 | b8 | c8 | *  | e8 | f8 | g8 | h8 |
    -----------------------------------------
    | a7 | b7 | c7 | *  | e7 | f7 | g7 | *  |
    -----------------------------------------
    | *  | b6 | c6 | *  | e6 | f6 | *  | h6 |
    -----------------------------------------
    | a5 | *  | c5 | *  | e5 | *  | g5 | h5 |
    -----------------------------------------
    | a4 | b4 | *  | *  | *  | f4 | g4 | h4 |
    -----------------------------------------
    | *  | *  | *  | X  | *  | *  | *  | *  |
    -----------------------------------------
    | a2 | b2 | *  | *  | *  | f2 | g2 | h2 |
    -----------------------------------------
    | a1 | *  | c1 | *  | e1 | *  | g1 | h1 |
    -----------------------------------------
    */

public class HW5_4 {
    
    public static int[][] setQueens(){
        String [] str = new String [] {"a","b","c","d","e","f","g","h"};
        Map <String, Integer> letters = new HashMap <> ();
        for (int i = 0; i < str.length; i++) {
            letters.put (str[i], i);
        }
        int [][] board = new int [8][8];
        System.out.println("Введите поле:");
		Scanner sc = new Scanner(System.in);
        String [] value = sc.nextLine().split("");
        int a = 0;
        if (letters.containsKey(value[0])) {
            a = letters.get(value[0]);
        }
        else {
            System.out.println("Ошибка ввода!");
        }
        int b = Integer.parseInt(value[1]);
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if (tryQueen (i, j, board) == true) {
                    
                }
            }
            
        }
        return board;
    }

    public boolean tryQueen (int a, int b, int[][]board) {
        for (int i = 0; i < a; ++i)
            if (board[i][b]==1) return false;
 
        for (int i = 1; i <= a && b - i >= 0; ++i)
            if (board[a - i][b - i]==1) return false;
 
        for (int i = 1; i <= a && b + i < 8; i++)
            if (board[a - i][b + i]==1) return false;
        return true;
    }


    public static void showBoard(int [][] board){
        for (int a = 0; a < 8; ++a)
        {
            for (int b = 0; b < 8; ++b)
            {
                System.out.print((board[a][b]==1) ? "Q " : ". ");
            }
            System.out.print('\n');
        }
    }

    public static void main(String args[]) {
        showBoard(setQueens());
    }
}