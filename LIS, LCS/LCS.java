// https://www.acmicpc.net/problem/9251

import java.util.*;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String a = sc.nextLine();
        String b = sc.nextLine();

        String[] aArr = a.split("");
        String[] bArr = b.split("");

        int[][] dp = new int[a.length() + 1][b.length() + 1];

        int answer = 0;

        for(int i = 1; i < a.length() + 1; i++) {
            for (int j = 1; j < b.length() + 1; j++) {
                if(aArr[i - 1].equals(bArr[j - 1])) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        System.out.println(dp[a.length()][b.length()]);
    }
}
