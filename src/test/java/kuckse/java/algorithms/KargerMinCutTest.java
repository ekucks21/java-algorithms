package kuckse.java.algorithms;

import com.googlecode.totallylazy.numbers.Integers;
import kuckse.java.algorithms.KargerMinCut.Edge;
import kuckse.java.algorithms.KargerMinCut.Graph;
import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static com.google.common.collect.Sets.newHashSet;
import static com.googlecode.totallylazy.Sequences.sequence;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

public class KargerMinCutTest {
    private KargerMinCut minCutCalculator = new KargerMinCut();

    @Test
    public void testSmall1() throws Exception {
        //given
        Graph graph = getGraph("smallKargerMinCut.txt");

        //when
        int minCut = minCutCalculator.calculate(graph);

        //then
       assertThat(minCut, equalTo(2));
    }

    private Graph getGraph(String graphFile) throws IOException {
        final List<String> adjacentVerticesString = FileUtils.readLines(new ClassPathResource(graphFile).getFile(), Charset.defaultCharset());
        final Set<HashSet<Integer>> rawEdges = sequence(adjacentVerticesString)
                .map(s -> s.split("\\s+"))
                .map(ss -> sequence(ss)
                        .map(Integer::parseInt)
                        .map(i -> i--))
                .flatMap(is -> is.drop(1).map(adjacent -> newHashSet(adjacent, is.first())))
                .toSet();
        final List<Edge> edges = sequence(rawEdges)
                .map(Set::iterator)
                .map(edgeIterator -> new Edge(edgeIterator.next(), edgeIterator.next()))
                .toList();

        return new Graph(edges, adjacentVerticesString.size());
    }
}
