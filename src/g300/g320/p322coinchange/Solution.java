package g300.g320.p322coinchange;

import java.util.*;

/**
 * @author Mario Macias (http://github.com/mariomac)
 */
public class Solution {
	private Map<Integer,Integer> partialSolutions = new HashMap<>();
	private int shorterUntilNow = Integer.MAX_VALUE;

	public int coinChange(int[] coins, int amount) {
		if(amount == 0) return 0;
		partialSolutions = new HashMap<>();
		Arrays.sort(coins);
		int e = coins.length - 1;
		for(int i = 0 ; i < coins.length / 2 ; i++) {
			int t = coins[i];
			coins[i] = coins[e];
			coins[e] = t;
			e--;
		}
		return coinChange2(coins,amount,1);
	}
	private int coinChange2(int[] coins, int amount, int depth) {
		if(amount < 0 && depth >= shorterUntilNow) {
			return -1;
		}
		Integer ps = partialSolutions.get(amount);
		if(ps == null) {
			int min = -1;
			for (int i = 0; i < coins.length; i++) {
				if (coins[i] == amount) {
					if(depth < shorterUntilNow) {
						shorterUntilNow = depth;
					}
					partialSolutions.put(amount,1);
					return 1;
				} else if (coins[i] < amount) {
					int sub = 1 + coinChange2(coins, amount - coins[i], depth+1);
					if (sub > 0 && (min == -1 || sub < min)) {
						min = sub;
					}
				}
			}
			ps = min;
			partialSolutions.put(amount,ps);
		}
		return ps;
	}
}
