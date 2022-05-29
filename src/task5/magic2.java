package task5;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class magic2 {
    public static void main(String[] args) {
//        try (FileInputStream fis = new FileInputStream(new File("input.txt"))) {

        Scanner scanner = new Scanner(System.in); //new Scanner(fis); //

        String text = scanner.nextLine();
        String string = scanner.nextLine();
        int[] textArr = new int[26];
        int[] stringArr = new int[26];

        if (text.length() < string.length()) {
            System.out.println(-1);
            return;
        }

        for (int i = 0; i < string.length(); i++) {
            int symbol = string.charAt(i) - 'a';
            stringArr[symbol]++;
        }

        for (int i = 0; i < string.length(); i++) {
            int symbol = text.charAt(i) - 'a';
            textArr[symbol]++;
        }

        for (int j = 0; j < text.length() - string.length() + 1; j++) {
            if (j > 0) {
                int symbol = text.charAt(j - 1) - 'a';
                textArr[symbol]--;
                symbol = text.charAt(j + string.length() - 1) - 'a';
                textArr[symbol]++;
            }
            int more = 0;
            int less = 0;
            for (int key = 0; key < 26; key++) {
                int diff = textArr[key] - stringArr[key];
                if (diff > 0) more += diff;
                else less -= diff;
                if (more >= 2 || less >= 2) break;
            }

            if (more == 1 && less == 1) {
                System.out.println(j);
                return;
            }
        }

        System.out.println(-1);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
