package kuckse.java.algorithms;

import org.hamcrest.Matchers;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;

public class SmallestTrieTest {

    @Test
    public void testSmallestTrie() throws Exception {
        assertThat(SmallestTrie.leastNodes("cba", "abc", "bca", "bac"), equalTo(4));
        assertThat(SmallestTrie.leastNodes("bdi", "dbf", "bld", "bop"), equalTo(8));
    }
}