package DataStructures;

import java.util.NoSuchElementException;

public class LinkedQueue {
    class Node {
        int data;
        Node next;

        public Node() {
            this(0);
        }

        public Node(int data) {
            this(data, null);
        }

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }
    }

    /**
     * Queue의 앞
     */
    private Node front;

    /**
     * Queue의 뒤
     */
    private Node rear;

    /**
     * Queue의 크기
     */
    private int size;

    /**
     * Init LinkedQueue
     */
    public LinkedQueue() {
        front = rear = new Node();
    }

    /**
     * queue가 비어있는지 체크
     *
     * @return <tt>true</tt> queue가 비어있다면, 아닌경우 <tt>false</tt>
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * queue의 뒤에 요소를 추가
     *
     * @param data 추가할 값
     * @return <tt>true</tt> 추가 성공시
     */
    public boolean enqueue(int data) {
        Node newNode = new Node(data);
        rear.next = newNode;
        rear = newNode; /* rear이 마지막 노드를 가리키도록 한다 */
        size++;
        return true;
    }

    /**
     * queue의 앞에 있는 요소 삭제
     *
     * @return queue의 앞에 있는 요소
     */
    public int dequeue() {
        if (isEmpty()) {
            throw new NoSuchElementException("queue is empty");
        }
        Node destroy = front.next;
        int retValue = destroy.data;
        front.next = front.next.next;
        destroy = null; /* GC가 작동하도록 destroy를 비어준다 */
        size--;

        if (isEmpty()) {
            front = rear;
        }

        return retValue;
    }

    /**
     * 삭제하지 않고 queue 앞에 있는 요소 검색
     *
     * @return 앞에 있는 요소
     */
    public int peekFront() {
        if (isEmpty()) {
            throw new NoSuchElementException("queue is empty");
        }
        return front.next.data;
    }

    /**
     * 제거하지 않고 queue의 뒤에 있는 요소 검색
     *
     * @return 앞에 있는 요소
     */
    public int peekRear() {
        if (isEmpty()) {
            throw new NoSuchElementException("queue is empty");
        }
        return rear.data;
    }

    /**
     * queue의 크기를 반환한다
     *
     * @return queue의 크기
     */
    public int size() {
        return size;
    }

    /**
     * queue에 있는 모든 노드 비우기
     */
    public void clear() {
        while (!isEmpty()) {
            dequeue();
        }
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "[]";
        }
        StringBuilder builder = new StringBuilder();
        Node cur = front.next;
        builder.append("[");
        while (cur != null) {
            builder.append(cur.data).append(", ");
            cur = cur.next;
        }
        builder.replace(builder.length() - 2, builder.length(), "]");
        return builder.toString();
    }

    /* Driver Code */
    public static void main(String[] args) {
        LinkedQueue queue = new LinkedQueue();
        assert queue.isEmpty();

        queue.enqueue(1); /* 1 */
        queue.enqueue(2); /* 1 2 */
        queue.enqueue(3); /* 1 2 3 */
        System.out.println(queue); /* [1, 2, 3] */

        assert queue.size() == 3;
        assert queue.dequeue() == 1;
        assert queue.peekFront() == 2;
        assert queue.peekRear() == 3;

        queue.clear();
        assert queue.isEmpty();

        System.out.println(queue); /* [] */
    }
}
