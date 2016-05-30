package g000.g10.p10regexp;

import java.util.HashMap;
import java.util.Map;

public class Solution_wrong {
    private class State {
        boolean finalState = false;
        Map<Character,State> transitions = new HashMap<Character,State>();

    }

    public boolean isMatch(String s, String p) {
        char[] sc = s.toCharArray();
        char[] regex = p.toCharArray();
        int pr = regex.length - 1;
        int psc = sc.length -1;
        while(pr >= 0 && psc >= 0) {
            if(regex[pr] == '.') {
                psc--;
            } else if(regex[pr] == '*') {
                pr--;
                while(psc>=0 && (regex[pr] == '.' || sc[psc] == regex[pr])) {
                    psc--;
                }
            } else if(regex[pr] == sc[psc]) {
                psc--;
            } else {
                return false;
            }

            pr--;
        }
        while(pr >= 0 && regex[pr] == '*') pr -= 2;
        return pr < 0 && psc < 0;
    }
}