package g040.p44wildcardmatching;

/**
 * DP approach, using a matrix that represents an inverse path from the success
 * path[M][N] to the origin (path[1][1])
 * <p>
 * Each position of the matrix is built as a function of the neighbors (if you
 * can reach such position from any neighbor that allows stepping in diagonal
 * or in any way) and the pattern matching of the corresponding input and
 * pattern chars. if path[x][y] == true, it means that there is any way to
 * reach this state
 */
public class Solution {

    public boolean isMatch(String input, String pattern) {
        char[] in = input.toCharArray();
        char[] pt = pattern.toCharArray();
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

        // we give more dimension to not check top-left boundaries
        boolean[][] path = new boolean[input.length + 1][pattern.length + 1];


        final int M = input.length;
        final int N = pattern.length;

        path[M][N] = true;

        for (int r = M; r > 0; r--) {
            for (int c = N; c > 0; c--) {
                if (path[r][c]) {
                    switch (pattern[c - 1]) {
                        case '?':
                            if (r >= 1) {
                                path[r - 1][c - 1] = true;
                            }
                            break;
                        case '*':
                            path[r - 1][c - 1] = true;
                            path[r - 1][c] = true;
                            path[r][c - 1] = true;
                            break;
                        default:
                            if (input[r - 1] == pattern[c - 1]) {
                                path[r - 1][c - 1] = true;
                            }
                            break;
                    }
                }
            }
        }

        // ignore leading asterisks
        int c;
        for (c = 0 ; !path[0][c] && pattern[c] == '*'; c++);
        return path[0][c];
    }
}
