package g000.g10.p11containermostwater;

/**
 * @author Mario Macias (http://github.com/mariomac)
 */
public class Solution {
	public int maxArea(int[] height) {
		int start = 0, end = height.length-1;
		int max = 0;
		while(start < end) {
			int area;
			if(height[start]>height[end]) {
				area = height[end] * (end - start);
				end--;
			} else {
				area = height[start] * (end - start);
				start++;

			}
			if(area > max) max = area;
		}

		return max;
	}
}
