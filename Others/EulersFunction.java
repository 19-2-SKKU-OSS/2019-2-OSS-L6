package Others;

/**
 * You can read more about Euler's totient function
 * <p>
 * See https://en.wikipedia.org/wiki/Euler%27s_totient_function
 * 오일러 피 함수: 1부터 n까지의 정수 중 n과 서로소인 수의 개수를 세는 알고리즘.
 */
public class EulersFunction {
    // This method returns us number of x that (x < n) and gcd(x, n) == 1 in O(sqrt(n)) time complexity;
    public static int getEuler(int n) {
        int result = n; //n부터 시작
        for (int i = 2; i * i <= n; i++) { //i는 2부터 i 제곱이 n보다 작거나 같을 동안만
            if (n % i == 0) { //n이 i로 나누어 떨어지면
                while (n % i == 0) n /= i; //계속 나누어 떨어질 때까지 n을 i로 나눔.
                result -= result / i; //result를 i로 나눈만큼 뺌
            }
        }
        if (n > 1) result -= result / n; //n이 1보다 크다면 result를 n으로 나눈만큼 뺌
        return result; //결과 값 리턴
    }

    public static void main(String[] args) {
        for (int i = 1; i < 100; i++) {
            System.out.println(getEuler(i));
        }
    }
}
