// https://www.acmicpc.net/problem/2961

import java.util.Scanner;

public class Cooking {

    static int answer = Integer.MAX_VALUE;
    static int[][] ingredients;
    static int count;

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        count = sc.nextInt();
        ingredients = new int[count][2];

        for ( int i = 0; i < count; i++ ) {
            ingredients[i][0] = sc.nextInt();
            ingredients[i][1] = sc.nextInt();
        }

        recursive(0, 1, 0, 0);

        System.out.println(answer);
    }

    static private void recursive(int index, int sour, int bitter, int use) {

        if ( index == count ) {

            if ( use == 0) return;

            int result = Math.abs(sour - bitter);
            answer = Math.min(answer, result);
            return;
        }

        recursive( index + 1, sour * ingredients[index][0], bitter + ingredients[index][1], use + 1 );
        recursive( index + 1, sour, bitter, use );
    }
}
