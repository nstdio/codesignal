package io.github.nstdio.codesignal.interview;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.mapping;
import static java.util.stream.Collectors.toCollection;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.stream.Stream;

public class HashTables {
    static String[][] groupingDishes(String[][] dishes) {
        return Arrays.stream(dishes)
                .flatMap(dish -> Arrays.stream(dish)
                        .skip(1)
                        .map(s -> Map.entry(s, dish[0]))
                )
                .collect(groupingBy(Map.Entry::getKey, TreeMap::new, mapping(Map.Entry::getValue, toCollection(TreeSet::new))))
                .entrySet()
                .stream()
                .filter(e -> e.getValue().size() > 1)
                .map(e -> Stream.concat(Stream.of(e.getKey()), e.getValue().stream()))
                .map(s -> s.toArray(String[]::new))
                .toArray(String[][]::new);
    }

    /**
     * Given an array strings, determine whether it follows the sequence given in the patterns array. In other words,
     * there should be no i and j for which strings[i] = strings[j] and patterns[i] ≠ patterns[j] or for which
     * strings[i] ≠ strings[j] and patterns[i] = patterns[j].
     * <p>
     * For strings = ["cat", "dog", "dog"] and patterns = ["a", "b", "b"], the output should be solution(strings,
     * patterns) = true;
     * <p>
     * For strings = ["cat", "dog", "doggy"] and patterns = ["a", "b", "b"], the output should be solution(strings,
     * patterns) = false.
     *
     * @param strings  An array of strings, each containing only lowercase English letters.
     * @param patterns An array of pattern strings, each containing only lowercase English letters.
     *
     * @return Return true if strings follows patterns and false otherwise.
     */
    static boolean areFollowingPatterns(String[] strings, String[] patterns) {
        var i2p = new HashMap<String, String>();
        var p2i = new HashMap<String, String>();

        for (int i = 0; i < strings.length; i++) {
            var item = strings[i];
            var pattern = patterns[i];

            if (!i2p.containsKey(item) && !p2i.containsKey(pattern)) {
                i2p.put(item, pattern);
                p2i.put(pattern, item);
            } else if (!pattern.equals(i2p.get(item)) || !item.equals(p2i.get(pattern))) {
                return false;
            }
        }

        return true;
    }

    /**
     * Given an array of integers nums and an integer k, determine whether there are two distinct indices i and j in the
     * array where nums[i] = nums[j] and the absolute difference between i and j is less than or equal to k.
     * <p>
     * For nums = [0, 1, 2, 3, 5, 2] and k = 3, the output should be solution(nums, k) = true. There are two 2s in nums,
     * and the absolute difference between their positions is exactly 3.
     * <p>
     * For nums = [0, 1, 2, 3, 5, 2] and k = 2, the output should be solution(nums, k) = false. The absolute difference
     * between the positions of the two 2s is 3, which is more than k.
     *
     * @param nums
     * @param k
     *
     * @return
     */
    static boolean containsCloseNums(int[] nums, int k) {
        var m = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            var idx = m.get(nums[i]);
            if (idx != null && Math.abs(i - idx) <= k) {
                return true;
            } else {
                m.put(nums[i], i);
            }
        }

        return false;
    }
}
