package g000.g10.p10regexp;

public class Main {

    public static void main(String[] args) {
		Solution s = new Solution();
		System.out.println(s.isMatch("aa","a") == false);
		System.out.println(s.isMatch("aa","aa") == true);
		System.out.println(s.isMatch("aaa","aa") == false);
		System.out.println(s.isMatch("aa", "a*") == true);
		System.out.println(s.isMatch("aa", ".*") == true);
		System.out.println(s.isMatch("ab", ".*") == true);
		System.out.println(s.isMatch("aab", "c*a*b") == true);
		System.out.println(s.isMatch("aabaa", "aaa*b*c*a*aa") == true);
		System.out.println(s.isMatch("abcd", "d*") == false);
	}
}
