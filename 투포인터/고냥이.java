// https://www.acmicpc.net/problem/16472

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 고양이가 구별할 수 있는 최대 문자 종류
        String str = br.readLine();              // 입력 문자열

        int[] count = new int[26]; // 알파벳 등장 횟수
        int unique = 0;            // 현재 윈도우 안에 존재하는 서로 다른 알파벳 개수
        int left = 0;              // 왼쪽 포인터
        int maxLength = 0;

        for (int right = 0; right < str.length(); right++) {
            char c = str.charAt(right);
            int idx = c - 'a';

            // 처음 보는 문자면 종류 수 증가
            if (count[idx] == 0) {
                unique++;
            }
            
            count[idx]++;

            // 종류 수가 N 초과면 왼쪽 포인터 이동
            while (unique > N) {
                char leftChar = str.charAt(left);
                int leftIdx = leftChar - 'a';
                count[leftIdx]--;

                if (count[leftIdx] == 0) {
                    unique--;
                }

                left++;
            }

            // 조건 만족할 때마다 최대 길이 갱신
            maxLength = Math.max(maxLength, right - left + 1);
        }

        System.out.println(maxLength);
    }
}
