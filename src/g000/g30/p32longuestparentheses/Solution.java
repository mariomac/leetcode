package g000.g30.p32longuestparentheses;

/**
 * Created by mmacias on 2/6/16.
 */
public class Solution {
    public int longestValidParentheses(String s) {
        int length = s.length();
        if(length == 0 || length == 1) return 0;
        int[] indexStack = new int[length];
        int head = 0;
        int max = 0;
        char[] string = s.toCharArray();

        for(int i = 0 ; i < string.length ; i++) {
            if(string[i] == '(') {
                indexStack[head] = i;
                head++;
            } else {
                if(head > 0) {
                    head--;
                    int substrLength = i - indexStack[head] + 1;
                    if(substrLength > max) {
                        max = substrLength;
                    }
                }
            }
        }
        return max;

    }
}