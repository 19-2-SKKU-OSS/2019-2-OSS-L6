package DataStructures.Graphs;

public class MatrixGraphs {

    public static void main(String args[]) {
        AdjacencyMatrixGraph graph = new AdjacencyMatrixGraph(10);
        graph.addEdge(1, 2);
        graph.addEdge(1, 5);
        graph.addEdge(2, 5);
        graph.addEdge(1, 2);
        graph.addEdge(2, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 1);
        graph.addEdge(2, 3);
        System.out.println(graph);
    }

}

class AdjacencyMatrixGraph {
    private int _numberOfVertices;
    private int _numberOfEdges;
    private int[][] _adjacency;

    static final int EDGE_EXIST = 1;
    static final int EDGE_NONE = 0;

    public AdjacencyMatrixGraph(int givenNumberOfVertices) {
        this.setNumberOfVertices(givenNumberOfVertices);
        this.setNumberOfEdges(0);
        this.setAdjacency(new int[givenNumberOfVertices][givenNumberOfVertices]);
        for (int i = 0; i < givenNumberOfVertices; i++) {
            for (int j = 0; j < givenNumberOfVertices; j++) {
                this.adjacency()[i][j] = AdjacencyMatrixGraph.EDGE_NONE;
            }
        }
    }

    private void setNumberOfVertices(int newNumberOfVertices) {
        this._numberOfVertices = newNumberOfVertices;
    }

    public int numberOfVertices() {
        return this._numberOfVertices;
    }

    private void setNumberOfEdges(int newNumberOfEdges) {
        this._numberOfEdges = newNumberOfEdges;
    }

    public int numberOfEdges() {
        return this._numberOfEdges;
    }

    private void setAdjacency(int[][] newAdjacency) {
        this._adjacency = newAdjacency;
    }

    private int[][] adjacency() {
        return this._adjacency;
    }

    private boolean adjacencyOfEdgeDoesExist(int from, int to) {
        return (this.adjacency()[from][to] != AdjacencyMatrixGraph.EDGE_NONE);
    }

    public boolean vertexDoesExist(int aVertex) {
        if (aVertex >= 0 && aVertex < this.numberOfVertices()) {
            return true;
        } else {
            return false;
        }
    }

    public boolean edgeDoesExist(int from, int to) {
        if (this.vertexDoesExist(from) && this.vertexDoesExist(to)) {
            return (this.adjacencyOfEdgeDoesExist(from, to));
        }

        return false;
    }

    /**
      * 특정한 두 정점 사이의 edge를 추가하는 메소드     
     * @param from edge가 시작하는 정점의 데이터
     * @param to   edge가 끝나는 정점의 데이터
     * @return edge가 존재하지 않을 경우 참을 반환, 아닐 경우 거짓을 반환
     */
    public boolean addEdge(int from, int to) {
        if (this.vertexDoesExist(from) && this.vertexDoesExist(to)) {
            if (!this.adjacencyOfEdgeDoesExist(from, to)) {
                this.adjacency()[from][to] = AdjacencyMatrixGraph.EDGE_EXIST;
                this.adjacency()[to][from] = AdjacencyMatrixGraph.EDGE_EXIST;
                this.setNumberOfEdges(this.numberOfEdges() + 1);
                return true;
            }
        }

        return false;
    }

    /**
     * 특정한 두 정점 사이의 edge를 삭제하는 메소드     
     * @param from edge가 시작하는 vertex의 데이터
     * @param to   edge가 끝나는 vertex의 데이터
     * @return edge가 존재하지 않으면 거짓을 반환, 존재한다면 참을 반환하고 삭제
     */
    public boolean removeEdge(int from, int to) {
        if (!this.vertexDoesExist(from) || !this.vertexDoesExist(to)) {
            if (this.adjacencyOfEdgeDoesExist(from, to)) {
                this.adjacency()[from][to] = AdjacencyMatrixGraph.EDGE_NONE;
                this.adjacency()[to][from] = AdjacencyMatrixGraph.EDGE_NONE;
                this.setNumberOfEdges(this.numberOfEdges() - 1);
                return true;
            }
        }
        return false;
    }

    /**
     * 이것은 정점의 목록과 이웃들을 제공한다
     *
     * @return 이 그래프를 나타내는 문자열 반환
     */
    public String toString() {
        String s = new String();
        s = "    ";
        for (int i = 0; i < this.numberOfVertices(); i++) {
            s = s + String.valueOf(i) + " ";
        }
        s = s + " \n";

        for (int i = 0; i < this.numberOfVertices(); i++) {
            s = s + String.valueOf(i) + " : ";
            for (int j = 0; j < this.numberOfVertices(); j++) {
                s = s + String.valueOf(this._adjacency[i][j]) + " ";
            }
            s = s + "\n";
        }
        return s;
    }

}
