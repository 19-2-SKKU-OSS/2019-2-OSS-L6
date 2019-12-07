package Others;

import java.util.Scanner;
/*
 * 하노이의 탑 알고리즘: 3개의 축과 임의의 개수의 크기가 다른 원반이 A 축에 주어졌을 때 재귀함수를 이용하여 크기 순서대로 A에서 B로 옮기기 위한 알고리즘.
 */ 
class TowerOfHanoi {
    public static void shift(int n, String startPole, String intermediatePole, String endPole) {
        if (n == 0) { //n이 0이되면
            return; //함수 끝
        }


        // Shift function is called in recursion for swapping the n-1 disc from the startPole to the intermediatePole
        shift(n - 1, startPole, endPole, intermediatePole); //n-1번째 원반을 매개체 축으로 옮김
        System.out.println("\nMove \"" + n + "\" from " + startPole + " --> " + endPole); //옮긴 결과 출력
        // Shift function is called in recursion for swapping the n-1 disc from the intermediatePole to the endPole
        shift(n - 1, intermediatePole, startPole, endPole); //n-1번째 원반을 정렬할 축으로 옮김
    }

    public static void main(String[] args) {
        System.out.print("Enter number of discs on Pole 1: ");
        Scanner scanner = new Scanner(System.in);
        int numberOfDiscs = scanner.nextInt(); //원반 개수 입력
        shift(numberOfDiscs, "Pole1", "Pole2", "Pole3"); //Shift function called
    }
}
