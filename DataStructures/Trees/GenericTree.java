package DataStructures.Trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Scanner;

/**
 * 일반 트리는 가능한 한 많은 자손을 가질 수있는 트리이다.
 * 이것은 심지어 존재하는 모든 노드가 루트 노드에 직접 연결되었을 수 있습니다.
 *
 * <p>
 * 이 코드에서
 * 모든 함수에는 두 개의 사본이 있다: 하나의 함수는 기본에서 호출 할 수있는 helper 함수이고 
 * 해당 함수에서 실제 작업을 수행하는 private 함수가 호출됩니다.
 * 나는 이 작업을 메인을 호출할 때 최소한의 매개변수를 갖도록 수행하였다.
 */
public class GenericTree {
    private class Node {
        int data;
        ArrayList<Node> child = new ArrayList<>();
    }

    private Node root;
    private int size;

    public GenericTree() {     //Constructor
        Scanner scn = new Scanner(System.in);
        root = create_treeG(null, 0, scn);
    }

    private Node create_treeG(Node node, int childindx, Scanner scn) {
        // display
        if (node == null) {
            System.out.println("Enter root's data");
        } else {
            System.out.println("Enter data of parent of index " + node.data + " " + childindx);
        }
        // input
        node = new Node();
        node.data = scn.nextInt();
        System.out.println("number of children");
        int number = scn.nextInt();
        for (int i = 0; i < number; i++) {
            Node child = create_treeG(node, i, scn);
            size++;
            node.child.add(child);
        }
        return node;
    }

    /**
     * Function to display the generic tree
     */
    public void display() {  //Helper function
        display_1(root);
    }

    private void display_1(Node parent) {
        System.out.print(parent.data + "=>");
        for (int i = 0; i < parent.child.size(); i++) {
            System.out.print(parent.child.get(i).data + " ");
        }
        System.out.println(".");
        for (int i = 0; i < parent.child.size(); i++) {
            display_1(parent.child.get(i));
        }
    }

    /**
     * One call store the size directly but if you are asked compute size this function to calculate
     * size goes as follows
     *
     * @return size
     */
    public int size2call() {
        return size2(root);
    }

    public int size2(Node roott) {
        int sz = 0;
        for (int i = 0; i < roott.child.size(); i++) {
            sz += size2(roott.child.get(i));
        }
        return sz + 1;
    }

    /**
     * Function to compute maximum value in the generic tree
     *
     * @return maximum value
     */
    public int maxcall() {
        int maxi = root.data;
        return max(root, maxi);
    }

    private int max(Node roott, int maxi) {
        if (maxi < roott.data)
            maxi = roott.data;
        for (int i = 0; i < roott.child.size(); i++) {
            maxi = max(roott.child.get(i), maxi);
        }

        return maxi;
    }

    /**
     * Function to compute HEIGHT of the generic tree
     *
     * @return height
     */
    public int heightcall() {
        return height(root) - 1;
    }

    private int height(Node node) {
        int h = 0;
        for (int i = 0; i < node.child.size(); i++) {
            int k = height(node.child.get(i));
            if (k > h)
                h = k;
        }
        return h + 1;
    }

    /**
     * Function to find whether a number is present in the generic tree or not
     *
     * @param info number
     * @return present or not
     */
    public boolean findcall(int info) {
        return find(root, info);
    }

    private boolean find(Node node, int info) {
        if (node.data == info)
            return true;
        for (int i = 0; i < node.child.size(); i++) {
            if (find(node.child.get(i), info))
                return true;
        }
        return false;
    }


    /**
     * Function to calculate depth of generic tree
     *
     * @param dep depth
     */
    public void depthcaller(int dep) {
        depth(root, dep);
    }

    public void depth(Node node, int dep) {
        if (dep == 0) {
            System.out.println(node.data);
            return;
        }
        for (int i = 0; i < node.child.size(); i++)
            depth(node.child.get(i), dep - 1);
        return;
    }

    /**
     * Function to print generic tree in pre-order
     */
    public void preordercall() {
        preorder(root);
        System.out.println(".");
    }

    private void preorder(Node node) {
        System.out.print(node.data + " ");
        for (int i = 0; i < node.child.size(); i++)
            preorder(node.child.get(i));
    }

    /**
     * Function to print generic tree in post-order
     */
    public void postordercall() {
        postorder(root);
        System.out.println(".");
    }

    private void postorder(Node node) {
        for (int i = 0; i < node.child.size(); i++)
            postorder(node.child.get(i));
        System.out.print(node.data + " ");
    }

    /**
     * Function to print generic tree in level-order
     */
    public void levelorder() {
        LinkedList<Node> q = new LinkedList<>();
        q.addLast(root);
        while (!q.isEmpty()) {
            int k = q.getFirst().data;
            System.out.print(k + " ");

            for (int i = 0; i < q.getFirst().child.size(); i++) {
                q.addLast(q.getFirst().child.get(i));
            }
            q.removeFirst();
        }
        System.out.println(".");
    }

    /**
     * Function to remove all leaves of generic tree
     */
    public void removeleavescall() {
        removeleaves(root);
    }

    private void removeleaves(Node node) {
        ArrayList<Integer> arr = new ArrayList<>();
        for (int i = 0; i < node.child.size(); i++) {
            if (node.child.get(i).child.size() == 0) {
                arr.add(i);
                // node.child.remove(i);
                // i--;
            } else
                removeleaves(node.child.get(i));
        }
        for (int i = arr.size() - 1; i >= 0; i--) {
            node.child.remove(arr.get(i) + 0);
        }
    }

}
