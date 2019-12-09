package DataStructures.Trees;

/**
 * 이 클래스는 이진 트리 자료 구조를 만드는 데 사용된다
 * 노드 클래스와 트리 클래스 둘다 밑에 설명되있다.
 */


/**
 * 이진 트리는 두 자손을 갖는 자료 구조이다.
 * 보통 왼쪽 자손이 오른쪽 자손보다 더 작다.
 * 
 *
 * @author Unknown
 *
 */
public class BinaryTree {

    /**
     * 이 클래스는 이진 트리로 이동할 노드를 구현합니다
     * 이진 트리는 데이터, 왼쪽 노드, 오른족 노드 및 부모로 구성 됩니다.
     *
     * @author Unknown
     *
     */
    class Node {
        /** 노드의 데이터*/
        public int data;
        /** 이 노드의 왼쪽 자손 */
        public Node left;
        /** 이 노드의 오른쪽 자손*/
        public Node right;
        /** 이 노드의 부모 */
        public Node parent;

        /**
         * 노드 생성자
         *
         * @param value 노드에 넣을 값
         */
        public Node(int value) {
            data = value;
            left = null;
            right = null;
            parent = null;
        }
    }


    /** 이진트리의 루트 */
    private Node root;

    /**
     * 생성자
     */
    public BinaryTree() {
        root = null;
    }

    /**
     * 특정한 값으로 노드를 찾는 메소드
     *
     * @param key 찾고자하는 값
     * @return 그 노드를 발견할 경우 노드를 반환하고, 아닐 경우 부모를 반환한다
     */
    public Node find(int key) {
        Node current = root;
        while (current != null) {
            if (key < current.data) {
                if (current.left == null)
                    return current;    // 키가 존재하지 않으므로 부모를 반환한다.
                current = current.left;
            } else if (key > current.data) {
                if (current.right == null)
                    return current;
                current = current.right;
            } else {    // 발견한 값을 
                return current;
            }
        }
        return null;
    }

    /**
     * 이진 트리에 특정 값 삽입하기
     *
     * @param value 삽입될 값
     */
    public void put(int value) {
        Node newNode = new Node(value);
        if (root == null)
            root = newNode;
        else {
            //찾고자하는 값의 부모를 반환한다
            Node parent = find(value);

            //부모의 데이터와 값을 비교해 왼쪽 자식에 둘지 오른쪽 자식에 둘지 정한다
            if (value < parent.data) {
                parent.left = newNode;
                parent.left.parent = parent;
                return;
            } else {
                parent.right = newNode;
                parent.right.parent = parent;
                return;
            }
        }
    }

    /**
     * 이진 트리로 부터 주어진 값을 삭제한다
     *
     * @param value 삭제될 값
     * @return 값이 삭제되면 참을 반환
     */
    public boolean remove(int value) {
        //temp는 삭제될 노드이다
        Node temp = find(value);

        //값이 존재하지 않을 경우
        if (temp.data != value)
            return false;

        //자손이 없다
        if (temp.right == null && temp.left == null) {
            if (temp == root)
                root = null;

                //부모의 데이터와 값을 비교해 왼쪽 자식에 null로 할당할지, 오른쪽 자식에 null로 할당할지 정한다
            else if (temp.parent.data < temp.data)
                temp.parent.right = null;
            else
                temp.parent.left = null;
            return true;
        }

        //자손이 둘인 경우
        else if (temp.left != null && temp.right != null) {
            Node successor = findSuccessor(temp);

            //temp의 왼쪽 트리는 자손의 왼쪽 트리가 된다
            successor.left = temp.left;
            successor.left.parent = successor;

            //만약 자손에게 오른쪽 자손이 있을 경우 그 자손의 부모의 부모가 새로운 부모가 된다
            if (successor.right != null && successor.parent != temp) {
                successor.right.parent = successor.parent;
                successor.parent.left = successor.right;
                successor.right = temp.right;
                successor.right.parent = successor;
            }
            if (temp == root) {
                successor.parent = null;
                root = successor;
                return true;
            }

            //만약 루트를 삭제하지 않는다면
            else {
                successor.parent = temp.parent;

                //부모의 데이터와 값을 비교해 왼쪽 자식에 둘지 오른쪽 자식에 둘지 정한다
                if (temp.parent.data < temp.data)
                    temp.parent.right = successor;
                else
                    temp.parent.left = successor;
                return true;
            }
        }
        //자손이 하나인 경우
        else {
            //그것이 오른쪽 자손일 경우
            if (temp.right != null) {
                if (temp == root) {
                    root = temp.right;
                    return true;
                }

                temp.right.parent = temp.parent;

                //Assigns temp to left or right child
                if (temp.data < temp.parent.data)
                    temp.parent.left = temp.right;
                else
                    temp.parent.right = temp.right;
                return true;
            }
            //왼쪽 자손인 경우
            else {
                if (temp == root) {
                    root = temp.left;
                    return true;
                }

                temp.left.parent = temp.parent;

                //temp를 오른쪽이나 왼쪽 자손에 
                if (temp.data < temp.parent.data)
                    temp.parent.left = temp.left;
                else
                    temp.parent.right = temp.left;
                return true;
            }
        }
    }

    /**
     * This method finds the Successor to the Node given.
     * Move right once and go left down the tree as far as you can
     *
     * @param n Node that you want to find the Successor of
     * @return The Successor of the node
     */
    public Node findSuccessor(Node n) {
        if (n.right == null)
            return n;
        Node current = n.right;
        Node parent = n.right;
        while (current != null) {
            parent = current;
            current = current.left;
        }
        return parent;
    }

    /**
     * Returns the root of the Binary Tree
     *
     * @return the root of the Binary Tree
     */
    public Node getRoot() {
        return root;
    }

    /**
     * Prints leftChild - root - rightChild
     *
     * @param localRoot The local root of the binary tree
     */
    public void inOrder(Node localRoot) {
        if (localRoot != null) {
            inOrder(localRoot.left);
            System.out.print(localRoot.data + " ");
            inOrder(localRoot.right);
        }
    }

    /**
     * Prints root - leftChild - rightChild
     *
     * @param localRoot The local root of the binary tree
     */
    public void preOrder(Node localRoot) {
        if (localRoot != null) {
            System.out.print(localRoot.data + " ");
            preOrder(localRoot.left);
            preOrder(localRoot.right);
        }
    }

    /**
     * Prints rightChild - leftChild - root
     *
     * @param localRoot The local root of the binary tree
     */
    public void postOrder(Node localRoot) {
        if (localRoot != null) {
            postOrder(localRoot.left);
            postOrder(localRoot.right);
            System.out.print(localRoot.data + " ");
        }
    }
}
