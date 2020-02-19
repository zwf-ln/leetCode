package com.zl.test;

public class Test {
    public static void main(String[] args) {
        Son son = new Son();
        Baba b = son;
        System.out.println(b.s);
        System.out.println(son.m);
    }
}
