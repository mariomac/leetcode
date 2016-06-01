package g000.g10.p15_3sum;

import java.util.*;

/**
 * @author Mario Macias (http://github.com/mariomac)
 */
public class Solution {

	private static int hash(int a, int b, int c) {
		a = a * 31 + b;
		return  a * 31 + c;

	}
	public List<List<Integer>> threeSum(int[] nums) {
		HashSet<Integer> hashes = new HashSet<>();
		List<List<Integer>> solutions = new LinkedList<>();
		Arrays.sort(nums);
		for(int m = 1 ; m < nums.length - 1 ; m++) {
			int l = 0, r = nums.length - 1;
			while(l < m && m < r) {
				int sum = nums[l]+nums[m]+nums[r];
				if(sum == 0) {
					int hash = hash(nums[l],nums[m],nums[r]);
					if(!hashes.contains(hash)) {
						solutions.add(Arrays.asList(nums[l],nums[m],nums[r]));
						hashes.add(hash);
					}
					if(l < m - 1) {
						l++;
					} else {
						r--;
					}
				} else if(sum < 0) {
					l++;
				} else {
					r--;
				}
			}
		}
		return solutions;
	}
}
