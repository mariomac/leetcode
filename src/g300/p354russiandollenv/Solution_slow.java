package g300.p354russiandollenv;

import java.util.HashMap;

/**
 * Created by mmacias on 8/6/16.
 */
public class Solution_slow {
    private class SolutionSolver {
        int[][] envelopes;

        HashMap<Integer,Integer> maxCache = new HashMap<>();

        public SolutionSolver(int[][] envelopes) {
            this.envelopes = envelopes;
        }

        private int maxEnvelopes(int[] currentDoll) {
            Integer max = maxCache.get(currentDoll[0]*31+currentDoll[1]);
            if(max == null) {
                max = 0;
                int[] maxSize = null;
                for (int e = 0; e < envelopes.length; e++) {
                    if ((envelopes[e][0] > currentDoll[0] && envelopes[e][1] > currentDoll[1])
                            && (maxSize == null || !(maxSize[0] <= envelopes[e][0] && maxSize[1] <= envelopes[e][1]))) {
                        int num = 1 + maxEnvelopes(envelopes[e]);
                        if (num > max) {
                            max = num;
                            maxSize = envelopes[e];
                        }
                    }
                }
                maxCache.put(currentDoll[0]*31+currentDoll[1],max);
            }
            return max;
        }
    }
    public int maxEnvelopes(int[][] envelopes) {
        return new SolutionSolver(envelopes).maxEnvelopes(new int[] {0,0});
    }
}