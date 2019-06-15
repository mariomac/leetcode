func myPow(x float64, n int) float64 {
	if n == 0 {
		return 1
	}
	if n < 0 {
		return 1.0 / myPow(x, -n)
	}
	if n&1 == 0 {
		p := myPow(x, n/2)
		return p * p
	}
	return x * myPow(x, n-1)
}
