package contest.task5;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Task5 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n + 1];
        long[] pref = new long[n + 1];
        long ans = 0;
        int lastI = 0;
        Map<Long, Integer> mapLast = new HashMap<>();
        mapLast.put(0L, 0);

        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
            pref[i] = pref[i - 1] + arr[i];
        }

        sc.close();

        for (int j = 1; j <= n; j++) {
            if (!mapLast.containsKey(pref[j])) {
                mapLast.put(pref[j], j);
                continue;
            }
            int i = mapLast.get(pref[j]) + 1;
            int l = (i - lastI);
            int r = (n - j + 1);
            ans += (long) l * r;
            mapLast.put(pref[j], j);
            lastI = i;
        }

        System.out.println(ans);
    }
}