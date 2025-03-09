// https://www.acmicpc.net/problem/12865

import java.util.Scanner;

public class Bagpack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        int[] weight = new int[N + 1];
        int[] value = new int[N + 1];
        int[][] dp = new int[N + 1][K + 1];

        for (int i = 1; i <= N; i++) {
            weight[i] = sc.nextInt();
            value[i] = sc.nextInt();
        }

        for (int i = 1; i <= N; i++) {
            // 무게를 1부터 최대 무게까지 살피며 현재 물건이 들어갈 수 있는 무게 범위를 체크하는 과정 ⇒ 원래는 0부터 체크해야 하지만 dp 배열이 0으로 초기화 되어 있고, 문제 특성 상 무게가 0일 때 가치도 0이기 때문에 1부터 시작작
            for (int w = 1; w <= K; w++) {
                // 만약 현재 물건의 무게가 현재 가용 무게보다 크면
                if (weight[i] > w) {  
                    // 이전 물건이 현재 무게일 때의 가치를 넣음 == 현재 물건을 안 넣었다
                    dp[i][w] = dp[i - 1][w];
                // 현재 물건의 무게가 현재 가용 무게보다 작으면 == 물건을 넣을 수 있는 상태라면
                } else {
                    // 물건을 안 넣었을 때의 가치(이전 물건이 현재 무게일 때의 가치)와 물건을 넣었을 때의 가치(이전 물건이 (현재 무게 - 현재 물건의 무게(= 넣고 난 뒤 가용 가능한 무게)일 때의 가치 ⇒ 이전 물건이 남는 무게에서 가진 가치) + 현재 물건의 가치) 중 큰 것을 넣음
                    dp[i][w] = Math.max(dp[i - 1][w], dp[i - 1][w - weight[i]] + value[i]);
                }
            }
        }

        System.out.println(dp[N][K]);
    }
}

/*
 * 입력 값
 * 3 4
 * 2 3
 * 1 2
 * 3 4
 * 
 * dp 배열
 *     0 1 2 3 4
 * 0 : 0 0 0 0 0
 * 1 : 0 0 3 3 3
 * 2 : 0 2 2 5 5
 * 3 : 0 2 2 5 6
 */
