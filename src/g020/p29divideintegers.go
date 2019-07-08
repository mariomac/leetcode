package main

import "math"

func divide(dividend int, divisor int) int {
	n := div(int64(dividend), int64(divisor))
	if n > math.MaxInt32 {
		return math.MaxInt32
	}
	if n < math.MinInt32 {
		return math.MinInt32
	}
	return int(n)
}

func div(dividend, divisor int64) int64 {
	if divisor == 1 {
		return dividend
	}
	if dividend < 0 && divisor < 0 {
		return div(-dividend, -divisor)
	}
	if dividend < 0 {
		return -div(-dividend, divisor)
	}
	if divisor < 0 {
		return -div(dividend, -divisor)
	}
	if divisor == dividend {
		return 1
	}
	if divisor > dividend {
		return 0
	}

	result := int64(0)
	for dividend >= divisor {
		for divisor&1 == 0 && dividend&1 == 0 {
			dividend >>= 1
			divisor >>= 1
		}
		result++
		dividend -= divisor
	}
	return result
}
