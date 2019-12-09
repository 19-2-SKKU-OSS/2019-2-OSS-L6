package DataStructures.Queues;

import java.util.ArrayList;

/**
 * 이 클래스는 일반화 컬렉션(array, list, queue)을 구현한 것이다.
 * <p>
 * 일반화 컬렉션(ArrayList queue) 함수들은 어떠한 타입의 queue와 동일하다.
 * 일반화 컬렉션(ArrayList queue) 는 런타임에서는 자료형이 구체적으로 명시된 요소를 갖는다.
 * 요소들은 FIFO(First in first out)방식으로 추가된다.
 * 새로운 요소들은 queue의 rear에 추가된다.
 *
 */
public class GenericArrayListQueue<T> {
    /**
     * queue를 위한 ArrayList 일반화 컬렉션
     * T는 일반화 요소이다.
     */
    ArrayList<T> _queue = new ArrayList<T>();

    /**
     * queue가 비어있지 않은지 체크한다.
     *
     * @return True queue가 값을 가지는 경우, False 아닌경우.
     */
    private boolean hasElements() {
        return !_queue.isEmpty();
    }

    /**
     * queue의 앞에 무엇이 있는지 체크한다.
     *
     * @return queue가 비어있지 않은 경우, queue앞에 있는 요소. 아닌경우 null
     */
    public T peek() {
        T result = null;
        if(this.hasElements()) { result = _queue.get(0); }
        return result;
    }

    /**
     * queue의 T 타입의 요소를 삽입
     *
     * @param T element 추가될 T 타입의 요소
     * @return True 요소 추가가 성공한 경우
     */
    public boolean add(T element) {
        return _queue.add(element);
    }

    /**
     * queue앞에 있는 것 검색
     *
     * @return queue가 비어있지 않은 경우, queue앞에 있는 요소. 아닌경우 null
     */
    public T poll() {
        T result = null;
        if(this.hasElements()) { result = _queue.remove(0); }
        return result;
    }

    /**
     * 메인 메소드
     *
     * @param args 커맨드 라인
     */
    public static void main(String[] args) {
        GenericArrayListQueue<Integer> queue = new GenericArrayListQueue<Integer>();
        System.out.println("Running...");
        assert queue.peek() == null;
        assert queue.poll() == null;
        assert queue.add(1) == true;
        assert queue.peek() == 1;
        assert queue.add(2) == true;
        assert queue.peek() == 1;
        assert queue.poll() == 1;
        assert queue.peek() == 2;
        assert queue.poll() == 2;
        assert queue.peek() == null;
        assert queue.poll() == null;
        System.out.println("Finished.");
    }
}
