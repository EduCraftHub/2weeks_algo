// https://www.acmicpc.net/problem/19942

import java.util.Stack;
import java.util.Scanner;

public class Diet {

    static int price = Integer.MAX_VALUE;
    static int[][] ingredients;
    static int count;
    static int standardProtein, standardFat, standardCarbs, standardVitamin;
    static Stack<Integer> used = new Stack<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        count = sc.nextInt();
        standardProtein = sc.nextInt();
        standardFat = sc.nextInt();
        standardCarbs = sc.nextInt();
        standardVitamin = sc.nextInt();
        ingredients = new int[count][5];

        for ( int i = 0; i < count; i++ ) {
            ingredients[i][0] = sc.nextInt();
            ingredients[i][1] = sc.nextInt();
            ingredients[i][2] = sc.nextInt();
            ingredients[i][3] = sc.nextInt();
            ingredients[i][4] = sc.nextInt();
        }

        recursive(0, 0, 0, 0, 0, 0);

        if ( price == Integer.MAX_VALUE ) System.out.println(-1);
        else System.out.println(price + "\n" + sb.toString());
    }

    static private void recursive(int index, int protein, int fat, int carbs, int vitamin, int cost) {

        if ( standardProtein <= protein && standardFat <= fat && standardCarbs <= carbs && standardVitamin <= vitamin ) {

            if (price > cost) {
                price = cost;

                sb.delete(0, sb.length());

                for (int i = 0; i < used.size(); i++) {
                    sb.append(used.get(i));
                    if ( i != used.size() - 1) sb.append(" ");
                }
            }            
        }

        if ( index == count ) {
            return;
        }

        used.push(index + 1);

        recursive( index + 1, protein + ingredients[index][0], fat + ingredients[index][1], carbs + ingredients[index][2], vitamin + ingredients[index][3], cost + ingredients[index][4] );

        used.pop();

        recursive( index + 1, protein, fat, carbs, vitamin, cost );
    }
}
