import java.util.ArrayList;

/**
 * 이 클래스는 ArrayList를 사용하여 스택을 구현했다.
 * <p>
 * 스택이 의미하는 것은 무더기이다. 
 * 스택 맨 위에 요소가 추가되고 맨 위에있는 요소 만 제거 될 수 있습니다.
 * <p>
 * 이것은 ArrayList을 사용한 stack구현이다.
 * 우리가 원하는 만큼 스택을 확장할 수 있기 때문에 크기는 문제가 되지 않는다. 
 *
 * @author Unknown
 */
public class StackArrayList {

    /**
     * 메인 메소드
     *
     * @param args Command line arguments
     */
    public static void main(String[] args) {
        
        StackArrayList myStackArrayList = new StackArrayList();
        
        myStackArrayList.push(5);
        myStackArrayList.push(8);
        myStackArrayList.push(2);
        myStackArrayList.push(9);

        System.out.println("*********************Stack List Implementation*********************");
        System.out.println(myStackArrayList.isEmpty()); // will print false
        System.out.println(myStackArrayList.peek()); // will print 9
        System.out.println(myStackArrayList.pop()); // will print 9
        System.out.println(myStackArrayList.peek()); // will print 2
        System.out.println(myStackArrayList.pop()); // will print 2
    }

    /**
     * ArrayList를 사용한 스택 구현
     */
    private ArrayList<Integer> stackList;

    /**
     * 생성자
     */
    public StackArrayList() {
        stackList = new ArrayList<>();
    }

    /**
     * 스택의 맨 위에있는 값을 추가한다.
     *
     * @param value 추가될 값
     */
    public void push(int value) {
        stackList.add(value);
    }

    /**
     * 스택의 맨위에 있는 마지막 요소를 pop한다.
     *
     * @return Element popped
     */
    public int pop() {

        if (!isEmpty()) { // 빈 스택을 체크한다.
            int popValue = stackList.get(stackList.size() - 1);
            stackList.remove(stackList.size() - 1);  // 리스트로 부터 pop된 요소 제거한다.
            return popValue;
        }

        System.out.print("The stack is already empty!");
        return -1;
    }

    /**
     * Checks for empty Stack
     *
     * @return true if stack is empty
     */
    public boolean isEmpty() {
        return stackList.isEmpty();
    }

    /**
     * Top element of stack
     *
     * @return top element of stack
     */
    public int peek() {
        return stackList.get(stackList.size() - 1);
    }
}
