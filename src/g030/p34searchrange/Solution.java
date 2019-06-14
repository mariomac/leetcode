package g000.g30.p34searchrange;

public class Solution {
    public int[] searchRange(int[] nums, int target) {
        if (nums.length < 1 || nums[0] > target || nums[nums.length - 1] < target) {
            return new int[]{-1, -1};
        }
        // Find any number
        int l = 0, r = nums.length - 1;
        int mid = (l + r + 1) / 2;
        while (nums[mid] != target && Math.abs(l - r) > 1) {
            if (nums[mid] > target) {
                r = mid;
                mid = (l + r + 1) / 2;
            } else if (nums[mid] < target) {
                l = mid;
                mid = (l + r + 1) / 2;
            }
        }
        if (nums[mid] != target) {
            if (nums[l] == target) {
                mid = l;
            } else if (nums[r] == target) {
                mid = r;
            } else {
                return new int[]{-1, -1};
            }
        }
        // left side
        int m = mid;
        l = m;
        int ll = 0;
        while (l > 0 && nums[l - 1] == target) {
            m = (l + ll) / 2;
            if (nums[m] == target) {
                l = m;
            } else {
                ll = m;
            }
        }
        // right side
        m = mid;
        r = m;
        int rr = nums.length - 1;
        while (r < nums.length - 1 && nums[r + 1] == target) {
            m = (r + rr + 1) / 2;
            if (nums[m] == target) {
                r = m;
            } else {
                rr = m;
            }
        }
        return new int[]{l, r};
    }
}
