package g200.g240.p242anagram;

/**
 * @author Mario Macias (http://github.com/mariomac)
 */
public class Solution {
	public boolean isAnagram(String s, String t) {
		if(s.length() != t.length()) return false;

		int[] histogram = new int['z'-'a'+1];
		for(char c : s.toCharArray()) {
			histogram[(Character.toLowerCase(c)-'a')]++;
		}
		for(char c : t.toCharArray()) {
			int i = Character.toLowerCase(c)-'a';
			histogram[i]--;
			if(histogram[i] < 0) {
				return false;
			}
		}
		return true;
	}
}
