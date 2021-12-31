package main

import "math"

func main() {
}

func depositProfit(deposit int, rate int, threshold int) int {
	years := 0
	var balance = float64(deposit)

	for balance < float64(threshold) {
		balance += balance * float64(rate) / 100.0
		years++
	}

	return years
}

func absoluteValuesSumMinimization(a []int) int {
	minElement := math.MaxInt
	minSum := math.MaxInt
	for _, i := range a {
		sum := 0
		for _, j := range a {
			sum += Abs(i - j)
		}
		if sum < minSum {
			minElement = i
			minSum = sum
		}
	}

	return minElement
}

func Abs(a int) int {
	if a < 0 {
		return -a
	}
	return a
}
