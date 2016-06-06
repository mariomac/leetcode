package g000.g30.p33searchsortrotarr;

/**
 * @author Mario Macias (http://github.com/mariomac)
 */
public class Solution {
	public int search(int[] nums, int target) {
		int l = 0, r = nums.length - 1;
		// binary search to look for the pivot
		int pivot = 0;
		while((r-l) <= 1) {
			pivot = (l + r) / 2;
			if(nums[l] > nums[pivot]) {
				r = pivot;
			} else {
				l = pivot;
			}
		}
		return pivot;
	}
}
