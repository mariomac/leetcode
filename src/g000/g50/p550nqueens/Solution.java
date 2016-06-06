package g000.g50.p550nqueens;

import java.sql.ResultSet;
import java.util.*;

/**
 * @author Mario Macias (http://github.com/mariomac)
 */
public class Solution {
	public List<List<String>> solveNQueens(int n) {
		List<List<String>> resultsSet = new LinkedList<>();
		solveRow(new Board(n),0,resultsSet);
		return resultsSet;
	}
	private void solveRow(Board board, int row, List<List<String>> resultsSet) {
		int startCol, afterEndCol;
		if(row == 0) {
			startCol = 0; afterEndCol = board.size;
		} else {
			if(board.rows[row - 1] + 2 >= board.size) {
				startCol = 0;
			} else {
				startCol = board.rows[row - 1] + 2;
			}
			if(board.rows[row - 1] - 1 <= 0) {
				afterEndCol = board.size;
			} else {
				afterEndCol = board.rows[row - 1] - 1;
			}
		}
		if(row == board.size - 1) {
			for(int c = startCol ; c != afterEndCol && (c % board.size) != afterEndCol ; c++) {
				if(board.put(row,c % board.size)) {
					resultsSet.add(board.asStringList());
					board.remove(row);
				}
			}
		} else {
			for(int c = startCol ; c != afterEndCol && (c % board.size) != afterEndCol ; c++) {
				if(board.put(row,c % board.size)) {
					solveRow(board,row + 1,resultsSet);
					board.remove(row);
				}
			}
		}
	}

	private static class Board {
		int size;
		// each int represents a row, and it's the column [1,size]
		// where there is a queen
		int[] rows;
		boolean[] colsCache;

		public Board(int size) {
			this.size = size;
			rows = new int[size];
			Arrays.fill(rows,-1);
			colsCache = new boolean[size];
		}
		// only checks rows top of the r,c positions
		// positions are 0-index based
		public boolean put(int r, int c) {
			if(colsCache[c]) return false;
			int shift = 1;
			while(r - shift >= 0) {
				if((rows[r-shift] >= 0 && rows[r-shift] == c - shift) || rows[r-shift] == c+shift) {
					return false;
				}
				shift++;
			}
			rows[r] = c;
			colsCache[c] = true;
			return true;
		}
		public void remove(int row) {
			colsCache[rows[row]] = false;
//			rows[row] = -1;
		}
		public List<String> asStringList() {
			List<String> ret = new ArrayList<>(size);
			for(int r : rows) {
				ret.add(getRow(size,r));
			}
			return ret;
		}
		private static String getRow(int length, int queenPos) {
			Map<Integer,String> byLength = rowStrings.get(length);
			if(byLength == null) {
				byLength = new HashMap<>();
				rowStrings.put(length, byLength);
			}
			String rowStr = byLength.get(queenPos);
			if(rowStr == null) {
				char[] rowChars = new char[length];
				Arrays.fill(rowChars,'.');
				rowChars[queenPos] = 'Q';
				rowStr = String.valueOf(rowChars);
				byLength.put(queenPos,rowStr);
			}
			return rowStr;
		}
		private static Map<Integer,Map<Integer,String>> rowStrings = new HashMap<>();
	}
}
