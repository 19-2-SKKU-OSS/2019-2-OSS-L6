package Maths;

public class ParseInteger {
    public static void main(String[] args) {
        assert parseInt("123") == Integer.parseInt("123");
        assert parseInt("-123") == Integer.parseInt("-123");
        assert parseInt("0123") == Integer.parseInt("0123");
        assert parseInt("+123") == Integer.parseInt("+123");
    }

    /**
     * 문자열을 숫자로 바꿉시다
     *
     * @문자열 s를 인자로 받습니다
     * @인자를 숫자의 형태로 반환합니다
     * @변환 가능한 숫자가 아닐 때 NumberFormatException을 발생시킵니다 
     */
    public static int parseInt(String s) {
        if (s == null) {
            throw new NumberFormatException("null");
        }
        boolean isNegative = s.charAt(0) == '-';
        boolean isPositive = s.charAt(0) == '+';
        int number = 0;
        for (int i = isNegative ? 1 : isPositive ? 1 : 0, length = s.length(); i < length; ++i) {
            if (!Character.isDigit(s.charAt(i))) {
                throw new NumberFormatException("s=" + s);
            }
            number = number * 10 + s.charAt(i) - '0';
        }
        return isNegative ? -number : number;
    }
}
