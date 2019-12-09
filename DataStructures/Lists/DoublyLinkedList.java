package DataStructures.Lists;

/**
 * 이 클래스는 이중 연결 리스트를 구현한 것이다.
 * 이 클래스는 LinkedList 과 Link 클래스를 사용한다.
 * <p>
 * 연결 리스트는 값을 가진다는 점에서 배열과 비슷하다.
 * 그러나 연결 리스트는 인덱스를 가지지 않는다.
 * 연결 리스트는 추가 되거나 삭제될때 그것의 크기를 미리 알 수 없다.
 * 이것은 이중 연결 리스트의 예시이다. 
 * 각각의 링크는 다음 링크와 전의 링크를 참조한다.
 *
 * @author Unknown
 */

public class DoublyLinkedList {
    /**
     * Head는 리스트의 앞을 나타낸다.
     */
    private Link head;
    /**
     * Tail는 리스트의 뒤를 나타낸다.
     */
    private Link tail;

    /**
     * 디폴트 
     */
    public DoublyLinkedList() {
        head = null;
        tail = null;
    }

    /**
     * 배열의 요소를 지닌 리스트 만들기
     *
     * @param array 리스트로 대체될 값을 가진 배열
     * @throws NullPointerException 배열의 값이 null일 경우
     */
    public DoublyLinkedList(int[] array) {
        if (array == null) throw new NullPointerException();
        for (int i : array) {
            insertTail(i);
        }
    }

    /**
     * head에 요소 삽입
     *
     * @param x 삽입될 요소
     */
    public void insertHead(int x) {
        Link newLink = new Link(x); // 값이 연결된 새로운 링크 생성
        if (isEmpty()) // Set the first element added to be the tail
            tail = newLink;
        else
            head.previous = newLink; // newLink <-- currenthead(head)
        newLink.next = head; // newLink <--> currenthead(head)
        head = newLink; // newLink(head) <--> oldhead
    }

    /**
     * tail에 요소 삽입
     *
     * @param x 삽입될 요소
     */
    public void insertTail(int x) {
        Link newLink = new Link(x);
        newLink.next = null; // currentTail(tail)     newlink -->
        if (isEmpty()) {        // 리스트가 비어있을 경우 첫 요소를 추가한다. 
            tail = newLink;
            head = tail;
        } else {
            tail.next = newLink; // currentTail(tail) --> newLink -->
            newLink.previous = tail; // currentTail(tail) <--> newLink -->
            tail = newLink; // oldTail <--> newLink(tail) -->
        }
    }

    /**
     * head에 있는 요소 삭제
     *
     * @return 새로운 head
     */
    public Link deleteHead() {
        Link temp = head;
        head = head.next; // oldHead <--> 2ndElement(head)
        head.previous = null; // oldHead --> 2ndElement(head) 아무것도 가리키지 않는 head를 삭제한다.
        if (head == null)
            tail = null;
        return temp;
    }

    /**
     * tail에 있는 요소 삭제
     *
     * @return 새로운 tail
     */
    public Link deleteTail() {
        Link temp = tail;
        tail = tail.previous; // 2ndLast(tail) <--> oldTail --> null
        tail.next = null; // 2ndLast(tail) --> null
        if (tail == null) {
            head = null;
        }
        return temp;
    }

    /**
     * 리스트 어딘가에 있는 요소를 삭제
     *
     * @param x 삭제할 요소
     * @return 삭제된 링크
     */
    public void delete(int x) {
        Link current = head;

        while (current.value != x) {// 삭제할 곳을 찾는다.
            if (current != tail) {
                current = current.next;
            } else {// 요소를 발견하지 못한 경우 던지는 에러 코드
                throw new RuntimeException("The element to be deleted does not exist!");
            }
        }

        if (current == head)
            deleteHead();

        else if (current == tail)
            deleteTail();

        else { // Before: 1 <--> 2(current) <--> 3
            current.previous.next = current.next;  // 1 --> 3
            current.next.previous = current.previous; // 1 <--> 3
        }
    }

    /**
     * 요소를 삽입하고 다시 정렬
     *
     * @param x 추가될 요소
     */
    public void insertOrdered(int x) {
        Link newLink = new Link(x);
        Link current = head;
        while (current != null && x > current.value) // 삽입할 위치 확인
            current = current.next;

        if (current == head)
            insertHead(x);

        else if (current == null)
            insertTail(x);

        else { // Before: 1 <--> 2(current) <--> 3
            newLink.previous = current.previous; // 1 <-- newLink
            current.previous.next = newLink; // 1 <--> newLink
            newLink.next = current; // 1 <--> newLink --> 2(current) <--> 3
            current.previous = newLink; // 1 <--> newLink <--> 2(current) <--> 3
        }
    }

    /**
     * 리스트가 비어있다면 참을 반환한다.
     *
     * @return 리스트가 비어있다면 참
     */
    public boolean isEmpty() {
        return (head == null);
    }

    /**
     * 리스트의 내용을 출력한다.
     */
    public void display() { 
        Link current = head;
        while (current != null) {
            current.displayLink();
            current = current.next;
        }
        System.out.println();
    }
}

/**
 * 이 클래스는 링크된 목록의 노드를 구현하는 데 사용된다.
 *
 * @author Unknown
 */
class Link {
    /**
     * 노드의 값
     */
    public int value;
    /**
     * 새로운 링크의 앞의 링크를 가리킨다.
     */
    public Link next;
    /**
     * 새로운 링크의 뒤의 링크를 가리킨다.
     */
    public Link previous;

    /**
     * 생성자
     *
     * @param value 노드의 값
     */
    public Link(int value) {
        this.value = value;
    }

    /**
     * 노드들을 출력한다.
     */
    public void displayLink() {
        System.out.print(value + " ");
    }

    /**
     * 메인 메소드
     *
     * @param args 커멘드 라인
     */
    public static void main(String args[]) {
        DoublyLinkedList myList = new DoublyLinkedList();
        myList.insertHead(13);
        myList.insertHead(7);
        myList.insertHead(10);
        myList.display(); // <-- 10(head) <--> 7 <--> 13(tail) -->

        myList.insertTail(11);
        myList.display(); // <-- 10(head) <--> 7 <--> 13 <--> 11(tail) -->

        myList.deleteTail();
        myList.display(); // <-- 10(head) <--> 7 <--> 13(tail) -->

        myList.delete(7);
        myList.display(); // <-- 10(head) <--> 13(tail) -->

        myList.insertOrdered(23);
        myList.insertOrdered(67);
        myList.insertOrdered(3);
        myList.display(); // <-- 3(head) <--> 10 <--> 13 <--> 23 <--> 67(tail) -->
    }
}
