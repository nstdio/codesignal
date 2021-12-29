package main

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