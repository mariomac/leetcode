package g000.g20.p22generateparenthe;

import java.util.*;

/**
 * @author Mario Macias (http://github.com/mariomac)
 */
public class Solution {
	public List<String> generateParenthesis(int n) {

		return new ArrayList<>(generateNonDuplicateParenthesis(n));
	}

	private Map<Integer,Set<String>> resultsCache = new HashMap<>();

	public Set<String> generateNonDuplicateParenthesis(int n) {
		Set<String> results = resultsCache.get(n);
		if(results == null) {
			results = new HashSet<>();
			if(n == 1) {
				results.add("()");
			} else if(n > 1) {
				for(String inner : generateNonDuplicateParenthesis(n-1)) {
					results.add("()"+inner);
					results.add(inner+"()");
					results.add("("+inner+")");
				}
				for(int i = 2 ; i <= n/2 + n%2 ; i++) {
					Set<String> s1 = generateNonDuplicateParenthesis(i);
					Set<String> s2 = generateNonDuplicateParenthesis(n-i);
					for(String str1 : s1) {
						for(String str2 : s2) {
							results.add(str1+str2);
							results.add(str2+str1);
						}
					}
				}
			}
			resultsCache.put(n,results);
		}
		return results;
	}
}
