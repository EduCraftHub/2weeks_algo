// https://www.acmicpc.net/problem/12865 => DP 적용 전

import java.util.Scanner;

public class Main {

    static int count;
    static int maxWeight;
    static int answer = Integer.MIN_VALUE;
    static int[][] things;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        count = sc.nextInt();
        maxWeight = sc.nextInt();
        things = new int[count][2];

        for(int i = 0; i < count; i++) {
            things[i][0] = sc.nextInt();
            things[i][1] = sc.nextInt();
        }

        // 종료 조건 : index == count
        // 물건의 무게 <= maxWeight 이면, value를 더해서 answer에 Math.max(answer, value)를 담는다

        recursive(0, 0, 0);

        System.out.println(answer);
    }

    private static void recursive(int index, int weight, int value) {
        if (weight <= maxWeight) answer = Math.max(answer, value);
        
        if (index == count) return; 

        recursive(index + 1, weight + things[index][0], value + things[index][1]);
        recursive(index + 1, weight, value);
    }
}
