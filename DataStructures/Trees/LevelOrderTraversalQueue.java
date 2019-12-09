package DataStructures.Trees;

import java.util.Queue;
import java.util.LinkedList;


/* 레벨순으로 출력하기 위한 클래스(level order traversal) */
public class LevelOrderTraversalQueue {

    /* 트리의 노드를 나타내는 클래스*/
    class Node {
        int data;
        Node left, right;

        public Node(int item) {
            data = item;
            left = null;
            right = null;
        }
    }

    Node root;

    /* 주어진 이진 트리에서
       큐로 구현된 배열을 사용해서 
       레벨 순으로 노드들을 출력한다  */
    void printLevelOrder() {
        Queue<Node> queue = new LinkedList<Node>();
        queue.add(root);
        while (!queue.isEmpty()) {
 
            /* poll()는 현제의 head를 제거하는 함수이다.
            poll()에 대한 더 많은 정보는 아래의 링크를 참고해라
            http://www.tutorialspoint.com/java/util/linkedlist_poll.htm */
            Node tempNode = queue.poll();
            System.out.print(tempNode.data + " ");

            /*왼쪽 자식을 큐에 넣는다 */
            if (tempNode.left != null) {
                queue.add(tempNode.left);
            }

            /*오른쪽 자식을 큐에 넣는다 */
            if (tempNode.right != null) {
                queue.add(tempNode.right);
            }
        }
    }
}
