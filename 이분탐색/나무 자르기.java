// https://www.acmicpc.net/problem/2805

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] trees = new int[n];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            trees[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(trees);

        long wood = 0; // m이 최대 2,000,000,000인데 이 값들을 최대 1,000,000개 더할 수 있으니 long으로 변환해줘야 오버 플로우 없이 계산이 됨됨
        int start = 1;
        int end = trees[n - 1];

        while (start <= end) {
            int mid = (start + end) / 2;
            wood = 0;

            for (int i = 0; i < n; i ++) {
                if (trees[i] >= mid) {
                    wood += trees[i] - mid;
                }
            }

            if (wood >= m) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        System.out.println(end);
    }
}
