package Others;

import java.util.Scanner;
/*
 * Krishnamurthy 수 알고리즘: 그 수의 자릿수마다의 팩토리얼의 합이 그 수와 같은지 판단하는 알고리즘. 
 */ 
class Krishnamurthy {
    static int fact(int n) { //n 팩토리얼을 반환하는 함수
        int i, p = 1;
        for (i = n; i >= 1; i--)
            p = p * i;
        return p;
    }

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int a, b, s = 0;
        System.out.print("Enter the number : ");
        a = sc.nextInt();
        int n = a;//본래의 값 저장
        while (a > 0) {
            b = a % 10; //각 자릿수
            s = s + fact(b); //각 자릿수의 팩토리얼을 더함
            a = a / 10; //다음 자릿수를 위해 나눔
        }
        if (s == n) //위의 작업을 실행한 값이 본래의 값과 같으면
            System.out.print(n + " is a krishnamurthy number");
        else //다르면
            System.out.print(n + " is not a krishnamurthy number");
        sc.close();
    }
}
