package io.github.nstdio.codesignal;

import static io.github.nstdio.codesignal.Challenge.delivery;
import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class ChallengeTest {

    @Test
    void testDelivery() {
        assertThat(delivery(new int[]{200, 20, 15}, new int[][]{{300, 40, 5}, {600, 40, 10}}))
                .isEqualTo(new boolean[]{false, true});
    }
}