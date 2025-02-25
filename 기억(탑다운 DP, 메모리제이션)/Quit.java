// https://www.acmicpc.net/problem/14501

import java.util.Scanner;

public class Quit {

    static int     day;
    static int[][] schedule;
    static int[]   dp;
    static int     salary;

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        day = sc.nextInt();
        schedule = new int[day][2];
        dp = new int[day + 1];

        for (int i = 0; i < day; i++) {
            schedule[i][0] = sc.nextInt();
            schedule[i][1] = sc.nextInt();
        }

        for (int i = 0; i <= day; i++) {
            dp[i] = -1;
        }

        System.out.println(recursive(0));
    }

    private static int recursive (int index) {

        // index == day면, 더 이상 일을 진행할 수 없기 때문에 수익이 0, Integer.MIN_VALUE를 return 하면 Integer.MIN_VALUE + schedule[index][1] 같은 형태가 나오기 때문에 오류가 생김
        if ( index == day ) return 0;

        // index가 day - 1보다 크면 선택할 수 없기 때문에 최소값을 반환
        if ( index > day - 1 ) return Integer.MIN_VALUE;

        // 만약 dp[index]가 -1이 아니면 이미 확인한 날이기 때문에 dp[index] 값을 반환
        if ( dp[index] != -1 ) return dp[index];

        dp[index] = Math.max( recursive(index + schedule[index][0]) + schedule[index][1], recursive(index + 1) );

        return dp[index];
    }
}

/*

recursive(0)
├── 선택 (index=0 상담 수락, index=3부터 진행) → recursive(3) + 10
│   ├── 선택 (index=3 상담 수락, index=4부터 진행) → recursive(4) + 20
│   │   ├── 선택 (index=4 상담 수락, index=6부터 진행) → recursive(6) + 15
│   │   │   ├── 선택 (index=6 상담 수락, index=8부터 진행) → (퇴사일 초과) → -∞
│   │   │   ├── 선택 안 함 (index=7) → 0
│   │   │   └── dp[6] = max(-∞, 0) = 0
│   │   ├── 선택 안 함 (index=5) → recursive(5)
│   │   │   ├── 선택 (index=5 상담 수락, index=9부터 진행) → (퇴사일 초과) → -∞
│   │   │   ├── 선택 안 함 (index=6) → 0 (이전 값 재사용)
│   │   │   └── dp[5] = max(-∞, 0) = 0
│   │   └── dp[4] = max(0 + 15, 0) = 15
│   ├── 선택 안 함 (index=3) → recursive(3)
│   └── dp[3] = max(15 + 20, 15) = 35
├── 선택 안 함 (index=1) → recursive(1)
│   ├── 선택 (index=1 상담 수락, index=6부터 진행) → recursive(6) + 20
│   │   ├── (이전 계산값 dp[6] 재사용) → 0
│   │   ├── dp[6] = 0
│   │   └── dp[1] = max(0 + 20, recursive(2))
│   ├── 선택 안 함 (index=2) → recursive(2)
│   │   ├── 선택 (index=2 상담 수락, index=3부터 진행) → recursive(3) + 10
│   │   ├── 선택 안 함 (index=3) → 35 (이전 값 재사용)
│   │   └── dp[2] = max(35 + 10, 35) = 45
│   └── dp[1] = max(20, 45) = 45
└── dp[0] = max(35 + 10, 45) = 45

 */
