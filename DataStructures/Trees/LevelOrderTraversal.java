package DataStructures.Trees;

public class LevelOrderTraversal {

    class Node {
        int data;
        Node left, right;

        public Node(int item) {
            data = item;
            left = right = null;
        }
    }

    // 이진 트리의 루트
    Node root;

    public LevelOrderTraversal() {
        root = null;
    }

    /* 트리를 레벨 순으로 출력하는 함수(level order traversal)*/
    void printLevelOrder() {
        int h = height(root);
        int i;
        for (i = 1; i <= h; i++)
            printGivenLevel(root, i);
    }

    /* 트리의 높이를 게산한다 --
     * 루트 노드에서 가장 먼 리프 노드까지 
     * 아래로 내려가는 가장 긴 경로의 노드의 수.
     
   */
    int height(Node root) {
        if (root == null)
            return 0;
        else {
            /**
             * 더 큰 서브트리의 높이를 반환한다
             */
            return Math.max(height(root.left), height(root.right)) + 1;
        }
    }

    /* 주어진 레벨에서 노드를 출력 */
    void printGivenLevel(Node root, int level) {
        if (root == null)
            return;
        if (level == 1)
            System.out.print(root.data + " ");
        else if (level > 1) {
            printGivenLevel(root.left, level - 1);
            printGivenLevel(root.right, level - 1);
        }
    }
}
