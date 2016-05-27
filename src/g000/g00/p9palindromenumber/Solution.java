package g000.g00.p9palindromenumber;

/**
 * Created by mmacias on 27/5/16.
 */
public class Solution {
    public boolean isPalindrome(int x) {
        if(x < 0) return false;
        long divider = 1;
        while(x / (divider * 10) != 0) {
            divider *= 10;
        }
        while(divider > 1) {
            if((x / divider) % 10 != x % 10) return false;
            x = x / 10;
            divider = divider / 100;
        }
        return true;
    }
}
