import java.util.Scanner;

public class Baseball {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int answer = 0;
        int times = sc.nextInt();
        sc.nextLine();

        int[][] hints = new int[times][3];

        for (int i = 0; i < times; i++) {
            String[] hintString = sc.nextLine().split(" ");
            for (int j = 0; j < 3; j++) {
                hints[i][j] = Integer.parseInt(hintString[j]);
            }
        }

        for (int i = 1; i < 10; i++) {
            for (int j = 1; j < 10; j++) {
                for (int k = 1; k < 10; k++) {
                    if ( i == j || j == k || i == k) continue;

                    int count = 0;

                    for (int[] hint : hints) {
                        int number = hint[0];
                        int strike = hint[1];
                        int ball = hint[2];
                        int ballCount = 0;
                        int strikeCount = 0;

                        int hundred = number / 100;
                        int ten = number % 100 / 10;
                        int one = number % 10;

                        if (hundred == i) strikeCount++;
                        if (hundred == j || hundred == k) ballCount++;
                        if (ten == j) strikeCount++;
                        if (ten == i || ten == k) ballCount++;
                        if (one == k) strikeCount++;
                        if (one == i || one == j) ballCount++;

                        if (ball == ballCount && strike == strikeCount) count++;
                    }

                    if (count == times) answer++;
                }
            }
        }

        System.out.println(answer);
    }
}
