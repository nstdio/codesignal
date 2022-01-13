package main

type Tree struct {
	Value interface{}
	Left  *Tree
	Right *Tree
}

func hasPathWithGivenSum(t *Tree, s int) bool {
	if t == nil {
		return false
	}
	s -= int(t.Value.(float64))
	if s == 0 && t.Left == nil && t.Right == nil {
		return true
	}

	return hasPathWithGivenSum(t.Left, s) || hasPathWithGivenSum(t.Right, s)
}
