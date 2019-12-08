/**
 *
 *이 파일에는 사전 식을 찾는 부스 알고리즘이 포함되어 있습니다.
 * 가장 작은 문자열 회전을 찾는 알고리즘 입니다.
 */
package com.williamfiset.algorithms.strings;

public class BoothsAlgorithm {

  
  // 가장 빠른 색인을 반환하는 부스 알고리즘을 수행합니다.
  // 사 전적으로 가장 작은 문자열 회전. 비교는
  // ASCII 값을 사용하여 수행되므로 소문자와 대문자를 혼합
  // 글자는 예상치 못한 결과를 줄 수 있습니다. O (n)
  public static int leastCyclicRotation(String s) {
    s += s;
    int[] f = new int[s.length()];
    java.util.Arrays.fill(f, -1);
    int k = 0;
    for (int j = 1; j < s.length(); j++) {
      char sj = s.charAt(j);
      int i = f[j - k - 1];
      while (i != -1 && sj != s.charAt(k + i + 1)) {
        if (sj < s.charAt(k + i + 1)) k = j - i - 1;
        i = f[i];
      }
      if (sj != s.charAt(k + i + 1)) {
        if (sj < s.charAt(k)) k = j;
        f[j - k] = -1;
      } else f[j - k] = i + 1;
    }
    return k;
  }

  public static void main(String[] args) {

    String s = "abcde";
    int index = leastCyclicRotation(s);

    
    // 문자열이 이미 최소 회전 상태이므로 0을 출력합니다.
    System.out.println(index);

    s = "cdeab";
    index = leastCyclicRotation(s);

    // 문자열을 왼쪽으로 3 번 돌리면 3이 출력됩니다.
    // 가장 작은 회전 : "cdeab"-> "deabc"-> "eabcd"-> "abcde"
    System.out.println(index);
  }
}
