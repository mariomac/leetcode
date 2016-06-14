package g000.g30.p32longestvalidpar;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Mario Macias (http://github.com/mariomac)
 */
public class Solution_slowCopy extends Solution {
	public int longestValidParentheses(String s) {
		int longest = 0;
		char[] str = s.toCharArray();
		for(int from = 0 ; from < (str.length - longest) - 1 ; from++) {
			if(str[from] == '(') {
				for(int to = str.length - 1 ; to > from ; to--) {
					if(str[to] == ')' && isValid(str,from,to)) {
						if(to - from + 1 > longest) {
							longest = to - from + 1;
						}
					}
				}
			}
		}
		return longest;

	}

	private boolean isValid(char[] str, int from, int to) {
		int head = 0;
		for(int i = from; i <= to ; i++) {
			char c = str[i];
			if(c == '(') {
				head++;
			} else {
				if(head-- == 0) return false;
			}
		}

		return head == 0;
	}
}
