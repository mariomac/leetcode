package g000.g10.p15_3sum.old;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @author Mario Macias (http://github.com/mariomac)
 */
public class Solution {

	private static int hash(int a, int b, int c) {
		a = a * 31 + b;
		return  a * 31 + c;

	}
	public List<List<Integer>> threeSum(int[] nums) {
		HashMap<Integer,List<Integer>> cache = new HashMap<>();
		Arrays.sort(nums);
		for(int i1 = 0 ; i1 < nums.length-2 ; i1++) {
			int i2 = i1+1;
			int i3 = nums.length - 1;
			do {
				int hash = hash(nums[i1],nums[i2],nums[i3]);
				if(cache.containsKey(hash)) {
					i2++;
				} else {
					int sum = nums[i1]+nums[i2]+nums[i3];
					if(sum == 0) {
						cache.put(hash,Arrays.asList(nums[i1],nums[i2],nums[i3]));
						i2++;
					} else if(sum < 0) {
						i2++;
					} else {
						i3--;
					}
				}
			} while(i2 < i3);
		}
		List<List<Integer>> results = new ArrayList<>(cache.size());
		results.addAll(cache.values());
		return results;
	}
}
