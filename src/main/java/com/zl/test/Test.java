package com.zl.test;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class Test {
    public static void main(String[] args) {
//        Son son = new Son();
//        Baba b = son;
//        System.out.println(b.s);
//        System.out.println(son.m);
        int[] arr = new int[10];
        arr[2] = 2;
        arr[3] = 3;
        arr[0] = 0;
        Arrays.stream(arr).forEach(System.out::println);
    }
}
