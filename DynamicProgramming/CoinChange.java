package DynamicProgramming;

/**
 * @author Varun Upadhyay (https://github.com/varunu28)
 */
public class CoinChange {

    // Driver Program
    public static void main(String[] args) {

        int amount = 12;
        int[] coins = {2, 4, 5};

        System.out.println("Number of combinations of getting change for " + amount + " is: " + change(coins, amount));
        System.out.println("Minimum number of coins required for amount :" + amount + " is: " + minimumCoins(coins, amount));

    }

    /**
     * 이 방법은 주어진 금액과 변화 동전에 대한 변화를 얻는 조합의 수를 찾습니다.
     *
     * @param coins  동전 목록
     * @param amount 변화를 찾아야 할 금액
     *               변화의 조합의 수를 찾습니다.
     **/
    public static int change(int[] coins, int amount) {

        int[] combinations = new int[amount + 1];
        combinations[0] = 1;

        for (int coin : coins) {
            for (int i = coin; i < amount + 1; i++) {
                combinations[i] += combinations[i - coin];
            }
            // 아래 줄을 주석 해제하여 각 동전의 조합 상태를 확인하십시오.
            // printAmount(combinations);
        }

        return combinations[amount];
    }

    /**
     * 이 방법은 주어진 금액에 필요한 최소 코인 수를 찾을 수 있습니다.
     *
     * @param coins  동전 목록
     * @param amount 변화를 찾아야 할 금액
     *               변화의 조합의 수를 찾습니다.
     **/
    public static int minimumCoins(int[] coins, int amount) {
        //minimumCoins[i]은 금액 i에 필요한 최소 코인을 저장합니다
        int[] minimumCoins = new int[amount + 1];

        minimumCoins[0] = 0;

        for (int i = 1; i <= amount; i++) {
            minimumCoins[i] = Integer.MAX_VALUE;
        }
        for (int i = 1; i <= amount; i++) {
            for (int coin : coins) {
                if (coin <= i) {
                    int sub_res = minimumCoins[i - coin];
                    if (sub_res != Integer.MAX_VALUE && sub_res + 1 < minimumCoins[i])
                        minimumCoins[i] = sub_res + 1;
                }
            }
        }
        // Uncomment the below line to see the state of combinations for each coin
        //printAmount(minimumCoins);
        return minimumCoins[amount];
    }

    // A basic print method which prints all the contents of the array
    public static void printAmount(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }
}