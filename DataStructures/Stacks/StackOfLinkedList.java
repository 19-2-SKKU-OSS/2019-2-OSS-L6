package DataStructures.Stacks;

/**
 * @author Varun Upadhyay (https://github.com/varunu28)
 */

// 연결 리스트를 사용한 스택 구현

class StackOfLinkedList {

    public static void main(String[] args) {

        LinkedListStack stack = new LinkedListStack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        System.out.println(stack);

        System.out.println("Size of stack currently is: " + stack.getSize());

        assert stack.pop() == 5;
        assert stack.pop() == 4;

        System.out.println("Top element of stack currently is: " + stack.peek());
    }
}

// 노드 

class Node {
    public int data;
    public Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

/**
 * 연결 리스트를 사용한 스택을 구현한 클래스
 * <p>
 * 모든 스택 메소드를 포함한다 : push, pop, printStack, isEmpty
 **/

class LinkedListStack {

    /**
     * 스택의 맨 위
     */
    Node head;

    /**
     * 스택의 크기
     */
    private int size;

    /**
     * Init properties
     */
    public LinkedListStack() {
        head = null;
        size = 0;
    }

    /**
     * 맨위에 있는 요소를 추가한다.
     *
     * @param x 추가될 값
     * @return <tt>true</tt> 성공적으로 추가된 경우
     */
    public boolean push(int x) {
        Node newNode = new Node(x);
        newNode.next = head;
        head = newNode;
        size++;
        return true;
    }

    /**
     * 스택의 맨위에 있는 값을 pop한다.
     *
     * @return 스택에서 pop된 값
     * @throws NoSuchElementException 스택이 비어있다면
     */
    public int pop() {
        if (size == 0) {
            throw new NoSuchElementException("Empty stack. Nothing to pop");
        }
        Node destroy = head;
        head = head.next;
        int retValue = destroy.data;
        destroy = null; // GC가 동작하도록 destroy를 비어둔다.
        size--;
        return retValue;
    }

    /**
     * Peek element at top of stack
     *
     * @return element at top of stack
     * @throws NoSuchElementException if stack is empty
     */
    public int peek() {
        if (size == 0) {
            throw new NoSuchElementException("Empty stack. Nothing to pop");
        }
        return head.data;
    }

    @Override
    public String toString() {
        Node cur = head;
        StringBuilder builder = new StringBuilder();
        while (cur != null) {
            builder.append(cur.data).append("->");
            cur = cur.next;
        }
        return builder.replace(builder.length() - 2, builder.length(), "").toString();
    }

    /**
     * Check if stack is empty
     *
     * @return <tt>true</tt> if stack is empty, otherwise <tt>false</tt>
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Return size of stack
     *
     * @return size of stack
     */
    public int getSize() {
        return size;
    }
}
