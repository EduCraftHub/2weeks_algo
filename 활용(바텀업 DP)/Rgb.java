// https://www.acmicpc.net/problem/1149

import java.util.*;

public class Rgb {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[][] cost = new int[N + 1][3];
        int[][] dp = new int[N + 1][3];

        for ( int i = 1; i <= N; i++) {
            cost[i][0] = sc.nextInt();
            cost[i][1] = sc.nextInt();
            cost[i][2] = sc.nextInt();
        }

        // 현재 집을 빨간색(0)으로 칠하려면 이전 집은 초록색(1)이나 파란색(2)이어야 함
        // dp 배열에 저장되는 값은 현재 집(i)을 빨간색(0), 초록색(1), 파란색(2)으로 칠한다고 했을 때의 누적된 최소 비용용
        for ( int i = 1; i <= N; i++) {
            dp[i][0] = cost[i][0] + Math.min(dp[i - 1][1], dp[i - 1][2]);
            dp[i][1] = cost[i][1] + Math.min(dp[i - 1][0], dp[i - 1][2]);
            dp[i][2] = cost[i][2] + Math.min(dp[i - 1][0], dp[i - 1][1]);
        }

        System.out.println(Math.min(dp[N][0], Math.min(dp[N][1], dp[N][2])));
    }
}
