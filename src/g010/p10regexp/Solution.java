package g000.g10.p10regexp;

/**
 * @author Mario Macias (http://github.com/mariomac)
 */
public class Solution {
	public boolean matches(char[] string, int stri, char[] regexp, int ri) {
		if(ri >= regexp.length) {
			return stri >= string.length;
		} else if(stri >= string.length) {
			while(ri < regexp.length - 1 && regexp[ri+1] == '*') {
				ri += 2;
			}
			return ri >= regexp.length;
		}
		boolean currentCharOk = regexp[ri] == '.' || regexp[ri] == string[stri];
		if(ri < regexp.length - 1 && regexp[ri+1] == '*') {
			return (currentCharOk && matches(string, stri+1, regexp, ri)) || matches(string,stri,regexp, ri + 2);
		} else if(currentCharOk) {
			return matches(string, stri+1, regexp, ri + 1);
		} else {
			return false;
		}
	}

	public boolean isMatch(String s, String p) {
		return matches(s.toCharArray(),0,p.toCharArray(),0);
	}

}
