package io.github.nstdio.codesignal.interview;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static io.github.nstdio.codesignal.interview.Arrays.firstNotRepeatingCharacter;
import static io.github.nstdio.codesignal.interview.Arrays.rotateImage;
import static io.github.nstdio.codesignal.interview.Arrays.sudoku2;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.params.provider.Arguments.arguments;

public class ArraysTest {

    static Stream<Arguments> isCryptSolutionPositiveData() {
        return Stream.of(
                arguments(new String[]{"ONE", "ONE", "TWO"},
                        new char[][]{
                                {'O', '2'},
                                {'T', '4'},
                                {'W', '6'},
                                {'E', '1'},
                                {'N', '3'}}
                ),
                arguments(new String[]{"A", "A", "A"},
                        new char[][]{
                                {'A', '0'}}
                )
        );
    }

    static Stream<Arguments> isCryptSolutionNegativeData() {
        return Stream.of(
                arguments(new String[]{"ONE", "ONE", "TWO"},
                        new char[][]{
                                {'O', '0'},
                                {'T', '1'},
                                {'W', '2'},
                                {'E', '5'},
                                {'N', '6'}}
                ),
                arguments(new String[]{"A", "B", "C"},
                        new char[][]{
                                {'A', '5'},
                                {'B', '6'},
                                {'C', '1'}}
                ),
                arguments(new String[]{"TEN", "TWO", "ONE"},
                        new char[][]{
                                {'O', '1'},
                                {'T', '0'},
                                {'W', '9'},
                                {'E', '5'},
                                {'N', '4'}}
                ),
                arguments(new String[]{"BAA", "CAB", "DAB"},
                        new char[][]{
                                {'A', '0'},
                                {'B', '1'},
                                {'C', '2'},
                                {'D', '4'}}
                )
        );
    }

    @Test
    void testFirstNotRepeatingCharacter() {
        assertThat(firstNotRepeatingCharacter("ngrhhn"))
                .isEqualTo('g');
    }

    @Test
    void testRotateImage() {
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
    void testSudoku2() {
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

    @ParameterizedTest
    @MethodSource("isCryptSolutionPositiveData")
    void testIsCryptSolutionPositive(String[] crypt, char[][] solution) {
        //when
        var actual = Arrays.isCryptSolution(crypt, solution);

        //then
        assertTrue(actual);
    }

    @ParameterizedTest
    @MethodSource("isCryptSolutionNegativeData")
    void testIsCryptSolutionNegative(String[] crypt, char[][] solution) {
        //when
        var actual = Arrays.isCryptSolution(crypt, solution);

        //then
        assertFalse(actual);
    }
}