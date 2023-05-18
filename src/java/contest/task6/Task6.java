package contest.task6;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Task6 {
    static Scanner sc = new Scanner(System.in);
    static int N = sc.nextInt();
    static int S = sc.nextInt();
    static int[] arrMin = new int[N];
    static int[] arrMax = new int[N];

    public static void main(String[] args) {
        for (int i = 0; i < N; i++) {
            arrMin[i] = sc.nextInt();
            arrMax[i] = sc.nextInt();
        }
        sc.close();

        List<Integer> list = new ArrayList<>(arrMin.length + arrMax.length);
        for (int i = 0; i < N; i++) {
            list.add(arrMin[i]);
            list.add(arrMax[i]);
        }
        Collections.sort(list);
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).equals(list.get(i - 1))) {
                list.remove(i);
                i--;
            }
        }
        long ans = -1;
        int mid = list.size() / 2;
        for (int del = -1; del <= 1; del++) {
            int i = mid + del;
            if (i >= 1 && i <= N) {
                ans = Math.max(ans, check(list.get(i), list.get(i)));
            }
        }

        for (int del = -1; del <= 1; del++) {
            int i = mid + del;
            if (i >= 1 && i < N) {
                ans = Math.max(ans, check(list.get(i), list.get(i + 1)));
            }
        }

        System.out.println(ans);
    }

    private static long check(int l, int r) {
        int a = 0;
        int b = 0;
        long sum = 0;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            if (arrMax[i] < l) {
                a++;
                sum += arrMin[i];
            } else if (arrMin[i] > r) {
                b++;
                sum += arrMin[i];
            } else {
                list.add(arrMin[i]);
            }
        }
        Collections.sort(list);

        if (a <= N / 2 && b <= N / 2) {
            for (int i = 0; i < N / 2 - a; i++) {
                sum += list.get(i);
            }
            long oc = Math.max(0, S - sum);
            long c = oc / ((N / 2 + 1 - b));
            if (c >= r) {
                c = r;
            }
            sum += c * (N / 2 + 1 - b);
            if (sum <= S && c >= l && c <= r) {
                return c;
            }
        }
        return -1;
    }
}
