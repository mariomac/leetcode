package g000.g10.p16_3sumclosest;

import java.util.Arrays;

/**
 * @author Mario Macias (http://github.com/mariomac)
 */
public class Solution {
	public int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);
		int closest = Integer.MAX_VALUE;
		boolean first = true;
		for(int i1 = 0 ; i1 < nums.length-2 ; i1++) {
			int i2 = i1+1;
			int i3 = nums.length - 1;

			do {
				int sum = nums[i1]+nums[i2]+nums[i3];
				if(sum == target) {
					return target;
				}
				if(first || Math.abs(target-sum) < Math.abs(target-closest)) {
					closest = sum;
					first = false;
				}

				if(sum < target) {
					i2++;
				} else {
					i3--;
				}
			} while(i2 < i3);
		}
		return closest;
	}
}
