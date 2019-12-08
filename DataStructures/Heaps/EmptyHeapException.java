package DataStructures.Heaps;

/**
 * @author Nicolas Renard
 * 빈 힙에 getElement 메소드를 사용할 경우 예외처리
 */
@SuppressWarnings("serial")
public class EmptyHeapException extends Exception {

    public EmptyHeapException(String message) {
        super(message);
    }

}
