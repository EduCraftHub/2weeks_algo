// https://www.acmicpc.net/problem/15651

import java.util.Stack;
import java.util.Scanner;

public class NumberSequence4 {

    static int loopIndex;
    static int step;
    static Stack<Integer> stack = new Stack<>();
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        loopIndex = sc.nextInt();
        step = sc.nextInt();

        recursive(0);

        System.out.println(sb.toString());
    }

    static private void recursive(int index) {

        if (index == step) {
            sb.append(String.valueOf(stack).replace("[", "").replace("]", "").replace(",", "")).append("\n");
            return;
        }
        
        for (int i = 1; i < loopIndex + 1; i++) {
            stack.push(i);
            recursive(index + 1);
            stack.pop();
        }
    }
}
