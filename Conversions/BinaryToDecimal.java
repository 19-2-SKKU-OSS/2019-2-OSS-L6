package Conversions;

import java.util.Scanner;

/**
 * 2진수를 10진수로 변환하는 클래스
 *
 */
class BinaryToDecimal {

    /**
     * Main Method
     *
     * @param args Command line arguments
     */
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int binNum, binCopy, d, s = 0, power = 0;
        try{
            
            System.out.print("Binary number: ");
            binNum = sc.nextInt();
            binCopy = binNum;
            while (binCopy != 0) {
                d = binCopy % 10;
                s += d * (int) Math.pow(2, power++);
                binCopy /= 10;
            }
            System.out.println("Decimal equivalent:" + s);
            sc.close();
        }catch(){
        
        }
    }
}
// 매우 정석적인 코드이고, 알고리즘을 처음 접하는 사람들에게 천천히 코드를 읽어보면서 변환되는 과정을 음미해볼 것을 권한다.
