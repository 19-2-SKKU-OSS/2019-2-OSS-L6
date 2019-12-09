package DataStructures.Trees;

import java.util.LinkedList;

/**
 * @author Varun Upadhyay (https://github.com/varunu28)
 */


// Driver Program
public class TreeTraversal {
    public static void main(String[] args) {
        Node tree = new Node(5);
        tree.insert(3);
        tree.insert(2);
        tree.insert(7);
        tree.insert(4);
        tree.insert(6);
        tree.insert(8);

        // Prints 5 3 2 4 7 6 8
        System.out.println("Pre order traversal:");
        tree.printPreOrder();
        System.out.println();
        // Prints 2 3 4 5 6 7 8
        System.out.println("In order traversal:");
        tree.printInOrder();
        System.out.println();
        // Prints 2 4 3 6 8 7 5
        System.out.println("Post order traversal:");
        tree.printPostOrder();
        System.out.println();
        // Prints 5 3 7 2 4 6 8
        System.out.println("Level order traversal:");
        tree.printLevelOrder();
        System.out.println();
    }
}

/**
 * 트리의 노드를 초기화하는 노드 클래스
 * 모두 4가지 탐사 메소드가 있다: printInOrder, printPostOrder， printPreOrder & printLevelOrder
 * printInOrder: LEFT -> ROOT -> RIGHT  (왼쪽 자식- > 루트 -> 오른쪽 자식)
 * printPreOrder: ROOT -> LEFT -> RIGHT  (루트 -> 왼쪽 자식 -> 오른쪽 자식)
 * printPostOrder: LEFT -> RIGHT -> ROOT  (왼쪽 자식 -> 오른쪽 자식 -> 루트)
 * printLevelOrder: 루트에서 시작해서 레벨에 따라 왼쪽에서 오른쪽으로  
 */
class Node {
    Node left, right;
    int data;

    public Node(int data) {
        this.data = data;
    }

    public void insert(int value) {
        if (value < data) {
            if (left == null) {
                left = new Node(value);
            } else {
                left.insert(value);
            }
        } else {
            if (right == null) {
                right = new Node(value);
            } else {
                right.insert(value);
            }
        }
    }

    public void printInOrder() {
        if (left != null) {
            left.printInOrder();
        }
        System.out.print(data + " ");
        if (right != null) {
            right.printInOrder();
        }
    }

    public void printPreOrder() {
        System.out.print(data + " ");
        if (left != null) {
            left.printPreOrder();
        }
        if (right != null) {
            right.printPreOrder();
        }
    }

    public void printPostOrder() {
        if (left != null) {
            left.printPostOrder();
        }
        if (right != null) {
            right.printPostOrder();
        }
        System.out.print(data + " ");
    }

    /**
     * 시간 복잡도: O(n)
     * 공간 복잡도: O(n) 
     */
    public void printLevelOrder() {
        LinkedList<Node> queue = new LinkedList<>();
        queue.add(this);
        while (queue.size() > 0) {
            Node head = queue.remove();
            System.out.print(head.data + " ");
            // 최근에 출력된 노드가 자식을 가지고 있는 경우 그 자식을 큐에 넣는다
            if (head.left != null) {
                queue.add(head.left);
            }
            if (head.right != null) {
                queue.add(head.right);
            }
        }
    }
}
