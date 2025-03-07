// https://www.acmicpc.net/problem/14501

import java.util.*;

public class Quit {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        
        int day = sc.nextInt();

        int[][] schedule = new int[day][2];
        int[] dp = new int[day + 1];

        for (int i = 0; i < day; i++) {
            schedule[i][0] = sc.nextInt();
            schedule[i][1] = sc.nextInt();
        }

        for (int i = day - 1; i >= 0; i--) {
            if (i + schedule[i][0] > day) {
                dp[i] = dp[i + 1];
            } else {
                dp[i] = Math.max(dp[i + schedule[i][0]] + schedule[i][1], dp[i + 1]);
            }
        }

        System.out.println(dp[0]);
    }
}
