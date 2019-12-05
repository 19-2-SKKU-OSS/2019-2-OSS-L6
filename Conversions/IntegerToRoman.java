package Conversions;

public class IntegerToRoman {
    private static int[] allArabianRomanNumbers = new int[]{1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
    private static String[] allRomanNumbers = new String[]{"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};

    public static String integerToRoman(int num) {
        if (num <= 0) {
            return "";
        }

        StringBuilder builder = new StringBuilder();

        for (int a = 0; a < allArabianRomanNumbers.length; a++) {
            int times = num / allArabianRomanNumbers[a];
            for (int b = 0; b < times; b++) {
                builder.append(allRomanNumbers[a]); //숫자에 맞는 알파벳을 문자열에 이어붙인다.
            }

            num -= times * allArabianRomanNumbers[a];
        }

        return builder.toString(); //최종적으로 만들어진 숫자를 반환한다.
    }

    public static void main(String[] args) {
        System.out.println(IntegerToRoman.integerToRoman(2131));
    }
}
// 10진수의 입력값을 로마문자를 이용한 숫자형태로 표현한다.
