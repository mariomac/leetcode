package g000.g40.p42trappingRain;

/**
 * Created by mmacias on 8/6/16.
 */
public class Solution_slow {
    public int trap(int[] height) {
        int water = 0;
        int walls = 0;
        int checkedHeight = 0;
        do {
            walls = 0;
            int lastWall = -1;
            for(int column = 0 ; column < height.length ; column++) {
                if(height[column] > checkedHeight) {
                    if(lastWall >= 0) {
                        water += (column - lastWall - 1);
                    }
                    lastWall = column;
                    walls++;
                }
            }
            checkedHeight++;
        } while (walls > 1);
        return water;
    }
}
