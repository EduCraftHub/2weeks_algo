// https://www.acmicpc.net/problem/22988

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        long total = Long.parseLong(st.nextToken());

        long[] array = new long[n];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < n; i++) {
            array[i] = Long.parseLong(st.nextToken());
        }

        Arrays.sort(array);

        int answer = 0;
        int remain = 0;
        int left = 0;
        int right = n - 1;

        while (left <= right) {
            if(array[right] == total) {
                answer++;
                right--;
                continue;
            }

            // 하나가 남는 경우
            if(left == right) {
                remain++;
                break;
            }

            // 절반보다 크거나 같은 경우
            if(array[left] + array[right] >= total / 2.0) {
                answer++;
                left++;
                right--;
            } else {
                // 절반보다 작은 경우
                remain++;
                left++;
            }
        }

        // 빈 병이어도 3개가 모이면 2병, 2병씩 반 병을 채우니까 한 병을 완성할 수 있음 ⇒ 3으로 나눈 몫을 구하는 이유
        System.out.println(answer + remain / 3);
    }
}
