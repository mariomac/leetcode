import g000.g10.p153sum.Solution;

import java.util.List;

public class Main {

    public static void main(String[] args) {
		Solution s = new Solution();
		List<List<Integer>> res = s.threeSum(new int[] {13,14,1,2,-11,-11,-1,5,-1,-11,-9,-12,5,-3,-7,-4,-12,-9,8,-13,-8,2,-6,8,11,7,7,-6,8,-9,0,6,13,-14,-15,9,12,-9,-9,-4,-4,-3,-9,-14,9,-8,-11,13,-10,13,-15,-11,0,-14,5,-4,0,-3,-3,-7,-4,12,14,-14,5,7,10,-5,13,-14,-2,-6,-9,5,-12,7,4,-8,5,1,-10,-3,5,6,-9,-5,9,6,0,14,-15,11,11,6,4,-6,-10,-1,4,-11,-8,-13,-10,-2,-1,-7,-9,10,-7,3,-4,-2,8,-13});
		for(List<Integer> r1 : res) {
			int sum = 0;
			for(Integer r : r1) {
				sum += r;
				System.out.print(r + " ");
			}
			System.out.println(" = " + sum);
		}
	}
}
