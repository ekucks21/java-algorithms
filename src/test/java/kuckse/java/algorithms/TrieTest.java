package kuckse.java.algorithms;

import com.googlecode.totallylazy.Segment;
import org.hamcrest.Matchers;
import org.junit.Test;

import static com.googlecode.totallylazy.Segment.constructors.characters;
import static org.junit.Assert.*;

public class TrieTest {

    @Test
    public void testSize() throws Exception {
        assertThat(Trie.<Character, String>trie().put(characters("abc"), null).size(), Matchers.equalTo(4));
        assertThat(Trie.<Character, String>trie()
                .put(characters("abc"), null)
                .put(characters("abde"), null).size(), Matchers.equalTo(6));
        assertThat(Trie.<Character, String>trie()
                .put(characters("abc"), null)
                .put(characters("fij"), null).size(), Matchers.equalTo(7));
    }
}