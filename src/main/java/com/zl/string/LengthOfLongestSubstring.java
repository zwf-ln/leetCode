package com.zl.string;

import java.util.HashSet;
import java.util.Set;

//找出不重复的最常子串
public class LengthOfLongestSubstring {

    public static void main(String[] args) {
        String s = "abbbbb";
        System.out.println(lengthOfLongestSubstring(s));
    }

    /**
     * 使用滑动窗口
     * 将不重复的字符存入到set集合中，
     *  遇到重复的字符时，从左边开始删除元素，知道剩下无重复的字符
     *  继续往后移动，移动的过程中，记录下无重复字符的最大值。
     * @param s
     * @return
     */
    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        Set<Character> set = new HashSet<>();
        int max = 0;
        int r = 0, l = 0;
        for (; r < s.length();) {
            if (!set.contains(s.charAt(r))) {
                set.add(s.charAt(r));
                r++;
                max = Math.max(max, r - l);
            } else {
                set.remove(s.charAt(l++));
            }
        }
        return max;
    }
}
