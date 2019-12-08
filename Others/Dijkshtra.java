package Others;

import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author Mayank K Jha
 * 다익스트라 알고리즘: 하나의 시작 정점으로부터 모든 다른 정점까지의 최단 경로를 찾는 알고리즘.
 */

public class Dijkshtra {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);

	int n = in.nextInt(); //노드의 개수 
        int m = in.nextInt(); //간선의 개수

        long[][] w = new long[n + 1][n + 1]; //인접 행렬
     
        for (long[] row : w) {
            Arrays.fill(row, 1000000L); //초기화
        }


        for (int i = 0; i < m; i++) {
            int x = in.nextInt(), y = in.nextInt(); //노드 입력
            long cmp = in.nextLong();

            if (w[x][y] > cmp) { //이전 노드 값과 현재 노드 값 비교
                w[x][y] = cmp;
                w[y][x] = cmp;
            }
        }

        //다익스트라 알고리즘
        Stack<Integer> t = new Stack<>();
        int src = in.nextInt();

        for (int i = 1; i <= n; i++) {
            if (i != src) {
                t.push(i);
            }
        }

        Stack<Integer> p = new Stack<>();
        p.push(src);
        w[src][src] = 0;

        while (!t.isEmpty()) {
            int min = 989997979;
            int loc = -1;

            for (int i = 0; i < t.size(); i++) {
                w[src][t.elementAt(i)] = Math.min(w[src][t.elementAt(i)], w[src][p.peek()] + w[p.peek()][t.elementAt(i)]);
                if (w[src][t.elementAt(i)] <= min) {
                    min = (int) w[src][t.elementAt(i)];
                    loc = i;
                }
            }
            p.push(t.elementAt(loc));
            t.removeElementAt(loc);
        }
        for (int i = 1; i <= n; i++) {
            if (i != src && w[src][i] != 1000000L) {
                System.out.print(w[src][i] + " "); //최단 경로 출력
            }
            else if (i != src) {
                System.out.print("-1" + " "); //경로가 없으면 -1출력
            }
        }
    }
}
