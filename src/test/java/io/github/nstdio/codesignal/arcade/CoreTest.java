package io.github.nstdio.codesignal.arcade;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class CoreTest {
    @Test
    void addTwoDigits() {
        assertThat(Core.addTwoDigits(12)).isEqualTo(3);
        assertThat(Core.addTwoDigits(29)).isEqualTo(11);
        assertThat(Core.addTwoDigits(48)).isEqualTo(12);
        assertThat(Core.addTwoDigits(10)).isEqualTo(1);
        assertThat(Core.addTwoDigits(25)).isEqualTo(7);
        assertThat(Core.addTwoDigits(99)).isEqualTo(18);
    }

    @Test
    void largestNumber() {
        assertThat(Core.largestNumber(1)).isEqualTo(9);
        assertThat(Core.largestNumber(2)).isEqualTo(99);
        assertThat(Core.largestNumber(4)).isEqualTo(9999);
        assertThat(Core.largestNumber(7)).isEqualTo(9_999_999);
    }

    @Test
    void candies() {
        assertThat(Core.candies(3, 10)).isEqualTo(9);
        assertThat(Core.candies(1, 2)).isEqualTo(2);
        assertThat(Core.candies(1, 5)).isEqualTo(5);
        assertThat(Core.candies(4, 4)).isEqualTo(4);
        assertThat(Core.candies(10, 5)).isEqualTo(0);
        assertThat(Core.candies(9, 50)).isEqualTo(45);
        assertThat(Core.candies(5, 50)).isEqualTo(50);
    }

    @Test
    void seatsInTheater() {
        assertThat(Core.seatsInTheater(16, 11, 5, 3)).isEqualTo(96);
        assertThat(Core.seatsInTheater(1, 1, 1, 1)).isEqualTo(0);
        assertThat(Core.seatsInTheater(1000, 1000, 1000, 1000)).isEqualTo(0);
    }

    @Test
    void maxMultiple() {
        assertThat(Core.maxMultiple(3, 10)).isEqualTo(9);
        assertThat(Core.maxMultiple(2, 7)).isEqualTo(6);
        assertThat(Core.maxMultiple(10, 50)).isEqualTo(50);
        assertThat(Core.maxMultiple(4, 99)).isEqualTo(96);
    }

    @Test
    void almostIncreasingSequenceTest() {
        assertThat(Core.almostIncreasingSequence(new int[]{1, 2, 3, 1})).isEqualTo(true);
        assertThat(Core.almostIncreasingSequence(new int[]{1, 2, 3, 4, 3, 6})).isEqualTo(true);
        assertThat(Core.almostIncreasingSequence(new int[]{1, 2, 3, 4, 99, 5, 6})).isEqualTo(true);
        assertThat(Core.almostIncreasingSequence(new int[]{10, 1, 2, 3, 4, 5})).isEqualTo(true);
        assertThat(Core.almostIncreasingSequence(new int[]{1, 3, 2})).isEqualTo(true);
        assertThat(Core.almostIncreasingSequence(new int[]{1, 2, 3, 4, 1, 2})).isEqualTo(false);
        assertThat(Core.almostIncreasingSequence(new int[]{1, 3, 2, 1})).isEqualTo(false);
        assertThat(Core.almostIncreasingSequence(new int[]{3, 6, 5, 8, 10, 20, 15})).isEqualTo(false);
        assertThat(Core.almostIncreasingSequence(new int[]{1, 1, 2, 3, 4, 4})).isEqualTo(false);
        assertThat(Core.almostIncreasingSequence(new int[]{1, 2, 3, 4, 5, 3, 5, 6})).isEqualTo(false);
        assertThat(Core.almostIncreasingSequence(new int[]{40, 50, 60, 10, 20, 30})).isEqualTo(false);
        assertThat(Core.almostIncreasingSequence(new int[]{1, 1})).isEqualTo(true);
    }

    @Test
    void matrixElementsSumTest() {
        assertThat(Core.matrixElementsSum(new int[][]{{0, 1, 1, 2}, {0, 5, 0, 0}, {2, 0, 3, 3}})).isEqualTo(9);
        assertThat(Core.matrixElementsSum(new int[][]{{1, 1, 1}, {0, 5, 0, 1}, {2, 1, 3, 10}})).isEqualTo(9);
        assertThat(Core.matrixElementsSum(new int[][]{{1, 1, 1}, {2, 2, 2}, {3, 3, 3}})).isEqualTo(18);
        assertThat(Core.matrixElementsSum(new int[][]{{0}})).isEqualTo(0);
        assertThat(Core.matrixElementsSum(new int[][]{{1, 0, 3}, {0, 2, 1}, {1, 2, 0}})).isEqualTo(5);
        assertThat(Core.matrixElementsSum(new int[][]{{0, 0, 0}, {9, 9, 9}, {9, 9, 9}})).isEqualTo(0);
        assertThat(Core.matrixElementsSum(new int[][]{{4, 0, 1}, {10, 7, 0}, {0, 0, 0}, {9, 1, 2}})).isEqualTo(15);
        assertThat(Core.matrixElementsSum(new int[][]{{1}})).isEqualTo(1);
    }

    @Test
    void allLongestStringsTest() {
        assertThat(Core.allLongestStrings(new String[]{"aba", "aa", "ad", "vcd", "aba"})).isEqualTo(new String[]{"aba", "vcd", "aba"});
        assertThat(Core.allLongestStrings(new String[]{"aa"})).isEqualTo(new String[]{"aa"});
    }

    @Test
    void commonCharacterCount() {
        assertThat(Core.commonCharacterCount("zzzz", "zzzzzzz")).isEqualTo(4);
        assertThat(Core.commonCharacterCount("aabcc", "adcaa")).isEqualTo(3);
        assertThat(Core.commonCharacterCount("abca", "xyzbac")).isEqualTo(3);
        assertThat(Core.commonCharacterCount("a", "b")).isEqualTo(0);
        assertThat(Core.commonCharacterCount("a", "aaa")).isEqualTo(1);
    }

    @Test
    void isLucky() {
        assertThat(Core.isLucky(1230)).isEqualTo(true);
        assertThat(Core.isLucky(239017)).isEqualTo(false);
        assertThat(Core.isLucky(134008)).isEqualTo(true);
        assertThat(Core.isLucky(10)).isEqualTo(false);
        assertThat(Core.isLucky(11)).isEqualTo(true);
        assertThat(Core.isLucky(1010)).isEqualTo(true);
        assertThat(Core.isLucky(261534)).isEqualTo(false);
        assertThat(Core.isLucky(100000)).isEqualTo(false);
        assertThat(Core.isLucky(999999)).isEqualTo(true);
        assertThat(Core.isLucky(123321)).isEqualTo(true);
    }

    @Test
    void sortByHeight() {
        assertThat(Core.sortByHeight(-1, 150, 190, 170, -1, -1, 160, 180))
                .containsExactly(-1, 150, 160, 170, -1, -1, 180, 190);

        assertThat(Core.sortByHeight(-1, -1, -1, -1, -1))
                .containsExactly(-1, -1, -1, -1, -1);

        assertThat(Core.sortByHeight(4, 2, 9, 11, 2, 16))
                .containsExactly(2, 2, 4, 9, 11, 16);

        assertThat(Core.sortByHeight(2, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 1))
                .containsExactly(1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, 2);

        assertThat(Core.sortByHeight(23, 54, -1, 43, 1, -1, -1, 77, -1, -1, -1, 3))
                .containsExactly(1, 3, -1, 23, 43, -1, -1, 54, -1, -1, -1, 77);
    }

    @Test
    void reverseInParentheses() {
        assertThat(Core.reverseInParentheses("foo(bar(baz))blim"))
                .isEqualTo("foobazrabblim");

        assertThat(Core.reverseInParentheses("(abc)d(efg)"))
                .isEqualTo("cbadgfe");

        assertThat(Core.reverseInParentheses("(((a)))"))
                .isEqualTo("a");

        assertThat(Core.reverseInParentheses("(((()()()()()()()()()(()()()()(()()()()()()()()()(()()()()()()()()()()))()()()()()))()()()()()()()()((()()()()()()()()()(()()()()()()()()()(()()()()()()()()()(()()()()()()()()()()))))()()()()()()()()()))()()()()()()()()(()()()()(()()()()()()()()()(()()()()()()()()()()))()()()()()))()()()()()()()()((()()()()()()()()()(()()()()()()()()()(()()()()()()()()()(()()()()()((()()()()()()()()()(()()()()(()()()()()()()()()(()()()()()()()()()()))()()()()()))()()()()()()()()((()()()()()()()()()(()()()()()()()()()(()()()()()()()()()(()()()()()()()()()()))))()()()()()()()()()))()()()()))))()()()()()()()()())"))
                .isEqualTo("");

        assertThat(Core.reverseInParentheses("((a)())c"))
                .isEqualTo("ac");

        assertThat(Core.reverseInParentheses("((a)(b))c"))
                .isEqualTo("bac");

        assertThat(Core.reverseInParentheses("(bar)"))
                .isEqualTo("rab");

        assertThat(Core.reverseInParentheses("foo(bar)baz"))
                .isEqualTo("foorabbaz");

        assertThat(Core.reverseInParentheses("foo(bar)baz(blim)"))
                .isEqualTo("foorabbazmilb");

        assertThat(Core.reverseInParentheses(""))
                .isEqualTo("");

        assertThat(Core.reverseInParentheses("()"))
                .isEqualTo("");
    }

    @Test
    void alternatingSums() {
    }

    @Test
    void addBorder() {
    }

    @Test
    void areSimilar() {
        assertThat(Core.areSimilar(new int[]{1, 2, 2}, new int[]{2, 1, 1})).isFalse();
        assertThat(Core.areSimilar(new int[]{1, 1, 4}, new int[]{1, 2, 3})).isFalse();
        assertThat(Core.areSimilar(new int[]{1, 2, 3}, new int[]{1, 10, 2})).isFalse();

        assertThat(Core.areSimilar(new int[]{1, 2, 3}, new int[]{2, 1, 3})).isTrue();
        assertThat(Core.areSimilar(new int[]{1, 2, 3}, new int[]{1, 2, 3})).isTrue();
        assertThat(Core.areSimilar(new int[]{2, 3, 1}, new int[]{1, 3, 2})).isTrue();
        assertThat(Core.areSimilar(new int[]{2, 3, 9}, new int[]{10, 3, 2})).isFalse();
        assertThat(Core.areSimilar(new int[]{4, 6, 3}, new int[]{3, 4, 6})).isFalse();
        assertThat(Core.areSimilar(new int[]{832, 998, 148, 570, 533, 561, 894, 147, 455, 279}, new int[]{832, 998, 148, 570, 533, 561, 455, 147, 894, 279})).isTrue();
    }

    @Test
    void arrayChange() {
        assertThat(Core.arrayChange(2, 3, 3, 5, 5, 5, 4, 12, 12, 10, 15)).isEqualTo(13);
        assertThat(Core.arrayChange(1, 1, 1)).isEqualTo(3);
        assertThat(Core.arrayChange(2, 1, 10, 1)).isEqualTo(12);
        assertThat(Core.arrayChange(3122, -645, 2616, 13213, -8069)).isEqualTo(25559);

        assertThat(Core.arrayChange(-787, -773, -93, 867, -28, 118, 372, 255, 355, 598, -179, -752, 794, 961, -84, 296, -714, 14, 666, -265, -905, 942, -691, -379, -698, -650, 637, 523, 709, -674, 574, -239, 805, -434, 597, -677, 664, 384, 726, -389, -387, 772, -603, 685, 249, 446, -631, 454, 983, 867, -158, 932, -440, 891, -12, 400, -916, 503, 185, -802, -255, 207, -952, -506, -689, 425, 747, -907, -30, 102, 553, 981, -664, 75, -957, -42, 99, -750, -277, 686, -884, -972, 470, 32, 439, 163, 887, 895, -555, -654, 793, 333, 143, 73, 181, -512, -915, -68, 542, 799)).isEqualTo(89510);
        assertThat(Core.arrayChange(-28943, -29728, -24726, -15090, -2555, -9551, -11025, 36442, -23240, -46093, 48516, 44580, -21573, 39172, -38017, -19354, -13460, 38212, -35646, -22288, 36832, -33115, 39055, -15935, -19300, -10419, -18548, 21742, -32032, 27988, -45323, 27454, -5683, -14209, -4168, 51188, 45552, 9899, 49241, -25939, -8344, -25788, 6808, 6931, 6145, -30802, -518, -42362)).isEqualTo(2020705);
        assertThat(Core.arrayChange(9796, 1283, -2825, 3870, -6727, -8616, -10191, -7727, 7074, 1580, -4583, 162, 2980, -3861, 9452, 8145, 1222, -1125, 5142, -5657, -974, -986, -9627, 5244, 8866, 3336, -9946, -5271, 10582, 3013, 8030, 4471, -3420, 9496, -3533, -8030, 10007, 2549, -8195, 7119, 302, -5322, -3537, 209, -8134, -9176, 6336, -1771, 9851, 3644, 9629, -2603, 3988, 10579, 2221, 1101, 1465, 5002, -6203, -8864, 596, 6005, 4554, 8526, 2178, -5447, -232, -9734, 7402, -3984, -7161, -2139, -3181, 10445, 4535, 6926, 7156)).isEqualTo(737073);
        assertThat(Core.arrayChange(-24875, -6401, 58256, 44456, 2244, -25333, -42389, -5975, 7650, -46343, -62011, -55366, 7802, -37699, 15461, 13309, -58664, 54557, 56324, -34397, -33024, -21934, -18861, -23196, 56542, -63986, 59833, -45610, -16948, 399, -7405, 54701, -57348, -32627, 65534, 615)).isEqualTo(2199614);
        assertThat(Core.arrayChange(22121, 42080, -51776, -28528, 39895, -50842, 25463, 46187, -29518, 42293, -25615, -47412, 24945, -2630, -12717, -23773, -47824, -7768, -23620, -30270, -51644, 42829, 27609, -40734, 2142, 20285, 29665, -36557, -24074, -11996, 30511, 17104, 4360, -41163, 6814, 959, 26613, -15121, -17355, 28424, -11305, 33175, -8585, 23649, -18428, 16770, 14095, 38766, -22425, -45139, -5836, -28668, -15123, -35450, 41353, 11103, -29233, -51990, -14958, 45944, 20841, -34149, 34720, -51760, 23519, -46257, 40985, -32615, -43378, 14243, -24731, 1311, -4236, -24885, 41713, -45195, -14683, 47765, 26904, -51741, 38051, 13429, 38189, -45812, -52474, 14936, 6582, -26313, 4692, 12313, -37502, -40673, 5799, 23264, 33617, -50938, 26268, -25548, -22353, -15175, -21568, 18656, 19208, 20674, 41228, -42538, -45085, -32356, -39901, -39585, -50690, 2859, -4079, 29823, 28849, -2142, -16613, 23378, 36363, 31780, -40379, 7489, -13324, -22377, 35661, -27141, -42727, 10122, -40385, -19765, 33913, -10504, -4715, -18190, 41430, -19134, 32646, 25839, 783, 32941, -25142)).isEqualTo(7097995);
    }

    @Test
    void palindromeRearranging() {
        assertThat(Core.palindromeRearranging("aabb")).isTrue();
        assertThat(Core.palindromeRearranging("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaabc")).isFalse();
        assertThat(Core.palindromeRearranging("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaab")).isTrue();
        assertThat(Core.palindromeRearranging("aaaaaaaaaaaaaaabaaaaaaaaaaaaaaa")).isTrue();
        assertThat(Core.palindromeRearranging("abbcabb")).isTrue();
        assertThat(Core.palindromeRearranging("zyyzzzzz")).isTrue();
        assertThat(Core.palindromeRearranging("z")).isTrue();
        assertThat(Core.palindromeRearranging("zaa")).isTrue();
        assertThat(Core.palindromeRearranging("abca")).isFalse();
        assertThat(Core.palindromeRearranging("abcad")).isFalse();
        assertThat(Core.palindromeRearranging("aaaaaaaaaaaaaaaaaaaaaaaaaaaaaabbbccccaaaaaaaaaaaaa")).isFalse();
        assertThat(Core.palindromeRearranging("abdhuierf")).isFalse();
        assertThat(Core.palindromeRearranging("aaaaaaaaaaaaaaabaaaaaaaaaaaaaaaa")).isFalse();
    }

    @Test
    void areEquallyStrong() {
        assertThat(Core.areEquallyStrong(15, 10, 15, 9)).isFalse();
    }

    @Test
    void arrayMaximalAdjacentDifference() {
    }

    @Test
    void isIPv4Address() {
        assertThat(Core.isIPv4Address("172.16.254.1")).isTrue();
        assertThat(Core.isIPv4Address("172.316.254.1")).isFalse();
        assertThat(Core.isIPv4Address(".254.255.0")).isFalse();
        assertThat(Core.isIPv4Address("0.254.255.0")).isTrue();
    }

    @Test
    void avoidObstacles() {
        assertThat(Core.avoidObstacles(new int[]{2, 3})).isEqualTo(4);
        assertThat(Core.avoidObstacles(new int[]{1000, 999})).isEqualTo(6);
        assertThat(Core.avoidObstacles(new int[]{5, 3, 6, 7, 9})).isEqualTo(4);
        assertThat(Core.avoidObstacles(new int[]{1, 4, 10, 6, 2})).isEqualTo(7);
        assertThat(Core.avoidObstacles(new int[]{19, 32, 11, 23})).isEqualTo(3);
    }

    @Test
    void boxBlur() {
        assertThat(Core.boxBlur(new int[][]{
                {36, 0, 18, 9},
                {27, 54, 9, 0},
                {81, 63, 72, 45},
        })).isEqualTo(new int[][]{{40, 30}});

        assertThat(Core.boxBlur(new int[][]{
                {0, 18, 9},
                {27, 9, 0},
                {81, 63, 45},
        })).isEqualTo(new int[][]{{28}});
    }

    @Test
    void minesweeper() {
        assertThat(Core.minesweeper(new boolean[][]{
                {true, true, true},
                {true, true, true},
                {true, true, true},
        })).isEqualTo(new int[][]{
                {3, 5, 3},
                {5, 8, 5},
                {3, 5, 3}
        });
    }

    @Test
    void evenDigitsOnly() {
        assertTrue(Core.evenDigitsOnly(468402800));

        assertFalse(Core.evenDigitsOnly(168402800));
    }

    @Test
    void variableName() {
        assertTrue(Core.variableName("var_1__Int"));
        assertTrue(Core.variableName("variable0"));
        assertTrue(Core.variableName("_Aas_23"));

        assertFalse(Core.variableName("2w2"));
        assertFalse(Core.variableName("qq-q"));
        assertFalse(Core.variableName(" variable"));
        assertFalse(Core.variableName("va[riable0"));
    }

    @Test
    void alphabeticShift() {
        assertEquals("dsbaz", Core.alphabeticShift("crazy"));
    }

    @Test
    void chessBoardCellColor() {
        assertTrue(Core.chessBoardCellColor("B3", "D5"));
        assertTrue(Core.chessBoardCellColor("A1", "D2"));
        assertTrue(Core.chessBoardCellColor("A1", "A3"));
        assertTrue(Core.chessBoardCellColor("A1", "A5"));
        assertTrue(Core.chessBoardCellColor("C1", "E7"));
        assertTrue(Core.chessBoardCellColor("B3", "C8"));

        assertFalse(Core.chessBoardCellColor("A1", "H3"));
        assertFalse(Core.chessBoardCellColor("A1", "A2"));
        assertFalse(Core.chessBoardCellColor("A1", "A4"));
        assertFalse(Core.chessBoardCellColor("B3", "H8"));
        assertFalse(Core.chessBoardCellColor("C3", "B5"));
    }

    @Test
    void circleOfNumbers() {
        assertEquals(0, Core.circleOfNumbers(6, 3));
        assertEquals(7, Core.circleOfNumbers(10, 2));
        assertEquals(2, Core.circleOfNumbers(10, 7));
        assertEquals(3, Core.circleOfNumbers(4, 1));
    }

    @Test
    void stringsRearrangement() {
        assertFalse(Core.stringsRearrangement(new String[]{"aba", "bbb", "bab"}));

        assertTrue(Core.stringsRearrangement(new String[]{"ab", "bb", "aa"}));
    }

    @Test
    void extractEachKth() {
        assertThat(Core.extractEachKth(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10}, 3))
                .isEqualTo(new int[]{1, 2, 4, 5, 7, 8, 10});
    }
}