package g000.g10.p17lettercombphone;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Mario Macias (http://github.com/mariomac)
 */
public class Solution {
	public List<String> letterCombinations(String digits) {
		if(digits == null || "".equals(digits)) return new ArrayList<>(0);

		// first index: 2 button
		char[][] keys = { {'a','b','c'}, {'d','e','f'}, {'g','h','i'}, {'j','k','l'},
				{'m','n','o'}, {'p','q','r','s'}, {'t','u','v'}, {'w','x','y','z'} };
		int repetitions = 0;
		char[][] groups = new char[digits.length()][];
		int i  = 0;
		for(char c : digits.toCharArray()) {
			char[] group = keys[c - '2'];
			groups[i++] = group;
			repetitions += group.length;
		}
		char[] combination = new char[groups.length];
		for(int c = 0 ; c < groups.length ; c++) {
			combination[c] = groups[c][0];
		}
		int[] indexes = new int[groups.length];
		boolean finish = false;
		List<String> results = new ArrayList<>(repetitions);
		while(!finish) {
			results.add(new String(combination));
			int carry;
			int tail = groups.length - 1;
			do {
				carry = (indexes[tail] + 1) / groups[tail].length;
				indexes[tail] = (indexes[tail] + 1) % groups[tail].length;
				tail--;
			} while(carry > 0 && tail >= 0);
			if(tail < 0 && carry > 0) {
				finish = true;
			} else {
				for(int addIdx = tail+1 ; addIdx < groups.length ; addIdx++) {
					combination[addIdx] = groups[addIdx][indexes[addIdx]];
				}
			}
		}
		return results;

	}
}
