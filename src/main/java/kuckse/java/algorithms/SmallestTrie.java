package kuckse.java.algorithms;

import com.googlecode.totallylazy.*;
import com.googlecode.totallylazy.numbers.Num;

import java.util.Map;
import java.util.function.Consumer;
import java.util.stream.Collectors;

import static com.googlecode.totallylazy.Callables.second;
import static com.googlecode.totallylazy.Maps.asMap;
import static com.googlecode.totallylazy.Maps.map;
import static com.googlecode.totallylazy.Segment.constructors.characters;
import static com.googlecode.totallylazy.Sequences.sequence;
import static com.googlecode.totallylazy.Strings.join;
import static com.googlecode.totallylazy.numbers.Numbers.add;

public class SmallestTrie {
    public static Number leastNodes(String... strings) {
        final Map<Character, Integer> frequencyByCharacter = sequence(strings)
                .flatMap(string -> getCharSequence(string))
                .map(achar -> charAndFrequency(achar, strings))
                .map(charAndFrequency -> charAndFrequency.second(frequency -> frequency * 1000 + (charAndFrequency.first() - 'a')))
                .fold(map(), asMap());
        final Sequence<String> sortedStrings = sequence(strings)
                .map(string -> getCharSequence(string)
                        .sort((char1, char2) -> frequencyByCharacter.get(char1).compareTo(frequencyByCharacter.get(char2)))
                        .reverse()
                        .map(achar -> achar.toString())
                        .reduce(join));
        return sortedStrings.fold(Trie.<Character, String>trie(), (trie, string) -> trie.put(characters(string), null)).size();
    }

    private static Pair<Character, Integer> charAndFrequency(Character achar, String[] strings) {
        return Pair.pair(achar, sequence(strings).map(string -> (string.indexOf(achar) == -1) ? 0 : 1).reduce(add).intValue());
    }

    private static Sequence<Character> getCharSequence(String string) {
        return sequence(string.chars().mapToObj(charInt -> new Character((char) charInt)).collect(Collectors.toList()));
    }
}
