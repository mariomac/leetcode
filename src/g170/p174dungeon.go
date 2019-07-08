package main

func calculateMinimumHP(dungeon [][]int) int {
	M := len(dungeon) - 1
	N := len(dungeon[0]) - 1

	for r := M; r >= 0; r-- {
		for c := N; c >= 0; c-- {
			if r == M && c == N {
				dungeon[r][c] = max(1, 1-dungeon[r][c])
				continue
			}
			if r == M {
				dungeon[r][c] = max(1, dungeon[r][c+1]-dungeon[r][c])
				continue
			}
			if c == N {
				dungeon[r][c] = max(1, dungeon[r+1][c]-dungeon[r][c])
				continue
			}

			dungeon[r][c] = max(1, min(dungeon[r+1][c], dungeon[r][c+1])-dungeon[r][c])
		}
	}

	return dungeon[0][0]
}

func min(i, j int) int {
	if i < j {
		return i
	}
	return j
}

func max(i, j int) int {
	if i > j {
		return i
	}
	return j
}
