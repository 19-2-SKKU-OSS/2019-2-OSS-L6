package DataStructures.Heaps;

import java.lang.Double;
import java.lang.Object;

/**
 * 힙 데이터와 공통된 인터페이스<br>
 * <p>힙은 트리와 비슷한 데이터 구조로서, 요소를 특정한 방법으로 저장할 수 있다.
 * 각 노드는 한 요소에 해당하며(루트를 제외하면) 하나의 부모 노드와 최대 두 개의 자식 노드를 가지고 있다.
 * 모든 요소에는 키가 들어 있고, 그 키들은 트리를 어떻게 만들어야하는 지를 나타낸다.
 * 예를 들어, 최소 힙의 경우, 노드의 키는 부모 노드의 키보다 크거나 같아야 하고 자식 노드의 키보다 작거나 같아야 한다.
 * 최대 힙에는 반대의 규칙이 적용된다.</p>
 * <p>모든 힙 관련 작업(요소 삽입 또는 삭제, 최소 또는 최대 추출)은 O(log n)의 시간 복잡도를 가진다.</p>
 *
 * @author Nicolas Renard
 */
public class HeapElement {
    private final double key;
    private final Object additionalInfo;

    // Constructors

    /**
     * @param key  : 'double' 타입 객체의 개수
     * @param info : 사용자를 위한 추가 사용 정보만 전달하기 때문에 어떠한 종류의 immutable 객체는 null일 수 있다
     */
    public HeapElement(double key, Object info) {
        this.key = key;
        this.additionalInfo = info;
    }

    /**
     * @param key  : 'int' 타입 객체의 개수
     * @param info : 사용자를 위한 추가 사용 정보만 전달하기 때문에 어떠한 종류의 immutable 객체는 null일 수 있다
     */
    public HeapElement(int key, Object info) {
        this.key = key;
        this.additionalInfo = info;
    }

    /**
     * @param key  : 'Integer' 타입 객체의 개수
     * @param info : 사용자를 위한 추가 사용 정보만 전달하기 때문에 어떠한 종류의 immutable 객체는 null일 수 있다
     */
    public HeapElement(Integer key, Object info) {
        this.key = key;
        this.additionalInfo = info;
    }

    /**
     * @param key  : 'Double' 타입 객체의 개수
     * @param info : 사용자를 위한 추가 사용 정보만 전달하기 때문에 어떠한 종류의 immutable 객체는 null일 수 있다
     */
    public HeapElement(Double key, Object info) {
        this.key = key;
        this.additionalInfo = info;
    }

    /**
     * @param key : 'double' 타입 객체의 개수
     */
    public HeapElement(double key) {
        this.key = key;
        this.additionalInfo = null;
    }

    /**
     * @param key : 'int' 타입 객체의 개수
     */
    public HeapElement(int key) {
        this.key = key;
        this.additionalInfo = null;
    }

    /**
     * @param key :'Integer' 타입 객체의 개수
     */
    public HeapElement(Integer key) {
        this.key = key;
        this.additionalInfo = null;
    }

    /**
     * @param key : 'Double' 타입 객체의 개수
     */
    public HeapElement(Double key) {
        this.key = key;
        this.additionalInfo = null;
    }

    // Getters

    /**
     * @return 사용자가 제공한 추가 정보가 들어 있는 객체
     */
    public Object getInfo() {
        return additionalInfo;
    }

    /**
     * @return 요소의 키 값
     */
    public double getKey() {
        return key;
    }

    // 상속된 객체 메소드

    public String toString() {
        return "Key: " + key + " - " + additionalInfo.toString();
    }

    /**
     * @param otherHeapElement
     * @return 키들의 요소들이 동일하고 추가 정보 객체들이 동일할 경우 참
     */
    public boolean equals(HeapElement otherHeapElement) {
        return (this.key == otherHeapElement.key) && (this.additionalInfo.equals(otherHeapElement.additionalInfo));
    }
}
