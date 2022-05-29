package task3;


import java.util.Scanner;

public class market {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.valueOf(scanner.nextLine());
        long income = 0;
        int buy = -1;
        int pred = 0;
        boolean sold = false;

        for (int i = 0; i < n; i++) {
            int price = scanner.nextInt();
            if (pred > price) {
                income += pred - buy;
                sold = true;
                buy = -1;
            }
            if (buy == -1 || buy > price) {
                buy = price;
                sold = false;
            }

            pred = price;
        }
        if (!sold) income += pred - buy;

        System.out.printf("" + income);
    }
}
