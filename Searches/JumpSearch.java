package Searches;

public class JumpSearch implements SearchAlgorithm {

    public static void main(String[] args) {
        JumpSearch jumpSearch = new JumpSearch();
        Integer[] array = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        for (int i = 0; i < array.length; i++) {
            assert jumpSearch.find(array, i) == i;
        }
        assert jumpSearch.find(array, -1) == -1;
        assert jumpSearch.find(array, 11) == -1;
    }

    /**
     * J점프 검색 알고리즘 구현
     *
     * @param array is 요소를 포함합니다
     * 검색 할 @param key
     * {@code 키}의 @return 색인 (발견 된 경우), 그렇지 않으면 <tt> -1 </ tt>
     */
    @Override
    public <T extends Comparable<T>> int find(T[] array, T key) {
        int length = array.length; /* 배열의 길이 */
        int blockSize = (int) Math.sqrt(length); /* 점프할 블록의 크기 */

        int limit = blockSize;
        while (key.compareTo(array[limit]) > 0 && limit < array.length - 1) {
            limit = Math.min(limit + blockSize, array.length - 1);
        }

        for (int i = limit - blockSize; i <= limit; i++) {
            if (array[i] == key) { /* 선형 검색 실행 */
                return i;
            }
        }
        return -1; /* 찾지 못한 경우 */
    }
}
