// https://www.acmicpc.net/problem/11726

import java.util.*;

public class Tiling {

    static int N;
    static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        N = sc.nextInt();

        int[] dp = new int[N + 1];

        // 높이가 2이기 때문에 밑의 칸(배열[1][N])을 떼고 보면 결국 1 혹은 2로 N을 채우는 경우를 전부 찾으면 됨
        // dp 배열에 해당 인덱스 길이를 만들 수 있는 경우의 수를 저장
        // dp[i] = dp[i - 1] + dp[i - 2]인 이유는 dp[i]에 도달할 수 있는 경우는 1칸 전의 경우와 2칸 전의 경우임(1칸을 채우거나 2칸을 채우는 경우)

        for (int i = 1; i <= N; i++) {
            if (i <= 2) {
                dp[i] = i;
                continue;
            }

            dp[i] = (dp[i - 1] + dp[i - 2]) % 10007;
        }

        System.out.println(dp[N]);
    }
}
