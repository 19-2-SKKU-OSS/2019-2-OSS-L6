package Conversions;

class DecimalToHexaDecimal {
	private static final int sizeOfIntInHalfBytes = 8;
	private static final int numberOfBitsInAHalfByte = 4;
	private static final int halfByte = 0x0F;
	private static final char[] hexDigits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E',
			'F' };

	// 10진수를 16진수로 변환하여 반환한다.
	public static String decToHex(int dec) {
		StringBuilder hexBuilder = new StringBuilder(sizeOfIntInHalfBytes);
		hexBuilder.setLength(sizeOfIntInHalfBytes);
		for (int i = sizeOfIntInHalfBytes - 1; i >= 0; --i) {
			int j = dec & halfByte;
			hexBuilder.setCharAt(i, hexDigits[j]);
			dec >>= numberOfBitsInAHalfByte;
		}
		return hexBuilder.toString().toLowerCase();
	}

	// Test above function.
	public static void main(String[] args) {
		System.out.println("Test...");
		int dec = 305445566;
		String libraryDecToHex = Integer.toHexString(dec);
		String decToHex = decToHex(dec);
		System.out.println("Result from the library : " + libraryDecToHex);
		System.out.println("Result decToHex method : " + decToHex);
	}
}

//10진수의 숫자를 16진수로 변환하는 함수이다. 10진수는 정수형태로 입력받고 16진수의 결과값은 문자열 형태로 나타낸다.
