// https://www.acmicpc.net/problem/1937

import java.util.*;

public class Panda {
    static int N;
    static int[][] map;
    static int[][] dp;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        map = new int[N][N];
        dp = new int[N][N]; // 이동한 횟수를 저장하는 배열

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
            }
        }

        int result = 0;
        
        // 모든 칸 탐색
        for (int x = 0; x < N; x++) {
            for (int y = 0; y < N; y++) {
                result = Math.max(result, recursive(x, y));
            }
        }

        // 이동 횟수가 아니라 이동할 수 있는 칸의 수이기 때문에 이동 횟수 + 1을 해야 함
        System.out.println(result + 1);
    }

    static int recursive(int x, int y) {
        // 만약 dp 배열의 값이 0이 아니면 해당 값 return ⇒ 메모리제이션
        // 이미 계산된 칸이라면 그 칸에서부터 앞으로 움직일 수 있는 최대값은 해당 칸의 값과 같음
        if (dp[x][y] != 0) return dp[x][y];

        // 4방향 확인
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            // 배열의 범위를 벗어나지 않는다면
            if (nx >= 0 && ny >= 0 && nx < N && ny < N) {
                // 만약 확인하는 칸의 값이 현재의 칸보다 값이 크다면
                if (map[nx][ny] > map[x][y]) {
                    // 현재 칸의 이동 가능 수와 다음으로 확인할 칸의 이동 가능 수 확인해서 큰 값을 dp 배열에 저장
                    // recursive(nx, ny) + 1을 하는 이유는 이동할 수 있는 칸의 수가 1칸 증가하는 거니까 + 1
                    // (x, y) → (nx, ny)로 이동한 것 자체가 1칸이니까 추가해 주는 것이라고 보면 됨
                    dp[x][y] = Math.max(dp[x][y], recursive(nx, ny) + 1);
                }
            }
        }
        return dp[x][y];
    }
}
