package task1;

import java.io.*;
import java.util.Scanner;

public class Letters {
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
//        try (FileInputStream fis = new FileInputStream(new File("input.txt"))) {

//            Scanner scanner = new Scanner(fis);
        int n = Integer.valueOf(scanner.nextLine());
        String string = scanner.nextLine();
        long max = -1;
        int index = -1;
        long a = 0;

        long pred = 0;
        for (int i = 0; i < n; i++) {
            a = -pred;
            pred = scanner.nextInt();
            a += pred;
            if (a >= max) {
                max = a;
                index = i;
            }
        }

        System.out.println("" + string.charAt(index));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
    }
}
