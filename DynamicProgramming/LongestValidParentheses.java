package DynamicProgramming;

import java.util.Scanner;


/**
 * 문자 '('와 ')'만 포함 된 문자열의 길이는
 * 가장 긴 유효한 (잘 구성된) 괄호 하위 문자열.
 *
 * @author Libin Yang (https://github.com/yanglbme)
 * @since 2018/10/5부터
 */

public class LongestValidParentheses {

    public static int getLongestValidParentheses(String s) {
        if (s == null || s.length() < 2) {
            return 0;
        }
        char[] chars = s.toCharArray();
        int n = chars.length;
        int[] res = new int[n];
        res[0] = 0;
        res[1] = chars[1] == ')' && chars[0] == '(' ? 2 : 0;

        int max = res[1];

        for (int i = 2; i < n; ++i) {
            if (chars[i] == ')') {
                if (chars[i - 1] == '(') {
                    res[i] = res[i - 2] + 2;
                } else {
                    int index = i - res[i - 1] - 1;
                    if (index >= 0 && chars[index] == '(') {
                        // ()(())
                        res[i] = res[i - 1] + 2 + (index - 1 >= 0 ? res[index - 1] : 0);
                    }
                }
            }
            max = Math.max(max, res[i]);
        }

        return max;

    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            String str = sc.nextLine();
            if ("quit".equals(str)) {
                break;
            }
            int len = getLongestValidParentheses(str);
            System.out.println(len);

        }

        sc.close();
    }
}
