// https://www.acmicpc.net/problem/2503

import java.util.Scanner;

public class Main2{

    static int answer = 0;
    static int length;
    static int[] numbers;
    static int[] strikes;
    static int[] balls;

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        length = Integer.valueOf(sc.nextLine());
        numbers = new int[length];
        strikes = new int[length];
        balls = new int[length];

        for ( int i = 0; i < length; i++ ) {
            numbers[i] = sc.nextInt();
            strikes[i] = sc.nextInt();
            balls[i] = sc.nextInt();
        }

        int[] checkingNumber = new int[3];
        boolean[] isUsedNumber = new boolean[10];

        recursive(0, checkingNumber, isUsedNumber);

        System.out.println(answer);
    }

    private static void recursive(int depth, int[] checkingNumber, boolean[] isUsedNumber) {
        if ( depth == 3) {
            if ( isValid(checkingNumber) ) {
                answer++;
            }
            return;
        }

        // 사용하지 않은 3가지 숫자 조합 -> 재귀가 끝나면 사용 여부 false로 변경 : 1 , 2, 3 조합을 봤다가 1, 3, 2를 보려면 3과 2가 false 상태여야 함
        for ( int i = 1; i < 10; i++ ) {
            if ( !isUsedNumber[i] ) {
                checkingNumber[depth] = i;
                isUsedNumber[i] = true;
                recursive(depth + 1, checkingNumber, isUsedNumber);
                isUsedNumber[i] = false;
            }
        }
    }

    // strike와 ball 수가 같은지 검증
    private static boolean isValid(int[] checkingNumber) {
        for ( int i = 0; i < length; i++) {

            int number = numbers[i];
            int strike = strikes[i];
            int ball = balls[i];

            int strikeCount = 0;
            int ballCount = 0;

            int checkingNumberHundred = checkingNumber[0];
            int checkingNumberTen = checkingNumber[1];
            int checkingNumberOne = checkingNumber[2];

            int hundred = number / 100;
            int ten = number % 100 / 10;
            int one = number % 10;

            if ( checkingNumberHundred == hundred ) strikeCount++;
            if ( checkingNumberHundred == ten || checkingNumberHundred == one ) ballCount++;
            if ( checkingNumberTen == ten ) strikeCount++;
            if ( checkingNumberTen == hundred || checkingNumberTen == one ) ballCount++;
            if ( checkingNumberOne == one ) strikeCount++;
            if ( checkingNumberOne == hundred || checkingNumberOne == ten ) ballCount++;

            if ( ballCount != ball || strikeCount != strike ) return false;
        }

        return true;
    }
}
