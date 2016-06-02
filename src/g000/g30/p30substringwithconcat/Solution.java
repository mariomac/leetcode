package g000.g30.p30substringwithconcat;


import sun.security.util.Length;

import java.util.*;

/**
 * Created by mmacias on 27/5/16.
 */
public class Solution {

    public List<String> permutations(String[] words, boolean[] used, int usedNum) {
        if(usedNum == words.length) return Arrays.asList("");
        LinkedList<String> results = new LinkedList<>();
        for(int i = 0 ; i < words.length ; i++) {
            if(!used[i]) {
                used[i] = true;
                for(String s : permutations(words,used,usedNum+1)) {
                    results.add(words[i]+s);
                }
                used[i] = false;
            }
        }
        return results;
    }

    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> results = new ArrayList<>(s.length());
        List<String> permutations = permutations(words,new boolean[words.length],0);
        int permLength = permutations.get(0).length();
        System.out.println("permLength = " + permLength);
        List<Integer> hashes = new ArrayList<>(permutations.size());
        for(String perm : permutations) {
            hashes.add(perm.hashCode());
        }
        for(int i = 0 ; i < s.length() - permLength ; i++) {
            int substr = s.substring(i,i+permLength).hashCode();
            for(Integer h : hashes) {
                if (substr == h) {
                    results.add(i);
                    break;
                }
            }
        }
        return results;
    }

}