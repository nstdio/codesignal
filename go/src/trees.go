package main

type Tree struct {
	Value int
	Left  *Tree
	Right *Tree
}

func hasPathWithGivenSum(t *Tree, s int) bool {
	if t == nil {
		return false
	}
	s -= int(t.Value)
	if s == 0 && t.Left == nil && t.Right == nil {
		return true
	}

	return hasPathWithGivenSum(t.Left, s) || hasPathWithGivenSum(t.Right, s)
}

func isTreeSymmetric(t *Tree) bool {
	return isMirror(t, t)
}

func isMirror(l, r *Tree) bool {
	if l == nil && r == nil {
		return true
	}

	if l != nil && r != nil && l.Value == r.Value {
		return isMirror(l.Left, r.Right) && isMirror(l.Right, r.Left)
	}

	return false
}
