package kuckse.java.algorithms;

import org.hamcrest.Matchers;
import org.junit.Test;

import static org.hamcrest.Matchers.equalTo;
import static org.junit.Assert.*;

public class SmallestTrieTest {

    @Test
    public void testSmallestTrie() throws Exception {
        //when
        final int leastNodes = SmallestTrie.leastNodes("cba", "abc", "bca", "bac");

        //then
        assertThat(leastNodes, equalTo(3));
    }
}