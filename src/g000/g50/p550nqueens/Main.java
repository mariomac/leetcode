package g000.g50.p550nqueens;

import java.util.List;

public class Main {

    public static void main(String[] args) {
		Solution s = new Solution();
		for(List<String> sol : s.solveNQueens(4)) {
			System.out.println("");
			for(String row : sol) {
				System.out.println(row);
			}
		}
	}
}
