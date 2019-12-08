/*
 * 인트로 정렬: 퀵 정렬과 힙 정렬을 혼합한 하이브리드 정렬. 이 코드에서는 파티션의 크기가 16 이하일 때, 삽입 정렬을 하여 최적화시켰다.
 * 시간복잡도: O(nlogn), 최악의 경우: O(nlogn)
 */ 
import java.io.IOException; 
  
public class Introsort { //Introsort 클래스 정의
  
    private int a[]; 
    private int n; 

    Introsort(int n) //생성자
    { 
        a = new int[n]; 
        this.n = 0; 
    } 
  
    private void dataAppend(int temp) //데이터를 추가하는 함수
    { 
        a[n] = temp; 
        n++; 
    } 
  
    private void swap(int i, int j) //데이터를 스왑하는 함수
    { 
        int temp = a[i]; 
        a[i] = a[j]; 
        a[j] = temp; 
    } 
  
    private void maxHeap(int i, int heapN, int begin) //최대힙을 구하는 함수
    { 
        int temp = a[begin + i - 1]; 
        int child; 
  
        while (i <= heapN / 2) { 
            child = 2 * i; 
  
            if (child < heapN 
                && a[begin + child - 1] < a[begin + child]) 
                child++; 
  
            if (temp >= a[begin + child - 1]) 
                break; 
  
            a[begin + i - 1] = a[begin + child - 1]; 
            i = child; 
        } 
        a[begin + i - 1] = temp; 
    } 
  
    private void heapify(int begin, int end, int heapN) //배열을 힙 구조로 만드는 함수
    { 
        for (int i = (heapN) / 2; i >= 1; i--) 
            maxHeap(i, heapN, begin); 
    } 
  
    private void heapSort(int begin, int end) //힙 정렬 함수
    { 
        int heapN = end - begin; 
  
        this.heapify(begin, end, heapN); 
  
        for (int i = heapN; i >= 1; i--) { 
  
            swap(begin, begin + i); 
  
            maxHeap(1, i, begin); 
        } 
    } 
  
    private void insertionSort(int left, int right) //삽입 정렬 함수
    { 
  
        for (int i = left; i <= right; i++) { 
            int key = a[i]; 
            int j = i; 
  
            while (j > left && a[j - 1] > key) { 
                a[j] = a[j - 1]; 
                j--; 
            } 
            a[j] = key; 
        } 
    } 
  
    private int findPivot(int a1, int b1, int c1) //퀵 정렬에 사용할 피벗을 찾는 함수
    { 
        int max = Math.max(Math.max(a[a1], a[b1]), a[c1]); 
        int min = Math.min(Math.min(a[a1], a[b1]), a[c1]); 
        int median = max ^ min ^ a[a1] ^ a[b1] ^ a[c1]; 
        if (median == a[a1]) 
            return a1; 
        if (median == a[b1]) 
            return b1; 
        return c1; 
    } 
  
    private int partition(int low, int high) //퀵 정렬에서 파티션을 나누며 정렬하는 함수
    { 
        int pivot = a[high]; 
  
        int i = (low - 1); 
        for (int j = low; j <= high - 1; j++) { 
  
            if (a[j] <= pivot) { 
  
                i++; 
                swap(i, j); 
            } 
        } 
        swap(i + 1, high); 
        return (i + 1); 
    } 
  
    private void sortDataUtil(int begin, int end, int depthLimit) //힙 정렬과 퀵 정렬을 번갈아가면서 정렬하는 함수
    { 
        if (end - begin > 16) { 
            if (depthLimit == 0) { 
                this.heapSort(begin, end); 
                return; 
            } 
  
            depthLimit = depthLimit - 1; 
            int pivot = findPivot(begin, 
                begin + ((end - begin) / 2) + 1, 
                                           end); 
            swap(pivot, end); 
  
            int p = partition(begin, end); 
  
            sortDataUtil(begin, p - 1, depthLimit); 
            sortDataUtil(p + 1, end, depthLimit); 
        } 
  
        else { 
            insertionSort(begin, end); 
        } 
    } 
  
    private void sortData() //퀵 정렬과 힙 정렬의 기준을 정하고 정렬하는 함수
    { 
  
        int depthLimit 
            = (int)(2 * Math.floor(Math.log(n) / 
                                  Math.log(2))); 
  
        this.sortDataUtil(0, n - 1, depthLimit); 
    } 
  
    private void printData() //데이터를 출력하는 함수
    { 
        for (int i = 0; i < n; i++) 
            System.out.print(a[i] + " "); 
    } 
  
    // 메인 함수
    public static void main(String args[]) throws IOException 
    { 
        int[] inp = { 2, 10, 24, 2, 10, 11, 27, 
                      4, 2, 4, 28, 16, 9, 8, 
                      28, 10, 13, 24, 22, 28, 
                      0, 13, 27, 13, 3, 23, 
                      18, 22, 8, 8 }; 
  
        int n = inp.length; 
        Introsort introsort = new Introsort(n); 
  
        for (int i = 0; i < n; i++) { 
            introsort.dataAppend(inp[i]); 
        } 
  
        introsort.sortData(); 
        introsort.printData(); 
    } 
} 

//This code has been contributed by Lokesh Karthikeyan
