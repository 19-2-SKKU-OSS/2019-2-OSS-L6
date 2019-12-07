/* 팀 정렬: 병합 정렬과 삽입 정렬을 혼합한 하이브리드 정렬. 병합 정렬은 원소의 개수가 적을 경우 오버헤드가 발생하기 때문에 파티션 크기가 특정 값(16 또는 32) 이하가 되면 삽입 정렬을 사용한다.
 * 시간복잡도: O(nlogn), 최악의 경우: O(nlogn), 최선의 경우: O(n)
 * */
class GFG //
{ 
  
    static int RUN = 32; //기준을 32로 잡음
  
    public static void insertionSort(int[] arr, int left, int right) //삽입 정렬 함수  
    { 
        for (int i = left + 1; i <= right; i++)  
        { 
            int temp = arr[i]; 
            int j = i - 1; 
            while (arr[j] > temp && j >= left) 
            { 
                arr[j + 1] = arr[j]; 
                j--; 
            } 
            arr[j + 1] = temp; 
        } 
    } 
  
    public static void merge(int[] arr, int l,  
                                int m, int r) //병합 정렬 함수
    { 
        int len1 = m - l + 1, len2 = r - m; 
        int[] left = new int[len1]; 
        int[] right = new int[len2]; 
        for (int x = 0; x < len1; x++)  
        { 
            left[x] = arr[l + x]; 
        } 
        for (int x = 0; x < len2; x++)  
        { 
            right[x] = arr[m + 1 + x]; 
        } 
  
        int i = 0; 
        int j = 0; 
        int k = l; 
  
        while (i < len1 && j < len2)  
        { 
            if (left[i] <= right[j])  
            { 
                arr[k] = left[i]; 
                i++; 
            } 
            else 
            { 
                arr[k] = right[j]; 
                j++; 
            } 
            k++; 
        } 
        while (i < len1) 
        { 
            arr[k] = left[i]; 
            k++; 
            i++; 
        } 

        while (j < len2)  
        { 
            arr[k] = right[j]; 
            k++; 
            j++; 
        } 
    }

    public static void timSort(int[] arr, int n) //하이브리드 함수
    { 
          
        for (int i = 0; i < n; i += RUN) //RUN의 크기를 기준으로
        { 
            insertionSort(arr, i, Math.min((i + 31), (n - 1))); //삽입 정렬을 실행
        } 
        for (int size = RUN; size < n; size = 2 * size) //RUN 크기를 기준으로 
        { 
            for (int left = 0; left < n; left += 2 * size)  
            { 
                int mid = left + size - 1; 
                int right = Math.min((left + 2 * size - 1), (n - 1)); 
                merge(arr, left, mid, right); //병합 정렬을 실행
            } 
        } 
    } 

    public static void printArray(int[] arr, int n) //배열을 출력하는 함수
    { 
        for (int i = 0; i < n; i++) 
        { 
            System.out.print(arr[i] + " "); 
        } 
        System.out.print("\n"); 
    } 
  
    // 메인 함수  
    public static void main(String[] args)  
    { 
        int[] arr = {5, 21, 7, 23, 19}; 
        int n = arr.length; 
        System.out.print("Given Array is\n"); 
        printArray(arr, n); 
  
        timSort(arr, n); 
  
        System.out.print("After Sorting Array is\n"); 
        printArray(arr, n); 
    } 
}


//This code has been contributed by 29AjayKumar

