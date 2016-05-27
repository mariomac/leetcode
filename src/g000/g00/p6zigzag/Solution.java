package g000.g00.p6zigzag;

/**
 * Created by mmacias on 27/5/16.
 */
public class Solution {
    public String convert(String s, int numRows) {
        if(numRows == 1) return s;

        char[] sc = s.toCharArray();
        int dr = 1;
        int r = 0;
        char[][] grid = new char[numRows][sc.length/numRows * 2];
        int[] maxCol = new int[numRows];
        for(char ch : sc) {
            grid[r][maxCol[r]] = ch;
            maxCol[r]++;
            r += dr;
            if(r >= numRows) {
                r-=2;
                dr = -1;
            } else if(r < 0) {
                r = 1;
                dr = 1;
            }
        }

        StringBuilder sb = new StringBuilder();

        for(int i = 0 ; i < numRows ; i++) {
            sb.append(grid[i],0,maxCol[i]);
        }
        return sb.toString();
    }
}
