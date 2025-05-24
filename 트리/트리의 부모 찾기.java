// https://www.acmicpc.net/problem/11725

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static int n;
    // 트리 연결 정보(인접 리스트)
    static List<Integer>[] graph;
    // 각 노드의 부모를 저장할 배열
    static int[] parent;
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        graph = new ArrayList[n + 1];
        parent = new int[n + 1];
        
        for(int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (graph[a] == null) graph[a] = new ArrayList<>();
            if (graph[b] == null) graph[b] = new ArrayList<>();

            graph[a].add(b);
            graph[b].add(a);
        }

        recursive(1, 0);

        StringBuilder sb = new StringBuilder();

        for (int i = 2; i <= n; i++) {
            sb.append(parent[i] + "\n");
        }

        System.out.println(sb.toString());
    }

    private static void recursive(int curr, int pre) {
        parent[curr] = pre;

        // 현재 노드에 연결된 이웃 노드들을 확인
        for (int next : graph[curr]) {
            // 만약 다음 노드가 부모라면, 다시 되돌아가지 않음
            if (next == pre) continue;

            // 자식 노드로 이동하면서 재귀 호출출
            recursive(next, curr);
        }

    }
}
