package g000.g10.p10regexp;

import java.util.*;

@SuppressWarnings("ALL")
public class Solution {
    static class State {
        static char[] regex;
        char check;
        int pr;
        public State(char check, int pr) {
            this.check = check;
            this.pr = pr;
        }

        public State(char check) {
            this.check = check;
        }

        Set<State> next(char input) {
            if()
        }
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
