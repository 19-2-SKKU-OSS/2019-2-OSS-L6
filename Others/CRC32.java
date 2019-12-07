package Others;

import java.util.BitSet;

/**
 * Generates a crc32 checksum for a given string or byte array
 * CRC32 알고리즘: 파일을 읽어서 파일에 훼손이 없는지 검사하는 알고리즘 중, 최근에 많이 사용하는 알고리즘
 */
public class CRC32 {

    public static void main(String[] args) {
        System.out.println(Integer.toHexString(crc32("Hello World")));
    }

    public static int crc32(String str) {
        return crc32(str.getBytes());
    }

    public static int crc32(byte[] data) {
        BitSet bitSet = BitSet.valueOf(data);
        int crc32 = 0xFFFFFFFF; // 첫 crc32 초기화
        for (int i = 0; i < data.length * 8; i++) {
            if (((crc32 >>> 31) & 1) != (bitSet.get(i) ? 1 : 0))
                crc32 = (crc32 << 1) ^ 0x04C11DB7; // xor 연산
            else
                crc32 = (crc32 << 1);
        }
        crc32 = Integer.reverse(crc32); //결과 반전
        return crc32 ^ 0xFFFFFFFF; // 마지막 xor 연산
    }

}
