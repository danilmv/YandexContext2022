package intern_1;

import java.util.Scanner;

public class delivery {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int s = scanner.nextInt();
        int n = scanner.nextInt();
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int a = 0;
        for (int i = 0; i < n; i++) {
            a = scanner.nextInt();
            if (min >= a) min = a;
            if (max <= a) max = a;
        }

        if (min == max) {
            a = Math.abs(min - s);
        } else if (min < s && max < s) {
            a = Math.abs(min - s);
        } else if (min < s) {
            max = Math.abs(max - s);
            min = Math.abs(min - s);
            if (max > min)
                a = max + 2 * min;
            else
                a = min + 2 * max;
        } else if (max >= s) {
            a = Math.abs(max - s);
        }

        System.out.println(a);
    }
}

