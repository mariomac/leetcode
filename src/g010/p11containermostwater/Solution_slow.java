package g000.g10.p11containermostwater;

/**
 * @author Mario Macias (http://github.com/mariomac)
 */
public class Solution_slow {
	public int maxArea(int[] height) {
		int maxArea = 0;
		//int avoidedLoops = 0;
		int innerLoops = 0;
		for(int s = 0 ; s < height.length  ; s++) {
			// optimisation: calculate the maximum possible area
			// and avoid doing the inner loop if this volume is lower
			// than the current actual max area
			int maxPossible = height[s] * ( height.length - 1 - s);
			if(maxPossible > maxArea) {
				for(int e = height.length - 1 ; maxPossible > maxArea && e > s ; e--) {
					int vol = (e-s) * Math.min(height[e],height[s]);
					if(vol > maxArea) {
						maxArea = vol;
						maxPossible = height[s] * ( e - 1 - s );
						if(maxPossible <= maxArea) {
							break;
						}
					}
				}
			}
		}
		return maxArea;
	}
}
