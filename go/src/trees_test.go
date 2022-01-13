package main

import (
	"encoding/json"
	"github.com/stretchr/testify/assert"
	"io"
	"os"
	"testing"
)

func TestHasPathWithGivenSum(t *testing.T) {
	tests := []struct {
		expected bool
		tree     *Tree
		sum      int
	}{
		{true, readTree("hasPathWithGivenSum/1.json"), 7},
	}

	for _, test := range tests {
		assert.Equal(t, test.expected, hasPathWithGivenSum(test.tree, test.sum))
	}
}

func readTree(filePath string) *Tree {
	open, err := os.Open("testdata/" + filePath)
	if err != nil {
		return nil
	}

	defer open.Close()

	jsonBytes, err := io.ReadAll(open)

	if err != nil {
		return nil
	}

	var tree Tree
	err = json.Unmarshal(jsonBytes, &tree)

	if err != nil {
		return nil
	}

	return &tree
}
