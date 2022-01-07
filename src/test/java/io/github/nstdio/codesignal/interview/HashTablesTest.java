package io.github.nstdio.codesignal.interview;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

import java.util.List;

class HashTablesTest {

    @Test
    void testGroupDishes() {
        assertThat(HashTables.groupingDishes(new String[][]{
                {"Salad", "Tomato", "Cucumber", "Salad", "Sauce"},
                {"Pizza", "Tomato", "Sausage", "Sauce", "Dough"},
                {"Quesadilla", "Chicken", "Cheese", "Sauce"},
                {"Sandwich", "Salad", "Bread", "Tomato", "Cheese"}
        }))
                .isEqualTo(new String[][]{
                        {"Cheese", "Quesadilla", "Sandwich"},
                        {"Salad", "Salad", "Sandwich"},
                        {"Sauce", "Pizza", "Quesadilla", "Salad"},
                        {"Tomato", "Pizza", "Salad", "Sandwich"}
                });
    }

    @Test
    void testAreFollowingPatterns() {
        assertTrue(HashTables.areFollowingPatterns(new String[]{"re",
                "jjinh",
                "rnz",
                "frok",
                "frok",
                "hxytef",
                "hxytef",
                "frok"}, new String[]{"kzfzmjwe",
                "fgbugiomo",
                "ocuijka",
                "gafdrts",
                "gafdrts",
                "ebdva",
                "ebdva",
                "gafdrts"}));
        assertFalse(HashTables.areFollowingPatterns(new String[]{"cat", "dog", "doggy"}, new String[]{"a", "b", "b"}));
    }

    @Test
    void testContainsCloseNums() {
        assertTrue(HashTables.containsCloseNums(new int[]{0, 1, 2, 3, 5, 2}, 3));
        assertFalse(HashTables.containsCloseNums(new int[]{0, 1, 2, 3, 5, 2}, 2));
        assertFalse(HashTables.containsCloseNums(new int[]{}, 0));
        assertTrue(HashTables.containsCloseNums(new int[]{99, 99}, 2));
    }

    @Test
    void testPossibleSums() {
        assertThat(HashTables.possibleSums(new int[]{1, 2, 3}, new int[]{1, 2})).isEqualTo(5);

        assertThat(HashTables.possibleSums(new int[]{10, 50, 100}, new int[]{1, 2, 1})).isEqualTo(9);

        assertThat(HashTables.possibleSums(new int[]{1, 2, 3}, new int[]{1, 1, 1})).isEqualTo(6);
        assertThat(HashTables.possibleSums(new int[]{10, 20, 30}, new int[]{1, 1, 1})).isEqualTo(6);
    }
}