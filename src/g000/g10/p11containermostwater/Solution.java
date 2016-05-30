package g000.g10.p11containermostwater;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Mario Macias (http://github.com/mariomac)
 */
public class Solution {
	public int maxArea(int[] height) {
		int maxArea = 0;
		//int avoidedLoops = 0;
		//int innerLoops = 0;
		for(int s = 0 ; s < height.length ; s++) {
			// optimisation: calculate the maximum possible area
			// and avoid doing the inner loop if this volume is lower
			// than the current actual max area
			int maxPossible = height[s] * ( height.length - 1 - s);
			if(maxPossible > maxArea) {
				for(int e = height.length - 1 ; e > s ; e--) {
					int vol = (e-s) * Math.min(height[e],height[s]);
					if(vol > maxArea) maxArea = vol;
					//innerLoops++;
				}
			} //else avoidedLoops += (height.length - 1 - s);
		}
		//System.out.println("height.length = " + height.length);
		//System.out.println("avoidedLoops = " + avoidedLoops);
		//System.out.println("innerLoops = " + innerLoops);
		return maxArea;
	}
}
