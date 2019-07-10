package g040.p44wildcardmatching;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        String[][] working = {
             {"aa", "aa"}, {"aa", "*"}, {"aa", "a*"},
                {"ab", "?*"},  {"", "*"}, {"a", "*"}, {"ho", "**ho"},
          {"ad*c","addc"}, {"a*d*c","addc"}, {"adceb","*a*b"},
          {"abbabbbaabaaabbbbbabbabbabbbabbaaabbbababbabaaabbab",
            "*aabb***aa**a******aa*"}
        };
        String[][] notworking = {
          {"aa", "a"}, {"aaa", "aa"},{"aab", "c*a*b"},
          {"acdcb", "a*c?b"}, {"cb","*a"}, {"", "?"}
        };
        Solution s = new Solution();
        for (String[][] set: Arrays.asList(working, notworking)) {
            System.out.println("*****");
            for (String[] in : set) {
                System.out.print(in[0] + ", " + in[1] + " -> ");
                System.out.flush();
                System.out.println(s.isMatch(in[0], in[1]));
            }
        }

	}
}
