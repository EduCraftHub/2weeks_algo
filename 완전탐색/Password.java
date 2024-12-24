import java.util.Scanner;

class Password {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);

        int lines = sc.nextInt();

        for (int i = 0; i < lines; i++) {
            long password = sc.nextLong();

            for (long j = 2; j <= 1000000; j++) {
                if (password % j == 0) {
                    System.out.println("NO");
                    break;
                }
                if (j == 1000000) System.out.println("YES");
            }
        }
    }
}
