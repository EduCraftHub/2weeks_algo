// https://www.acmicpc.net/problem/2606

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int computer = Integer.parseInt(br.readLine());
        int connection = Integer.parseInt(br.readLine());

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= computer; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < connection; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            graph.get(a).add(b);
            graph.get(b).add(a);
        }

        boolean[] visited = new boolean[computer + 1];
        Deque<Integer> deque = new LinkedList<>();
        deque.addLast(1); // 또는 deque.offerLast(1);

        while (!deque.isEmpty()) {
            int current = deque.pollFirst();
            visited[current] = true;

            for (int neighbor : graph.get(current)) {
                if (!visited[neighbor]) {
                    deque.addLast(neighbor);
                }
            }
        }

        int count = 0;
        for (int i = 1; i <= computer; i++) {
            if (visited[i]) count++;
        }

        System.out.println(count - 1);
    }
}
