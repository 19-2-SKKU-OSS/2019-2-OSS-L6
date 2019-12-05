package Conversions;

public class HexaDecimalToBinary {

    private final int LONG_BITS = 8;

    public void convert(String numHex) {
        // 16진수는 문자열의 형태로 표현되어있다.
        int conHex = Integer.parseInt(numHex, 16);
        // 문자열 형태의 16진수를 2진수의 형태로 변환한다.
        String binary = Integer.toBinaryString(conHex);
    
        System.out.println(numHex + " = " + completeDigits(binary));
    }

    public String completeDigits(String binNum) {
        for (int i = binNum.length(); i < LONG_BITS; i++) {
            binNum = "0" + binNum;
        }
        return binNum;
    }

    public static void main(String[] args) {

        //Testing Numbers:
        String[] hexNums = {"1", "A1", "ef", "BA", "AA", "BB",
                "19", "01", "02", "03", "04"};
        HexaDecimalToBinary objConvert = new HexaDecimalToBinary();

        for (String num : hexNums) {
            objConvert.convert(num);
        }
    }
}
// 문자열 형태의 16진수를 입력값으로 받아 2진수의 형태로 변환한다.
