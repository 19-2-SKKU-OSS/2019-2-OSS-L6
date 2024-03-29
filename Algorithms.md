# 알고리즘 - Java

## 해당 프로젝트에서 사용된 정렬에 대한 한글 설명입니다

해당 [Branch](https://github.com/TheAlgorithms/Java/tree/Development)는 기존 프로젝트를 Java 프로젝트 구조로 재개발하기 위해 작성되었습니다.   
누구나 개인 branch로 기여를 할 수 있습니다. 자세한 내용은 [Issue](https://github.com/TheAlgorithms/Java/issues/474)를 참고하세요.

### 자바로 구현된 모든 알고리즘들 (교육용)

이 저장소에 있는 알고리즘들은 교육용 알고리즘 입니다. 표준 자바 라이브러리에는 더 효율적인 알고리즘이 있습니다.  
단순히 교육용이므로, 속도와 성능이 떨어질 수 있습니다.  

## 정렬 알고리즘


### 버블 정렬
![alt text][bubble-image]

참조 [Wikipedia][bubble-wiki]: 버블 정렬(sinking sort 라고도 불림)은 리스트를 반복적인 단계로 접근하여 정렬합니다. 각각의 짝을 비교하며, 순서가 잘못된 경우 근접한 아이템들을 바꾸는 알고리즘입니다. 더 이상 바꿀 것이 없을 때까지 반복하며, 반복이 끝났다는 것은 리스트가 정렬되었음을 의미합니다.

__속성__
* 최악의 성능    O(n^2)
* 최고의 성능    O(n)
* 평균 성능    O(n^2)

###### 눈으로 보고 싶다면 [참조][bubble-toptal]
  


### 삽입 정렬
![alt text][insertion-image]

참조 [Wikipedia][insertion-wiki]: 삽입 정렬은 최종 정렬된 배열(또는 리스트)을 한번에 하나씩 구축하는 알고리즘입니다. 이 알고리즘은 큰 규모의 리스트에서 퀵 정렬, 힙 정렬, 또는 머지 정렬보다 훨씬 효율이 좋지 않습니다. 그림에서 각 막대는 정렬해야 하는 배열의 요소를 나타냅니다. 상단과 두 번째 상단 막대의 첫 번째 교차점에서 발생하는 것은 두 번째 요소가 첫 번째 요소보다 더 높은 우선 순위를 가지기 떄문에 막대로 표시되는 요소를 교환한 것입니다. 이 방법을 반복하면 삽입 정렬이 완료됩니다.

__속성__
* 최악의 성능    O(n^2)
* 최고의 성능    O(n)
* 평균     O(n^2)

###### 눈으로 보고 싶다면 [참조][insertion-toptal]
  

### 병합 정렬
![alt text][merge-image]

참조 [Wikipedia][merge-wiki]: 병합 정렬은 효율적이며 범용적이고 비교 기반 정렬 알고리즘입니다. 대부분은 안정적인 상태를 유지합니다. 이것은 정렬되어 출력될 때 동일한 입력 순서를 유지한다는 것을 의미합니다. 병합 정렬은 1945년에 John von Neumann이 발명한 분할 정복 알고리즘입니다.

__속성__
* 최악의 성능    O(n log n) (일반적)
* 최고의 성능    O(n log n)
* 평균    O(n log n)


###### 눈으로 보고 싶다면 [참조][merge-toptal]
  
### 퀵 정렬
![alt text][quick-image]

참조 [Wikipedia][quick-wiki]: 퀵 정렬(가끔 partition-exchange sort 라고도 불림)은 효율적인 정렬 알고리즘으로, 랜덤 액세스 파일 또는 배열의 요소를 순서대로 배치하기위한 체계적인 방법으로 사용됩니다. 1959 년 영국 컴퓨터 과학자 토니 호아 (Tony Hoare)가 개발하고 1961 년에 출판 한 이 알고리즘은 여전히 ​​ 일반적으로 사용되는 정렬 알고리즘입니다. 

__속성__
* 최악의 성능    O(n^2)
* 최고의 성능    O(n log n) or O(n) with three-way partition
* 평균    O(n log n)

여기서 시간 복잡도만 본다면 병합 정렬보다 최악의 경우에 성능이 O(n^2)으로 성능이 안 좋아 보일수도 있습니다. 하지만 실제로 속도를 따져보면 퀵 정렬이 더 빠른 경우가 많은데, 그 이유는 퀵 정렬이 **Cache-friendly** 하기 때문입니다. Cache-friendly에 대해서 궁금하시다면 다음 [링크](https://stackoverflow.com/questions/16699247/what-is-a-cache-friendly-code)를 참조하시기 바랍니다.  

###### 눈으로 보고 싶다면 [참조][quick-toptal]
  
### 선택 정렬
![alt text][selection-image]

참조 [Wikipedia][selection-wiki]: 입력 리스트를 두 부분으로 나눕니다. 첫 부분은 항목들이 이미 왼쪽에서 오른쪽으로 정렬되었습니다. 알고리즘은 가장 작은 요소를 정렬되지 않은 리스트에서 찾고 정렬이 안 된 가장 왼쪽(정렬된 리스트) 리스트와 바꿉니다. 이렇게 오른쪽으로 진행해 나갑니다.

__속성__
* 최악의 성능    O(n^2)
* 최고의 성능    O(n^2)
* 평균    O(n^2)

###### 눈으로 보고 싶다면 [참조][selection-toptal]
  
### 쉘 정렬
![alt text][shell-image]

참조 [Wikipedia][shell-wiki]:  쉘 정렬은 멀리 떨어져 있는 항목의 교환하며 정렬합니다. 핵심 아이디어는 모든 n번째 요소가 정렬된 목록을 제공한다는 것을 고려하여 어느 곳에서든지 시작하도록 요소의 목록을 배열하는 것입니다. 이러한 목록은 h-sorted로 알려져 있습니다.

__속성__
* 최악의 성능 O(nlog2 2n)
* 최고의 성능 O(n log n)
* 평균 사례의 성능은 시퀀스의 차이에 따라 다릅니다

###### 눈으로 보고 싶다면 [참조][shell-toptal]
  
### 시간 복잡도 그래프

정렬 알고리즘의 복잡도 비교 (버블 정렬, 삽입 정렬, 선택 정렬)

[복잡도 그래프](https://github.com/prateekiiest/Python/blob/master/sorts/sortinggraphs.png)

----------------------------------------------------------------------------------

## 검색 알고리즘

### 선형 탐색
![alt text][linear-image]

참조 [Wikipedia][linear-wiki]: 선형 탐색 또는 순차 탐색은 리스트 내에서 목표값을 찾는 방법입니다. 항목이 일치하거나 모든 요소가 탐색될 때까지 목록의 각 요소에 대해 목표값을 순차적으로 비교합니다. 선형 탐색은 최악의 경우 O(n)으로 실행되며 최대 n개의 비교를 합니다. 여기서 n은 리스트의 길이입니다.

__속성__
* 최악의 성능    O(n)
* 최고의 성능    O(1)
* 평균    O(n)
* 최악의 경우 공간 복잡    O(1) iterative
  
### 이진 탐색
![alt text][binary-image]

출처 [Wikipedia][binary-wiki]: 이진 탐색(로그 탐색이라고도 불림)은 정렬된 배열 내에서 목표값의 위치를 찾는 검색 알고리즘입니다.  
배열의 중간 요소와 목표값을 비교해서 만약 동일하지 않으면, 탐색할 배열의 절반을 제거하고 검색이 완료될 때까지 나머지 절반에서 이 과정을 반복합니다.

__속성__
* 최악의 성능    O(log n)
* 최고의 성능    O(1)
* 평균    O(log n)
* 최악의 경우 공간 복잡도    O(1) 
  

[bubble-toptal]: https://www.toptal.com/developers/sorting-algorithms/bubble-sort
[bubble-wiki]: https://en.wikipedia.org/wiki/Bubble_sort
[bubble-image]: https://upload.wikimedia.org/wikipedia/commons/thumb/8/83/Bubblesort-edited-color.svg/220px-Bubblesort-edited-color.svg.png "Bubble Sort"

[insertion-toptal]: https://www.toptal.com/developers/sorting-algorithms/insertion-sort
[insertion-wiki]: https://en.wikipedia.org/wiki/Insertion_sort
[insertion-image]: https://upload.wikimedia.org/wikipedia/commons/7/7e/Insertionsort-edited.png "Insertion Sort"

[quick-toptal]: https://www.toptal.com/developers/sorting-algorithms/quick-sort
[quick-wiki]: https://en.wikipedia.org/wiki/Quicksort
[quick-image]: https://upload.wikimedia.org/wikipedia/commons/6/6a/Sorting_quicksort_anim.gif "Quick Sort"

[merge-toptal]: https://www.toptal.com/developers/sorting-algorithms/merge-sort
[merge-wiki]: https://en.wikipedia.org/wiki/Merge_sort
[merge-image]: https://upload.wikimedia.org/wikipedia/commons/c/cc/Merge-sort-example-300px.gif "Merge Sort"

[selection-toptal]: https://www.toptal.com/developers/sorting-algorithms/selection-sort
[selection-wiki]: https://en.wikipedia.org/wiki/Selection_sort
[selection-image]: https://upload.wikimedia.org/wikipedia/commons/thumb/b/b0/Selection_sort_animation.gif/250px-Selection_sort_animation.gif "Selection Sort Sort"

[shell-toptal]: https://www.toptal.com/developers/sorting-algorithms/shell-sort
[shell-wiki]: https://en.wikipedia.org/wiki/Shellsort
[shell-image]: https://upload.wikimedia.org/wikipedia/commons/d/d8/Sorting_shellsort_anim.gif "Shell Sort"

[linear-wiki]: https://en.wikipedia.org/wiki/Linear_search
[linear-image]: http://www.tutorialspoint.com/data_structures_algorithms/images/linear_search.gif

[binary-wiki]: https://en.wikipedia.org/wiki/Binary_search_algorithm
[binary-image]: https://upload.wikimedia.org/wikipedia/commons/f/f7/Binary_search_into_array.png


--------------------------------------------------------------------
## 나머지 알고리즘에 대한 링크

전환          |                                          다이나믹프로그래밍(DP)   |암호|그 외 것들|
-----------          |----------------------------------------------------------------|-------|-------------|
[Any Base to Any Base](Conversions/AnyBaseToAnyBase.java)| [Coin Change](Dynamic%20Programming/CoinChange.java)|[Caesar](ciphers/Caesar.java)|[Heap Sort](misc/heap_sort.java)|
[Any Base to Decimal](Conversions/AnyBaseToDecimal.java)|[Egg Dropping](Dynamic%20Programming/EggDropping.java)|[Columnar Transposition Cipher](ciphers/ColumnarTranspositionCipher.java)|[Palindromic Prime Checker](misc/PalindromicPrime.java)|
[Binary to Decimal](Conversions/BinaryToDecimal.java)|[Fibonacci](Dynamic%20Programming/Fibonacci.java)|[RSA](ciphers/RSA.java)|More soon...|
[Binary to HexaDecimal](Conversions/BinaryToHexadecimal.java)|[Kadane Algorithm](Dynamic%20Programming/KadaneAlgorithm.java)|more coming soon...|
[Binary to Octal](Conversions/BinaryToOctal.java)|[Knapsack](Dynamic%20Programming/Knapsack.java)|
[Decimal To Any Base](Conversions/DecimalToAnyBase.java)|[Longest Common Subsequence](Dynamic%20Programming/LongestCommonSubsequence.java)|
[Decimal To Binary](Conversions/DecimalToBinary.java)|[Longest Increasing Subsequence](Dynamic%20Programming/LongestIncreasingSubsequence.java)|
[Decimal To Hexadecimal](Conversions/DecimalToHexaDecimal.java)|[Rod Cutting](Dynamic%20Programming/RodCutting.java)|
and much more...|                                                    and more...|

### 자료 구조
그래프|힙|리스트|큐|
------|-----|-----|------|
[너비우선탐색](DataStructures/Graphs/BFS.java)|[빈 힙 예외처리](DataStructures/Heaps/EmptyHeapException.java)|[원형 연결리스트](DataStructures/Lists/CircleLinkedList.java)|[제너릭 어레이 리스트 큐](DataStructures/Queues/GenericArrayListQueue.java)|
[깊이우선탐색](DataStructures/Graphs/DFS.java)|[힙](DataStructures/Heaps/Heap.java)|[이중 연결리스트](DataStructures/Lists/DoublyLinkedList.java)|[큐](DataStructures/Queues/Queues.java)|
[그래프](DataStructures/Graphs/Graphs.java)|[힙 요소](DataStructures/Heaps/HeapElement.java)|[단순 연결리스트](DataStructures/Lists/SinglyLinkedList.java)|
[크루스칼 알고리즘](DataStructures/Graphs/KruskalsAlgorithm.java)|[최대힙](Data%Structures/Heaps/MaxHeap.java)|
[행렬 그래프](DataStructures/Graphs/MatrixGraphs.java)|[최소힙](DataStructures/Heaps/MinHeap.java)|
[프림 최소신장트리](DataStructures/Graphs/PrimMST.java)|

스택|트리|
------|-----|
[노드 스택](DataStructures/Stacks/NodeStack.java)|[AVL 트리](DataStructures/Trees/AVLTree.java)|
[연결리스트 스택](DataStructures/Stacks/StackOfLinkedList.java)|[이진 트리](DataStructures/Trees/BinaryTree.java)|
[스택](DataStructures/Stacks)|And much more...|

* [Bags](DataStructures/Bags/Bag.java)
* [Buffer](DataStructures/Buffers/CircularBuffer.java)
* [HashMap](DataStructures/HashMap/HashMap.java)
* [Matrix](DataStructures/Matrix/Matrix.java)
