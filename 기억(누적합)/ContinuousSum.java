public class ContinuousSum {

  // https://www.acmicpc.net/problem/1912

    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        int size = sc.nextInt();
        int[] array = new int[size];
        int[] prefix = new int[size + 1];
        int answer = Integer.MIN_VALUE;

        for (int i = 0; i < size; i++) {
            array[i] = Integer.parseInt(sc.next());
        }

        // 누적 합의 값보다 array의 크면 거기서 새로 시작하는 이유 : 지금까지 연속으로 더해온 숫자보다 그 다음이 클 예정이기 때문
        for (int i = 0; i < size; i++) {
            prefix[i + 1] = Math.max(array[i] + prefix[i], array[i]);
        }

        // 0번 인덱스는 무조건 0이기 때문에 1번 인덱스부터 순회 시작, prefix 배열을 순회하는 것이기 때문에 prefix.length만큼 순회
        for (int i = 1; i < prefix.length; i++) {
            answer = Math.max(prefix[i], answer);
        }

        System.out.println(Arrays.toString(prefix));
        System.out.println(answer);
    }
}
