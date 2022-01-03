package main

import (
	"math"
)

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

func longestUncorruptedSegment(sourceArray []int, destinationArray []int) []int {
	l, lMax, start := 0, 0, 0
	for i := 0; i < len(sourceArray); i++ {
		if sourceArray[i] == destinationArray[i] {
			l++
			if l > lMax {
				lMax = l
				start = i - l + 1
			}
		} else {
			l = 0
		}
	}

	return []int{lMax, start}
}
