package Maths;

public class PalindromeNumber {
    public static void main(String[] args) {

        assert isPalindrome(12321);
        assert !isPalindrome(1234);
        assert isPalindrome(1);
    }

    /**
     * 숫자 n이 회문인지 아닌지를 판단합니다
     *
     * @숫자 n을 인자로 받습니다
     * @n이 회문이면 true를 반환하고 아니면 false를 반환합니다
     */
    public static boolean isPalindrome(int number) {
        if (number < 0) {
            throw new IllegalArgumentException(number + "");
        }
        int numberCopy = number;
        int reverseNumber = 0;
        while (numberCopy != 0) {
            int remainder = numberCopy % 10;
            reverseNumber = reverseNumber * 10 + remainder;
            numberCopy /= 10;
        }
        return number == reverseNumber;
    }
}
