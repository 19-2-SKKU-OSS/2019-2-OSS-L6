package Others;

import java.util.Scanner;
/*
 * 플로이드의 삼각형 알고리즘: 직각삼각형 모양의 자연수 피라미드 알고리즘.
 */ 

class FloydTriangle {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of rows which you want in your Floyd Triangle: ");
        int r = sc.nextInt(), n = 0;
        sc.close();
        for (int i = 0; i < r; i++) { //r만큼의 높이의 피라미드 생성
            for (int j = 0; j <= i; j++) {
                System.out.print(++n + " "); //n을 1부터 늘려나감
            }
            System.out.println();
        }
    }
}
