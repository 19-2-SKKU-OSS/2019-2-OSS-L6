/**
 *
 *   선형 시간에서 가장 긴 회문을 찾아주는 알고리즘
 *   이는 Manacher 알고리즘을 이용하여 문제를 해결합니다. 
 * 출처 http://www.leetcode.com/2011/11/longest-palindromic-substring-part-ii.html
 *
 */
public class Manacher {
    private int[]  p;  // p [i] = i를 중심으로 t의 가장 긴 회문의 길이
    private String s;  // 문자열 원본
    private char[] t;  // 변환된 분자열

    public Manacher(String s) {
        this.s = s;
        preprocess();
        p = new int[t.length];

        int center = 0, right = 0;
        for (int i = 1; i < t.length-1; i++) {
            int mirror = 2*center - i;

            if (right > i)
                p[i] = Math.min(right - i, p[mirror]);
 
            // i를 중심으로 회문 확장 시도
            while (t[i + (1 + p[i])] == t[i - (1 + p[i])])
                p[i]++;
 
            // i 중심의 회문이 오른쪽을지나 확장하면
            // 확장 된 회문을 기준으로 센터를 조정합니다.
            if (i + p[i] > right) {
                center = i;
                right = i + p[i];
            }
        }

    }

    // s를 t로 변환합니다.
    // 예를 들어, s = "abba"이면 t = "$ # a # b # b # a # @"
    // 짝수 / 홀수 길이 회문을 균일하게 피하기 위해 #이 인터리브됩니다.
    // 경계 검사를 피하기 위해 $와 @가 앞에 붙고 끝에 추가됩니다.
    private void preprocess() {
        t = new char[s.length()*2 + 3];
        t[0] = '$';
        t[s.length()*2 + 2] = '@';
        for (int i = 0; i < s.length(); i++) {
            t[2*i + 1] = '#';
            t[2*i + 2] = s.charAt(i);
        }
        t[s.length()*2 + 1] = '#';
    }
 
    // 가장 긴 회문 하위 문자열
    public String longestPalindromicSubstring() {
        int length = 0;   // 가장 긴 회문 하위 문자열의 길이
        int center = 0;   // 가장 긴 회문 하위 문자열의 중심
        for (int i = 1; i < p.length-1; i++) {
            if (p[i] > length) {
                length = p[i];
                center = i;
            }
        }
        return s.substring((center - 1 - length) / 2, (center - 1 + length) / 2);
    }

    //  인덱스 i / 2를 중심으로 가장 긴 하위 문자열 회문
    public String longestPalindromicSubstring(int i) {
        int length = p[i + 2];
        int center = i + 2;
        return s.substring((center - 1 - length) / 2, (center - 1 + length) / 2);
    }



    // 테스트 클라이언트
    public static void main(String[] args) {
        String s = args[0];
        Manacher manacher = new Manacher(s);
        StdOut.println(manacher.longestPalindromicSubstring());
        for (int i = 0; i < 2*s.length(); i++)
            StdOut.println(i +  ": " + manacher.longestPalindromicSubstring(i));
         
    }
}
