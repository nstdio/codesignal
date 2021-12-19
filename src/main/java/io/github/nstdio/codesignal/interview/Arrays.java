package io.github.nstdio.codesignal.interview;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class Arrays {
    /**
     * Given a string s consisting of small English letters, find and return the first instance of a non-repeating
     * character in it. If there is no such character, return '_'.
     *
     * @param s A string that contains only lowercase English letters.
     *
     * @return The first non-repeating character in s, or '_' if there are no characters that do not repeat.
     */
    static char firstNotRepeatingCharacter(String s) {
        Map<Character, Integer> occurrence = new LinkedHashMap<>();

        for (int i = 0; i < s.length(); i++) {
            occurrence.compute(s.charAt(i), (c, f) -> f == null ? 1 : ++f);
        }

        for (Map.Entry<Character, Integer> e : occurrence.entrySet()) {
            if (e.getValue() == 1)
                return e.getKey();
        }

        return '_';
    }

    /**
     * You are given an n x n 2D matrix that represents an image. Rotate the image by 90 degrees (clockwise).
     * <p>
     * Note: Try to solve this task in-place (with O(1) additional memory), since this is what you'll be asked to do
     * during an interview.
     *
     * @param a
     *
     * @return
     */
    static int[][] rotateImage(int[][] a) {
        int[][] copy = a.clone();

        for (int i = 0; i < copy.length; i++) {
            copy[i] = copy[i].clone();
        }

        for (int i = 0; i < a.length; i++) {
            int[] row = a[i];
            int rotationCol = a.length - 1 - i;

            for (int j = 0; j < a.length; j++) {
                copy[j][rotationCol] = row[j];
            }
        }

        return copy;
    }

    public static boolean sudoku2(char[][] grid) {
        final int n = grid.length;
        for (int i = 0; i < n; i++) {
            char[] rt = new char[n];
            char[] ct = new char[n];

            for (int j = 0; j < n; j++) {
                if (check(grid, i, rt, j))
                    return false;

                if (check(grid, j, ct, i))
                    return false;
            }
        }

        return true;
    }

    private static boolean check(char[][] grid, int row, char[] rt, int col) {
        char r = grid[row][col];
        if (r == '.')
            return false;

        if (checkInBlock(grid, row, row, col)) {
            return true;
        }

        if (checkInBlock(grid, col, row, col)) {
            return true;
        }

        if (rt[r - 49] == '\0') {
            rt[r - 49] = r;
            return false;
        } else {
            return rt[r - 49] == r;
        }
    }

    private static boolean checkInBlock(char[][] grid, int cur, int row, int col) {
        int s = (cur / 3);
        int startIndex = Math.max(s, s * 3);
        int endIndex = Math.min(startIndex + 3, grid.length);
        char e = grid[row][col];

        for (int i = startIndex; i < endIndex; i++) {
            for (int j = startIndex; j < endIndex; j++) {
                char c = grid[i][j];
                if (i == row && j == col || c == '.') {
                    continue;
                }

                if (c == e)
                    return true;
            }
        }

        return false;
    }

}
