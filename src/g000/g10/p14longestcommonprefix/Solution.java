package g000.g10.p14longestcommonprefix;

import g000.g20.p23mergeksortedlists.ListNode;

import java.text.StringCharacterIterator;
import java.util.*;

/**
 * @author Mario Macias (http://github.com/mariomac)
 */
public class Solution {

	public String longestCommonPrefix(String[] strs) {
		if(strs.length == 0) return "";
		else if(strs.length == 1) return strs[0];

		char[] longest = strs[0].toCharArray();
		int longestLength = longest.length;

		for(int i = 1 ; i < strs.length && longestLength > 0 ; i++) {
			char[] current = strs[i].toCharArray();
			if(current.length == 0) return "";

			int ci = 0;
			while(ci < longestLength && ci < current.length && current[ci] == longest[ci]) {
				ci++;
			}
			if(ci == 0) return "";
			longestLength = ci;
		}
		return new String(longest,0,longestLength);
	}
}
