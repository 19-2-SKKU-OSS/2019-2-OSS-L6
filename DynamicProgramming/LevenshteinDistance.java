package DynamicProgramming;

/**
 * @author Kshitij VERMA (github.com/kv19971)
 * 두 문자열의 차이를 보여주는 LEVENSHTEIN DISTANCE 동적 프로그래밍 구현 (https://en.wikipedia.org/wiki/Levenshtein_distance)
 */

public class LevenshteinDistance {
    private static int minimum(int a, int b, int c) {
        if (a < b && a < c) {
            return a;
        } else if (b < a && b < c) {
            return b;
        } else {
            return c;
        }
    }

    private static int calculate_distance(String a, String b) {
        int len_a = a.length() + 1;
        int len_b = b.length() + 1;
        int[][] distance_mat = new int[len_a][len_b];
        for (int i = 0; i < len_a; i++) {
            distance_mat[i][0] = i;
        }
        for (int j = 0; j < len_b; j++) {
            distance_mat[0][j] = j;
        }
        for (int i = 0; i < len_a; i++) {
            for (int j = 0; j < len_b; j++) {
                int cost;
                if (a.charAt(i) == b.charAt(j)) {
                    cost = 0;
                } else {
                    cost = 1;
                }
                distance_mat[i][j] = minimum(distance_mat[i - 1][j], distance_mat[i - 1][j - 1], distance_mat[i][j - 1]) + cost;


            }

        }
        return distance_mat[len_a - 1][len_b - 1];

    }

    public static void main(String[] args) {
        String a = ""; // 스트링을 입력해주세요.
        String b = ""; // 스트링을 입력해주세요.
        System.out.print("Levenshtein distance between " + a + " and " + b + " is: ");
        System.out.println(calculate_distance(a, b));


    }
}
