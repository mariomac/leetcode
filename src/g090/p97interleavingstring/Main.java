package g000.g90.p97interleavingstring;

public class Main {

    public static void main(String[] args) {
        Solution s = new Solution();
        String[][] tests = {
                {"aabcc", "dbbca", "aadbbcbcac"},
                {"aabcc", "dbbca", "aadbbbaccc"},
                {"bbbbbabbbbabaababaaaabbababbaaabbabbaaabaaaaababbbababbbbbabbbbababbabaabababbbaabababababbbaaababaa",
                        "babaaaabbababbbabbbbaabaabbaabbbbaabaaabaababaaaabaaabbaaabaaaabaabaabbbbbbbbbbbabaaabbababbabbabaab",
                        "babbbabbbaaabbababbbbababaabbabaabaaabbbbabbbaaabbbaaaaabbbbaabbaaabababbaaaaaabababbababaababbababbbababbbbaaaabaabbabbaaaaabbabbaaaabbbaabaaabaababaababbaaabbbbbabbbbaabbabaabbbbabaaabbababbabbabbab"},
                {"a", "", "a"}     ,
                {"aabaac",
                        "aadaaeaaf",
                        "aadaaeaabaacaaf"},
        };

        for (String[] i : tests) {
            System.out.println(i[0] + " * " + i[1] + " = " + i[2] + "? --> "
                    + s.isInterleave(i[0], i[1], i[2]));
        }

    }
}
