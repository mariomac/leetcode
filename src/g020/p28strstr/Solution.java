package g000.g20.p28strstr;

/**
 * Created by mmacias on 13/6/16.
 */
public class Solution {
    public int strStr(String haystack, String needle) {
        // Cheating? No! That's recycling :-)
        return haystack.indexOf(needle);
    }
}
