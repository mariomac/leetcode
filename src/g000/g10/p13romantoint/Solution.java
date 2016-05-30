package g000.g10.p13romantoint;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

/**
 * @author Mario Macias (http://github.com/mariomac)
 */
public class Solution {
	public int romanToInt(String s) {
		char[] roman = s.toCharArray();
		int num = 0;
		int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
		char[][] letters = {{'M'},{'C','M'},{'D'},{'C','D'},{'C'},{'X','C'},{'L'},{'X','L'},{'X'},{'I','X'},{'V'},{'I','V'},{'I'}};
		int r = 0;
		for(int d = 0 ; d < letters.length ; d++) {
			char[] romanDigit = letters[d];
			while(r+romanDigit.length <= roman.length
				&& (romanDigit.length == 1 ? roman[r] == romanDigit[0] :
					roman[r] == romanDigit[0] && roman[r+1] == romanDigit[1])) {
				r += romanDigit.length;
				num += values[d];
			}
		}
		return  num;
	}
}
