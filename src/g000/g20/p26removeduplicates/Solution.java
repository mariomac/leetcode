package g000.g20.p26removeduplicates;

/**
 * Created by mmacias on 10/6/16.
 */
public class Solution {
    public int removeDuplicates(int[] nums) {
        if(nums.length == 0 || nums.length == 1) return nums.length;
        int nonDuplicatesSize = 1;
        for(int i = 1 ; i < nums.length ; i++) {
            if(nums[i] > nums[nonDuplicatesSize-1]) {
                nums[nonDuplicatesSize++] = nums[i];
            }
        }
        return nonDuplicatesSize;
    }
}