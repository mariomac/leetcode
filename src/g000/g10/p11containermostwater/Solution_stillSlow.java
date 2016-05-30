package g000.g10.p11containermostwater;

/**
 * @author Mario Macias (http://github.com/mariomac)
 */
public class Solution_stillSlow {
	public int maxArea(int[] height) {
		int maxArea = 0;
		int avoidedLoops = 0;
		int innerLoops = 0;
		for(int repeats = 0 ; repeats < height.length  ; repeats++) {
			// We initially calculate the wider areas, since they would be more likely to
			// contain the maximum area
			int startIndex;
			int endIndex;
			if(repeats % 2 == 0) {
				startIndex = repeats/2;
				endIndex = height.length - 1;
			} else {
				startIndex = 0;
				endIndex = height.length - 2 - repeats / 2;
			}
			// optimisation: calculate the maximum possible area
			// and avoid doing the inner loop if this volume is lower
			// than the current actual max area
			int maxPossible = height[startIndex] * (endIndex-startIndex);
			if(maxPossible > maxArea) {
				for(int e = endIndex ; e > startIndex ; e--) {
					int vol = (e-startIndex) * Math.min(height[e],height[endIndex]);
					if(vol > maxArea) {
						maxArea = vol;
						maxPossible = height[startIndex] * ( e - 1 - startIndex );
						if(maxPossible <= maxArea) {
							avoidedLoops += (e - 1 - startIndex);
							break;
						}
					}
					innerLoops++;
				}
			} else avoidedLoops += (endIndex- startIndex - 1);
		}
		System.out.println("innerLoops = " + innerLoops);
		System.out.println("avoidedLoops = " + avoidedLoops);
		return maxArea;
	}
}
