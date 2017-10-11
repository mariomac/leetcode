package g000.g40.p44wildcardmatching;

public class Solution {
    public boolean isMatch(String input, String pattern) {
        char[] in = input.toCharArray();
        char[] pt = pattern.toCharArray();
        return matches(in, in.length - 1, pt, pt.length - 1);
    }

    // we look in reverse order, recursively
    boolean matches(char[] in, int ini, char[] pt, int pti) {
        if (pti == -1 && ini == -1) {
            return true;
        }
        if(pti == -1) {
            return false;
        }
        if(ini == -1) {
            // if only asterisks are missing, returns true
            for (int i = 0 ; i <= pti ; i++) {
                if(pt[i] != '*') {
                    return false;
                }
            }
            return true;
        }
        switch (pt[pti]) {
            case '*':
                if (pti == 0) {
                    return true;
                }
                return matches(in, ini - 1, pt, pti)
                        || matches(in, ini - 1, pt, pti - 1)
                        || matches(in, ini, pt, pti - 1);
            case '?':
                return matches(in, ini - 1, pt, pti - 1);
            default:
                if (in[ini] == pt[pti]) {
                    return matches(in, ini - 1, pt, pti - 1);
                } else {
                    return false;
                }
        }
    }
}
