import java.util.Stack;
import java.util.Scanner;

class NumberSequence3 {

    static int loopIndex;
    static int step;
    static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        loopIndex = sc.nextInt();
        step = sc.nextInt();

        recursive(0);
    }

    private static void recursive(int index) {

        if (index == step) {
            System.out.println(stack.toString().replace(",", "").replace("[", "").replace("]", ""));
            return;
        }
        
        for (int i = 1; i < loopIndex + 1; i++) {
            if (!stack.isEmpty() && stack.peek() >= i + 1) continue;
            
            stack.push(i);
            recursive(index + 1);
            stack.pop();
        }
    }
}
