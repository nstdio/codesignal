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
