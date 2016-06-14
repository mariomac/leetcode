package g000.g30.p35searchinsert;

/**
 * @author Mario Macias (http://github.com/mariomac)
 */
public class Solution {
	public int searchInsert(int[] nums, int target) {
		if(nums.length == 0) return 0;
		int li = 0, ri = nums.length - 1;
		while(ri - li > 1) {
			if(nums[li] == target) return li;
			if(nums[ri] == target) return ri;
			int middle = (li + ri) / 2;
			if(nums[middle] == target) return middle;
			else if(nums[middle] < target) {
				li = middle;
			} else {
				ri = middle;
			}
		}
		if(nums[li] == target) return li;
		if(nums[ri] == target) return ri;
		if(ri == li) {
			return (target > nums[li]) ? li + 1 : li;
		} else {
			if(target < nums[li]) return li;
			else return (target > nums[ri]) ? ri + 1 : ri;

		}
	}
}
