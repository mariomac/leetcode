package g000.g40.p44wildcardmatching;

public class Main {

    public static void main(String[] args) {
        String[][] input = {
            {"aa", "a"}, {"aa", "aa"}, {"aaa", "aa"}, {"aa", "*"}, {"aa", "a*"},
                {"ab", "?*"}, {"aab", "c*a*b"}, {"", "*"}, {"ho", "**ho"}
        };
        Solution s = new Solution();
        for(String[] in : input) {
            System.out.print(in[0] + ", " + in[1] + " -> ");
            System.out.flush();
            System.out.println(s.isMatch(in[0], in[1]));
        }

	}
}
