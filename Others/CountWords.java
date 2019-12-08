package Others;

import java.util.Scanner;

/**
 * You enter a string into this program, and it will return how many words were
 * in that particular string
 *
 * @author Marcus
 * 단어 세기 알고리즘: 문자열을 받아서 띄어쓰기를 기준으로 몇 개의 단어가 있는지 세는 알고리즘.
 */
public class CountWords {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter your text: ");
        String str = input.nextLine();

        System.out.println("Your text has " + wordCount(str) + " word(s)");
        System.out.println("Your text has " + secondaryWordCount(str) + " word(s)");
        input.close();
    }

    private static int wordCount(String s) {
        if (s == null || s.isEmpty())
            return 0;
        return s.trim().split("[\\s]+").length; //[\\s] 를 기준으로 잘라서 길이를 리턴
    }

    /**
     * counts the number of words in a sentence but ignores all potential
     * non-alphanumeric characters that do not represent a word. runs in O(n) where
     * n is the length of s
     * 
     * @param s String: sentence with word(s)
     * @return int: number of words
     */
    private static int secondaryWordCount(String s) {
        if (s == null || s.isEmpty())
            return 0;
        StringBuilder sb = new StringBuilder();
        for (char c : s.toCharArray()) {
            if (Character.isLetter(c) || Character.isDigit(c)) //배열의 값이 문자거나 숫자면
                sb.append(c); //새 배열에 추가
        }
        s = sb.toString(); //문자열로 바꾸기
        return s.trim().split("[\\s]+").length; //띄어쓰기로 잘라서 길이를 리턴
    }
}
