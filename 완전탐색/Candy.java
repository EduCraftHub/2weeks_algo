import java.util.Scanner;

class Candy {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        int candy = sc.nextInt();
        int answer = 0;

        for (int a = 1; a <= candy; a++) {
            for (int b = 1; b <= candy; b++) {
                for (int c = 1; c <= candy; c++) {
                    if (a + b + c == candy) {
                        if (a > b + 1) {
                            if (c % 2 == 0) answer ++;
                        }
                    }
                }
            }
        }

        System.out.println(answer);
    }
}
