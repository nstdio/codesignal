package io.github.nstdio.codesignal.arcade;

import static java.util.stream.Collectors.toMap;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Core {
    /**
     * You are given a two-digit integer n. Return the sum of its digits.
     * <p>
     * Example
     * <p>
     * For n = 29, the output should be addTwoDigits(n) = 11.
     * <p>
     * Input/Output
     * <p>
     * [execution time limit] 3 seconds (java)
     *
     * @param n A positive two-digit integer (10 ≤ n ≤ 99).
     *
     * @return The sum of the first and second digits of the input number.
     */
    public static int addTwoDigits(int n) {
        return n % 10 + n / 10;
    }

    /**
     * Given an integer n, return the largest number that contains exactly n digits.
     * <p>
     * Example
     * <p>
     * For n = 2, the output should be largestNumber(n) = 99.
     * <p>
     * Input/Output
     * <p>
     * [execution time limit] 3 seconds (java)
     *
     * @param n The number length (1 ≤ n ≤ 7).
     *
     * @return The largest integer of length n.
     */
    public static int largestNumber(int n) {
        return (int) Math.pow(10, n) - 1;
    }

    /**
     * n children have got m pieces of candy. They want to eat as much candy as they can, but each child must eat
     * exactly the same amount of candy as any other child. Determine how many pieces of candy will be eaten by all the
     * children together. Individual pieces of candy cannot be split.
     * <p>
     * Example
     * <p>
     * For n = 3 and m = 10, the output should be candies(n, m) = 9.
     * <p>
     * Each child will eat 3 pieces. So the answer is 9.
     * <p>
     * [execution time limit] 3 seconds (java)
     *
     * @param n The number of children (1 ≤ n ≤ 10).
     * @param m The number of pieces of candy (2 ≤ m ≤ 100).
     *
     * @return The total number of pieces of candy the children will eat provided they eat as much as they can and all
     * children eat the same amount.
     */
    public static int candies(int n, int m) {
        return (m / n) * n;
    }

    /**
     * Your friend advised you to see a new performance in the most popular theater in the city. He knows a lot about
     * art and his advice is usually good, but not this time: the performance turned out to be awfully dull. It's so bad
     * you want to sneak out, which is quite simple, especially since the exit is located right behind your row to the
     * left. All you need to do is climb over your seat and make your way to the exit.
     * <p>
     * The main problem is your shyness: you're afraid that you'll end up blocking the view (even if only for a couple
     * of seconds) of all the people who sit behind you and in your column or the columns to your left. To gain some
     * courage, you decide to calculate the number of such people and see if you can possibly make it to the exit
     * without disturbing too many people.
     * <p>
     * Given the total number of rows and columns in the theater (nRows and nCols, respectively), and the row and column
     * you're sitting in, return the number of people who sit strictly behind you and in your column or to the left,
     * assuming all seats are occupied.
     * <p>
     * Example
     * <p>
     * For nCols = 16, nRows = 11, col = 5 and row = 3, the output should be
     * <p>
     * seatsInTheater(nCols, nRows, col, row) = 96.
     * <p>
     * [execution time limit] 3 seconds (java)
     *
     * @param nCols The number of theater's columns (1 ≤ nCols ≤ 1000).
     * @param nRows The number of theater's rows (1 ≤ nRows ≤ 1000).
     * @param col   The column number of your own seat (1-based, 1 ≤ col ≤ nCols).
     * @param row   The row number of your own seat (1-based, 1 ≤ row ≤ nRows).
     *
     * @return The number of people who sit strictly behind you and in your column or to the left.
     */
    public static int seatsInTheater(int nCols, int nRows, int col, int row) {
        return (nCols - col + 1) * (nRows - row);
    }

    /**
     * Given a divisor and a bound, find the largest integer N such that:
     * <p>
     * N is divisible by divisor. N is less than or equal to bound. N is greater than 0.
     * <p>
     * It is guaranteed that such a number exists.
     * <p>
     * Example
     * <p>
     * For divisor = 3 and bound = 10, the output should be maxMultiple(divisor, bound) = 9.
     * <p>
     * The largest integer divisible by 3 and not larger than 10 is 9.
     *
     * @param divisor 2 ≤ divisor ≤ 10
     * @param bound   5 ≤ bound ≤ 100
     *
     * @return The largest integer not greater than bound that is divisible by divisor.
     */
    public static int maxMultiple(int divisor, int bound) {
        return (bound / divisor) * divisor;
    }

    /**
     * Given a sequence of integers as an array, determine whether it is possible to obtain a strictly increasing
     * sequence by removing no more than one element from the array.
     * <p>
     * Note: sequence a0, a1, ..., an is considered to be a strictly increasing if a0 < a1 < ... < an. Sequence
     * containing only one element is also considered to be strictly increasing.
     * <p>
     * Example
     * <p>
     * For sequence = [1, 3, 2, 1], the output should be almostIncreasingSequence(sequence) = false.
     * <p>
     * There is no one element in this array that can be removed in order to get a strictly increasing sequence.
     * <p>
     * For sequence = [1, 3, 2], the output should be almostIncreasingSequence(sequence) = true.
     * <p>
     * You can remove 3 from the array to get the strictly increasing sequence [1, 2]. Alternately, you can remove 2 to
     * get the strictly increasing sequence [1, 3].
     *
     * @param seq Guaranteed constraints: 2 ≤ sequence.length ≤ 105, -105 ≤ sequence[i] ≤ 105.
     *
     * @return Return true if it is possible to remove one element from the array in order to get a strictly increasing
     * sequence, otherwise return false.
     */
    public static boolean almostIncreasingSequence(final int[] seq) {
        int l = seq.length;
        int count = 0;
        int idx = 0;

        for (int i = 1; i < l; i++) {
            if (seq[i - 1] >= seq[i]) {
                count++;
                idx = (i - 1) % 2 == 0 ? i - 1 : i;

                if (i + 1 == l && count == 1) {
                    return true;
                }

                if (count > 1) {
                    return false;
                }
            }
        }

        if (count == 0 || (count == 1 && idx == 0)) {
            return true;
        }

        return idx + 1 == l || seq[idx + 1] > seq[idx - 1];
    }

    /**
     * After becoming famous, the CodeBots decided to move into a new building together. Each of the rooms has a
     * different cost, and some of them are free, but there's a rumour that all the free rooms are haunted! Since the
     * CodeBots are quite superstitious, they refuse to stay in any of the free rooms, or any of the rooms below any of
     * the free rooms.
     * <p>
     * Given matrix, a rectangular matrix of integers, where each value represents the cost of the room, your task is to
     * return the total sum of all rooms that are suitable for the CodeBots (ie: add up all the values that don't appear
     * below a 0).
     *
     * <p>Example:
     * <pre>
     * For
     *     matrix = [[0, 1, 1, 2],
     *               [0, 5, 0, 0],
     *               [2, 0, 3, 3]]
     * </pre>
     * the output should be matrixElementsSum(matrix) = 9.
     *
     * @param matrix A 2-dimensional array of integers representing the cost of each room in the building. A value of 0
     *               indicates that the room is haunted. Guaranteed constraints: 1 ≤ matrix.length ≤ 5, 1 ≤
     *               matrix[i].length ≤ 5, 0 ≤ matrix[i][j] ≤ 10.
     *
     * @return The total price of all the rooms that are suitable for the CodeBots to live in.
     */
    public static int matrixElementsSum(int[][] matrix) {
        return IntStream.range(0, matrix[0].length)
                .flatMap(i -> Stream.of(matrix)
                        .takeWhile(rows -> rows[i] != 0)
                        .mapToInt(rows -> rows[i]))
                .sum();
    }

    /**
     * Given an array of strings, return another array containing all of its longest strings.
     * <p>
     * Example
     * <p>
     * For inputArray = ["aba", "aa", "ad", "vcd", "aba"], the output should be allLongestStrings(inputArray) = ["aba",
     * "vcd", "aba"].
     *
     * @param inputArray A non-empty array. Guaranteed constraints: 1 ≤ inputArray.length ≤ 10, 1 ≤ inputArray[i].length
     *                   ≤ 10.
     *
     * @return Array of the longest strings, stored in the same order as in the inputArray.
     */
    public static String[] allLongestStrings(String[] inputArray) {
        int max = Stream.of(inputArray)
                .mapToInt(String::length)
                .max()
                .orElse(0);

        return Stream.of(inputArray)
                .filter(s -> s.length() == max)
                .toArray(String[]::new);
    }

    /**
     * Given two strings, find the number of common characters between them.
     * <p>Example
     * <p>
     * For s1 = "aabcc" and s2 = "adcaa", the output should be commonCharacterCount(s1, s2) = 3.
     * <p>
     * Strings have 3 common characters - 2 "a"s and 1 "c".
     *
     * @param s1 A string consisting of lowercase English letters. Guaranteed constraints: 1 ≤ s1.length < 15.
     * @param s2 A string consisting of lowercase English letters. Guaranteed constraints: 1 ≤ s1.length < 15.
     *
     * @return common character count between s1 and s2.
     */
    public static int commonCharacterCount(String s1, String s2) {
        Map<Character, Integer> freq = s2.chars()
                .mapToObj(value -> (char) value)
                .collect(toMap(c -> c, c -> 1, Integer::sum));

        return s1.chars()
                .mapToObj(value -> (char) value)
                .collect(toMap(c -> c, c -> 1, Integer::sum))
                .entrySet()
                .stream()
                .mapToInt(e -> Math.min(e.getValue(), freq.getOrDefault(e.getKey(), 0)))
                .sum();
    }

    /**
     * Ticket numbers usually consist of an even number of digits. A ticket number is considered lucky if the sum of the
     * first half of the digits is equal to the sum of the second half.
     * <p>
     * Given a ticket number n, determine if it's lucky or not.
     * <p>
     * Example
     * <p>
     * For n = 1230, the output should be isLucky(n) = true; For n = 239017, the output should be isLucky(n) = false.
     *
     * @param n A ticket number represented as a positive integer with an even number of digits. Guaranteed constraints:
     *          10 ≤ n < 106.
     *
     * @return true if n is a lucky ticket number, false otherwise.
     */
    public static boolean isLucky(int n) {
        // half of digits count
        int h = ((int) Math.log10(n) + 1) / 2;

        // difference of half sums
        int diff = 0;
        while (n != 0) {
            diff = h > 0 ? diff + n % 10 : diff - n % 10;

            n /= 10;
            h--;
        }

        return diff == 0;
    }

    /**
     * Some people are standing in a row in a park. There are trees between them which cannot be moved. Your task is to
     * rearrange the people by their heights in a non-descending order without moving the trees. People can be very
     * tall!
     *
     * @param a If a[i] = -1, then the ith position is occupied by a tree. Otherwise a[i] is the height of a person
     *          standing in the ith position. Guaranteed constraints: 1 ≤ a.length ≤ 1000, -1 ≤ a[i] ≤ 1000.
     *
     * @return Sorted array a with all the trees untouched.
     */
    public static int[] sortByHeight(int... a) {
        List<Integer> sorted = IntStream.range(0, a.length)
                .filter(i -> a[i] != -1)
                .map(i -> a[i])
                .sorted()
                .boxed()
                .collect(Collectors.toList());

        IntStream.range(0, a.length)
                .filter(i -> a[i] == -1)
                .forEach(treeIndex -> sorted.add(treeIndex, -1));

        return sorted.stream()
                .mapToInt(Integer::intValue)
                .toArray();
    }

    /**
     * Write a function that reverses characters in (possibly nested) parentheses in the input string.
     * <p>
     * Input strings will always be well-formed with matching ()s.
     * <p>
     * Example
     * <p>
     * For input = "(bar)", the output should be reverseInParentheses(input) = "rab";
     * <p>
     * For input = "foo(bar)baz", the output should be reverseInParentheses(input) = "foorabbaz";
     * <p>
     * For input = "foo(bar)baz(blim)", the output should be reverseInParentheses(input) = "foorabbazmilb";
     * <p>
     * For input = "foo(bar(baz))blim", the output should be reverseInParentheses(input) = "foobazrabblim".
     * <p>
     * Because "foo(bar(baz))blim" becomes "foo(barzab)blim" and then "foobazrabblim".
     *
     * @param input A string consisting of lowercase English letters and the characters ( and ). It is guaranteed that
     *              all * parentheses in input form a regular bracket sequence. A bracket sequence is called regular if
     *              it is * possible to insert some numbers and signs into the sequence in such a way that the new
     *              sequence will represent a * correct arithmetic expression. Guaranteed constraints: 0 ≤ input.length
     *              ≤ 50
     *
     * @return Return input, with all the characters that were in parentheses reversed.
     */
    public static String reverseInParentheses(String input) {
        StringBuilder buff = new StringBuilder(input);
        Deque<Integer> open = new LinkedList<>();

        for (int i = 0; i < buff.length(); i++) {
            char c = buff.charAt(i);

            if (c == '(') {
                open.add(i);
            } else if (c == ')') {
                int start = open.removeLast();
                int end = --i;

                // delete parents from both sides
                buff.deleteCharAt(start--).deleteCharAt(i);

                while (++start <= --end) {
                    char tmp = buff.charAt(start);
                    buff.setCharAt(start, buff.charAt(end));
                    buff.setCharAt(end, tmp);
                }

                i--;
            }
        }

        return buff.toString();
    }

    /**
     * Several people are standing in a row and need to be divided into two teams. The first person goes into team 1,
     * the second goes into team 2, the third goes into team 1 again, the fourth into team 2, and so on.
     * <p>
     * You are given an array of positive integers - the weights of the people. Return an array of two integers, where
     * the first element is the total weight of team 1, and the second element is the total weight of team 2 after the
     * division is complete.
     * <p>
     * Example
     * <p>
     * For a = [50, 60, 60, 45, 70], the output should be alternatingSums(a) = [180, 105].
     *
     * @param a Guaranteed constraints: 1 ≤ a.length ≤ 105, 45 ≤ a[i] ≤ 100.
     *
     * @return an array of two integers, where the first element is the total weight of team 1, and the second element
     * is the total weight of team 2.
     */
    public static int[] alternatingSums(int[] a) {
        int[] teams = new int[2];

        for (int i = 0; i < a.length; i++) {
            teams[i % 2] += a[i];
        }

        return teams;
    }

    /**
     * Given a rectangular matrix of characters, add a border of asterisks(*) to it.
     * <p>
     * Example
     * <p>
     * For
     * <p>
     * picture = ["abc", "ded"] the output should be
     * <p>
     * addBorder(picture) = ["*****", "*abc*", "*ded*", "*****"]
     *
     * @param picture A non-empty array of non-empty equal-length strings. Guaranteed constraints: 1 ≤ picture.length ≤
     *                100, 1 ≤ picture[i].length ≤ 100.
     *
     * @return The same matrix of characters, framed with a border of asterisks of width 1.
     */
    public static String[] addBorder(String[] picture) {
        String border = IntStream.range(0, picture[0].length() + 2)
                .mapToObj(i -> '*')
                .collect(StringBuilder::new, StringBuilder::append, StringBuilder::append)
                .toString();

        return Stream.of(
                        Stream.of(border),
                        Stream.of(picture).map(s -> '*' + s + '*'),
                        Stream.of(border)
                )
                .flatMap(stream -> stream)
                .toArray(String[]::new);
    }

    /**
     * Two arrays are called similar if one can be obtained from another by swapping at most one pair of elements in one
     * of the arrays.
     * <p>
     * Given two arrays a and b, check whether they are similar.
     * <p>
     * Example
     * <p>
     * For a = [1, 2, 3] and b = [1, 2, 3], the output should be areSimilar(a, b) = true.
     * <p>
     * The arrays are equal, no need to swap any elements.
     * <p>
     * For a = [1, 2, 3] and b = [2, 1, 3], the output should be areSimilar(a, b) = true.
     * <p>
     * We can obtain b from a by swapping 2 and 1 in b.
     * <p>
     * For a = [1, 2, 2] and b = [2, 1, 1], the output should be areSimilar(a, b) = false.
     * <p>
     * Any swap of any two elements either in a or in b won't make a and b equal.
     *
     * @param a Array of integers. Guaranteed constraints: 3 ≤ a.length ≤ 105, 1 ≤ a[i] ≤ 1000.
     * @param b Array of integers of the same length as a. Guaranteed constraints: b.length = a.length, 1 ≤ b[i] ≤ 1000
     *
     * @return true if a and b are similar, false otherwise.
     */
    public static boolean areSimilar(int[] a, int[] b) {
        int[] diff = new int[2];
        int idx = -1;

        for (int i = 0; i < a.length && idx < diff.length - 1; i++) {
            if (a[i] != b[i]) {
                diff[++idx] = i;
            }
        }

        if (idx == 1) {
            int tmp = a[diff[0]];
            a[diff[0]] = a[diff[1]];
            a[diff[1]] = tmp;

            return Arrays.equals(a, b);
        }

        return true;
    }

    /**
     * You are given an array of integers. On each move you are allowed to increase exactly one of its element by one.
     * Find the minimal number of moves required to obtain a strictly increasing sequence from the input.
     * <p>
     * For arr = [1, 1, 1], the output should be arrayChange(arr) = 3.
     *
     * @param arr Guaranteed constraints: 3 ≤ arr.length ≤ 105, -105 ≤ arr[i] ≤ 105.
     *
     * @return The minimal number of moves needed to obtain a strictly increasing sequence from arr. It's guaranteed
     * that for the given test cases the answer always fits signed 32-bit integer type.
     */
    public static int arrayChange(int... arr) {
        int ret = 0;

        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] >= arr[i]) {
                int tmp = arr[i - 1] - arr[i] + 1;
                ret += tmp;
                arr[i] += tmp;
            }
        }

        return ret;
    }

    public static boolean palindromeRearranging(String input) {
        int[] freq = new int[26];

        input.chars()
                .map(operand -> operand - 'a')
                .forEach(idx -> freq[idx] = ++freq[idx]);

        return IntStream.of(freq)
                .filter(value -> value % 2 == 1)
                .count() < 2;
    }

    /**
     * Call two arms equally strong if the heaviest weights they each are able to lift are equal.
     * <p>
     * Call two people equally strong if their strongest arms are equally strong (the strongest arm can be both the
     * right and the left), and so are their weakest arms.
     * <p>
     * Given your and your friend's arms' lifting capabilities find out if you two are equally strong.
     *
     * @param yourLeft     A non-negative integer representing the heaviest weight you can lift with your left arm.
     * @param yourRight    A non-negative integer representing the heaviest weight you can lift with your right arm.
     * @param friendsLeft  A non-negative integer representing the heaviest weight your friend can lift with his or her
     *                     left arm.
     * @param friendsRight A non-negative integer representing the heaviest weight your friend can lift with his or her
     *                     right arm.
     *
     * @return true if you and your friend are equally strong, false otherwise.
     */
    public static boolean areEquallyStrong(int yourLeft, int yourRight, int friendsLeft, int friendsRight) {
        return Math.max(yourLeft, yourRight) == Math.max(friendsLeft, friendsRight)
                && Math.min(yourLeft, yourRight) == Math.min(friendsLeft, friendsRight);
    }

    /**
     * Given an array of integers, find the maximal absolute difference between any two of its adjacent elements.
     * <p>
     * Example
     * <p>
     * For inputArray = [2, 4, 1, 0], the output should be arrayMaximalAdjacentDifference(inputArray) = 3.
     *
     * @param inputArray Guaranteed constraints: 3 ≤ inputArray.length ≤ 10, -15 ≤ inputArray[i] ≤ 15.
     *
     * @return The maximal absolute difference.
     */
    public static int arrayMaximalAdjacentDifference(int[] inputArray) {
        int diff = Integer.MIN_VALUE;

        for (int i = 1; i < inputArray.length; i++) {
            diff = Math.max(Math.abs(inputArray[i - 1] - inputArray[i]), diff);
        }

        return diff;
    }

    public static boolean isIPv4Address(String inputString) {
        try {
            return Stream.of(inputString.split("\\."))
                    .mapToInt(Integer::parseInt)
                    .filter(value -> value > -1 && value < 256)
                    .count() == 4;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    /**
     * You are given an array of integers representing coordinates of obstacles situated on a straight line.
     * <p>
     * Assume that you are jumping from the point with coordinate 0 to the right. You are allowed only to make jumps of
     * the same length represented by some integer.
     * <p>
     * Find the minimal length of the jump enough to avoid all the obstacles.
     * <p>
     * Example
     * <p>
     * For inputArray = [5, 3, 6, 7, 9], the output should be avoidObstacles(inputArray) = 4.
     *
     * @param inputArray Non-empty array of positive integers. Guaranteed constraints: 2 ≤ inputArray.length ≤ 1000, 1 ≤
     *                   inputArray[i] ≤ 1000.
     *
     * @return The desired length.
     */
    public static int avoidObstacles(int[] inputArray) {
        int j = 1;

        for (int ignored : inputArray) {
            for (int k : inputArray) {
                while (k % j == 0) {
                    ++j;
                }
            }
        }

        return j;
    }

    /**
     * Last night you partied a little too hard. Now there's a black and white photo of you that's about to go viral!
     * You can't let this ruin your reputation, so you want to apply the box blur algorithm to the photo to hide its
     * content.
     * <p>
     * The pixels in the input image are represented as integers. The algorithm distorts the input image in the
     * following way: Every pixel x in the output image has a value equal to the average value of the pixel values from
     * the 3 × 3 square that has its center at x, including x itself. All the pixels on the border of x are then
     * removed.
     * <p>
     * Return the blurred image as an integer, with the fractions rounded down.
     *
     * @param image An image, stored as a rectangular matrix of non-negative integers.
     *
     * @return A blurred image represented as integers, obtained through the process in the description.
     */
    public static int[][] boxBlur(int[][] image) {
        var blured = new int[image.length - 2][image[0].length - 2];

        for (int i = 1; i < image.length - 1; i++) {
            for (int j = 1; j < image[i].length - 1; j++) {
                int sum = 0;
                for (int k = 1; k >= -1; k--)
                    for (int l = -1; l <= 1; l++) sum += image[i + l][j + k];

                blured[i - 1][j - 1] = sum / 9;
            }
        }

        return blured;
    }

    /**
     * In the popular Minesweeper game you have a board with some mines and those cells that don't contain a mine have a
     * number in it that indicates the total number of mines in the neighboring cells. Starting off with some
     * arrangement of mines we want to create a Minesweeper game setup.
     *
     * @param matrix A non-empty rectangular matrix consisting of boolean values - true if the corresponding cell
     *               contains a mine, false otherwise.
     *
     * @return Rectangular matrix of the same size as matrix each cell of which contains an integer equal to the number
     * of mines in the neighboring cells. Two cells are called neighboring if they share at least one corner.
     */
    public static int[][] minesweeper(boolean[][] matrix) {
        var board = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {

                for (int k = 1; k >= -1; k--) {
                    for (int l = -1; l <= 1; l++) {
                        if (k == 0 && l == 0)
                            continue;

                        try {
                            board[i][j] = matrix[i + l][j + k] ? ++board[i][j] : board[i][j];
                        } catch (IndexOutOfBoundsException e) {
                        }
                    }
                }
            }
        }

        return board;
    }

    /**
     * Given an array of integers, replace all the occurrences of elemToReplace with substitutionElem.
     */
    public static int[] arrayReplace(int[] inputArray, int elemToReplace, int substitutionElem) {
        for (int i = 0; i < inputArray.length; i++) {
            if (inputArray[i] == elemToReplace) {
                inputArray[i] = substitutionElem;
            }
        }

        return inputArray;
    }

    public static boolean evenDigitsOnly(int n) {
        while (n > 0) {
            if (n % 10 % 2 != 0)
                return false;
            n /= 10;
        }
        return true;
    }

    /**
     * Correct variable names consist only of English letters, digits and underscores and they can't start with a
     * digit.
     * <p>
     * Check if the given string is a correct variable name.
     */
    public static boolean variableName(String name) {
        return !Character.isDigit(name.charAt(0)) && name.matches("(?i)[a-z0-9_]+");
    }

    /**
     * Given a string, your task is to replace each of its characters by the next one in the English alphabet; i.e.
     * replace a with b, replace b with c, etc (z would be replaced by a).
     *
     * @param input A non-empty string consisting of lowercase English characters.
     *
     * @return The resulting string after replacing each of its characters.
     */
    public static String alphabeticShift(String input) {
        return input.chars().mapToObj(c -> Character.toString(c == 'z' ? 'a' : ++c)).collect(Collectors.joining());
    }

    /**
     * Given two cells on the standard chess board, determine whether they have the same color or not.
     */
    public static boolean chessBoardCellColor(String cell1, String cell2) {
        return cell1.charAt(0) % 2 == cell2.charAt(0) % 2
                ? cell1.charAt(1) % 2 == cell2.charAt(1) % 2
                : Math.abs(cell1.charAt(1) - cell2.charAt(1)) % 2 == 1;
    }

    /**
     * Consider integer numbers from 0 to n - 1 written down along the circle in such a way that the distance between
     * any two neighboring numbers is equal (note that 0 and n - 1 are neighboring, too).
     * <p>
     * Given n and firstNumber, find the number which is written in the radially opposite position to firstNumber.
     * <p>
     * Example
     * <p>
     * For n = 10 and firstNumber = 2, the output should be solution(n, firstNumber) = 7.
     *
     * @return
     */
    public static int circleOfNumbers(int n, int firstNumber) {
        var i = firstNumber - n / 2;
        return i < 0 ? i + n : i;
    }

    /**
     * Given an array of equal-length strings, you'd like to know if it's possible to rearrange the order of the
     * elements in such a way that each consecutive pair of strings differ by exactly one character. Return true if it's
     * possible, and false if not.
     * <p>
     * Note: You're only rearranging the order of the strings, not the order of the letters within the strings!
     *
     * @param inputArray A non-empty array of strings of lowercase letters.
     *
     * @return Return true if the strings can be reordered in such a way that each neighbouring pair of strings differ
     * by exactly one character (false otherwise).
     */
    public static boolean stringsRearrangement(String[] inputArray) {
        if (checkDistance(inputArray)) {
            return true;
        }

        int n = inputArray.length;
        int[] indexes = new int[n];

        int i = 0;
        while (i < n) {
            if (indexes[i] < i) {
                int j = i % 2 == 0 ? 0 : indexes[i];
                String tmp = inputArray[j];
                inputArray[j] = inputArray[i];
                inputArray[i] = tmp;

                if (checkDistance(inputArray)) {
                    return true;
                }
                indexes[i]++;
                i = 0;
            } else {
                indexes[i] = 0;
                i++;
            }
        }

        return false;
    }

    private static boolean checkDistance(String[] input) {
        for (int i = 1; i < input.length; i++) {
            var a = input[i - 1];
            var b = input[i];

            int distance = 0;
            for (int j = 0; j < a.length(); j++) {
                if (a.charAt(j) != b.charAt(j)) {
                    distance++;
                }
            }

            if (distance != 1) {
                return false;
            }
        }

        return true;
    }
}
