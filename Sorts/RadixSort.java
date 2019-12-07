package Sorts;

import java.util.Arrays;
/*
 * 기수 정렬: 데이터를 낮은 자릿수부터 같은 자릿수끼리 비교하며 정렬하며 전체 데이터를 정렬.
 * 시간복잡도: O(k*n) (k는 데이터 중 최대 자릿수)
 */
class RadixSort { //RadixSort 클래스 정의

    private static int getMax(int arr[], int n) { //최대값을 구하는 함수
        int mx = arr[0];
        for (int i = 1; i < n; i++)
            if (arr[i] > mx)
                mx = arr[i];
        return mx;
    }

    private static void countSort(int arr[], int n, int exp) { //자릿수끼리 정렬하는 함수
        int output[] = new int[n];
        int i;
        int count[] = new int[10];
        Arrays.fill(count, 0); //count를 모두 0으로 초기화

        for (i = 0; i < n; i++)
            count[(arr[i] / exp) % 10]++; //데이터들의 임의의 자릿수가 같은 것끼리의 개수 저장

        for (i = 1; i < 10; i++)
            count[i] += count[i - 1]; //하나 큰 수의 개수에 하나 작은 수의 개수를 계속 더해줌

        for (i = n - 1; i >= 0; i--) {
            output[count[(arr[i] / exp) % 10] - 1] = arr[i]; //arr의 값을 output에 저장하고
            count[(arr[i] / exp) % 10]--; //count를 하나 줄임
        }

        for (i = 0; i < n; i++)
            arr[i] = output[i]; //다시 arr에 output값을 저장
    }

    private static void radixsort(int arr[], int n) {

        int m = getMax(arr, n);


        for (int exp = 1; m / exp > 0; exp *= 10) //한 자릿수부터 최대 자릿수만큼
            countSort(arr, n, exp); //자릿수끼리 정렬
    }


    static void print(int arr[], int n) { //원소를 출력하는 함수
        for (int i = 0; i < n; i++)
            System.out.print(arr[i] + " ");
    }


    public static void main(String[] args) {
        int arr[] = {170, 45, 75, 90, 802, 24, 2, 66};
        int n = arr.length;
        radixsort(arr, n);
        print(arr, n);
    }
}
// Written by James Mc Dermott(theycallmemac)
