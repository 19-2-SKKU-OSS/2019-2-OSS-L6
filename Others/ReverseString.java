package Others;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * This method produces a reversed version of a string
 *
 * @author Unknown
 * 문자열 반전 알고리즘: 문자열을 역순으로 반전시키는 알고리즘.
 */
public class ReverseString{

    /**
     * This method reverses the string str and returns it
     *
     * @param str String to be reversed
     * @return Reversed string
     */
    public static String reverse(String str) {
        if (str == null || str.isEmpty()) return str;

        char[] arr = str.toCharArray();
        for (int i = 0, j = str.length() - 1; i < j; i++, j--) { //i는 처음, j는 끝부터 처음은 늘려가며, 끝을 줄여가며
            char temp = arr[i]; 
            arr[i] = arr[j];
            arr[j] = temp; //서로 교환한다.
        }
        return new String(arr); //반전된 배열 리턴
    }

    /**
     * Main Method
     *
     * @param args Command line arguments
     * @throws IOException Exception thrown because of BufferedReader
     */
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Enter the string");
        String srr = br.readLine();
        System.out.println("Reverse=" + reverse(srr));
        br.close();
    }
}
		
