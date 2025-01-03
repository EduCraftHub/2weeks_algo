import java.util.Scanner;

public class Temperature {

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        int size = Integer.parseInt(sc.next());
        int term = sc.nextInt();
        int answer = Integer.MIN_VALUE;

        int[] array = new int[size];
        // 실제 배열보다 + 1한 사이즈로 누적합 배열을 만드는 이유는 편하게 저장하기 위해서(안 그러면 0번 인덱스에 대해서 if 처리를 해줘야 함)
        int[] prefix = new int[size + 1];

        for (int i = 0; i < size; i++) {
            array[i] = Integer.parseInt(sc.next());
        }

        for (int i = 0; i < size; i++) {
            prefix[i + 1] = prefix[i] + array[i];
        }

        // term에서 시작해야 그만큼 전 값을 뺄 수 있어서 term에서 시작하고, i보다 term 전의 값들을 빼나가며 큰 값을 answer에 대입
        for (int i = term; i < prefix.length; i++) {
            answer = Math.max(prefix[i] - prefix[i - term], answer);
        }

        System.out.println(answer);
    }    
}
