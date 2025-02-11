import java.util.Scanner;

public class Quit {

    static int day;
    static int salary = Integer.MIN_VALUE;
    static int[][] schedule;

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        day = sc.nextInt();
        schedule = new  int[day][2];

        for(int i = 0; i < day; i++) {
            schedule[i][0] = sc.nextInt();
            schedule[i][1] = sc.nextInt();
        }

        // 종료일이 day보다 적어야 함 -> 인덱스를 받고 인덱스(0부터) + 기간 (= 종료일) <= day
        // 재귀를 돌면서 종료일 <= day 일 때, salary = Math.max(salary, result)
        // 종료 조건은? index 다 돌았을 때
        // index 증가 조건은 index + 기간(스케쥴 했을 때) & index + 1(스케쥴 안 했을 때)

        recursive(0, 0);

        System.out.println(salary);
    }

    static void recursive(int index, int fee) {

        if ( index <= day ) {
            salary = Math.max(salary, fee);
        }

        if ( index >= day) return;

        recursive(index + schedule[index][0], fee + schedule[index][1]);
        recursive(index + 1, fee);
    }
}
