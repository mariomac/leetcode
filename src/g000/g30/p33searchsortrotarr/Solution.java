package g000.g30.p33searchsortrotarr;

/**
 * @author Mario Macias (http://github.com/mariomac)
 */
public class Solution {
	public int search(int[] nums, int target) {
		if(nums.length == 0) return -1;

		int l = 0, r = nums.length - 1;
		// binary search to look for the pivot
		int pivot = 0;
		while( l != r ) {
			pivot = (l + r) / 2;
			if(nums[l] < nums[r]) {
				pivot = l;
				break;
			} else if(l == pivot || r == pivot) {
				pivot = r;
				break;
			} if(nums[pivot] < nums[l]) {
				r = pivot;
			} else {
				l = pivot;
			}
		}
		// binary search to look for the target
		l = 0; r = nums.length - 1;
		do {
			if(nums[(l+pivot)%nums.length] == target) return (l+pivot)%nums.length;
			if(nums[(r+pivot)%nums.length] == target) return (r+pivot)%nums.length;
			int half = ((l+r) / 2);
			if(nums[(half+pivot)%nums.length] == target) return (half+pivot)%nums.length;
			else if(target < nums[(half+pivot)%nums.length]) r = half;
			else l = half;
		}while(r-l > 1);
		return -1;
	}
}
