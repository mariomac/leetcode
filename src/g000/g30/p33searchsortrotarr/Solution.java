package g000.g30.p33searchsortrotarr;

/**
 * @author Mario Macias (http://github.com/mariomac)
 */
public class Solution {
	public int search(int[] nums, int target) {
		int l = 0, r = nums.length - 1;
		// binary search to look for the pivot
		int pivot = 0;
		while( l != r ) {
			pivot = (l + r) / 2;

			for(int n : nums) {
				System.out.print(n + "\t");
			}
			System.out.println();
			for(int i = 0 ; i < nums.length ; i++) {
				if(i == l) System.out.print("l\t");
				else if(i == r) System.out.print("r\t");
				else if(i == pivot) System.out.print("*\t");
				else System.out.print("\t");
			}
			System.out.println();
			System.out.println();
			if(pivot == l || pivot == r) {
				if(nums[l] < nums[r]) {
					return l;
				} else {
					return r;
				}
			} else if(nums[pivot] < nums[l]) {
				r = pivot;
			} else {
				l = pivot;
			}
		}
		for(int n : nums) {
			System.out.print(n + "\t");
		}
		System.out.println();
		for(int i = 0 ; i < nums.length ; i++) {
			if(i == l) System.out.print("l\t");
			else if(i == r) System.out.print("r\t");
			else if(i == pivot) System.out.print("*\t");
			else System.out.print("\t");
		}
		System.out.println();
		System.out.println();

		return pivot;
	}
}
