package main

import (
	"fmt"
	"math"
)

func champagneTower(poured int, query_row int, query_glass int) float64 {
	pours := [100][100]float64{}

	pours[0][0] = float64(poured)

	for r := 1; r <= query_row; r++ {
		for g := 0; g <= r; g++ {
			rglass := float64(0)
			if g < r {
				rglass = math.Max(0, (pours[r-1][g]-1)/2)
			}
			lglass := float64(0)
			if g > 0 {
				lglass = math.Max(0, (pours[r-1][g-1]-1)/2)
			}
			pours[r][g] = rglass + lglass
		}
	}

	return math.Min(pours[query_row][query_glass], 1)
}

func main() {

	fmt.Println(champagneTower(6, 3, 1))
}
