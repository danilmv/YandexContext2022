package task2;

import java.io.*;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class emails2 {
    public static void main(String[] args) {
//        try (FileInputStream fis = new FileInputStream(new File("input.txt"))) {

        Scanner scanner = new Scanner(System.in);//new Scanner(fis); //
        Set<String> logins = new HashSet<>( 150000, 0.75f);

        int n = Integer.valueOf(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            int position = 0;
            boolean skip = false;
            char[] login = new char[50];
            char[] domain = new char[50];
            boolean isDomain = false;
            int numDots = 0;

            String email = scanner.nextLine();
            for (char symbol : email.toCharArray()) {
                if (symbol == '@') {
                    isDomain = true;
                    position = 0;
                }
                if (!isDomain) {
                    if (symbol == '-') skip = true;
                    if (skip || symbol == '.') continue;
                    login[position++] = symbol;
                } else {
                    if (symbol == '.') numDots++;
                    domain[position++] = symbol;
                }
            }
            for (int p = 0; p < domain.length; p++) {
                if (domain[p] == '.') numDots--;
                if (numDots < 1)
                    domain[p] = ' ';
            }
            logins.add(String.valueOf(login) + String.valueOf(domain));
        }
        System.out.println(logins.size());
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

    }
}
