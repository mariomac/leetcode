package g000.g90.p97interleavingstring;

class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1.isEmpty()) {
            return s2.equals(s3);
        }
        if (s2.isEmpty()) {
            return (s1.equals(s3));
        }
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }
        // compare histograms
        char[] sc1 = s1.toCharArray();
        char[] sc2 = s2.toCharArray();
        char[] sc3 = s3.toCharArray();
        int[] h1 = histogram(sc1);
        int[] h2 = histogram(sc2);
        int[] h3 = histogram(sc3);
        for (int i = 0; i < h1.length; i++) {
            if (h1[i] + h2[i] != h3[i]) {
                return false;
            }
        }
        return isInterleave(sc1, sc2, sc3);
    }

    static final int[] histogram(char[] s) {
        int[] chars = new int[256];
        for (char c : s) {
            chars[c]++;
        }
        return chars;
    }

    static final boolean isInterleave(char[] s1, char[] s2, char[] s3) {
        int i1 = 0, i2 = 0, i3 = 0;
        int[] stack = new int[s3.length * 3];
        int sp = 0;
        while (true) {
            if (i1 < s1.length && i2 < s2.length && i3 < s3.length
                    && s1[i1] == s2[i2] && s1[i1] == s3[i3]) {
                // when two ways are possible, store them in the stack queue and restore head
                stack[sp] = i1;
                stack[sp + 1] = i2 + 1;
                stack[sp + 2] = i3 + 1;
                sp += 3;
                i1++;
                i3++;
                continue;
            }
            if (i1 < s1.length && i3 < s3.length && s1[i1] == s3[i3]) {
                i1++;
                i3++;
                continue;
            }
            if (i2 < s2.length && i3 < s3.length && s2[i2] == s3[i3]) {
                i2++;
                i3++;
                continue;
            }
            if (i1 == s1.length && i2 == s2.length && i3 == s3.length) {
                return true;
            }

            // If there is no status in the queue return as failed
            if (sp == 0) {
                return false;
            }

            // something is in the queue, restore the status
            i1 = stack[sp - 3];
            i2 = stack[sp - 2];
            i3 = stack[sp - 1];
            sp -= 3;
        }
    }
}
