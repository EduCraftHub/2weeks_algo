// https://www.acmicpc.net/problem/2589

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        // 지도 받기(L, W로 이루어져 있어서 char로 받음)
        char[][] map = new char[n][m];
        for (int i = 0; i < n; i++) {
            map[i] = br.readLine().toCharArray();
        }

        // 최종 답(최대 거리)
        int maxDistance = 0;

        // 방향 배열 (상하좌우)
        int[] dx = {0, 0, -1, 1};
        int[] dy = {-1, 1, 0, 0};

        // 모든 육지에서 BFS 시작
        for (int y = 0; y < n; y++) {
            for (int x = 0; x < m; x++) {

                // 만약 현재 지점이 육지면,
                if (map[y][x] == 'L') {
                    // 방문 여부 배열 생성
                    boolean[][] visited = new boolean[n][m];
                    // 길이를 기록하는 배열 생성
                    int[][] dist = new int[n][m];

                    // BFS를 위한 큐 생성
                    Queue<int[]> queue = new LinkedList<>();
                    // 큐에 y, x 값을 배열로 추가(시작점)
                    queue.add(new int[]{y, x});
                    // 방문했다고 표기
                    visited[y][x] = true;

                    // 이번 BFS에서 최대 거리
                    int localMax = 0;

                    // 큐가 빌 때까지 BFS 반복
                    while (!queue.isEmpty()) {
                        // 현재 좌표를 꺼냄
                        int[] cur = queue.poll();
                        int cy = cur[0];
                        int cx = cur[1];

                        // 현재 좌표에서 4방향 탐색
                        for (int d = 0; d < 4; d++) {
                            int ny = cy + dy[d];
                            int nx = cx + dx[d];

                            // 범위 안에 있고, 육지이며, 방문하지 않았다면
                            if (ny >= 0 && ny < n && nx >= 0 && nx < m &&
                                map[ny][nx] == 'L' && !visited[ny][nx]) {

                                // 방문 표시
                                visited[ny][nx] = true;
                                // 거리 = 현재 위치까지 거리 + 1
                                dist[ny][nx] = dist[cy][cx] + 1;
                                // 현재 BFS 내 최장 거리 갱신
                                localMax = Math.max(localMax, dist[ny][nx]);
                                // 다음 탐색 대상으로 큐에 넣기
                                queue.add(new int[]{ny, nx});
                            }
                        }
                    }

                    maxDistance = Math.max(maxDistance, localMax);
                }
            }
        }

        System.out.println(maxDistance);
    }
}
