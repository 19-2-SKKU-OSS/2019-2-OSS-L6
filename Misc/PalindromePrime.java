package Misc;

import java.util.Scanner;

public class PalindromePrime {

    public static void main(String[] args) { // 메인 함수
        Scanner in = new Scanner(System.in);
        System.out.println("원하시는 first Palindromic Prime의 숫자를 입력하세요");
        int n = in.nextInt(); // first pallindromic prime(회문 소수)을 넣습니다 
        functioning(n); // functioning 함수 호출  
    }

    public static boolean prime(int num) { // 해당 숫자가 소수인지 아닌지를 판단합니다
        for (int divisor = 3; divisor <= Math.sqrt(num); divisor += 2) {
            if (num % divisor == 0) {
                return false; //  소수가 아니면 false를 반환합니다
            }
        }
        return true; // 소수면 true를 반환합니다
    }

    public static int reverse(int n) { //  숫자를 뒤집어서 반환합니다
        int reverse = 0;
        while (n != 0) {
            reverse *= 10;
            reverse += n % 10;
            n /= 10;
        }
        return reverse;
    }

    public static void functioning(int y) {
        if (y == 0) return;
        System.out.print(2 + "\n"); // first Palindromic Prime를 출력합니다
        int count = 1;
        int num = 3;
        while (count < y) {
            if (num == reverse(num) && prime(num)) { // 숫자가 소수고 회문이면
                count++; // 반복문을 도는 동안 카운팅을 합니다
                System.out.print(num + "\n"); // Palindromic Prime를 출력합니다
            }
            num += 2; // 2만큼 증가시킵니다
        }
    }
}
