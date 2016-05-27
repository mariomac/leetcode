package g000.g20.p27removeelement;

/**
 * Created by mmacias on 27/5/16.
 */
public class Solution {
    public int removeElement(int[] nums, int val) {
        int w = 0;
        for(int r = 0 ; r < nums.length ; r++) {
            if(nums[r] != val) {
                nums[w] = nums[r];
                w++;
            }
        }
        return w;
    }
}