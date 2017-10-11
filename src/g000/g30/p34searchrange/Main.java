package g000.g30.p34searchrange;

import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        Solution s = new Solution();
        int[] nums = new int[]{2, 2};
        int[] range = s.searchRange(nums, 2);

        System.out.println("Arrays.toString(range) = " + Arrays.toString(range));

	}

}
