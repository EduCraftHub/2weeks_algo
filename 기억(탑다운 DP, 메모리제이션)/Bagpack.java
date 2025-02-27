// https://www.acmicpc.net/problem/12865

import java.util.*;

public class Bagpack {

    static int     count;
    static int     maxWeight;
    static int[][] things;
    static int[][]   dp;

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        count = sc.nextInt();
        maxWeight = sc.nextInt();
        things = new int[count][2];
        // 인덱스를 개수와 무게로 쓰기 때문에 최대값까지 인덱스가 있어야 해서 + 1한 값들로 배열 선언언
        dp = new int[count + 1][100001];

        for (int i = 0; i < count; i++) {
            things[i][0] = sc.nextInt();
            things[i][1] = sc.nextInt();
        }

        for (int i = 0; i < dp.length; i++) {
            Arrays.fill(dp[i], -1);
        }

        System.out.println(recursive(0, 0));
    }

    private static int recursive (int index, int weight) {

        // 무게가 maxWeight보다 큰 경우 쓸 수 없기 때문에 최소값 return
        if ( weight > maxWeight ) return Integer.MIN_VALUE;

        // index가 count랑 같으면 things[index]에 값이 없기 때문에(마지막까지 확인 완료) return 0 ⇒ 더 넣을 게 없음
        if ( index == count ) return 0;

        // dp[index][weight] 값이 -1이 아니라면, 이미 계산된 값이므로 다시 계산하지 않고 반환
        if ( dp[index][weight] != -1 ) return dp[index][weight];

        // index와 weight로 2차원 배열을 선언해서, 해당 index의 무게가 N일 때 value가 얼마인지 표기기
        dp[index][weight] = Math.max(   recursive(index + 1, weight + things[index][0]) + things[index][1], // 현재 물건 선택
                                        recursive(index + 1, weight) // 현재 물건 선택 X
                                    );

        // index번째의 물건이고, 배낭의 무게가 weight일 때 얻을 수 있는 최대 value return
        return dp[index][weight];
    }
}

/*

입력 값 :
3 5
2 3
3 4
4 5

호출 스택

    recursive(0, 0)  
    ├── recursive(1, 2)  // 물건 0을 넣음 (무게 +2, 가치 +3)
    │   ├── recursive(2, 5)  // 물건 1을 넣음 (무게 +3, 가치 +4)
    │   │   ├── recursive(3, 5) → return 0  // 모든 물건 고려 완료
    │   │   → dp[2][5] = 0
    │   │
    │   ├── recursive(2, 2)  // 물건 1을 안 넣음
    │   │   ├── recursive(3, 6) → return Integer.MIN_VALUE  // 무게 초과
    │   │   ├── recursive(3, 2) → return 0  // 모든 물건 고려 완료
    │   │   → dp[2][2] = 0
    │   │
    │   → dp[1][2] = max(0 + 4, 0) = 4
    │
    ├── recursive(1, 0)  // 물건 0을 안 넣음
    │   ├── recursive(2, 3)  // 물건 1을 넣음 (무게 +3, 가치 +4)
    │   │   ├── recursive(3, 7) → return Integer.MIN_VALUE  // 무게 초과
    │   │   ├── recursive(3, 3) → return 0  // 모든 물건 고려 완료
    │   │   → dp[2][3] = 0
    │   │
    │   → dp[1][0] = max(0 + 4, 0) = 4
    │
    │   ├── recursive(2, 0)  // 물건 1을 안 넣음
    │   │   ├── recursive(3, 4) → return 0  // 물건 2를 넣음 (무게 +4, 가치 +5)
    │   │   ├── recursive(3, 0) → return 0  // 물건 2를 안 넣음
    │   │   → dp[2][0] = max(0 + 5, 0) = 5
    │   │
    │   → dp[1][0] = max(4, 5) = 5
    │
    → dp[0][0] = max(4 + 3, 5) = 7

 */

 /*

 dp 배열

    weight →   0   1   2   3   4   5
    --------------------------------
    dp[0]   |  7  -1  -1  -1  -1  -1  (모든 물건 고려)
    dp[1]   |  5  -1   4  -1  -1  -1  (물건 1까지 고려)
    dp[2]   |  5  -1   0   0  -1   0  (물건 2까지 고려)

  */
