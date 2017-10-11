package g000.g30.p39combinationsum;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<List<Integer>> sol = new Solution().combinationSum(new int[]{2,3,6,7}, 7);

        System.out.println("sol = " + sol);
    }
}
