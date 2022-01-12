package main

import (
	"math"
	"unicode"
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

func extractEachKth(inputArray []int, k int) []int {
	n := len(inputArray)
	ret := make([]int, 0, n-n/k)

	for i, item := range inputArray {
		if (i+1)%k != 0 {
			ret = append(ret, item)
		}
	}

	return ret
}

func firstDigit(input string) string {
	for _, c := range input {
		if unicode.IsDigit(c) {
			return string(c)
		}
	}
	return ""
}

func differentSymbolsNaive(s string) int {
	table := [26]bool{}
	cnt := 0
	for _, c := range s {
		if !table[c-97] {
			cnt++
			table[c-97] = true
		}
	}

	return cnt
}

func arrayMaxConsecutiveSum(input []int, k int) int {
	max := 0
	for i := 0; i < len(input); i++ {
		tmp := 0
		for j := i; j < i+k && j < len(input); j++ {
			tmp += input[j]
		}
		if tmp > max {
			max = tmp
		}
	}

	return max
}
