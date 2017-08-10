package kuckse.java.algorithms;

import com.sun.corba.se.impl.orbutil.graph.Graph;

import java.util.List;
import java.util.Objects;
import java.util.Random;
import java.util.Set;

public class KargerMinCut {
    public int calculate(Graph graph) {
        int numVertices = graph.numVertices;
        final Random random = new Random();
        while(numVertices > 2) {
            random.nextInt(graph.numEdges);
        }
        return 0;
    }

    public static class Edge {
        public int src;
        public int dest;

        public Edge(int src, int dest) {
            this.src = src;
            this.dest = dest;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Edge edge = (Edge) o;
            return src == edge.src &&
                    dest == edge.dest;
        }

        @Override
        public int hashCode() {
            return Objects.hash(src, dest);
        }
    }

    public static class Graph {
        public List<Edge> edges;
        public int numEdges;
        public int numVertices;

        public Graph(List<Edge> edges, int numVertices) {
            this.edges = edges;
            this.numEdges = edges.size();
            this.numVertices = numVertices;
        }
    }
}
