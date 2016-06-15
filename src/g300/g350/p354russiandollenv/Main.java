package g300.g350.p354russiandollenv;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) throws IOException {
		Solution s = new Solution();
        LinkedList<int[]> data = new LinkedList<>();
        BufferedReader br = new BufferedReader(new InputStreamReader(Main.class.getResourceAsStream("data2.txt")));
        String read = null;
        do {
            read = br.readLine();
            if (read != null && !"".equals(read.trim())) {
                String[] nums = read.split(",");
                data.add(new int[] {Integer.valueOf(nums[0]),Integer.valueOf(nums[1])});
            }
        } while(read != null);

        System.out.println(data.size() + " read dolls");
        System.out.println(s.maxEnvelopes(data.toArray(new int[0][])));
    }
}
