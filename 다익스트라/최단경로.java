// https://www.acmicpc.net/problem/1753

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    /**
     * 다익스트라
     * 
     * 모든 마을까지 거리 노트를 만든다.
     * 처음엔 다 "엄청 멀다(∞)"고 적는다.
     * 내가 있는 마을만 0으로 한다.
     * 가까운 마을부터 하나씩 보면서, 더 빠른 길 있으면 업데이트한다.
     * 모든 마을까지 가장 빠른 길이 찾아질 때까지 반복한다.
     * 
     */

     // 도착지의 번호와 그곳까지 가는 거리
    static class Node implements Comparable<Node> {
        int vertex;
        int weight;

        Node(int vertex, int weight) {
            this.vertex = vertex;
            this.weight = weight;
        }

        public int compareTo(Node other) {
            // 거리 기준으로 정렬
            // this가 더 작으면 음수가 반환되어 우선순위 큐에서 먼저 처리됨
            return this.weight - other.weight;
        }
        
    }

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int nodeCount = Integer.parseInt(st.nextToken());
        int lineCount = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(br.readLine());

        // index를 node로 쓰는 배열 생성 및 초기화 : index 노드에 연결된 노드와 거리(가중치)를 담는 배열
        // List<Node>[] : 배열 안에 List가 들어가 있는 구조
        List<Node>[] links = new ArrayList[nodeCount + 1];
        for (int i = 0; i < nodeCount + 1; i++) {
            links[i] = new ArrayList<>();
        }

        int[] dist = new int[nodeCount + 1];
        // 배열을 int의 가장 큰 수로 담음 ⇒ 최소값을 찾아 가야 해서
        Arrays.fill(dist, Integer.MAX_VALUE);

        // 간선 정보 입력
        for (int i = 0; i < lineCount; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());

            links[from].add(new Node(to, weight));
        }

        PriorityQueue<Node> queue = new PriorityQueue<>();
        // 현재 위치 queue에 담음
        queue.offer(new Node(start, 0));
        // 시작점은 움직이지 않아도 되니까 0으로 변경
        dist[start] = 0;

        while (!queue.isEmpty()) {
            Node currentNode = queue.poll();
            int now = currentNode.vertex;
            int cost = currentNode.weight;

            // 이미 더 짧은 거리로 처리된 경우는 무시
            if (dist[now] < cost) continue;

            // 연결된 노드 탐색색
            for (Node next : links[now]) {
                int newCost = dist[now] + next.weight;
                
                // 기존보다 더 짧은 길이면 그걸로 값을 수정하고 queue에 담음
                if (newCost < dist[next.vertex]) {
                    dist[next.vertex] = newCost;
                    // 큐에 다음 탐색 항목으로 담음
                    queue.offer(new Node(next.vertex, newCost));
                }
            }
        }

        // 출력 로직
        for (int i = 1; i < nodeCount + 1; i++) {
            if (dist[i] == Integer.MAX_VALUE) {
                System.out.println("INF");
            } else {
                System.out.println(dist[i]);
            }
        }
        
    }
}
