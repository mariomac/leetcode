package g000.g10.p18_4sum;

import java.util.*;

/**
 * @author Mario Macias (http://github.com/mariomac)
 */
public class Solution {
	static int hash(int a, int b, int c, int d) {
		a = a * 31 + b;
		a = a * 31 + c;
		return a * 31 + d;
	}

	public List<List<Integer>> fourSum(int[] nums, int target) {
		Arrays.sort(nums);
		HashSet<Integer> hashes = new HashSet<>();
		LinkedList<List<Integer>> results = new LinkedList<>();
		for(int l = 0 ; l < nums.length - 3 ; l++) {
			for(int r = nums.length - 1 ; r > l + 2 ; r--) {
				int li = l + 1;
				int ri = r - 1;
				while(li < ri) {
					int sum = nums[l]+nums[li]+nums[ri]+nums[r];
					if(sum == target) {
						int hash = hash(nums[l],nums[li],nums[ri],nums[r]);
						if(!hashes.contains(hash)) {
							hashes.add(hash);
							results.addLast(Arrays.asList(nums[l],nums[li],nums[ri],nums[r]));
						}
						li++;
					} else if(sum < target) {
						li++;
					} else {
						ri--;
					}

				}
			}
		}
		return results;
	}
}