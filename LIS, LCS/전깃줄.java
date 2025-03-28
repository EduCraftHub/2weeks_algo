// https://www.acmicpc.net/problem/2565

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[][] array = new int[n][2];
        int[] dp = new int[n];
        int answer = 0;

        for(int i = 0; i < n; i++) {
            array[i][0] = sc.nextInt();
            array[i][1] = sc.nextInt();
        }

        // A 전봇대 기준으로 정렬
        Arrays.sort(array, (a, b) -> Integer.compare(a[0], b[0]));

        // 접근 방식은 A로 정렬해서, B의 LIS를 찾는 문제
        // for문으로 array 순회
        // 이중for문으로 0부터 i까지 순회
        // array에 array[i][1]보다 작은 값이 있으면 + 1한 값과 기존 값을 비교해서 큰 걸로 dp[i]에 저장
        // n - (배열에서 가장 큰 값 + 1) : 현재는 총 수열의 길이보다 1 적게 나옴(수열의 시작 값이 1로 count 되지 않아서)

        for (int i = 0; i < n; i++) {
            for(int j = 0; j < i; j++) {
                if(array[i][1] > array[j][1]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        for (int i : dp) {
            answer = Math.max(answer, i);
        }

        System.out.println(n - (answer + 1));
    }
}
