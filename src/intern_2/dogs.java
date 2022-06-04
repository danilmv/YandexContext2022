package intern_2;

import java.util.Scanner;

public class dogs {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());
        int[] a = new int[n];
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }
        for (int i = 0; i < n; i++) {
            b[i] = scanner.nextInt();
        }
        int min_start = -1;
        long min_value = Long.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            long value = 0;
            for (int j = 0; j < n; j++) {
                value += satisfaction(a[(i + j) % n], b[j]);
            }
            if (value < min_value) {
                min_start = i + 1;
                min_value = value;
            }
        }

        System.out.println(min_start + " " + min_value);
    }

    public static int satisfaction(int a, int b) {
        int dif = b - a;
        if (dif <= 0) return 0;
        return dif > 100 ? 30 : (dif) / 2;
    }
}
