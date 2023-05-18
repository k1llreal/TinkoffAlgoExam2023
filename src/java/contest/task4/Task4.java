package contest.task4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Task4 {
    public static void main(String[] args) {
        int maxCount = 0;
        Map<Integer, Integer> map1 = new HashMap<>();
        Map<Integer, Integer> map2 = new HashMap<>();
        int l = 2;

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine());
            String str = reader.readLine();
            int[] arr = new int[n];
            String[] splitStr = str.split("\\D+");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(splitStr[i]);
                int count1 = map1.getOrDefault(arr[i], 0) + 1;
                map1.put(arr[i], count1);
                int count2 = map2.getOrDefault(count1, 0) + 1;
                if (count1 > 1 && map2.getOrDefault(count1 - 1, 0) == 1) {
                    map2.remove(count1 - 1);
                } else if (count1 > 1) {
                    map2.put(count1 - 1, map2.getOrDefault(count1 - 1, 0) - 1);
                }
                map2.put(count1, count2);
                if (count1 > maxCount) {
                    maxCount = count1;
                }
            }

            for (int i = n - 1; i > 0; i--) {
                if ((map2.size() == 1) ||
                        (map2.size() == 2 && map2.getOrDefault(1, 0) == 1) ||
                        (map2.size() == 2 && map2.getOrDefault(maxCount, 0) == 1 &&
                                map2.getOrDefault(maxCount - 1, 0) != 0)) {
                    l = i + 1;
                    break;
                }

                int count1 = map1.get(arr[i]) - 1;
                if (maxCount == count1 + 1 && map2.get(count1 + 1) == 1) {
                    maxCount -= 1;
                }
                if (count1 == 0) {
                    map1.remove(arr[i]);
                } else {
                    map1.put(arr[i], count1);
                }
                int count2 = map2.get(count1 + 1) - 1;
                if (count2 == 0) {
                    map2.remove(count1 + 1);
                } else {
                    map2.put(count1 + 1, count2);
                }
                if (count1 != 0) {
                    map2.put(count1, map2.getOrDefault(count1, 0) + 1);
                }
            }

            System.out.println(l);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
