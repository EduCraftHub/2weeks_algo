// https://www.acmicpc.net/problem/15655

import java.util.Stack;
import java.util.Arrays;
import java.util.Scanner;

public class NumberSequence6 {

    static int loopIndex;
    static int step;
    static int[] numbers;
    static StringBuilder sb = new StringBuilder();
    static Stack<Integer> stack = new Stack<>();

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        loopIndex = sc.nextInt();
        step = sc.nextInt();
        numbers = new int[loopIndex];        

        sc.nextLine();

        for (int i = 0; i < loopIndex; i++) {
            numbers[i] = sc.nextInt();
        }

        Arrays.sort(numbers);

        // 종료 조건 : step 기준으로 for문 깊이의 depth를 갖고 있는 값이 필요한가 0부터 +1 증가하는 값을 넘겨서 step == 해당 값으로 종료 추가하기
        // i, j k, l을 어떻게 할지 : 값을 넘겨야겠다
        // recursive(for문 인덱스, depth)
        
        // for (int i = 0; i < loopIndex; i++) {
        //     if (stack.contains(numbers[i])) continue;

        //     stack.push(numbers[i]);


        //     for (int j = i + 1; j < loopIndex; j++) {
        //         if (stack.contains(numbers[j])) continue;

        //         stack.push(numbers[j]);

        //         for (int k = j + 1; k < loopIndex; k++) {
        //             if (stack.contains(numbers[k])) continue;

        //             stack.push(numbers[k]);

        //             for (int l = k + 1; k < loopIndex; l++) {
        //                 if (l >= loopIndex) break;
        //                 if (stack.contains(numbers[l])) continue;

        //                 stack.push(numbers[l]);

        //                 // for문 깊이가 step이랑 같으니까
        //                 sb.append(stack.toString().replace(",", "").replace("[", "").replace("]", ""));
        //                 sb.append("\n");

        //                 stack.pop();
        //             }

        //             stack.pop();
        //         }

        //         stack.pop();
        //     }

        //     stack.pop();
        // }

        recursive(0, 0);

        System.out.println(sb.toString());
    }

    private static void recursive (int index, int depth) {

        if (step == depth) {
            sb.append(stack.toString().replace(",", "").replace("[", "").replace("]", ""));
            sb.append("\n");
            return;
        }

        for ( int i = index; i < loopIndex; i++) {
            if (stack.contains(numbers[i])) continue;

            stack.push(numbers[i]);
            recursive(i + 1, depth + 1);
            stack.pop();
        }
    }
}
