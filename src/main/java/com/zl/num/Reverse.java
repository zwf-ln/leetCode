package com.zl.num;

import java.util.Random;

public class Reverse {
    public static void main(String[] args) {
        for (int i = 0; i < 100000; i++) {
            int num = getNum();
            if (reverse(num) == 0) {
                System.out.println(num);
            }
        }

    }

    public static int getNum() {
        double random = Math.random();
        return (int)(random * Integer.MIN_VALUE);
    }
    public static int reverse(int x) {
        int reverse = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (reverse > Integer.MAX_VALUE / 10 || (reverse == Integer.MAX_VALUE && pop > Integer.MAX_VALUE % 10))
                return 0;
            if (reverse < Integer.MIN_VALUE / 10 || (reverse == Integer.MAX_VALUE && pop < Integer.MIN_VALUE % 10))
                return 0;
            reverse = reverse * 10 + pop;
        }
        return reverse;
    }
    public static int reverse2(int x) {
        int reverse = 0;
        while (x != 0) {
            if ((reverse * 10) / 10 != reverse) {
                System.out.println(reverse);
                return 0;
            }
            reverse = reverse * 10 + x % 10;
            x /= 10;
        }
        return reverse;
    }
}
