package io.github.nstdio.codesignal.interview;

import static io.github.nstdio.codesignal.interview.Arrays.firstNotRepeatingCharacter;
import static io.github.nstdio.codesignal.interview.Arrays.rotateImage;
import static io.github.nstdio.codesignal.interview.Arrays.sudoku2;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import org.junit.Ignore;
import org.junit.Test;

public class ArraysTest {

    @Test
    public void testFirstNotRepeatingCharacter() {
        assertThat(firstNotRepeatingCharacter("ngrhhn"))
            .isEqualTo('g');
    }

    @Test
    public void testRotateImage() {
        assertThat(rotateImage(new int[][]{
                new int[]{1, 2, 3},
                new int[]{4, 5, 6},
                new int[]{7, 8, 9}
            })
        )
            .isEqualTo(new int[][]{
                new int[]{7, 4, 1},
                new int[]{8, 5, 2},
                new int[]{9, 6, 3}
            });
        assertThat(rotateImage(new int[][]{new int[]{4, 5}, new int[]{6, 7}}))
            .isEqualTo(new int[][]{new int[]{6, 4}, new int[]{7, 5}});
        assertThat(rotateImage(new int[][]{new int[]{1}}))
            .isEqualTo(new int[][]{new int[]{1}});
    }

    @Test
    public void testSudoku2() {
        assertThat(sudoku2(new char[][]{
            {'.', '.', '.', '1', '4', '.', '.', '2', '.'},
            {'.', '.', '6', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.', '.'},

            {'.', '.', '1', '.', '.', '.', '.', '.', '.'},
            {'.', '6', '7', '.', '.', '.', '.', '.', '9'},
            {'.', '.', '.', '.', '.', '.', '8', '1', '.'},

            {'.', '3', '.', '.', '.', '.', '.', '.', '6'},
            {'.', '.', '.', '.', '.', '7', '.', '.', '.'},
            {'.', '.', '.', '5', '.', '.', '.', '7', '.'}
        })).isTrue();

        assertThat(sudoku2(new char[][]{
            {'6', '.', '.', '1', '4', '.', '.', '2', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '6', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '1', '.', '.', '.', '.', '.', '.'},
            {'.', '6', '7', '.', '.', '.', '.', '.', '9'},
            {'.', '.', '.', '.', '.', '.', '8', '1', '.'},
            {'.', '3', '.', '.', '.', '.', '.', '.', '6'},
            {'.', '.', '.', '.', '.', '7', '.', '.', '.'},
            {'.', '.', '.', '5', '.', '.', '.', '7', '.'}
        })).isFalse();
        
        assertThat(sudoku2(new char[][]{
            {'6', '.', '.', '1', '4', '.', '.', '2', '.'},
            {'.', '.', '6', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '1', '.', '.', '.', '.', '.', '.'},
            {'.', '6', '7', '.', '.', '.', '.', '.', '9'},
            {'.', '.', '.', '.', '.', '.', '8', '1', '.'},
            {'.', '3', '.', '.', '.', '.', '.', '.', '6'},
            {'.', '.', '.', '.', '.', '7', '.', '.', '.'},
            {'.', '.', '.', '5', '.', '.', '.', '7', '.'}
        })).isFalse();

        assertThat(sudoku2(new char[][]{
            {'.', '.', '.', '1', '4', '.', '.', '2', '.'},
            {'6', '.', '6', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '1', '.', '.', '.', '.', '.', '.'},
            {'.', '6', '7', '.', '.', '.', '.', '.', '9'},
            {'.', '.', '.', '.', '.', '.', '8', '1', '.'},
            {'.', '3', '.', '.', '.', '.', '.', '.', '6'},
            {'.', '.', '.', '.', '.', '7', '.', '.', '.'},
            {'.', '.', '.', '5', '.', '.', '.', '7', '.'}
        })).isFalse();

        assertThat(sudoku2(new char[][]{
            {'.', '.', '.', '1', '4', '.', '.', '2', '.'},
            {'.', '.', '6', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '1', '.', '.', '.', '.', '.', '.'},
            {'.', '6', '7', '.', '.', '.', '.', '.', '9'},
            {'.', '.', '.', '.', '.', '.', '8', '1', '.'},
            {'.', '3', '.', '.', '.', '.', '.', '.', '6'},
            {'.', '.', '.', '.', '.', '7', '.', '.', '.'},
            {'.', '.', '.', '5', '.', '.', '.', '7', '.'}
        })).isTrue();

        assertThat(sudoku2(new char[][]{
            {'1', '.', '.', '1', '4', '.', '.', '2', '.'},
            {'.', '.', '6', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '1', '.', '.', '.', '.', '.', '.'},
            {'.', '6', '7', '.', '.', '.', '.', '.', '9'},
            {'.', '.', '.', '.', '.', '.', '8', '1', '.'},
            {'.', '3', '.', '.', '.', '.', '.', '.', '6'},
            {'.', '.', '.', '.', '.', '7', '.', '.', '.'},
            {'.', '.', '.', '5', '.', '.', '.', '7', '.'}
        })).isFalse();

        assertThat(sudoku2(new char[][]{
            {'.', '3', '.', '1', '4', '.', '.', '2', '.'},
            {'.', '.', '6', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '.', '.', '.', '.', '.', '.', '.'},
            {'.', '.', '1', '.', '.', '.', '.', '.', '.'},
            {'.', '6', '7', '.', '.', '.', '.', '.', '9'},
            {'.', '.', '.', '.', '.', '.', '8', '1', '.'},
            {'.', '3', '.', '.', '.', '.', '.', '.', '6'},
            {'.', '.', '.', '.', '.', '7', '.', '.', '.'},
            {'.', '.', '.', '5', '.', '.', '.', '7', '.'}
        })).isFalse();
    }
}