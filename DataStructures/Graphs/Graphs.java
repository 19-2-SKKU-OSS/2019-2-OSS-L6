package DataStructures.Graphs;

import java.util.ArrayList;
import java.lang.StringBuilder;

class AdjacencyListGraph<E extends Comparable<E>> {

    ArrayList<Vertex> verticies;

    public AdjacencyListGraph() {
        verticies = new ArrayList<>();
    }

    private class Vertex {
        E data;
        ArrayList<Vertex> adjacentVerticies;

        public Vertex(E data) {
            adjacentVerticies = new ArrayList<>();
            this.data = data;
        }

        public boolean addAdjacentVertex(Vertex to) {
            for (Vertex v : adjacentVerticies) {
                if (v.data.compareTo(to.data) == 0) {
                    return false; // 이미 존재하는 Edge
                }
            }
            return adjacentVerticies.add(to); // 이것은 참을 반환한다
        }

        public boolean removeAdjacentVertex(E to) {
            // 여기서 인덱스를 사용하여 ArrayList.remove 메소드를 사용하지 않고 제거할 수 있다
            for (int i = 0; i < adjacentVerticies.size(); i++) {
                if (adjacentVerticies.get(i).data.compareTo(to) == 0) {
                    adjacentVerticies.remove(i);
                    return true;
                }
            }
            return false;
        }
    }

    /**
     * 특정한 두 정점 사이의 edge를 삭제하는 메소드     
     * @param from edge가 시작하는 vertex의 데이터
     * @param to   edge가 끝나는 vertex의 데이터
     * @return edge가 존재하지 않으면 거짓을 반환, 존재한다면 참을 반환하고 삭제 
     */
    public boolean removeEdge(E from, E to) {
        Vertex fromV = null;
        for (Vertex v : verticies) {
            if (from.compareTo(v.data) == 0) {
                fromV = v;
                break;
            }
        }
        if (fromV == null) return false;
        return fromV.removeAdjacentVertex(to);
    }

    /**
     * 특정한 두 정점 사이의 edge를 추가하는 메소드     
     * @param from edge가 시작하는 정점의 데이터
     * @param to   edge가 끝나는 정점의 데이터
     * @return edge가 존재하지 않을 경우 참을 반환, 아닐 경우 거짓을 반환
     */
    public boolean addEdge(E from, E to) {
        Vertex fromV = null, toV = null;
        for (Vertex v : verticies) {
            if (from.compareTo(v.data) == 0) { // 만약 시작 정점이 이미 있을 경우
                fromV = v;
            } else if (to.compareTo(v.data) == 0) { // 만약 끝 정점이 이미 있을 경우
                toV = v;
            }
            if (fromV != null && toV != null) break; // 두 노드가 있어서 검색을 종료
        }
        if (fromV == null) {
            fromV = new Vertex(from);
            verticies.add(fromV);
        }
        if (toV == null) {
            toV = new Vertex(to);
            verticies.add(toV);
        }
        return fromV.addAdjacentVertex(toV);
    }

    /**
     * 이것은 정점의 목록과 이웃들을 제공한다
     *
     * @return 이 그래프를 나타내는 문자열 반환
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Vertex v : verticies) {
            sb.append("Vertex: ");
            sb.append(v.data);
            sb.append("\n");
            sb.append("Adjacent verticies: ");
            for (Vertex v2 : v.adjacentVerticies) {
                sb.append(v2.data);
                sb.append(" ");
            }
            sb.append("\n");
        }
        return sb.toString();
    }
}

public class Graphs {

    public static void main(String args[]) {
        AdjacencyListGraph<Integer> graph = new AdjacencyListGraph<>();
        assert graph.addEdge(1, 2);
        assert graph.addEdge(1, 5);
        assert graph.addEdge(2, 5);
        assert !graph.addEdge(1, 2);
        assert graph.addEdge(2, 3);
        assert graph.addEdge(3, 4);
        assert graph.addEdge(4, 1);
        assert !graph.addEdge(2, 3);
        System.out.println(graph);
    }

}
