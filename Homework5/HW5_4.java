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







public class Main {
	
	public static void main(String[] args) {
		int[][] arr = new int[8][8];
		queens(0,arr);
	}
	
	private static void queens(int row, int[][] arr) {
	    
		if (row == 8){
		    System.out.println();
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr[i].length; j++) {
					System.out.print(arr[i][j]+" ");
				}
				System.out.println();
			}
		}
		else {
			int[][] newArr = new int[8][8];
			for (int i = 0; i < arr.length; i++) {
				for ( int j = 0; j < arr[i].length; j++) {
					newArr[i][j] = arr[i][j];
				}
			}
			for (int col = 0; col < 8; col++) {
				if (noDangerous (row, col, newArr)) {
					for (int c = 0; c < 8; c++) {
						newArr[row][c] = 0;
					}
					newArr[row][col] = 1;
					queens(row+1, newArr);
				}
			}
		}	
	}
	
	private static boolean noDangerous(int row, int col, int[][] newArr) {

		for (int r = row-1; r >= 0; r--) {
			if (newArr[r][col] == 1) {
				return false;
			}
		}

		for (int r = row-1, c = col-1; r>=0 && c>=0; r--, c--) {
			if (newArr[r][c] == 1) {
				return false;
			}
		}

		for(int r = row-1, c = col+1; r>=0 && c<8; r--, c++) {
			if(newArr[r][c] == 1) {
				return false;
			}
		}
		
		return true;
	}
}
