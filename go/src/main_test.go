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
