package g000.g10.p12inttoroman;

import java.util.Map;
import java.util.TreeMap;

/**
 * @author Mario Macias (http://github.com/mariomac)
 */
public class Solution {
	public String intToRoman(int num) {
		StringBuilder sb = new StringBuilder();
		int[] values = {1000,900,500,400,100,90,50,40,10,9,5,4,1};
		char[][] letters = {{'M'},{'C','M'},{'D'},{'C','D'},{'C'},{'X','C'},{'L'},{'X','L'},{'X'},{'I','X'},{'V'},{'I','V'},{'I'}};
		int d = 0;
		while(num > 0 && d < values.length) {
			while(num >= values[d]) {
				sb.append(letters[d]);
				num -= values[d];
			}
			d++;
		}
		return sb.toString();
	}
}
