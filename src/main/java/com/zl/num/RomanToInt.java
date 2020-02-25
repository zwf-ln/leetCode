package com.zl.num;

import java.util.HashMap;
import java.util.Map;

public class RomanToInt {
    public static void main(String[] args) {
        System.out.println((0 - 1) / 2);
//        System.out.println(romanToInt("IV"));
    }

    public static int romanToInt(String s) {
        if (s == null || " ".equals(s)) {
            return 0;
        }
        int res = 0;
        int end = s.length() - 1;
        Map<Character, Integer> map = new HashMap<>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        while (end > 0) {
            char cur = s.charAt(end);
            char pre = s.charAt(end - 1);
            int curVal = map.get(cur);
            int preVal = map.get(pre);
            if ((curVal / preVal == 10 || curVal / preVal == 5) && (preVal % 10 == 0 || preVal == 1)) {
                res += (curVal - preVal);
                end -= 2;
            } else {
                res += curVal;
                end--;
            }
        }
        if (end == 0) {
            res += map.get(s.charAt(0));
        }
        return res;
    }
}
