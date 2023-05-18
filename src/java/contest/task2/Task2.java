package contest.task2;

import java.util.Scanner;

public class Task2 {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            int n = sc.nextShort();
            int m = sc.nextShort();
            int k = sc.nextShort();

            int result = (n * k + m - 1) / m;

            System.out.println(result);
        }
    }
}
