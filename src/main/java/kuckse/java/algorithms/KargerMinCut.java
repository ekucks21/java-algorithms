package kuckse.java.algorithms;

import java.util.*;

public class KargerMinCut {
    public int calculate(Graph graph) {
        double numTries = Math.pow(graph.numVertices, 2) * (Math.log(graph.numVertices) / Math.log(2));
        int minCut = 0;
        for (int i = 0; i < numTries; i++) {
            
        }
        return randomCut(graph);
    }

    private int randomCut(Graph graph) {
        int numVertices = graph.numVertices;
        final Random random = new Random();
        final ArrayList<Subset> subsets = new ArrayList<>(graph.numVertices);
        for (int i = 0; i < numVertices; i++) {
            subsets.add(i, new Subset(0, i));
        }
        while(numVertices > 2) {
            final Edge edgeToRemove = graph.edges.get(random.nextInt(graph.numEdges));
            if(find(subsets, edgeToRemove.dest) != find(subsets, edgeToRemove.src)) {
                numVertices--;
                union(subsets, edgeToRemove.dest, edgeToRemove.src);
            }
        }

        int numCrossingEdges = 0;
        for (int i = 0; i < graph.numEdges; i++) {
            if (find(subsets, graph.edges.get(i).dest) != find(subsets, graph.edges.get(i).src)) {
                numCrossingEdges++;
            }
        }
        return numCrossingEdges;
    }

    private void union(ArrayList<Subset> subsets, int x, int y) {
        int xroot = find(subsets, x);
        int yroot = find(subsets, y);

        if(subsets.get(xroot).rank > subsets.get(yroot).rank) {
            subsets.get(yroot).parent = xroot;
        } else if(subsets.get(yroot).rank > subsets.get(xroot).rank){
            subsets.get(xroot).parent = yroot;
        } else {
            subsets.get(xroot).rank++;
            subsets.get(yroot).parent = xroot;
        }
    }

    private int find(ArrayList<Subset> subsets, int x) {
        int parent = subsets.get(x).parent;
        if(parent != x) {
            parent = find(subsets, parent);
            subsets.get(x).parent = parent;
        }
        return parent;
    }

    public static class Subset {
        public int rank;
        public int parent;

        public Subset(int rank, int parent) {
            this.rank = rank;
            this.parent = parent;
        }
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
