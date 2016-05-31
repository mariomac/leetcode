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
		char[] longest = strs[0].toCharArray();
		int longestLength = longest.length;
		for(int i = 1 ; i < strs.length && longestLength > 0 ; i++) {
			StringCharacterIterator ci = new StringCharacterIterator(strs[i]);
			int cil = 0;
			while(cil < longestLength && ci.current() == longest[cil]) {
				ci.next(); cil++;
			}
			longestLength = cil;
		}
		return new String(longest,0,longestLength);
	}
}
