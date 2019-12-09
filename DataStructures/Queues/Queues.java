package DataStructures.Queues;

/**
 * 이 클래스는 큐 클래스를 사용하여 큐를 구현한 클래스이다.
 * <p>
 * 큐 자료 구조 함수는 현실의 줄서기 와 같다.
 * 먼저 추가된 요소가 먼저 제거된다.
 * 새로운 요소는 큐의 뒤쪽에 추가된다.
 *
 */
class Queue {
    /**
     * capacity의 디폴트 초기화
     */
    private static final int DEFAULT_CAPACITY = 10;

    /**
     * 큐의 최대 크기
     */
    private int maxSize;
    /**
     * 큐를 나타내는 배열
     */
    private int[] queueArray;
    /**
     * 큐의 앞
     */
    private int front;
    /**
     * 큐의 뒤
     */
    private int rear;
    /**
     * 큐에 들어있는 아이템의 개수
     */
    private int nItems;

    /**
     * init with DEFAULT_CAPACITY 
     */
    public Queue() {
        this(DEFAULT_CAPACITY);
    }

    /**
     * 생성자
     *
     * @param size 새로운 큐의 크기
     */
    public Queue(int size) {
        maxSize = size;
        queueArray = new int[size];
        front = 0;
        rear = -1;
        nItems = 0;
    }

    /**
     * 큐의 뒤쪽에 새로운 요소 삽입
     *
     * @param x 추가될 요소
     * @return True 요소 추가 성공시 
     */
    public boolean insert(int x) {
        if (isFull())
            return false;
        // If the back of the queue is the end of the array wrap around to the front
        rear = (rear + 1) % maxSize;
        queueArray[rear] = x;
        nItems++;
        return true;
    }

    /**
     * queue의 앞 요소 삭제
     *
     * @return 새로운 큐의 앞 
     */
    public int remove() {
        if (isEmpty()) {
            return -1;
        }
        int temp = queueArray[front];
        front = (front + 1) % maxSize;
        nItems--;
        return temp;
    }

    /**
     * 큐 앞에 무엇이 있는지 검사
     *
     * @return 큐 앞의 요소
     */
    public int peekFront() {
        return queueArray[front];
    }

    /**
     * queue 뒤에 무엇이 있는지 검사
     *
     * @return queue 뒤에 요소 
     */
    public int peekRear() {
        return queueArray[rear];
    }

    /**
     * 큐가 비어있을 경우 참 반환
     *
     * @return 큐가 비어있을 경우
     */
    public boolean isEmpty() {
        return nItems == 0;
    }

    /**
     * 큐가 가득 찰 경우 참 반환
     *
     * @return true 큐가 가득 찰 경우
     */
    public boolean isFull() {
        return nItems == maxSize;
    }

    /**
     * 큐의 요소 개수를 반환
     *
     * @return 큐의 요소 개수
     */
    public int getSize() {
        return nItems;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = front; ; i = ++i % maxSize) {
            sb.append(queueArray[i]).append(", ");
            if (i == rear) {
                break;
            }
        }
        sb.replace(sb.length() - 2, sb.length(), "]");
        return sb.toString();
    }
}

/**
 * 큐 클래스 예시를 위한 클래스
 *
 * @author Unknown
 */
public class Queues {
    /**
     * 메인 메소드
     *
     * @param args 커맨드 라인
     */
    public static void main(String[] args) {
        Queue myQueue = new Queue(4);
        myQueue.insert(10);
        myQueue.insert(2);
        myQueue.insert(5);
        myQueue.insert(3);
        // [10(front), 2, 5, 3(rear)]

        System.out.println(myQueue.isFull()); // 참 출력할 것이다.

        myQueue.remove(); // 2를 새로운 전선으로 만들고, 10을 더 이상 큐에 포함하지 않음
        // [10, 2(front), 5, 3(rear)]

        myQueue.insert(7); // 반복으로 인해 인덱스가 0이 될 큐의 뒤에 7을 삽입히다.
        // [7(rear), 2(front), 5, 3]

        System.out.println(myQueue.peekFront()); // Will print 2
        System.out.println(myQueue.peekRear()); // Will print 7
        System.out.println(myQueue.toString()); // Will print [2, 5, 3, 7]
    }
}
