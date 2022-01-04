package io.github.nstdio.codesignal.interview;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

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
}