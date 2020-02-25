package com.zl.string;

import java.util.Stack;

//括号匹配
public class IsValid {
    public static void main(String[] args) {
        //System.out.println(isValid1("()[]{}"));
    }
    public static boolean isValid(String s) {
        if (s == null || "".equals(s)) {
            return true;
        }
        if ((s.length() & 1) == 1) {
            return false;
        }
        char[] chars = s.toCharArray();
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            if (ch == '{' || ch == '(' || ch == '[') {
                stack.push(ch);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                if (ch == ')' && stack.pop() != '(') {
                    return false;
                }
                if (ch == ']' && stack.pop() != '[') {
                    return false;
                }
                if (ch == '}' && stack.pop() != '{') {
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
    //可以使用数组来替代栈;
    public static boolean isValid1(String s) {
        if (s == null || "".equals(s)) {
            return true;
        }
        if ((s.length() & 1) == 1) {
            return false;
        }
        char[] chars = s.toCharArray();
        char[] res = new char[chars.length / 2 + 1];
        int index = 0;
        for (int i = 0; i < chars.length; i++) {
            char ch = chars[i];
            if (ch == '(') res[index++] = ')';
            else if (ch == '[') res[index++] = ']';
            else if (ch == '{') res[index++] = '}';
            else if (--index < 0 || res[index] != ch || index > chars.length / 2) {
                return false;
            }
        }
        return index == 0;
    }
}
