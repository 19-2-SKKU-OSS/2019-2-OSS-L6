package DataStructures.Graphs;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * 그래프에서 서로 연결된 여러 구성 요소의 수를 계산하는 클래스
 *
 * @author Lukas Keul, Florian Mercks
 */
class Graph<E extends Comparable<E>> {

    class Node {
        E name;

        public Node(E name) {
            this.name = name;
        }
    }

    class Edge {
        Node startNode, endNode;

        public Edge(Node startNode, Node endNode) {
            this.startNode = startNode;
            this.endNode = endNode;
        }
    }

    ArrayList<Edge> edgeList;
    ArrayList<Node> nodeList;

    public Graph() {
        edgeList = new ArrayList<Edge>();
        nodeList = new ArrayList<Node>();
    }

    /**
     * 노드가 아직 nodeList에 없는 경우, 그래프에 새로운 Edge를 추가한다
     * 
     *
     * @param startNode Edge의 시작 노드
     * @param endNode   Edge의 끝 노드
     */
    public void addEdge(E startNode, E endNode) {
        Node start = null, end = null;
        for (Node node : nodeList) {
            if (startNode.compareTo(node.name) == 0) {
                start = node;
            } else if (endNode.compareTo(node.name) == 0) {
                end = node;
            }
        }
        if (start == null) {
            start = new Node(startNode);
            nodeList.add(start);
        }
        if (end == null) {
            end = new Node(endNode);
            nodeList.add(end);
        }

        edgeList.add(new Edge(start, end));
    }

    /**
     * 연결된 구성 요소를 세는 메인 메소드 
     * 실제 노드에서 그래프의 모든 노드를 가져오기 위해 DFS(깊이 우선 탐색)를 수행하도록 노드 배열을 반복한다. 
     * 이 노드들은 배열에 추가된다
     * markedNode가 nodeList에서 선택될 때 그 노드를 무시한다 
     *
     * @return 비연결 그래프의 수를 반환
     */
    public int countGraphs() {
        int count = 0;
        Set<Node> markedNodes = new HashSet<Node>();

        for (Node n : nodeList) {
            if (!markedNodes.contains(n)) {
                markedNodes.add(n);
                markedNodes.addAll(depthFirstSearch(n, new ArrayList<Node>()));
                count++;
            }
        }

        return count;
    }

    /**
     * DFS(깊이 우선 탐색)를 실행
     *
     * @param n       실제 방문하고 있는 노드
     * @param visited DFS에서 이미 방문한 노드
     * @return 방문한 노드들의 집합을 반환
     */
    public ArrayList<Node> depthFirstSearch(Node n, ArrayList<Node> visited) {
        visited.add(n);
        for (Edge e : edgeList) {
            if (e.startNode.equals(n) && !visited.contains(e.endNode)) {
                depthFirstSearch(e.endNode, visited);
            }
        }
        return visited;
    }
}

public class ConnectedComponent {

    public static void main(String[] args) {
        Graph graphChars = new Graph();

        // Graph 1
        graphChars.addEdge('a', 'b');
        graphChars.addEdge('a', 'e');
        graphChars.addEdge('b', 'e');
        graphChars.addEdge('b', 'c');
        graphChars.addEdge('c', 'd');
        graphChars.addEdge('d', 'a');

        graphChars.addEdge('x', 'y');
        graphChars.addEdge('x', 'z');

        graphChars.addEdge('w', 'w');

        Graph graphInts = new Graph();

        // Graph 2
        graphInts.addEdge(1, 2);
        graphInts.addEdge(2, 3);
        graphInts.addEdge(2, 4);
        graphInts.addEdge(3, 5);

        graphInts.addEdge(7, 8);
        graphInts.addEdge(8, 10);
        graphInts.addEdge(10, 8);

        System.out.println("Amount of different char-graphs: " + graphChars.countGraphs());
        System.out.println("Amount of different int-graphs: " + graphInts.countGraphs());
    }
}
