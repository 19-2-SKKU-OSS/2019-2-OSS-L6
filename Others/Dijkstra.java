package Others;


/**
 * Dijkstra's algorithm,is a graph search algorithm that solves the single-source
 * shortest path problem for a graph with nonnegative edge path costs, producing
 * a shortest path tree.
 * <p>
 * NOTE:  The inputs to Dijkstra's algorithm are a directed and weighted graph consisting
 * of 2 or more nodes, generally represented by an adjacency matrix or list, and a start node.
 * <p>
 * Original source of code: https://rosettacode.org/wiki/Dijkstra%27s_algorithm#Java
 * Also most of the comments are from RosettaCode.
 * 다익스트라 알고리즘: 하나의 시작 정점으로부터 모든 다른 정점까지의 최단 경로
를 찾는 알고리즘.
 */

import java.util.*;

public class Dijkstra {
    private static final Graph.Edge[] GRAPH = {
            new Graph.Edge("a", "b", 7), //노드 a와 b의 거리가 7이다.
            new Graph.Edge("a", "c", 9),
            new Graph.Edge("a", "f", 14),
            new Graph.Edge("b", "c", 10),
            new Graph.Edge("b", "d", 15),
            new Graph.Edge("c", "d", 11),
            new Graph.Edge("c", "f", 2),
            new Graph.Edge("d", "e", 6),
            new Graph.Edge("e", "f", 9),
    };
    private static final String START = "a";
    private static final String END = "e";

    public static void main(String[] args) {
        Graph g = new Graph(GRAPH);
        g.dijkstra(START);
        g.printPath(END);
    }
}

class Graph {
    private final Map<String, Vertex> graph;

    public static class Edge {
        public final String v1, v2;
        public final int dist;

        public Edge(String v1, String v2, int dist) {
            this.v1 = v1;
            this.v2 = v2;
            this.dist = dist;
        }
    }

    public static class Vertex implements Comparable<Vertex> {
        public final String name;
        public int dist = Integer.MAX_VALUE;
        public Vertex previous = null;
        public final Map<Vertex, Integer> neighbours = new HashMap<>();

        public Vertex(String name) {
            this.name = name;
        }

        private void printPath() {
            if (this == this.previous) {
                System.out.printf("%s", this.name);
            } else if (this.previous == null) {
                System.out.printf("%s(unreached)", this.name);
            } else {
                this.previous.printPath();
                System.out.printf(" -> %s(%d)", this.name, this.dist);
            }
        }

        public int compareTo(Vertex other) {
            if (dist == other.dist)
                return name.compareTo(other.name);

            return Integer.compare(dist, other.dist);
        }

        @Override
        public String toString() {
            return "(" + name + ", " + dist + ")";
        }
    }

    /**
     * Builds a graph from a set of edges
     */
    public Graph(Edge[] edges) {
        graph = new HashMap<>(edges.length);

        //모든 노드
        for (Edge e : edges) {
            if (!graph.containsKey(e.v1)) graph.put(e.v1, new Vertex(e.v1));
            if (!graph.containsKey(e.v2)) graph.put(e.v2, new Vertex(e.v2));
        }

        //다른 노드
        for (Edge e : edges) {
            graph.get(e.v1).neighbours.put(graph.get(e.v2), e.dist);
        }
    }

    public void dijkstra(String startName) {
        if (!graph.containsKey(startName)) {
            System.err.printf("Graph doesn't contain start vertex \"%s\"\n", startName);
            return;
        }
        final Vertex source = graph.get(startName);
        NavigableSet<Vertex> q = new TreeSet<>();

        for (Vertex v : graph.values()) {
            v.previous = v == source ? source : null;
            v.dist = v == source ? 0 : Integer.MAX_VALUE;
            q.add(v);
        }

        dijkstra(q);
    }

    private void dijkstra(final NavigableSet<Vertex> q) {
        Vertex u, v;
        while (!q.isEmpty()) {
            u = q.pollFirst();
            if (u.dist == Integer.MAX_VALUE)
                break;
            for (Map.Entry<Vertex, Integer> a : u.neighbours.entrySet()) {
                v = a.getKey(); //이웃

                final int alternateDist = u.dist + a.getValue();
                if (alternateDist < v.dist) { //이웃에게서의 최단 경로
                    q.remove(v);
                    v.dist = alternateDist;
                    v.previous = u;
                    q.add(v);
                }
            }
        }
    }

    public void printPath(String endName) {
        if (!graph.containsKey(endName)) {
            System.err.printf("Graph doesn't contain end vertex \"%s\"\n", endName);
            return;
        }

        graph.get(endName).printPath();
        System.out.println();
    }

    public void printAllPaths() {
        for (Vertex v : graph.values()) {
            v.printPath();
            System.out.println();
        }
    }
}
