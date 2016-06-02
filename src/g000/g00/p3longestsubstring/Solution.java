package g000.g00.p3longestsubstring;

import java.util.Arrays;

/**
 * Created by mmacias on 27/5/16.
 */
public class Solution {
    public int lengthOfLongestSubstring(String s) {
		int stringLength = s.length();
		if(stringLength == 0 || stringLength == 1) return stringLength;
        char[] str = s.toCharArray();
		int[] lastAppearance = new int[127];
		Arrays.fill(lastAppearance,-1);
		int lastRepetition = 0;
		int max = 0;
        for(int pos = 0 ; pos < stringLength ; pos++) {
			char c = str[pos];
			if(lastAppearance[c] >= 0) {
				int length = pos - lastRepetition;
				if(length > max) max = length;
				lastRepetition = pos;
			}
			lastAppearance[c] = pos;
		}
		if(stringLength-lastRepetition > max) max = stringLength - (lastRepetition )+ 1 ;

		return max;
    }
}

