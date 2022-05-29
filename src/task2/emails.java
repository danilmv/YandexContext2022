package task2;

import java.io.*;
import java.util.HashSet;
import java.util.Scanner;

public class emails {
    public static void main(String[] args) {
//        try (FileInputStream fis = new FileInputStream(new File("input.txt"))) {

        Scanner scanner = new Scanner(System.in);//new Scanner(fis); //
        HashSet<String> logins = new HashSet();

        int n = Integer.valueOf(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String email = scanner.nextLine();
            String[] parts = email.split("@");
            String login = parts[0].replace(".", "");
            if (login.contains("-")) {
                String[] subLogin = login.split("-");
                login = subLogin[0];
            }
            parts = parts[1].split("\\.");
            StringBuilder sb = new StringBuilder();
            for (int j = 0; j < parts.length - 1; j++) {
                sb.append(parts[j]);
                sb.append("\\.");
            }
            logins.add(login + "@" + sb);
        }
        System.out.println(logins.size());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

    }
}
