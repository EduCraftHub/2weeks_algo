package Java;
import java.util.Scanner;

public class Storage {

    public static void main(String[] args) {

        // https://www.acmicpc.net/problem/2304

        // 왼쪽에서 가장 큰 기둥까지 누적합
        // 오른쪽에서 가장 큰 기둥까지 누적합
        // 1000 길이의 배열을 만들어서 인덱스에 넣고
        // 가장 큰 인덱스와 가장 큰 길이를 저장
        // 누적합 배열을 만들되, 큰 값을 만나면 더하고 작은 값을 만나면 기존 값을 더함
        
        Scanner sc = new Scanner(System.in);

        int[] array = new int[1000];

        int maxIndex = 0;
        int maxHeight = 0;
        int maxHeightIndex = 0;
        int current = 0;
        int answer = 0;
        int total = sc.nextInt();

        for ( int i = 0; i < total; i++ ) {
            int index = Integer.parseInt(sc.next()) - 1;
            int height = sc.nextInt();

            array[index] = height;

            if ( maxHeight < height) {
                maxHeight = height;
                maxHeightIndex = index;
            }

            maxIndex = Math.max(maxIndex, index);
            maxHeight = Math.max(maxHeight, height);
        }

        int[] prefix = new int[maxIndex + 2];
        answer += maxHeight;
    
        for (int i = 0; i < maxHeightIndex + 1; i++) {
            current = Math.max(current, array[i]);
            prefix[i + 1] = prefix[i] + current;

            if (i == maxHeightIndex - 1) answer += prefix[i + 1];
        }

        for (int i = maxIndex; i > maxHeightIndex; i--) {
            if ( i == maxIndex ) current = 0;
            current = Math.max(current, array[i]);
            prefix[i] = prefix[i + 1] + current;

            if (i == maxHeightIndex + 1) answer += prefix[i];
        }

        System.out.println(answer);
    }
}
