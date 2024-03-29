package DynamicProgramming;

/**
 * A DynamicProgramming based solution for Edit Distance problem In Java
 * Description of Edit Distance with an Example:
 * <p>
 * Edit distance is a way of quantifying how dissimilar two strings (e.g., words) are to one another,
 * by counting the minimum number of operations required to transform one string into the other. The
 * distance operations are the removal, insertion, or substitution of a character in the string.
 * <p>
 * <p>
 * The Distance between "kitten" and "sitting" is 3. A minimal edit script that transforms the former into the latter is:
 * <p>
 * kitten → sitten (substitution of "s" for "k")
 * sitten → sittin (substitution of "i" for "e")
 * sittin → sitting (insertion of "g" at the end).
 *
 * @author SUBHAM SANGHAI
 **/

import java.util.Scanner;

public class EditDistance {

    public static int minDistance(String word1, String word2) {
        int len1 = word1.length();
        int len2 = word2.length();
        // len1+1, len2+1, because finally return dp[len1][len2]
        int[][] dp = new int[len1 + 1][len2 + 1];
     	/* 두 번째 문자열이 비어 있으면 유일한 옵션은
        첫 번째 문자열의 모든 문자를 두 번째에 삽입*/
        for (int i = 0; i <= len1; i++) {
            dp[i][0] = i;
        }
     	/* 두 번째 문자열이 비어 있으면 유일한 옵션은
        첫 번째 문자열의 모든 문자를 두 번째에 삽입*/
        for (int j = 0; j <= len2; j++) {
            dp[0][j] = j;
        }
        //반복하고 마지막 문자를 확인하십시오.
        for (int i = 0; i < len1; i++) {
            char c1 = word1.charAt(i);
            for (int j = 0; j < len2; j++) {
                char c2 = word2.charAt(j);
                // 마지막 두 문자가 같으면
                if (c1 == c2) {
                    //+1 길이에 대한 dp 값 업데이트
                    dp[i + 1][j + 1] = dp[i][j];
                } else {
			/* 두 문자가 다른 경우
            그런 다음 다양한 작업 ( 삽입, 제거, 대체)을 최소화하십시오*/
                    int replace = dp[i][j] + 1;
                    int insert = dp[i][j + 1] + 1;
                    int delete = dp[i + 1][j] + 1;

                    int min = replace > insert ? insert : replace;
                    min = delete > min ? min : delete;
                    dp[i + 1][j + 1] = min;
                }
            }
        }
        /* 두 문자열을 전부 탐색 한 후, 최종 결과값을 반환하십시오.*/
        return dp[len1][len2];
    }


    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String s1, s2;
        System.out.println("Enter the First String");
        s1 = input.nextLine();
        System.out.println("Enter the Second String");
        s2 = input.nextLine();
        // ans는 두 문자열 사이의 최종적으로 편집된 거리를 저장합니다
        int ans = minDistance(s1, s2);
        System.out.println("The minimum Edit Distance between \"" + s1 + "\" and \"" + s2 + "\" is " + ans);
    }
}
