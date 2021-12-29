package main

import "testing"

func TestDepositeProfit(t *testing.T) {

	got := depositProfit(100, 20, 170)
	want := 3

	if got != want {
		t.Errorf("got %q, wanted %q", got, want)
	}
}
