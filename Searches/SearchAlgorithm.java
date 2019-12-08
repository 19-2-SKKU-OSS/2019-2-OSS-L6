package Searches;


/**
 * 대부분의 검색 알고리즘의 공통 인터페이스
 *
 * @author Podshivalov Nikita (https://github.com/nikitap492)
 **/

public interface SearchAlgorithm {

    
 /**
 * @param 키는 찾아야 할 요소입니다
 * @param array는 요소를 찾아야하는 배열입니다
 * @param <T> 비교 가능한 유형
 * @return은 요소의 색인을 처음 발견했습니다.
 **/
    <T extends Comparable<T>> int find(T array[], T key);

}
