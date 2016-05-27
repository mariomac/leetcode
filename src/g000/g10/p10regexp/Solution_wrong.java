package g000.g10.p10regexp;

public class Solution_wrong {
    public boolean isMatch(String s, String p) {
        char[] sc = s.toCharArray();
        char[] regex = p.toCharArray();
        int pr = 0;
        int psc = 0;
        while(pr < regex.length && psc < sc.length) {
            char precedingChar = regex[pr++];
            if (pr < regex.length && regex[pr] == '*') {
                while (psc < sc.length && (precedingChar == '.' || sc[psc] == precedingChar)) {
                    psc++;
                }
                pr++;
            } else if(precedingChar == '.' || precedingChar == sc[psc]) {
                psc++;
            } else {
                return false;
            }
        }
        // empty optional chars of regexp
        while(pr < regex.length - 1 && regex[pr+1] == '*') {
            pr += 2;
        }
        return (pr == regex.length && psc == sc.length);
    }
}
