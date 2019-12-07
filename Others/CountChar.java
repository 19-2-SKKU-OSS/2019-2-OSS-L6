package Others;

import java.util.Scanner;
/*
 * 문자열 세기 알고리즘: 문자열의 문자 개수를 세는 알고리즘.
 */ 
public class CountChar {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("Enter your text: ");
        String str = input.nextLine();
        input.close();
        System.out.println("There are " + CountCharacters(str) + " characters.");
    }

    /**
     * Count non space character in string
     *
     * @param str String to count the characters
     * @return number of character in the specified string
     */
    private static int CountCharacters(String str) {
        return str.replaceAll("\\s", "").length(); //.length() 함수를 이용하였다.
    }
}
