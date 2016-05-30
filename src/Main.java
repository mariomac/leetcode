import g000.g10.p11containermostwater.*;
public class Main {

    public static void main(String[] args) {
		int[] input = new int[15000];
		for(int i = 0 ; i < input.length ; i++) {
			input[i] = 15000-i;
		}
        Solution s = new Solution();

		System.out.println(s.maxArea(input));

    }
}
