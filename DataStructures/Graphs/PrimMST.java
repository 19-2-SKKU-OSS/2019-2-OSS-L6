package DataStructures.Graphs;

import java.lang.*;

/**
 * 프림의 MST(최소 신장 트리) 알고리즘 자바 프로그램
 * 인접행렬로 그래프를 표현
 */
class PrimMST {
    // 그래프에 있는 정점의 개수
    private static final int V = 5;

    // 최소 키로 정점을 찾는 유용한 함수
    // MST에 아직 포함되지 않는 정점들의 집합으로 부터의 값
    int minKey(int key[], Boolean mstSet[]) {
        // 최솟값 초기화
        int min = Integer.MAX_VALUE, min_index = -1;

        for (int v = 0; v < V; v++)
            if (mstSet[v] == false && key[v] < min) {
                min = key[v];
                min_index = v;
            }

        return min_index;
    }

    // parent[]에 저장된 MST 출력하는 함수
    void printMST(int parent[], int n, int graph[][]) {
        System.out.println("Edge   Weight");
        for (int i = 1; i < V; i++)
            System.out.println(parent[i] + " - " + i + "    " +
                    graph[i][parent[i]]);
    }

    // 그래프의 MST 구성 및 출력하는 함수
    // 인접행렬 표현을 사용
    void primMST(int graph[][]) {
        // 구성한 MST를 배열에 저장
        int parent[] = new int[V];

        // 최소 가중치 edge를 고르기 위해 사용되는 키 값
        int key[] = new int[V];

        // 아직 MST에 포함되지 않은 정점들의 집합을 표현
        Boolean mstSet[] = new Boolean[V];

        // 모든 키들을 무한대로 초기화
        for (int i = 0; i < V; i++) {
            key[i] = Integer.MAX_VALUE;
            mstSet[i] = false;
        }

        // MST의 첫 정점을 항상 포함한다
        key[0] = 0;     //첫 정점으로 만들기 위해 키를 0으로 한다
        parent[0] = -1; // MST의 root는 항상 첫 노드

        // MST는 V개의 정점들을 가진다
        for (int count = 0; count < V - 1; count++) {
            // 아직 MST에 포함되지 않은 정점들의 집합으로 부터 최소 키 정점을 고른다
            int u = minKey(key, mstSet);

            // 고른 정점을 MST 집합에 추가한다
            mstSet[u] = true;

            // 키값과 인접한 부모 인덱스를 갱신
            // 아직 MST에 포함되지 않은 정점들만 고려한다
            for (int v = 0; v < V; v++)

                // graph[u][v]가 0일 때는 edge없는 경우라서 고려하지 않는다
                // 아직 MST에 포함되지 않은 정점에 대해서 mstSet[v]는 거짓 
                // graph[u][v]가 key[v]보다 작을 경우 graph[u][v]를 갱신
                if (graph[u][v] != 0 && mstSet[v] == false &&
                        graph[u][v] < key[v]) {
                    parent[v] = u;
                    key[v] = graph[u][v];
                }
        }

        // 구성된 MST를 출력한다
        printMST(parent, V, graph);
    }

    public static void main(String[] args) {
        /* 다음 그래프를 
           2    3
        (0)--(1)--(2)
        |    / \   |
        6| 8/   \5 |7
        | /      \ |
        (3)-------(4)
             9          */
        PrimMST t = new PrimMST();
        int graph[][] = new int[][]{{0, 2, 0, 6, 0},
                {2, 0, 3, 8, 5},
                {0, 3, 0, 0, 7},
                {6, 8, 0, 0, 9},
                {0, 5, 7, 9, 0},
        };

        // 결과를 출력
        t.primMST(graph);
    }
}
