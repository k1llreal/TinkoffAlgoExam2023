package contest.task3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task3 {
    public static void main(String[] args) {
        int indexA = -1;
        int indexB = -1;
        int indexC = -1;
        int indexD = -1;
        char current;
        boolean hasGoodStr = false;

        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.parseInt(reader.readLine());
            String str = reader.readLine();
            int result = n;

            for (int i = 0; i < n; i++) {
                current = str.charAt(i);
                switch (current) {
                    case 'a':
                        indexA = i;
                        break;
                    case 'b':
                        indexB = i;
                        break;
                    case 'c':
                        indexC = i;
                        break;
                    case 'd':
                        indexD = i;
                        break;
                }

                if (Math.min(indexA, indexB) >= 0 && Math.min(indexC, indexD) >= 0) {
                    hasGoodStr = true;

                    int minCD = Math.min(indexC, indexD);
                    int minBCD = Math.min(indexB, minCD);
                    int minABCD = Math.min(indexA, minBCD);

                    int maxCD = Math.max(indexC, indexD);
                    int maxBCD = Math.max(indexB, maxCD);
                    int maxABCD = Math.max(indexA, maxBCD);

                    result = Math.min(result, maxABCD + 1 - minABCD);

                    if (result == 4) {
                        break;
                    }
                }
            }

            if (hasGoodStr) {
                System.out.println(result);
            } else {
                System.out.println(-1);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
