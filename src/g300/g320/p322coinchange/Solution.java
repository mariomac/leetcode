package g300.g320.p322coinchange;

import java.util.Arrays;

/**
 * @author Mario Macias (http://github.com/mariomac)
 */
public class Solution {
	// TODO: doesn't work.
	public int coinChange(int[] coins, int amount) {
		Arrays.sort(coins);
		int ncoins = 0;
		for(int c = coins.length - 1; amount > 0 && c >= 0 ; c--) {
			while(coins[c] <= amount) {
				amount -= coins[c];
				ncoins++;
			}
		}

		return amount > 0 ? -1 : ncoins;
	}
}
