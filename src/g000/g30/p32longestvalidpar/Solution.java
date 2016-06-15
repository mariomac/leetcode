package g000.g30.p32longestvalidpar;

import java.util.Stack;

/**
 * @author Mario Macias (http://github.com/mariomac)
 */
public class Solution {
	public int longestValidParentheses(String s) {
		char[] str = s.toCharArray();
		for(int tr = 0, tl = str.length - 1, pl = 0, pr = 0 ; tr < str.length ;tr++, tl--) {
			switch(str[tr]) {
				case '(':
					pr++;
					break;
				case ')':
					if(pr == 0) {
						str[tr] = '\0';
					} else {
						pr--;
					}
					break;
			}
			switch (str[tl]) {
				case ')':
					pl++;
					break;
				case '(':
					if(pl == 0) {
						str[tl] = '\0';
					} else {
						pl--;
					}
					break;
			}
		}
		int longitude = 0, longest = 0;
		for(int i = 0 ; i < str.length ; i++) {
			if(str[i]!='\0') {
				longitude++;
			} else {
				if(longest < longitude) {
					longest = longitude;
				}
				longitude = 0;
			}
		}
		if(longest < longitude) {
			longest = longitude;
		}
		return longest;
	}
}
