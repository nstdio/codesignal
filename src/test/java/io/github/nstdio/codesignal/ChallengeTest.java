package io.github.nstdio.codesignal;

import static io.github.nstdio.codesignal.Challenge.delivery;
import static io.github.nstdio.codesignal.Challenge.domainForwarding;
import static io.github.nstdio.codesignal.Challenge.shoppingList;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

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

    @Test
    void testDomainForwarding() {
        assertThat(domainForwarding(new String[][]{
                {"d2", "d1"},
                {"d3", "d2"},
                {"d4", "d2"},
                {"d5", "d2"},
                {"d6", "d3"},
                {"d7", "d3"}
        }))
                .isEqualTo(new String[][]{
                        {"d1", "d2", "d3", "d4", "d5", "d6", "d7"}
                });

        assertThat(domainForwarding(new String[][]{
                {"a-b.c", "a.c"},
                {"aa-b.c", "a-b.c"},
                {"bb-b.c", "a-b.c"},
                {"cc-b.c", "a-b.c"},
                {"d-cc-b.c", "bb-b.c"},
                {"e-cc-b.c", "bb-b.c"}
        }))
                .isEqualTo(new String[][]{
                        {"a-b.c", "a.c", "aa-b.c", "bb-b.c", "cc-b.c", "d-cc-b.c", "e-cc-b.c"}
                });

        assertThat(domainForwarding(new String[][]{
                {"c", "d"},
                {"f", "b"},
        })).isEqualTo(new String[][]{
                {"b", "f"},
                {"c", "d"}
        });

        assertThat(domainForwarding(new String[][]{
                {"d1", "d4"},
                {"d2", "d1"},
                {"d3", "d1"},
                {"d4", "d5"},
        }))
                .isEqualTo(new String[][]{
                        {"d1", "d2", "d3", "d4", "d5"}
                });

        assertThat(domainForwarding(new String[][]{
                {"d2", "d1"},
                {"d3", "d1"},
                {"d1", "d4"},
                {"d4", "d5"},
        }))
                .isEqualTo(new String[][]{
                        {"d1", "d2", "d3", "d4", "d5"}
                });

        assertThat(domainForwarding(new String[][]{
                {"d2", "d1"},
                {"d3", "d1"},
                {"d1", "d4"},
        }))
                .isEqualTo(new String[][]{
                        {"d1", "d2", "d3", "d4"}
                });

        assertThat(domainForwarding(new String[][]{
                {"d2", "d1"},
                {"d3", "d1"},
        }))
                .isEqualTo(new String[][]{
                        {"d1", "d2", "d3"}
                });

        assertThat(domainForwarding(new String[][]{
                {"d1", "d2"},
                {"d2", "d3"},
                {"d3", "d4"},
                {"d4", "d5"},
        }))
                .isEqualTo(new String[][]{
                        {"d1", "d2", "d3", "d4", "d5"}
                });

        assertThat(domainForwarding(new String[][]{
                {"d2", "d3"},
                {"d1", "d2"},
                {"d4", "d5"},
        })).isEqualTo(new String[][]{
                {"d1", "d2", "d3"},
                {"d4", "d5"}
        });

        assertThat(domainForwarding(new String[][]{
                {"d1", "d2"},
                {"d2", "d3"},
                {"d4", "d5"},
                {"d6", "d7"},
        }))
                .isEqualTo(new String[][]{
                        {"d1", "d2", "d3"},
                        {"d4", "d5"},
                        {"d6", "d7"},
                });


        assertThat(domainForwarding(new String[][]{
                {"godaddy.net", "godaddy.com"},
                {"godaddy.org", "godaddycares.com"},
                {"godady.com", "godaddy.com"},
                {"godaddy.ne", "godaddy.net"}
        }))
                .isEqualTo(new String[][]{
                        {"godaddy.com", "godaddy.ne", "godaddy.net", "godady.com"},
                        {"godaddy.org", "godaddycares.com"}
                });
    }

    @Test
    void testTyposquatting() {
        assertEquals(-1, Challenge.typosquatting(3, "ab.ab"));
        assertEquals(-1, Challenge.typosquatting(2, "a.ab"));

        assertEquals(-1, Challenge.typosquatting(0, "aaa.aaa"));
        assertEquals(-1, Challenge.typosquatting(10, "aaa.aaa"));

        assertEquals(2, Challenge.typosquatting(9, "omg.tv"));
        assertEquals(1, Challenge.typosquatting(7, "godaddy.com"));
        assertEquals(1, Challenge.typosquatting(8, "godaddy.com"));
        assertEquals(0, Challenge.typosquatting(1, "godaddy.com"));
        assertEquals(0, Challenge.typosquatting(0, "godaddy.com"));
        assertEquals(2, Challenge.typosquatting(85, "godaddy.godaddy.com"));
        assertEquals(2, Challenge.typosquatting(85, "godaddy.godaddy.com"));
    }

    @Test
    void testBlockStorageRewrites() {
        assertThat(Challenge.blockStorageRewrites(7, new int[][]{
                {1, 1},
                {1, 2},
                {1, 3},
                {1, 4},
                {1, 5},
                {5, 6},
                {6, 6},
                {6, 6},
        }, 3))
                .isEqualTo(new int[][]{{1, 3}, {6, 6}});

        assertThat(Challenge.blockStorageRewrites(10, new int[][]{{0, 4}, {3, 5}, {2, 6}}, 2))
                .isEqualTo(new int[][]{{2, 5}});
        assertThat(Challenge.blockStorageRewrites(1, new int[][]{
                {0, 0},
                {0, 0},
                {0, 0},
                {0, 0},
                {0, 0},
                {0, 0},
        }, 2))
                .isEqualTo(new int[][]{{0, 0}});

        assertThat(Challenge.blockStorageRewrites(10, new int[][]{{0, 4}, {3, 5}, {2, 6}}, 3))
                .isEqualTo(new int[][]{{3, 4}});

        assertThat(Challenge.blockStorageRewrites(10, new int[][]{{3, 4}, {0, 1}, {6, 6}}, 1))
                .isEqualTo(new int[][]{{0, 1}, {3, 4}, {6, 6}});
        assertThat(Challenge.blockStorageRewrites(1, new int[][]{}, 1))
                .isEqualTo(new int[][]{});
    }
}