package DataStructures.Bags;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * 요소 제거를 허용하지 않는 컬렉션(수집 과 반복만 한다)
 *
 * @param <Element> - bag에 들어있는 요소의 generic type
 */
public class Bag<Element> implements Iterable<Element> {

    private Node<Element> firstElement; // bag의 첫 요소 
    private int size; // bag 의 크기

    private static class Node<Element> {
        private Element content;
        private Node<Element> nextElement;
    }

    /**
     * 빈 bag 만들기
     */
    public Bag() {
        firstElement = null;
        size = 0;
    }

    /**
     * @bag 가 비어있으면 참을 반환, 아니면 거짓을 반환
     */
    public boolean isEmpty() {
        return firstElement == null;
    }

    /**
     * @요소의 개수를 반환
     */
    public int size() {
        return size;
    }

    /**
     * @param element - 추가할 요소
     */
    public void add(Element element) {
        Node<Element> oldfirst = firstElement;
        firstElement = new Node<>();
        firstElement.content = element;
        firstElement.nextElement = oldfirst;
        size++;
    }

    /**
     * bag에 특정한 요소가 들어있는지 체크한다.
     *
     * @찾고싶은 param 요소
     * @bag가 요소를 포함하면 참을 반환, 아니면 거짓을 반환
     */
    public boolean contains(Element element) {
        Iterator<Element> iterator = this.iterator();
        while (iterator.hasNext()) {
            if (iterator.next().equals(element)) {
                return true;
            }
        }
        return false;
    }

    /**
     * @ bag안의 요소를 임의적인 순서로 반복하는 interator를 반환
     */
    public Iterator<Element> iterator() {
        return new ListIterator<>(firstElement);
    }

    @SuppressWarnings("hiding")
    private class ListIterator<Element> implements Iterator<Element> {
        private Node<Element> currentElement;

        public ListIterator(Node<Element> firstElement) {
            currentElement = firstElement;
        }

        public boolean hasNext() {
            return currentElement != null;
        }

        /**
         * bag에서 제거는 허락되지 않는다
         */
        @Override
        public void remove() {
            throw new UnsupportedOperationException();
        }

        public Element next() {
            if (!hasNext())
                throw new NoSuchElementException();
            Element element = currentElement.content;
            currentElement = currentElement.nextElement;
            return element;
        }
    }

    /**
     * 테스트 위한 메인 메소드
     */
    public static void main(String[] args) {
        Bag<String> bag = new Bag<>();

        bag.add("1");
        bag.add("1");
        bag.add("2");

        System.out.println("size of bag = " + bag.size());
        for (String s : bag) {
            System.out.println(s);
        }

        System.out.println(bag.contains(null));
        System.out.println(bag.contains("1"));
        System.out.println(bag.contains("3"));
    }

}
