package main

import (
	"github.com/stretchr/testify/assert"
	"testing"
)

func TestDepositProfit(t *testing.T) {
	assert.Equal(t, 3, depositProfit(100, 20, 170))
}

func TestAbsoluteValuesSumMinimization(t *testing.T) {
	assert.Equal(t, 4, absoluteValuesSumMinimization([]int{2, 4, 7}))
	assert.Equal(t, 2, absoluteValuesSumMinimization([]int{2, 3}))
	assert.Equal(t, 1, absoluteValuesSumMinimization([]int{1, 1, 3, 4}))
	assert.Equal(t, 23, absoluteValuesSumMinimization([]int{23}))
}

func TestLongestUncorruptedSegment(t *testing.T) {
	assert.Equal(t, []int{4, 0}, longestUncorruptedSegment([]int{92988800, 80253955, 17396563, 91682092, 77708269, 97587946, 23889892, 20661856, 21013095, 92028000, 17562863, 86804822, 17819093, 97941923, 64955308}, []int{92988800, 80253955, 17396563, 91682092, 77708229, 97587946, 23889892, 20661866, 21013095, 92928000, 17962863, 86804822, 14819093, 97241923, 62955308}))

	assert.Equal(t, []int{4, 2}, longestUncorruptedSegment([]int{33531593, 96933415, 28506400, 39457872, 29684716, 86010806}, []int{33531593, 96913415, 28506400, 39457872, 29684716, 86010806}))
	assert.Equal(t, []int{0, 0}, longestUncorruptedSegment([]int{28813641, 31985183, 49809398, 48959083, 59368847, 37296474, 92567090, 50320165, 12197477, 28906340}, []int{38813641, 31983183, 49879398, 48959043, 59468847, 35296474, 92567020, 80320165, 14197477, 28906360}))
	assert.Equal(t, []int{0, 0}, longestUncorruptedSegment([]int{10000000}, []int{99999999}))
	assert.Equal(t, []int{7, 3}, longestUncorruptedSegment([]int{20800440, 98256958, 64277103, 40475664, 98589505, 31621824, 84322264, 58283379, 15631261, 35464021}, []int{20800440, 95256958, 64276103, 40475664, 98589505, 31621824, 84322264, 58283379, 15631261, 35464021}))
	assert.Equal(t, []int{4, 6}, longestUncorruptedSegment([]int{99919628, 77504204, 18846830, 86785029, 86230362, 96953294, 53208680, 95327090, 68996760, 26366538, 90490275, 62583792, 87514087, 96921389, 21309822}, []int{99919628, 77503204, 18546830, 86785029, 86230362, 96953264, 53208680, 95327090, 68996760, 26366538, 90420275, 62583792, 87514087, 39692139, 21303822}))
}

func TestExtractEachKth(t *testing.T) {
	testData := []struct {
		expected, input []int
		k               int
	}{
		{[]int{1, 2, 4, 5, 7, 8, 10}, []int{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 3},
	}

	for _, test := range testData {
		assert.Equal(t, test.expected, extractEachKth(test.input, test.k))
	}
}

func TestFirstDigit(t *testing.T) {
	data := []struct{ expected, input string }{
		{"1", "var_1__Int"},
	}

	for _, test := range data {
		assert.Equal(t, test.expected, firstDigit(test.input))
	}
}

func TestDifferentSymbolsNaive(t *testing.T) {
	data := []struct {
		expected int
		input    string
	}{
		{1, "ccccccccccc"},
	}

	for _, test := range data {
		assert.Equal(t, test.expected, differentSymbolsNaive(test.input))
	}
}

func TestArrayMaxConsecutiveSum(t *testing.T) {
	data := []struct {
		expected int
		input    []int
		k        int
	}{
		{9, []int{1, 3, 2, 4}, 3},
		{8, []int{2, 3, 5, 1, 6}, 2},
		{14, []int{2, 4, 10, 1}, 2},
	}

	for _, test := range data {
		assert.Equal(t, test.expected, arrayMaxConsecutiveSum(test.input, test.k))
	}
}

func TestCoverDebts(t *testing.T) {
	tests := []struct {
		s                int
		debts, interests []int
		expected         float64
	}{
		{50, []int{2, 2, 5}, []int{200, 100, 150}, 22},
	}

	for _, test := range tests {
		assert.Equal(t, test.expected, coverDebts(test.s, test.debts, test.interests))
	}
}

func TestSalesLeadsScore(t *testing.T) {
	tests := []struct {
		names          []string
		time, netValue []int
		onVocations    []bool
		expected       []string
	}{
		{[]string{"lead1", "lead2", "lead3", "lead4", "lead5"}, []int{0, 300, 300, 250, 300}, []int{200, 800, 1000, 1000, 800}, []bool{false, false, false, false, false}, []string{"lead3", "lead4", "lead2", "lead5", "lead1"}},
		{[]string{"lead1", "lead2", "lead3", "lead4", "lead5"}, []int{250, 300, 250, 260, 310}, []int{1000, 800, 1100, 1200, 1000}, []bool{true, false, true, false, false}, []string{"lead4", "lead5", "lead2"}},
	}

	for _, test := range tests {
		assert.Equal(t, test.expected, salesLeadsScore(test.names, test.time, test.netValue, test.onVocations))
	}
}
