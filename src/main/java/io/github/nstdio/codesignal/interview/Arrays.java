package io.github.nstdio.codesignal.interview;

import java.util.LinkedHashMap;
import java.util.Map;

public class Arrays {
    /**
     * Given a string s consisting of small English letters, find and return the first instance of a non-repeating
     * character in it. If there is no such character, return '_'.
     *
     * @param s A string that contains only lowercase English letters.
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

    /**
     * Sudoku is a number-placement puzzle. The objective is to fill a 9 × 9 grid with numbers in such a way that each
     * column, each row, and each of the nine 3 × 3 sub-grids that compose the grid all contain all of the numbers from
     * 1 to 9 one time.
     * <p>
     * Implement an algorithm that will check whether the given grid of numbers represents a valid Sudoku puzzle
     * according to the layout rules described above. Note that the puzzle represented by grid does not have to be
     * solvable.
     *
     * @param grid A 9 × 9 array of characters, in which each character is either a digit from '1' to '9' or a period '.'.
     * @return Return true if grid represents a valid Sudoku puzzle, otherwise return false.
     */
    public static boolean sudoku2(char[][] grid) {
        final int n = grid.length;
        for (int i = 0; i < n; i++) {
            char[] rt = new char[n];
            char[] ct = new char[n];

            for (int j = 0; j < n; j++) {
                if (check(grid, rt, i, j)) {
                    return false;
                }

                if (check(grid, ct, j, i)) {
                    return false;
                }
            }
        }

        return true;
    }

    private static boolean check(char[][] grid, char[] rt, int row, int col) {
        char r = grid[row][col];
        if (r == '.')
            return false;

        if (checkInBlock(grid, row, col)) {
            return true;
        }

        if (rt[r - 49] == '\0') {
            rt[r - 49] = r;
            return false;
        } else {
            return rt[r - 49] == r;
        }
    }

    private static boolean checkInBlock(char[][] grid, int row, int col) {
        // calculating 3x3 block that row belongs to
        int sRow = row / 3;
        int startRow = Math.max(sRow, sRow * 3);
        int stopRow = Math.min(startRow + 3, grid.length);

        // calculating 3x3 block that col belongs to
        int sCol = col / 3;
        int startCol = Math.max(sCol, sCol * 3);
        int stopCol = Math.min(startCol + 3, grid.length);

        for (int i = startRow; i < stopRow; i++) {
            for (int j = startCol; j < stopCol; j++) {
                char c = grid[i][j];
                if (i == row && j == col || c == '.') {
                    continue;
                }

                if (c == grid[row][col])
                    return true;
            }
        }

        return false;
    }

    /**
     * A cryptarithm is a mathematical puzzle for which the goal is to find the correspondence between letters and
     * digits, such that the given arithmetic equation consisting of letters holds true when the letters are converted
     * to digits.
     * <p>
     * You have an array of strings crypt, the cryptarithm, and an an array containing the mapping of letters and
     * digits, solution. The array crypt will contain three non-empty strings that follow the
     * structure: [word1, word2, word3], which should be interpreted as the word1 + word2 = word3 cryptarithm.
     *
     * @param crypt    An array of three non-empty strings containing only uppercase English letters.
     * @param solution An array consisting of pairs of characters that represent the correspondence between letters and
     *                 numbers in the cryptarithm. The first character in the pair is an uppercase English letter, and
     *                 the second one is a digit in the range from 0 to 9.
     *                 <p>
     *                 It is guaranteed that solution only contains entries for the letters present in crypt and that
     *                 different letters have different values.
     * @return Return true if the solution represents the correct solution to the cryptarithm crypt, otherwise return false.
     */
    public static boolean isCryptSolution(String[] crypt, char[][] solution) {
        return false;
    }
}
