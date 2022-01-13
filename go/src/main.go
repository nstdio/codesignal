package main

import (
	"math"
	"sort"
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
	for i := 0; i <= len(input)-k; i++ {
		tmp := 0
		for j := 0; j < k; j++ {
			tmp += input[i+j]
		}
		if tmp > max {
			max = tmp
		}
	}

	return max
}

func coverDebts(s int, debts []int, interests []int) float64 {
	type debt struct {
		value    float64
		interest float64
	}
	debtsToUse := make([]*debt, 0, len(debts))
	for i := 0; i < len(debts); i++ {
		debtsToUse = append(debtsToUse, &debt{float64(debts[i]), float64(interests[i])})
	}
	sort.Slice(debtsToUse, func(i, j int) bool {
		return debtsToUse[i].interest > debtsToUse[j].interest
	})

	total := 0.0
	skipped := 0
	for skipped != len(debtsToUse) {
		spend := 0.1 * float64(s)
		skipped = 0
		for _, debt := range debtsToUse {
			if debt.value != 0 {
				if spend > 0 {
					leftSpend := math.Max(spend-debt.value, 0.0)

					debt.value = math.Max(debt.value-spend, 0.0)
					total += spend - leftSpend
					spend = leftSpend
				}

				debt.value += debt.value * (debt.interest / 100.0)
			} else {
				skipped++
			}
		}
	}

	return total
}

func salesLeadsScore(names []string, time, netValue []int, isOnVacation []bool) []string {
	type salesLead struct {
		name  string
		time  int
		score float64
	}

	leds := []salesLead{}

	for i := 0; i < len(names); i++ {
		if !isOnVacation[i] {
			leds = append(leds, salesLead{
				name:  names[i],
				time:  time[i],
				score: float64(netValue[i]*time[i]) / 365.0,
			})
		}
	}

	sort.Slice(leds, func(i, j int) bool {
		l1 := leds[i]
		l2 := leds[j]
		if l1.score == l2.score {
			if l1.time == l2.time {
				return l1.name < l2.name
			} else {
				return l1.time > l2.time
			}
		} else {
			return l1.score > l2.score
		}
	})

	ret := make([]string, 0, len(leds))
	for _, l := range leds {
		ret = append(ret, l.name)
	}

	return ret
}
