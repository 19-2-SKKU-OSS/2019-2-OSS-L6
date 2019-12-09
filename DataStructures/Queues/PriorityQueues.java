package DataStructures.Queues;

/**
 * 이 클래스는 우선순위 큐를 구현한 것이다.
 * <p>
 * 우선순위 큐는 그들의 우선순위에 기반해서 요소를 추가한다.
 * 그래서 가장 중요한 요소는 제일 위에 둔다.
 * 예시에서 더 높은 우선순위를 가진 수를 제공할 것이다.
 * Queues 는 이론상 고정된 크기를 가지진 않지만 배열로 구현할 경우는 그러하다. 
 */
class PriorityQueue {
    /**
     * queue의 최대 크기
     */
    private int maxSize;
    /**
     * queue를 위한 배열
     */
    private int[] queueArray;
    /**
     * queue에 들어있는 아이템의 개수
     */
    private int nItems;

    /**
     * 생성자
     *
     * @param size queue의 크기
     */
    public PriorityQueue(int size) {
        maxSize = size;
        queueArray = new int[size];
        nItems = 0;
    }

    /**
     * 적절한 장소에 요소 삽입
     *
     * @param value 삽입될 값
     */
    public void insert(int value) {
        if (isFull()) {
            throw new RuntimeException("Queue is full");
        } else {
            int j = nItems - 1; // 마지막 요소의 인덱스
            while (j >= 0 && queueArray[j] > value) {
                queueArray[j + 1] = queueArray[j]; // 추가하기 위해 모든 요소의 자리를 바꾼다.
                j--;
            }
            queueArray[j + 1] = value; // 값이 들어갈 적절한 장소를 찾은 경우
            nItems++;
        } 
    }

    /**
     * Remove queue 앞에 있는 요소 삭제
     *
     * @return 삭제된 요소
     */
    public int remove() {
        return queueArray[--nItems];
    }

    /**
     * queue의 앞에 무엇이 있는지 검사한다.
     *
     * @return queue의 앞에있는 요소
     */
    public int peek() {
        return queueArray[nItems - 1];
    }

    /**
     * queue가 비어있을 경우 참을 반환
     *
     * @return queue가 비어있을 경우
     */
    public boolean isEmpty() {
        return (nItems == 0);
    }

    /**
     * queue가 가득 차있을 경우 참을 반환
     *
     * @return queue가 가득 차있을 경우 참
     */
    public boolean isFull() {
        return (nItems == maxSize);
    }

    /**
     * queue에 있는 요소의 개수를 반환
     *
     * @return queue에 있는 요소의 개수
     */
    public int getSize() {
        return nItems;
    }
}

/**
 * 우선순위 큐 구현을 위한 클래스
 *
 * @author Unknown
 */
public class PriorityQueues {
    /**
     * 메인메소드
     *
     * @param args 커맨드 라인
     */
    public static void main(String[] args) {
        PriorityQueue myQueue = new PriorityQueue(4);
        myQueue.insert(10);
        myQueue.insert(2);
        myQueue.insert(5);
        myQueue.insert(3);
        // [2, 3, 5, 10] 높은 수일 수록 높은 우선순위를 갖도록 하였다.

        for (int i = 3; i >= 0; i--)
            System.out.print(myQueue.remove() + " "); // queue를 반대 순서로 출력한다. [10, 5, 3, 2]

        // 보다시피 우선순위 큐는 정렬 알고리즘에 쓰일 수 있다.
    }
}
