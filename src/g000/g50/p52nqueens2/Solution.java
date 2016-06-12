package g000.g50.p52nqueens2;

import java.util.*;

/**
 * Created by mmacias on 13/6/16.
 */
public class Solution {
        public int totalNQueens(int n) {
            return solveRow(new Board(n),0);
        }
    private int solveRow(Board board, int row) {
        int results = 0;
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
                    results++;
                    board.remove(row);
                }
            }
        } else {
            for(int c = startCol ; c != afterEndCol && (c % board.size) != afterEndCol ; c++) {
                if(board.put(row,c % board.size)) {
                    results += solveRow(board,row + 1);
                    board.remove(row);
                }
            }
        }
        return results;
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
    }

}
