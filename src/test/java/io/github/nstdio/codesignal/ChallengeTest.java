package io.github.nstdio.codesignal;

import static io.github.nstdio.codesignal.Challenge.delivery;
import static io.github.nstdio.codesignal.Challenge.shoppingList;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class ChallengeTest {

    @Test
    void testDelivery() {
        assertThat(delivery(new int[]{200, 20, 15}, new int[][]{{300, 40, 5}, {600, 40, 10}}))
                .isEqualTo(new boolean[]{false, true});
    }

    @Test
    void testShoppingList() {
        assertThat(shoppingList("blue suit for 24$, cape for 12.99$ & glasses for 15.70")).isEqualTo(52.69);
        assertThat(shoppingList("Doughnuts, 4; doughnuts holes, 0.08; glue, 3.4")).isEqualTo(7.48);
        assertThat(shoppingList("")).isEqualTo(0.0);
        assertThat(shoppingList("wanna 22.2&15.3olo 0.00 and 12.12kk0.02 ..34")).isEqualTo(83.64);
        assertThat(shoppingList("Each snack for 2.21$, each drink for 1.1")).isEqualTo(3.31);
    }
}