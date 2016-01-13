package kuckse.java.algorithms;

import com.googlecode.totallylazy.Segment;
import org.hamcrest.Matchers;
import org.junit.Test;

import static com.googlecode.totallylazy.Segment.constructors.characters;
import static org.junit.Assert.*;

public class TrieTest {

    @Test
    public void testSize() throws Exception {
        assertThat(Trie.<Character, String>trie().put(characters("abc"), null).size(), Matchers.equalTo(3));
    }
}