/**
 * 이 클래스는 일반 배열을 사용하여 스택을 구현한다.
 * <p>
 * 스택이 의미하는 것은 무더기이다. 
 * 스택 맨 위에 요소가 추가되고 맨 위에있는 요소 만 제거 될 수 있습니다.
 * 이것은 스택의 배열 구현의 예입니다. 
 * 따라서 배열 끝에서만 요소를 추가/제거 할 수 있습니다. 
 * 이론적으로 스택의 크기는 고정되어 있지 않지만 배열 구현에서는 크기가 다릅니다.
 *
 * @author Unknown
 */
public class StackArray {

    /**
     * 메인 메소드
     *
     * @param args Command line arguments
     */
    public static void main(String[] args) {
        // 스택의 최대 크기 4로 선언한다.
        StackArray myStackArray = new StackArray(4);

        // 스택을 채우다.
        myStackArray.push(5);
        myStackArray.push(8);
        myStackArray.push(2);
        myStackArray.push(9);

        System.out.println("*********************Stack Array Implementation*********************");
        System.out.println(myStackArray.isEmpty()); // will print false
        System.out.println(myStackArray.isFull()); // will print true
        System.out.println(myStackArray.peek()); // will print 9
        System.out.println(myStackArray.pop()); // will print 9
        System.out.println(myStackArray.peek()); // will print 2
    }

    /**
     * Default initial capacity.
     */
    private static final int DEFAULT_CAPACITY = 10;

    /**
     * 스택의 최대 크기
     */
    private int maxSize;

    /**
     * 스택의 배열 표현
     */
    private int[] stackArray;

    /**
     * 스택의 맨 위
     */
    private int top;

    /**
     * init Stack with DEFAULT_CAPACITY
     */
    public StackArray() {
        this(DEFAULT_CAPACITY);
    }
    
    /**
     * 생성자
     *
     * @param size 스택의 크기
     */
    public StackArray(int size) {
        maxSize = size;
        stackArray = new int[maxSize];
        top = -1;
    }

    /**
     * 스택의 맨위로 요소 추가
     *
     * @param value 추가된 요소
     */
    public void push(int value) {
        if (!isFull()) { // 스택이 가득 차있는지 검사한다.
            top++;
            stackArray[top] = value;
        } else {
            resize(maxSize * 2);
            push(value); // 크기를 바꾼다음에 push할 것
        }
    }

    /**
     * 스택에서 맨 위 요소 삭제한 뒤 그 값 반환
     *
     * @return 스택에서 pop된 값
     */
    public int pop() {
        if (!isEmpty()) { // 빈 스택인지 검사
            return stackArray[top--];
        }

        if (top < maxSize / 4) {
            resize(maxSize / 2);
            return pop();// 크기 바꾼 뒤 pop한다.
        } else {
            System.out.println("The stack is already empty");
            return -1;
        }
    }

    /**
     * 스택의 맨위 요소를 반환한다.
     *
     * @return 스택의 맨위 요소
     */
    public int peek() {
        if (!isEmpty()) { // 빈 스택인지 검사
            return stackArray[top];
        } else {
            System.out.println("The stack is empty, cant peek");
            return -1;
        }
    }

    private void resize(int newSize) {
        int[] transferArray = new int[newSize];

        for (int i = 0; i < stackArray.length; i++) {
            transferArray[i] = stackArray[i];
        }
        // 이곳에서 참조변경을 하는 것을 추천한다.
        stackArray = transferArray;
        maxSize = newSize;
    }

    /**
     * 스택이 비어있을 경우 참 반환한다.
     *
     * @return true 빈 스택일 경우
     */
    public boolean isEmpty() {
        return (top == -1);
    }

    /**
     * 스택이 가득 차있을 경우 참을 반환
     *
     * @return true 스택이 가득 찬 경우
     */
    public boolean isFull() {
        return (top + 1 == maxSize);
    }

    /**
     * 스택에 있는 모든 것을 삭제한다.
     * <p>
     * 배열에 있는 요소들 삭제하지 않는다.
     * makeEmpty 호출 후에 push 메소드를 호출 한다면 덮어쓰기 될 것이다.
     * 
     */
    public void makeEmpty() { // 배열에 있는 요소들을 삭제하지 말 것
        top = -1;             // makeEmpty를 호출한 후 push 메소드를 호출 했다면 전의 값을 덮어쓰기 할 것이다.
    }
}
