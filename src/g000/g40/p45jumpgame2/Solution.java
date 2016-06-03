package g000.g40.p45jumpgame2;

public class Solution {
    int[] jumpsCache;
    public int jump(int[] nums,int from) {
        if(from >= nums.length - 1) return 0;
        if(from + nums[from] >= nums.length - 1 ) return 1;
        if(jumpsCache[from] != 0) return jumpsCache[from];
        final int startFrom = from;
        int directJumps = 0;
        while(nums[from]==1) {
            directJumps++;
            from++;
            if(from == nums.length - 1) {
                return directJumps;
            } else if(nums[from] == 0) {
                return -1;
            }
        }
        int jumps = -1;
        for(int i = nums[from] ; i >= 1 ; i--) {
            int nj = jump(nums,from+i);
            if(nj >= 0 && (jumps == -1 || nj + 1 < jumps)) {
                jumps = nj + 1;
                if(nj == 1) break;
            }
        }
        jumpsCache[startFrom] = jumps + directJumps;
        return jumps + directJumps;
    }
    public int jump(int[] nums) {
        jumpsCache = new int[nums.length];
        return jump(nums,0);
    }
}