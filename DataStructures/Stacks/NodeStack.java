/**
* 노드를 사용한 스택 구현
* 무제한의 크기, arraylist를 사용하지 않은
*
* @author Kyler Smith, 2017
*/


public class NodeStack<Item> {

    /**
    * 프로그램 진입
    */
    public static void main(String[] args) {
        NodeStack<Integer> Stack = new NodeStack<Integer>();

        Stack.push(3);
        Stack.push(4);
        Stack.push(5);
        System.out.println("Testing :");
        Stack.print();  			// prints : 5 4 3

        Integer x = Stack.pop(); 	// x = 5
        Stack.push(1);
        Stack.push(8);
        Integer y = Stack.peek();	// y = 8
        System.out.println("Testing :");
        Stack.print();				// prints : 8 1 4 3

        System.out.println("Testing :");
        System.out.println("x : " + x);
        System.out.println("y : " + y);
    }

    /**
    * 각 노드에 포함되어야 하는 정보
    * @value data : 노드 값 정보
    * @value head : 스택의 head
    * @value next : 노드 다음의 값
    * @value previous : 이 노드로부터 마지막 값
    * @value size : 스택의 크기
    */
    private Item data;
    private static NodeStack<?> head;
    private NodeStack<?> next;
    private NodeStack<?> previous;
    private static int size = 0;


    /**
    * NodeStack의 생성자
    */
    public NodeStack() {
	}

    private NodeStack(Item item) {
        this.data = item;
    }

    /**
    * stack에 값을 넣는다.
    *
    * @param item : 스택에 넣을 값
    */
    public void push(Item item) {

    	NodeStack<Item> newNs = new NodeStack<Item>(item);

        if(this.isEmpty()) {
        	NodeStack.setHead(new NodeStack<>(item));
        	newNs.setNext(null);
        	newNs.setPrevious(null);
        } else {
        	newNs.setPrevious(NodeStack.head);
        	NodeStack.head.setNext(newNs);
        	NodeStack.head = newNs;
        }

        NodeStack.setSize(NodeStack.getSize() + 1);
    }

    /**
    * 스택에서 값 꺼내기
    *
    * @return item : 반환된 값
    */
    public Item pop() {

    	Item item = (Item) NodeStack.head.getData();

    	NodeStack.head = NodeStack.head.getPrevious();
    	NodeStack.head.setNext(null);

    	NodeStack.setSize(NodeStack.getSize() - 1);

        return item;
    }

    /**
    * 스택에서 다음으로 제거할 값
    *
    * @return item : 스택에서 팝된 다음 값
    */
    public Item peek() {
        return (Item) NodeStack.head.getData();
    }

    /**
    * 스택에 비어있는지 아닌지 검사
    *
    * @return boolean : 스택이 비어있는지 아닌지
    */
    public boolean isEmpty() {
        return NodeStack.getSize() == 0;
    }

    /**
    * Returns 스택의 크기
    *
    * @return int : 스택에 있는 값 개수
    */
    public int size() {
        return NodeStack.getSize();
    }

    /**
    * 스택의 내용을 다음 형식으로 출력한다.
    *
    * x <- head (next out)
    * y
    * z <- tail (first in)
    * .
    * .
    * .
    *
    */
    public void print() {
    	for(NodeStack<?> n = NodeStack.head; n != null; n = n.previous) {
    		System.out.println(n.getData().toString());
    	}
    }

    /** Getters and setters (private) */
    private NodeStack<?> getHead() {
    	return NodeStack.head;
    }

    private static void setHead(NodeStack<?> ns) {
    	NodeStack.head = ns;
    }

    private NodeStack<?> getNext() {
		return next;
	}

    private void setNext(NodeStack<?> next) {
		this.next = next;
	}

    private NodeStack<?> getPrevious() {
		return previous;
	}

    private void setPrevious(NodeStack<?> previous) {
		this.previous = previous;
	}

    private static int getSize() {
		return size;
	}

    private static void setSize(int size) {
		NodeStack.size = size;
	}

    private Item getData() {
		return this.data;
	}

    private void setData(Item item) {
		this.data = item;
	}
}
