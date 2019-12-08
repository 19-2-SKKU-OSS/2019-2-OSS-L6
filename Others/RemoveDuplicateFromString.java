package Others;

import java.io.BufferedReader;
import java.io.InputStreamReader;

/**
 * @author Varun Upadhyay (https://github.com/varunu28)
 * 문자열 중복 제거 알고리즘: 문자열에서 중복이 아닌 것만 남겨 두는 알고리즘.
 */

public class RemoveDuplicateFromString {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String inpStr = br.readLine();

        System.out.println("Actual string is: " + inpStr);
        System.out.println("String after removing duplicates: " + removeDuplicate(inpStr));

        br.close();
    }

    /**
     * This method produces a string after removing all the duplicate characters from input string and returns it
     * Example: Input String - "aabbbccccddddd"
     * Output String - "abcd"
     *
     * @param s String from which duplicate characters have to be removed
     * @return string with only unique characters
     */

    public static String removeDuplicate(String s) {
        if (s == null || s.isEmpty()) {
            return s;
        }

        StringBuilder sb = new StringBuilder();
        int n = s.length();

        for (int i = 0; i < n; i++) {
            if (sb.toString().indexOf(s.charAt(i)) == -1) { //없었던 문자열이면
                sb.append(String.valueOf(s.charAt(i))); //새로 만든 문자열에 추가한다.
            }
        }

        return sb.toString(); //중복 없는 문자열 리턴
    }
}
