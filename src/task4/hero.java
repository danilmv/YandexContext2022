package task4;

import java.util.Scanner;

public class hero {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.valueOf(scanner.nextLine());
        int numZ = 0;
        int numP = 0;
        int numN = 0;
        int minP = 0;
        int maxP = 0;
        int minN = 0;
        int maxN = 0;
        for (int i = 0; i < n; i++) {
            int value = scanner.nextInt();
            if (value == 0) {
                numZ++;
            } else if (value > 0) {
                numP++;
                if (minP > value || minP == 0) minP = value;
                if (maxP < value || maxP == 0) maxP = value;
            } else {
                numN++;
                if (minN > value || minN == 0) minN = value;
                if (maxN < value || maxN == 0) maxN = value;
            }
        }

        if (numN == n) {
            if (numN % 2 == 0)
                System.out.println(minN);
            else
                System.out.println(maxN);
        } else if (numZ > 0) {
            if (numN % 2 == 0)
                System.out.println("0");
            else
                System.out.println(minN);
        } else if (numN > 0) {
            if (numN % 2 == 0)
                System.out.println(minP);
            else
                System.out.println(maxN);
        } else
            System.out.println(minP);
    }
}
