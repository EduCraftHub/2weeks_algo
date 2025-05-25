// https://www.acmicpc.net/problem/1991

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    static List<Character>[] graph = new ArrayList[130];
    static StringBuilder sb = new StringBuilder();
    
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        
        for(int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            char a = st.nextToken().toCharArray()[0];
            char b = st.nextToken().toCharArray()[0];
            char c = st.nextToken().toCharArray()[0];

            graph[a] = new ArrayList<>();

            graph[a].add(b);
            graph[a].add(c);
        }

        recursivePre('A');
        System.out.println(sb.toString());

        sb.setLength(0);
        recursiveIn('A');
        System.out.println(sb.toString());

        sb.setLength(0);
        recursivePost('A');
        System.out.println(sb.toString());

    }

    // 전위 순회
    private static void recursivePre(char c) {
        if (c != '.') {
            sb.append(c);

            recursivePre(graph[c].get(0));
            recursivePre(graph[c].get(1));
        }
    }

    // 중위 순회
    private static void recursiveIn(char c) {
        if (c != '.') {
            recursiveIn(graph[c].get(0));

            sb.append(c);

            recursiveIn(graph[c].get(1));
        }
    }

    // 후위 순회
    private static void recursivePost(char c) {
        if (c != '.') {
            recursivePost(graph[c].get(0));
            recursivePost(graph[c].get(1));

            sb.append(c);
        }
    }
}
