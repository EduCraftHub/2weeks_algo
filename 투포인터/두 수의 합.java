// https://www.acmicpc.net/problem/3273

import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int answer = 0;
        int n = sc.nextInt();
        int[] array = new int[n];

        for(int i = 0; i < n; i++) {
            array[i] = sc.nextInt();
        }

        int num = sc.nextInt();

        Arrays.sort(array);

        int left = 0;
        int right = n - 1;

        while (left < right) {
            if(array[left] + array[right] == num) {
                answer++;
                right--;
            }

            if(array[left] + array[right] > num) {
                right--;
            } else {
                left++;
            }
        }

        System.out.println(answer);
    }
}
