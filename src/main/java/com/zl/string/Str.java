package com.zl.string;

public class Str {
    public static void main(String[] args) {
        int i = strStr("mississippi", "issip");
        System.out.println(i);
    }
    public static int strStr(String haystack, String needle) {
        if ("".equals(needle)) {
            return 0;
        }
        if (needle.length() > haystack.length()) {
            return -1;
        }
        for (int j = 0; j <= haystack.length() - needle.length(); ++j) {
            int i = 0;
            while (i < needle.length()) {
                if (haystack.charAt(j + i) != needle.charAt(i))
                    break;
                ++i;
            }
            if (i == needle.length()) {
                return j;
            }
        }
        return -1;
    }
}
