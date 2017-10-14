package g000.g90.p97interleavingstring;

class SolutionRecursive {
    public boolean isInterleave(String s1, String s2, String s3) {
        return isInterleave(s1.toCharArray(), s2.toCharArray(), s3.toCharArray(), 0, 0, 0);
    }

    boolean isInterleave(char[] s1, char[] s2, char[] s3, int i1, int i2, int i3) {
        if (i1 == s1.length && i2 == s2.length && i3 == s3.length) {
            return true;
        }
        if(i1 < s1.length && i3 < s3.length && s1[i1] == s3[i3]) {
            if (isInterleave(s1, s2, s3, i1 + 1, i2, i3 + 1)) {
                return true;
            }
        }
        if(i2 < s2.length && i3 < s3.length && s2[i2] == s3[i3]) {
            return isInterleave(s1, s2, s3, i1, i2 + 1, i3 + 1);
        }
        return false;
    }
}
