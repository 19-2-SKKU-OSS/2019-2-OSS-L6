package Searches;

import java.util.Scanner;

/**
 * 새들백 검색을 수행하는 프로그램
 * 정렬 된 2D 배열이 주어지면 (오름차순으로 가정하여 모든 행과 열에서 요소가 정렬됩니다)
 * n * m 크기의 O (n + m)에서 주어진 요소를 검색 할 수 있습니다.
 * <p>
 * 왼쪽 아래에서 시작합니다
 * 현재 요소가 주어진 요소보다 크면 위로 이동
 * 그렇지 않으면 우회전
 * 샘플 입력 :
 * 5 5-> 치수
 * -10-5-3 34 9
 * -6-2 5 5 10
 * -4-1 6 12
 * 2 3 7 8 13
 * 100120130140150
 * 140-> 검색 할 요소
 * 출력 : 4 3 // 첫 번째 값은 행이고 두 번째 값은 열이다.
 *
 * @author Nishita Aggarwal
 */
public class SaddlebackSearch {

    /**
     * 이 방법은 새들백 검색을 수행합니다.
     *
     * @param arr 요소를 검색 할 ** Sorted ** 배열입니다.
     * @param row 는 현재 행입니다.
     * @param col 현재 열.
     * @param key 검색하고자하는 요소.
     * @return 발견 된 경우 요소의 주소 (행 및 열)
     * Else returns -1 -1.
     */
    private static int[] find(int arr[][], int row, int col, int key) {

        // 응답 행과 열을 저장하는 배열
        int ans[] = {-1, -1};
        if (row < 0 || col >= arr[row].length) {
            return ans;
        }
        if (arr[row][col] == key) {
            ans[0] = row;
            ans[1] = col;
            return ans;
        }
        // 현재 요소가 주어진 요소보다 크면 위로 이동합니다
        else if (arr[row][col] > key) {
            return find(arr, row - 1, col, key);
        }
        //그렇지 않으면 오른쪽으로 이동
        return find(arr, row, col + 1, key);
    }

    /**
     * 주요 방법
     *
     * @param args 명령 줄 인수
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Scanner sc = new Scanner(System.in);
        int arr[][];
        int i, j, rows = sc.nextInt(), col = sc.nextInt();
        arr = new int[rows][col];
        for (i = 0; i < rows; i++) {
            for (j = 0; j < col; j++) {
                arr[i][j] = sc.nextInt();
            }
        }
        int ele = sc.nextInt();
        // 우리는 왼쪽 하단에서 시작
        int ans[] = find(arr, rows - 1, 0, ele);
        System.out.println(ans[0] + " " + ans[1]);
        sc.close();
    }

}
