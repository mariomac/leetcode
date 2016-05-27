package g000.g30.p37sudokusolver;

/**
 * Created by mmacias on 27/5/16.
 */
public class Solution {
    public boolean canFit(char[][]board,int r, int c, char num) {
        int boxR = (r / 3) * 3;
        int boxC = (c / 3) * 3;
        for(int i = 0 ; i < 9 ; i++) {
            if(board[r][i] == num || board[i][c] == num || board[boxR+i%3][boxC+i/3] == num) {
                return false;
            }
        }
        return true;
    }
    public boolean solveRecursively(char[][] board,int r, int c) {
        while(board[r][c] != '.') {
            c++;
            if(c >= 9) {
                c=0; r++;
                if(r >= 9) {
                    return true;
                }
            }
        }
        for(char n = '1' ; n <= '9' ; n++) {
            if(canFit(board,r,c,n)) {
                board[r][c]=n;
                if(solveRecursively(board,r,c)) {
                    return true;
                }
            }
        }
        board[r][c]='.';
        return false;
    }
    public void solveSudoku(char[][] board) {
        solveRecursively(board,0,0);
    }
}