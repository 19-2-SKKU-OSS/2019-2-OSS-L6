package Conversions;

import java.util.Scanner;
//주어진 숫자와 초기진법, 최종진법을 고려하여 초기진법으로 주어진 숫자를 최종 진법의 결과 숫자로 변환한다.
//sn ,sb,db ---> ()dn  .   this is what we have to do    .

public class AnytoAny {

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int sn = scn.nextInt(); //변환하고자하는 숫자
        int sb = scn.nextInt(); //변환하고자하는 숫자의 진법
        int db = scn.nextInt(); //최종적으로 변환되어져 나올 숫자의 진법
        int m = 1, dec = 0, dn = 0;
        while (sn != 0) {
            dec = dec + (sn % 10) * m;
            m *= sb;
            sn /= 10;
        }
        m = 1;
        while (dec != 0) {
            dn = dn + (dec % db) * m;
            m *= 10;
            dec /= db;
        }
        System.out.println(dn);
    }

}

// AnyBaseToAnyBase.java 의 코드보다 좀 더 간결하다. 하지만, 알파벳으로 표현되는 숫자를 처리할 수 없는 것이 단점이다.
// 10진수 이하의 진법으로 표현된 숫자들끼리만 변환이 
