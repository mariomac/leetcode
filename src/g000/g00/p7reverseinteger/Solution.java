package g000.g00.p7reverseinteger;

public class Solution {
    public int reverse(int x) {
        final int sign;
        if( x < 0) {
            sign = -1;
            x = -x;
        } else {
            sign = 1;
        }
        long rev = 0;
        while(x > 0) {
            rev = rev * 10 + x%10;
            x /= 10;
        }
        rev *= sign;
        if((sign < 0 && rev < Integer.MIN_VALUE)
            || (sign > 0 && rev > Integer.MAX_VALUE)) {
            return 0;
        } else {
            return (int)rev;
        }
    }
}
