package g040.p44wildcardmatching;

public class Solution {
    public boolean isMatch(String input, String pattern) {
        char[] in = input.toCharArray();
        char[] pt = pattern.toCharArray();
        cached = new Boolean[in.length][pt.length];
        return matches(in, in.length - 1, pt, pt.length - 1);
    }

    private Boolean[][] cached;

    // we look in reverse order, recursively
    boolean matches(char[] in, int ini, char[] pt, int pti) {
        if (pti == -1 && ini == -1) {
            return true;
        }
        if (pti == -1) {
            return false;
        }
        if (ini == -1) {
            // if only asterisks are missing, returns true
            for (int i = 0; i <= pti; i++) {
                if (pt[i] != '*') {
                    return false;
                }
            }
            return true;
        }

        if (cached[ini][pti] != null) {
            return cached[ini][pti];
        }

        switch (pt[pti]) {
            case '*':
                if (pti == 0) {
                    cached[ini][pti] = true;
                } else {
                    cached[ini][pti] = matches(in, ini - 1, pt, pti)
                            || matches(in, ini - 1, pt, pti - 1)
                            || matches(in, ini, pt, pti - 1);
                }
                break;
            case '?':
                cached[ini][pti] = matches(in, ini - 1, pt, pti - 1);
                break;
            default:
                if (in[ini] == pt[pti]) {
                    cached[ini][pti] = matches(in, ini - 1, pt, pti - 1);
                } else {
                    cached[ini][pti] = false;
                }
                break;
        }
        return cached[ini][pti];
    }
}
