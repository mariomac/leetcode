package g000.g30.p36validsudoku;

/**
 * Created by mmacias on 13/6/16.
 */
public class Solution {
    public boolean isValidSudoku(char[][] board) {
        for(int r = 0 ; r < 9 ; r++) {
            boolean[] checkR = new boolean[9];
            boolean[] checkC = new boolean[9];
            boolean[] checkBox = new boolean[9];
            int bl = (r%3) * 3;
            int bt = (r/3) * 3;
            for(int c = 0 ; c < 9 ; c++) {
                int tr = board[r][c] - '1';
                if(tr >= 0) {
                    if(checkR[tr]) return false;
                    checkR[tr] = true;
                }
                int tc = board[c][r] - '1';
                if(tc >= 0) {
                    if(checkC[tc]) return false;
                    checkC[tc] = true;
                }
                int tb = board[bl+c%3][bt+c/3] - '1';
                if(tb >= 0) {
                    if(checkBox[tb]) return false;
                    checkBox[tb] = true;
                }
            }
        }
        return true;
    }
}
