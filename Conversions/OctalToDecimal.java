package Conversions;

import java.util.Scanner;

/**
 * 8진수의 숫자를 10진수의 숫자로 변환한다.
 * 
 * @author Zachary Jones
 *
 */
public class OctalToDecimal {

	/**
	 * Main method
	 * 
	 * @param args
	 *            Command line arguments
	 */
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		System.out.print("Octal Input: ");
		String inputOctal = sc.nextLine();
		int result = convertOctalToDecimal(inputOctal);
		if (result != -1)
			System.out.println("Result convertOctalToDecimal : " + result);
		sc.close();
	}

	/**
	 * 아래의 함수는 8진수의 숫자를 10진수의 숫자로 변환한다.
	 * 
	 * @param inputOctal
	 *            The octal number
	 * @return The decimal number
	 */
	public static int convertOctalToDecimal(String inputOctal) {

		try {
			// 실질적인 8진수에서 10진수로의 변환
			Integer outputDecimal = Integer.parseInt(inputOctal, 8);
			return outputDecimal;
		} catch (NumberFormatException ne) {
			// 만약 입력된 값이 적절한 8진수의 형태가 아닐시에 예외 처리한다.
			
			System.out.println("Invalid Input, Expecting octal number 0-7");
			return -1;
		}
	}
}
// 8진수의 숫자를 10진수로 변환하는 함수이다.
