package g000.g30.p38countandsay;

public class Solution {

    private static final int ARR_SIZE = 100000;

    public String countAndSay(int n) {
        char[] src = new char[ARR_SIZE];
        char[] dst = new char[ARR_SIZE];

        src[0] = '1';
        int lastLength = 1;
        for (int i = 2 ; i <= n ; i++) {
            lastLength = countAndSayLong(src, lastLength, dst);
            char[] tmp = src;
            src = dst;
            dst = tmp;
        }

        return String.valueOf(src, 0, lastLength);
    }

    /**
     * @return length of the dst char array
     */
    public int countAndSayLong(char[] src, int srcLength, char[] dst) {
        char last = src[0];
        int dstLength = 0;
        int lastCount = 1;

        for (int i = 1 ; i < srcLength ; i++) {
            if (src[i] == last) {
                lastCount++;
            } else {
                dst[dstLength++] = (char) ('0' + lastCount);
                dst[dstLength++] = last;
                last = src[i];
                lastCount = 1;
            }
        }

        dst[dstLength++] = (char) ('0' + lastCount);
        dst[dstLength++] = last;

        return dstLength;
    }

}
