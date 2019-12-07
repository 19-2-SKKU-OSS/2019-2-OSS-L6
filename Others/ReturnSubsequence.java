package Others;

import java.util.Scanner;
/*
 * 서브 시퀀스 알고리즘: 재귀함수를 이용하여 주어진 문자열의 서브 시퀀스 문자열을 구하는 알고리즘.
 */ 

public class ReturnSubsequence {
    public static void main(String[] args) {
        System.out.println("Enter String: ");
        Scanner s = new Scanner(System.in);
        String givenString = s.next(); //given string
        String[] subsequence = returnSubsequence(givenString); //calling returnSubsequence() function
        System.out.println("Subsequences : ");
        //print the given array of subsequences
        for (int i = 0; i < subsequence.length; i++) {
            System.out.println(subsequence[i]);
        }
    }

    /**
     * @param givenString
     * @return subsequence
     */
    private static String[] returnSubsequence(String givenString) {
        if (givenString.length() == 0) // If string is empty we will create an array of size=1 and insert "" (Empty string) in it
        {
            String[] ans = new String[1];
            ans[0] = "";
            return ans;

        }
        String[] SmallAns = returnSubsequence(givenString.substring(1)); //재귀 함수 호출

        String[] ans = new String[2 * SmallAns.length];// Our answer will be an array off string of size=2*SmallAns
        int i = 0;
        for (; i < SmallAns.length; i++) {
            ans[i] = SmallAns[i]; //모든 문자열 복사
        }
        for (int k = 0; k < SmallAns.length; k++) {
            ans[k + SmallAns.length] = givenString.charAt(0) + SmallAns[k]; //모든 SmallAns 앞에 서브 문자열의 인덱스 0의 값을 삽입
        }
        return ans;
    }
}
