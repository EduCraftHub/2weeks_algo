// https://www.acmicpc.net/problem/1520

import java.util.*;

public class Downhill {
    static int M, N;
    static int[][] map;
    static int[][] dp;
    // dx와 dy 배열로 위, 아래, 왼쪽, 오른쪽 방향 배열 생성
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        M = sc.nextInt();
        N = sc.nextInt();

        map = new int[M][N];
        dp = new int[M][N];

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < N; j++) {
                map[i][j] = sc.nextInt();
                // 아직 안 가본 곳은 -1로 저장
                dp[i][j] = -1;
            }
        }

        // (0,0)에서 출발
        System.out.println(recursive(0, 0));
    }

    // (x, y)에서 도착점까지 가는 길의 개수 탐색
    static int recursive(int x, int y) {
        // 마지막에 도착하면 1개 성공
        if (x == M - 1 && y == N - 1) return 1;

        // 이미 계산했다면 다시 계산 안 하고 바로 리턴
        if (dp[x][y] != -1) return dp[x][y];

        // 갈 수 있는 길 개수를 세기 위해 0으로 초기화(세지 않은 경우는 -1이고, 만약 확인했는데 없는 거면 0으로 저장되어 있을 수 있게)
        dp[x][y] = 0;

        // 4개의 방향 탐색
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            // 범위 안에 있고, 더 낮은 곳으로 가는 경우만 이동
            if (nx >= 0 && ny >= 0 && nx < M && ny < N) {
                if (map[x][y] > map[nx][ny]) {
                    // 마지막까지 갈 수 없다면 0이 return 될 거고, 마지막까지 갈 수 있다면 1이 return
                    dp[x][y] += recursive(nx, ny);
                }
            }
        }
        return dp[x][y];
    }
}
