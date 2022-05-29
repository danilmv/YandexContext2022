package task5;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;

public class magic {
    public static void main(String[] args) {
        try (FileInputStream fis = new FileInputStream(new File("input.txt"))) {

            Scanner scanner = new Scanner(fis); //new Scanner(System.in);

            String text = scanner.nextLine();
            String string = scanner.nextLine();

            HashMap<Character, Integer> stringMap = new HashMap<>();
            for (int i = 0; i < string.length(); i++) {
                char symbol = string.charAt(i);
                Integer value = stringMap.get(symbol);
                if (value == null)
                    stringMap.put(symbol, 1);
                else
                    stringMap.put(symbol, value + 1);
            }

            HashMap<Character, Integer> textMap = new HashMap<>();
            for (int j = 0; j < text.length() - string.length() + 1; j++) {
                for (int i = 0; i < string.length(); i++) {
                    char symbol = text.charAt(j + i);
                    Integer value = textMap.get(symbol);
                    if (value == null)
                        textMap.put(symbol, 1);
                    else
                        textMap.put(symbol, value + 1);
                }

                int more = 0;
                int less = 0;
                for (char key : textMap.keySet()) {
                    Integer value = stringMap.get(key);
                    if (value == null) more += textMap.get(key);
                    else {
                        int diff = textMap.get(key) - value;
                        if (diff > 0) more += diff;
                        else less -= diff;
                    }
                    if (more >= 2 || less >= 2) break;
                }
                for (char key : stringMap.keySet()) {
                    if (textMap.get(key) == null)
                        less += stringMap.get(key);
                }

                if (more == 1 && less == 1) {
                    System.out.println(j);
                    return;
                }

                textMap.clear();
            }

            System.out.println(-1);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
