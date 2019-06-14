package g000.g40.p49groupanagrams;

import java.util.*;

/**
 * Created by mmacias on 15/6/16.
 */
public class Solution {
    private class Histogram {
        private int[] nums = new int['z'-'a'+1];
        public Histogram(String word) {
            for(char c : word.toCharArray()) {
                nums[Character.toLowerCase(c) - 'a']++;
            }
        }
        private int hash = -1;

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Histogram histogram = (Histogram) o;
            return Arrays.equals(nums, histogram.nums);
        }

        @Override
        public int hashCode() {
            if(hash == -1) {
                hash = Arrays.hashCode(nums);
            }
            return hash;
        }
    }
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<Histogram,List<String>> groups = new HashMap<>();
        for(String word : strs) {
            Histogram wh = new Histogram(word);
            List<String> anagrams = groups.get(wh);
            if(anagrams == null) {
                anagrams = new ArrayList<>();
                groups.put(wh,anagrams);
            }
            anagrams.add(word);
        }
        return new ArrayList<>(groups.values());

    }
}
