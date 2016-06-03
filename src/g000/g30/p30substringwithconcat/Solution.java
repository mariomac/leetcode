package g000.g30.p30substringwithconcat;


import sun.security.util.Length;

import java.util.*;

/**
 * Created by mmacias on 27/5/16.
 */
public class Solution {

    private static final boolean equals(char[] s1, int i1, char[] s2, int i2, int length) {
        for(int i = 0 ; i < length ; i++) {
            if(s1[i1+i] != s2[i2+i]) return false;
        }
        return true;
    }

    private boolean findSubstr(char[] s, int from, ArrayDeque<char[]> words) {
        if(words.size() == 0) return true;
        int iterations = words.size();
        boolean foundSubstr = false;
        for(int i = 0 ; i < iterations && !foundSubstr ; i++) {
            char[] word = words.pollFirst();
            if(equals(word,0,s,from,word.length)) {
                foundSubstr |= findSubstr(s,from+word.length, words.clone());
            }
            words.addLast(word);
        }
        return foundSubstr;
    }

    public List<Integer> findSubstring(String s, String[] words) {
        char[] str = s.toCharArray();

        ArrayDeque<char[]> wordsDeque = new ArrayDeque<>(words.length);
        int permutationLength = 0;
        for(int i = 0 ; i < words.length ; i++) {
            char[] arr =words[i].toCharArray();
            wordsDeque.add(arr);
            permutationLength += arr.length;
        }

        List<Integer> results = new ArrayList<>(str.length);
        for(int i = 0 ; i < str.length - permutationLength ; i++) {
            if(findSubstr(str,i,wordsDeque)) {
                results.add(i);
            }
        }
        return results;
    }

}