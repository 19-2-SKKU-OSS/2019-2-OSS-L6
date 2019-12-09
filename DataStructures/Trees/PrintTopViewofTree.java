package DataStructures.Trees;// Java program to print top view of Binary tree

import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

// 트리 노드 클래스
class TreeNode {
    // 멤버 변수들
    int key;
    TreeNode left, right;

    // 생성자
    public TreeNode(int key) {
        this.key = key;
        left = right = null;
    }
}

// 큐의 아이템을 나타내는 클래스. 큐는 레벨순 검색을 하기위해 사용(level order traversal queue를 참고)
// 모든 큐의 아이템들은 노드와 horizontal을 멤버 변수로 가지고 있다
// distance of node from root
class QItem {
    TreeNode node;
    int hd;

    public QItem(TreeNode n, int h) {
        node = n;
        hd = h;
    }
}

// 이진 트리 클래스
class Tree {
    TreeNode root;

    // 생성자
    public Tree() {
        root = null;
    }

    public Tree(TreeNode n) {
        root = n;
    }

    // 이 메소드는 이진 트리의 노드들을 top view로 출력한다
    public void printTopView() {
        // 추가 안된 트리의 경우
        if (root == null) {
            return;
        }

        // 빈 해쉬집합을 만든다
        HashSet<Integer> set = new HashSet<>();

        // 큐를 만든 뒤 루트를 큐에 넣는다 
        Queue<QItem> Q = new LinkedList<QItem>();
        Q.add(new QItem(root, 0)); // Horizontal distance of root is 0

        // 너비 우선 탐색(BFS) or 레벨 순회(level order traversal) 
        while (!Q.isEmpty()) {
            // 앞의 정보를 삭제한 뒤 멤버 변수의 값을 얻는다
            QItem qi = Q.remove();
            int hd = qi.hd;
            TreeNode n = qi.node;

            // 이것이 수평 거리의 첫번째 노드인 경우,
            // 이 노드를 top view 로 한다
            if (!set.contains(hd)) {
                set.add(hd);
                System.out.print(n.key + " ");
            }

            // 현재 노드의 왼쪽 자식과 오른쪽 자식을 큐에 넣는다
            if (n.left != null)
                Q.add(new QItem(n.left, hd - 1));
            if (n.right != null)
                Q.add(new QItem(n.right, hd + 1));
        }
    }
}

// 위의 메소드들을 테스트하기 위한 클래스
public class PrintTopViewofTree {
    public static void main(String[] args) {
        /* 위의 이진 트리를 만들어라
             1
           /  \
          2    3
           \
            4
             \
              5
               \
                6*/
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.left.right.right = new TreeNode(5);
        root.left.right.right.right = new TreeNode(6);
        Tree t = new Tree(root);
        System.out.println("Following are nodes in top view of Binary Tree");
        t.printTopView();
    }
}
