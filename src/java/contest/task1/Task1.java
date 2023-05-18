package contest.task1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Task1 {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in))) {
            String str = reader.readLine();
            System.out.println(checkOrder(str));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static String checkOrder(String str) {
        String[] splitStr = str.split("\\D+");
        boolean orderFlag = Integer.parseInt(splitStr[0]) > Integer.parseInt(splitStr[1]);

        for (int i = 1; i < splitStr.length - 1; i++) {
            if (orderFlag) {
                if (Integer.parseInt(splitStr[i]) < Integer.parseInt(splitStr[i + 1])) {
                    return "NO";
                }
            } else {
                if (Integer.parseInt(splitStr[i]) > Integer.parseInt(splitStr[i + 1])) {
                    return "NO";
                }
            }
        }

        return "YES";
    }
}
