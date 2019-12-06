package Sorts;

/**
 * @author Mateus Bizzo (https://github.com/MattBizzo)
 * @author Podshivalov Nikita (https://github.com/nikitap492)
 * 칵테일 쉐이커 정렬: 양방향 버블 정렬이다. 가장 큰 값을 찾고, 가장 작은 값을 찾고, 2번째로 큰 값을 찾고 2번째로 작은 값을 찾는 식의 작업을 반복하는 정렬이다.
 * 시간복잡도: O(n^2), 최악의 경우: O(n^2), 최선의 경우: O(n)(버블 정렬은 O(n^2))
 * /

class CocktailShakerSort implements SortAlgorithm { //CocktailShakerSort 클래스 정의

    /**
     * This method implements the Generic Cocktail Shaker Sort
     *
     * @param array The array to be sorted
     *              Sorts the array in increasing order
     **/

    @Override
    public <T extends Comparable<T>> T[] sort(T[] array) { //정렬하는 함수

        int length = array.length;
        int left = 0; //왼쪽 끝
        int right = length - 1; //오른쪽 끝
        int swappedLeft, swappedRight;
        while (left < right) {
            // front
            swappedRight = 0;
            for (int i = left; i < right; i++) {//왼쪽 끝부터 오른쪽 끝까지
                if (SortUtils.less(array[i + 1], array[i])) {//i+1 인덱스의 값이 i 인덱스의 값보다 작으면->앞에서 뒤로 가기 때문에 오름차순 정렬
                    SortUtils.swap(array, i, i + 1); //스왑한다.
                    swappedRight = i;//마지막으로 스왑된 i의 인덱스를 저장
                }
            }
            // back
            right = swappedRight;//마지막으로 스왑된 i의 인덱스를 right로 설정하면서 쓸데없는 비교를 없애며 시간 절약
            swappedLeft = length - 1;
            for (int j = right; j > left; j--) {//오른쪽 끝부터 왼쪽 끝까지
                if (SortUtils.less(array[j], array[j - 1])) {//이번엔 j가 j-1보다 작으면->뒤에서 앞으로 가기 때문에 내림차순으로 해줘야 결과적으로 오름차순 정렬이 된다.
                    SortUtils.swap(array, j - 1, j); //스왑한다.
                    swappedLeft = j;//마지막으로 스왑된 j의 인덱스를 저장
                }
            }
            left = swappedLeft; //마지막으로 스왑된 j의 인덱스를 left로 설정하면서 쓸데없는 비교를 없애며 시간 절약
        }
        return array;//정렬된 배열 리턴

    }

    // Driver Program
    public static void main(String[] args) {
        // Integer Input
        Integer[] integers = {4, 23, 6, 78, 1, 54, 231, 9, 12};
        CocktailShakerSort shakerSort = new CocktailShakerSort();

        // Output => 1 4 6 9 12 23 54 78 231
        SortUtils.print(shakerSort.sort(integers));

        // String Input
        String[] strings = {"c", "a", "e", "b", "d"};
        SortUtils.print(shakerSort.sort(strings));
    }


}
