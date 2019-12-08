package Misc;

public class heap_sort {
    public void sort(int[] arr) {
        int n = arr.length;

        // Heap을 만듭니다
        for (int i = n / 2 - 1; i >= 0; i--)
            heapify(arr, n, i);

        // Heap에서 원소 하나씩 빼냅니다
        for (int i = n - 1; i >= 0; i--) {
            // temp변수를 처음부터 끝까지 보냅니다
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            // call max heapify on the reduced heap
            heapify(arr, i, 0);
        }
    }

    // 배열 arr의 노드 i를 루트로 하는 서브트리를 heapify합니다
    // n은 heap의 크기입니다
    void heapify(int[] arr, int n, int i) {
        int largest = i;  // Initialize largest as root
        int l = 2 * i + 1;  // left = 2*i + 1
        int r = 2 * i + 2;  // right = 2*i + 2

        // 왼쪽 자식이 루트보다 작다면
        if (l < n && arr[l] > arr[largest])
            largest = l;

        // 오른쪽 자식이 지금까지 가장 큰 자식보다 크다면
        if (r < n && arr[r] > arr[largest])
            largest = r;

        // 가장 큰게 루트가 아닌경우
        if (largest != i) {
            int swap = arr[i];
            arr[i] = arr[largest];
            arr[largest] = swap;

            // 관련된 서브 트리를 heapify합니다
            heapify(arr, n, largest);
        }
    }

    /* 길이 n인 배열을 출력합니다 */
    static void printArray(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; ++i)
            System.out.print(arr[i] + " ");
        System.out.println();
    }

    // Driver program
    public static void main(String args[]) {
        int arr[] = {12, 11, 13, 5, 6, 7};
        int n = arr.length;

        heap_sort ob = new heap_sort();
        ob.sort(arr);

        System.out.println("Sorted array is");
        printArray(arr);
    }
}
