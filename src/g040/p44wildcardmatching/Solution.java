package g040.p44wildcardmatching;

/**
 * DP approach, using a matrix that represents an inverse path from the success
 * path[M][N] to the origin (path[0][0])
 *
 * Each position of the matrix is built as a function of the neighbors (if you
 * can reach such position from any neighbor that allows stepping in diagonal
 * or in any way) and the pattern matching of the corresponding input and
 * pattern chars.
 */
public class Solution {

    private static final int NOWAY = 0;
    private static final int DIAGONAL = 1;
    private static final int ANYWAY = 2;

    private int[][] path;

    public boolean isMatch(String input, String pattern) {
        char[] in = input.toCharArray();
        char[] pt = pattern.toCharArray();
        path = new int[in.length][pt.length];
        return matches(in, pt);
    }

    boolean matches(char[] input, char[] pattern) {
        if (input.length == 0) {
            for (char c : pattern) {
                if (c != '*') {
                    return false;
                }
            }
            return true;
        }
        if (pattern.length == 0) {
            return false;
        }

        final int M = input.length - 1;
        final int N = pattern.length - 1;

        // bottom right of the matrix
        path[M][N] = direction(input[M], pattern[N]);

        // right edge of the matrix
        for (int r = M - 1; r >= 0 && path[r + 1][N] == ANYWAY; r--) {
            path[r][N] = direction(input[r], pattern[N]);
        }

        // bottom edge of the matrix
        for (int c = N - 1; c >= 0 && path[M][c + 1] == ANYWAY; c--) {
            path[M][c] = direction(input[M], pattern[c]);
        }

        for (int r = M - 1; r >= 0; r--) {
            for (int c = N - 1; c >= 0; c--) {
                if (path[r + 1][c] == ANYWAY
                    || path[r + 1][c + 1] == DIAGONAL
                    || path[r][c + 1] == ANYWAY) {
                    path[r][c] = direction(input[r], pattern[c]);
                }
            }
        }

        // ignore leading asterisks
        int c;
        for (c = 0 ; path[0][c] == NOWAY && pattern[c] == '*'; c++);
        return path[0][c] != NOWAY;
    }

    int direction(char input, char pattern) {
        switch (pattern) {
            case '?':
                return DIAGONAL;
            case '*':
                return ANYWAY;
            default:
                if (pattern == input) {
                    return DIAGONAL;
                }
        }
        return NOWAY;
    }
}
