import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

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

public class Main {
	
	public static void main(String[] args) {
		int[][] arr = new int[8][8];
		String [] str = new String [] {"a","b","c","d","e","f","g","h"};
		Map <String, Integer> letters = new HashMap <> ();
        for (int i = 0; i < str.length; i++) {
            letters.put (str[i], i);
        }
        System.out.println("Введите поле:");
		Scanner sc = new Scanner(System.in);
		String inputData = sc.nextLine();
        String [] value = inputData.split("");

        int a = 8-Integer.parseInt(value[1]);
        
        int b = 0;
        if (letters.containsKey(value[0])) {
            b = letters.get(value[0]);
        }
        else {
            System.out.println("Ошибка ввода!");
        }
        System.out.println("Возможные комбинации расстановки ферзей при постановке первого ферзя на поле " + inputData);
        
		queens(0,arr, a, b);
	}
	
	private static void queens(int row, int[][] arr, int a, int b) {

		if (row == 8 && arr[a][b]==1){
		    System.out.println();
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr[i].length; j++) {
					System.out.print((arr[i][j]==1) ? "Q " : ". ");
				}
				System.out.println();
			}
		}
		else {
			int[][] newArr = new int[8][8];
			for (int i = 0; i < arr.length; i++) {
				for (int j = 0; j < arr[i].length; j++) {
					newArr[i][j] = arr[i][j];
			    }
			}
			for (int col = 0; col < 8; col++) {
				if (noDangerous (row, col, newArr)) {
				    for (int c = 0; c < 8; c++) {
						newArr[row][c] = 0;
					}
				    newArr[row][col] = 1;
					queens(row+1, newArr, a, b);
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
