package g000.g00.p3longestsubstring.old;

import java.util.*;

/**
 * Created by mmacias on 27/5/16.
 */
public class Solution {
    public int lengthOfLongestSubstring(String s) {
        char[] str = s.toCharArray();
        List<Set<Character>> appearances = new LinkedList<Set<Character>>();
        int max = 0;
        for(char c : str) {
            appearances.add(new HashSet<Character>());
            Iterator<Set<Character>> it = appearances.iterator();
            while(it.hasNext()) {
                Set<Character> hist = it.next();
                if(hist.contains(c)) {
                    int sl = hist.size();
                    if(sl > max) max = sl;
                    it.remove();
                } else {
                    hist.add(c);
                }
            }
        }
        if(appearances.size() > 0) {
            int sl = appearances.get(0).size();
            if(sl > max) max = sl;
        }
        return max;
    }
}

