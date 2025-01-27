import java.util.Stack;
import java.util.Arrays;
import java.util.Scanner;

public class NumberSequence7 {

    static int loopIndex;
    static int step;
    static Stack<Integer> stack = new Stack<>();
    static StringBuilder sb = new StringBuilder();
    static int[] array;

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        loopIndex = sc.nextInt();
        step = sc.nextInt();
        array = new int[loopIndex];

        sc.nextLine();

        for (int i = 0; i < loopIndex; i++) {
            array[i] = sc.nextInt();
        }

        Arrays.sort(array);

        recursive(0);

        System.out.println(sb.toString());
    }

    static private void recursive(int index) {

        if (index == step) {
            sb.append(String.valueOf(stack).replace("[", "").replace("]", "").replace(",", "")).append("\n");
            return;
        }
        
        for (int i = 0; i < loopIndex; i++) {
            stack.push(array[i]);
            recursive(index + 1);
            stack.pop();
        }
    }
}
