package kuckse.java.algorithms;

import org.apache.commons.io.FileUtils;
import org.junit.Test;
import org.springframework.core.io.ClassPathResource;

import java.io.IOException;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Map;

public class KargerMinCutTest {
    private KargerMinCut minCut = new KargerMinCut();

    @Test
    public void testSmall1() throws Exception {
        //given
        Map<Integer, int[]> graph = getGraph();

        //when


        //then

    }

    private Map<Integer, int[]> getGraph() throws IOException {
        final List<String> s = FileUtils.readLines(new ClassPathResource("kargerMinCut.txt").getFile(), Charset.defaultCharset());
        return null;
    }
}
