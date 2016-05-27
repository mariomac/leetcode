package g000.g00.p8atoi;

public class Solution {
    public int myAtoi(String str) {
        char[] s = str.toCharArray();
        int i = 0;
        int nonNumeric = 0;
        long number = 0;
        while(i < s.length && (s[i] < '0' || s[i] > '9')) {
            if(nonNumeric > 0) return 0;
            if(s[i] != ' ') {
                nonNumeric++;
            }
            i++;
        }
        final int sign;
        if(i==0) {
            sign = 1;
        } else if(s[i-1] == '-') {
            sign = -1;
        } else if(s[i-1] == '+' || s[i-1] == ' ') {
            sign = 1;
        } else return 0;

        while(i < s.length && s[i] >= '0' && s[i] <= '9') {
            number = number*10 + (s[i] - '0');
            if(sign > 0 && number > Integer.MAX_VALUE) return Integer.MAX_VALUE;
            else if(sign < 0 && -number < Integer.MIN_VALUE) return Integer.MIN_VALUE;
            i++;
        }

        number *= sign;
        if(sign < 0 && number < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        } else if (sign > 0 && number > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else {
            return (int)number;
        }

    }
}
