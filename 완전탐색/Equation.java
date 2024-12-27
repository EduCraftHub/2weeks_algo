import java.util.Scanner;

public class Equation {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] numbers = sc.nextLine().split(" ");

        int a = Integer.parseInt(numbers[0]);
        int b = Integer.parseInt(numbers[1]);
        int c = Integer.parseInt(numbers[2]);
        int d = Integer.parseInt(numbers[3]);
        int e = Integer.parseInt(numbers[4]);
        int f = Integer.parseInt(numbers[5]);

        for (int i = -10000; i <= 10000; i ++) {
            for (int j = -10000; j <= 10000; j ++) {
                if ( a * i + b * j == c) {
                    if (d * i + e * j == f) {
                        System.out.println(i + " " + j);
                        break;
                    }
                }
            }
        }
    }
}
