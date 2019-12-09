package DataStructures.Trees;

public class ValidBSTOrNot {

    class Node {
        int data;
        Node left, right;

        public Node(int item) {
            data = item;
            left = right = null;
        }
    }

    //이진 트리의 루트
    Node root;
 
    /* 코드에 따라 최소 및 최대값을 줄 수 있습니다.
       또는 트리의 최소 최대 값을 찾는 함수를 작성할 수 있습니다. */

    /* 만약 주어진 트리가 이진 탐색 트리(효율 좋은 버전)일 경우 참을 반환
      */
    boolean isBST() {
        return isBSTUtil(root, Integer.MIN_VALUE,
                Integer.MAX_VALUE);
    }

    /* 만약 주어진 트리가 이진 탐색 트리(BST)이고 
       그것의 값들이 min보다 크고 max보다 작을 경우 참을 반환한다*/
    boolean isBSTUtil(Node node, int min, int max) {
        /* an empty tree is BST */
        if (node == null)
            return true;

        /* 만약 이 노드가 제한 밖이라면 거짓을 반환한다 */
        if (node.data < min || node.data > max)
            return false;
 
        /* 아닌경우 서브트리들을 재귀적으로 
           min/max 제한에 맞는지 검사한다*/
        // 제한에 맞는 값만 반환한다
        return (isBSTUtil(node.left, min, node.data - 1) &&
                isBSTUtil(node.right, node.data + 1, max));
    }
}
