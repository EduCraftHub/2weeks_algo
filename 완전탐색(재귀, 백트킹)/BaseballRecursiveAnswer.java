// https://www.acmicpc.net/problem/2503
// 파이썬 정답 버전 자바로 옮긴 코드

import java.util.Scanner;

public class Main {
    static int n;
    static int[][] hint; // hint[i] = {숫자, 스트라이크, 볼}
    static int answer = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        hint = new int[n][3];
        for (int i = 0; i < n; i++) {
            hint[i][0] = sc.nextInt();
            hint[i][1] = sc.nextInt();
            hint[i][2] = sc.nextInt();
        }
        // 후보 숫자는 100부터 999까지 검사 (숫자 0이 포함되면 안되므로)
        recur(0, 100);
        System.out.println(answer);
    }

    /**
     * 재귀 함수
     * @param idx 현재 검사할 hint의 인덱스 (0부터 n-1)
     * @param number 현재 후보 숫자 (100 ~ 999)
     */
    static void recur(int idx, int number) {
        // 후보 숫자가 1000이 되면 더 이상 3자리 수가 아니므로 종료
        if (number == 1000) {
            return;
        }
        // 모든 힌트를 다 만족했다면 정답 count 증가 후, 다음 후보 숫자로 넘어감
        if (idx == n) {
            answer++;
            recur(0, number + 1);
            return;
        }
        // 현재 후보 숫자가 hint[idx]를 만족하면 다음 hint를 검사하고,
        // 만족하지 않으면 이 후보는 탈락 → 다음 후보 숫자로 넘어감.
        if (checker(idx, number)) {
            recur(idx + 1, number);
        } else {
            recur(0, number + 1);
        }
    }

    /**
     * 현재 후보 숫자가 hint[idx]의 조건(스트라이크, 볼)에 부합하는지 검사
     * @param idx 힌트의 인덱스
     * @param number 후보 숫자
     * @return 조건에 맞으면 true, 아니면 false
     */
    static boolean checker(int idx, int number) {
        int _number = hint[idx][0];
        int _strike = hint[idx][1];
        int _ball = hint[idx][2];

        // 후보 숫자와 힌트의 숫자를 각 자리로 분해
        int A = number / 100;
        int B = (number % 100) / 10;
        int C = number % 10;

        int _A = _number / 100;
        int _B = (_number % 100) / 10;
        int _C = _number % 10;

        // 0이 포함되거나 중복되는 숫자가 있으면 조건에 맞지 않음
        if (A == 0 || B == 0 || C == 0) return false;
        if (A == B || A == C || B == C) return false;

        int strike = 0;
        int ball = 0;

        // 스트라이크 판별 (자릿수와 값 모두 일치)
        if (A == _A) strike++;
        if (B == _B) strike++;
        if (C == _C) strike++;

        // 볼 판별 (값은 일치하지만, 자릿수는 다름)
        if (A == _B || A == _C) ball++;
        if (B == _A || B == _C) ball++;
        if (C == _A || C == _B) ball++;

        return (strike == _strike && ball == _ball);
    }
}
