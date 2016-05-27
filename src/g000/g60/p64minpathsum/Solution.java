package g000.g60.p64minpathsum;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by mmacias on 27/5/16.
 */
public class Solution {
    private class Position implements Cloneable {
        public int sum = 0;
        public int x = 0, y = 0;
        private int[][] grid;

        public Position(int[][] grid) {
            this.grid = grid;
            sum = grid[x][y];
        }

        private Position getNext(int incX, int incY) {
            if(x + incX >= grid.length || y+incY >= grid[x].length) {
                return null;
            } else {
                Position next = new Position(grid);
                next.x = x+incX;
                next.y = y+incY;
                next.sum = sum+grid[next.x][next.y];
                return next;
            }
        }

        public long getUniquePosition() {
            return y * grid.length + x;
        }
    }

    public int minPathSum(int[][] grid) {
        if(grid.length == 1 && grid[0].length == 1) {
            return grid[0][0];
        }
        Map<Long,Position> positions = new HashMap<Long, Position>();
        positions.put(0L,new Position(grid));
        while(positions.size() > 1 || positions.values().iterator().next().getUniquePosition() != grid.length * grid[0].length - 1)
        {
            Map<Long,Position> followingPositions = new HashMap<Long, Position>();
            for(Position p : positions.values()) {
                Position r = p.getNext(1,0);
                if(r != null) {
                    Position r1 = followingPositions.get(r.getUniquePosition());
                    if(r1 != null && r1.sum < r.sum) {
                        r = r1;
                    }
                    followingPositions.put(r.getUniquePosition(),r);
                }
                Position f = p.getNext(0,1);
                if(f != null) {
                    Position f1 = followingPositions.get(f.getUniquePosition());
                    if(f1 != null && f1.sum < f.sum) {
                        f = f1;
                    }
                    followingPositions.put(f.getUniquePosition(),f);
                }
            }
            positions = followingPositions;
        }
        return positions.values().iterator().next().sum;
    }
}
