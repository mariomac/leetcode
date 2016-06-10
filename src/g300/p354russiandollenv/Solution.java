package g300.p354russiandollenv;

import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by mmacias on 10/6/16.
 */
public class Solution {
    private class SolutionSolver {
        int[][] envelopes;

        HashMap<Long,Integer> maxCache = new HashMap<>();

        public SolutionSolver(int[][] envelopes) {
            this.envelopes = envelopes;
            Arrays.sort(envelopes, (a,b) -> (a[0] - b[0]) == 0 ? a[1] - b[1] : a[0] - b[0]);
        }
        private int maxEnvelopes(int[] currentDoll, int lookFrom) {
            long key = (new Long(currentDoll[0])<<32)+currentDoll[1];
            Integer max = maxCache.get(key);
            if(max == null) {
                while(lookFrom < envelopes.length
                        && (envelopes[lookFrom][0] == currentDoll[0] || envelopes[lookFrom][1] <= currentDoll[1])) {
                    lookFrom++;
                }
                max = 0;
                int[] maxSize = null;
                for (int e = lookFrom; e < envelopes.length; e++) {
                    if (envelopes[e][1] > currentDoll[1]
                            && (maxSize == null || !(maxSize[0] <= envelopes[e][0] && maxSize[1] <= envelopes[e][1]))) {
                        int num = 1 + maxEnvelopes(envelopes[e], e+1);
                        if (num > max) {
                            max = num;
                            maxSize = envelopes[e];
                        }
                    }
                }
                maxCache.put(key,max);
            }
            return max;
        }
    }
    public int maxEnvelopes(int[][] envelopes) {
        return new SolutionSolver(envelopes).maxEnvelopes(new int[]{0,0},0);
    }
}
