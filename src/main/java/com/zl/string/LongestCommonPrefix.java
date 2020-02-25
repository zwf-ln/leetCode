package com.zl.string;

public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] strs = {"foak", "", "fo", "fk"};
        System.out.println(longestCommonPrefix3(strs));
    }


    public static String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        String str = strs[0];
        for (int i = 1; i < strs.length; i++) {
            int index = 0;
            int minLen = Math.min(strs[i].length(), str.length());
            while (index < minLen && (str.charAt(index) == strs[i].charAt(index))) {
                index++;
            }
            str = str.substring(0, index);
            if ("".equals(str)) {
                break;
            }
        }
        return str;
    }

    /**
     * 使用IndexOf水平扫描法
     *
     * @param strs
     * @return
     */
    public static String longestCommonPrefix1(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "f";
        }
        String str = strs[0];
        for (int i = 1; i < strs.length; i++) {
            //判断不包含当前字符串, 截取一部分字符串
            while (strs[i].indexOf(str) != 0) {
                //每次截取一个字符
                str = str.substring(0, str.length() - 1);
                if (str.isEmpty()) {
                    return "";
                }
            }
        }
        return str;
    }

    /**
     * 垂直扫描法, 遍历公共子串每一个字符, 查看数组中的每一个元素的当前位置是否包含当前字符
     *
     * @param strs
     * @return
     */
    public static String longestCommonPrefix2(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        for (int i = 0; i < strs[0].length(); i--) {
            char ch = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                //逐个字符, 从第一个字符开始比较, 直到不相等,即可返回
                if (i == strs[j].length() || strs[j].charAt(i) != ch) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }

    /**
     * 分治法, 将数组分为两组, 每组得到一个公共子串, 然后两组的公共字符,就是全组的公共字符
     *
     * @param strs
     * @return
     */
    public static String longestCommonPrefix3(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        /**
         * 边界问题, 是否包含尾边界,
         * 终止条件是 l == r, 应该取到数组中的每一个值,
         *
         */
        return longestCommonPrefix3(strs, 0, strs.length - 1);
    }

    private static String longestCommonPrefix3(String[] strs, int l, int r) {
        //如果只有一个元素, 公共前缀就是自己;
        if (l == r) {
            return strs[l];
        }
        int mid = l + (r - l) / 2;
        String leftPrefix = longestCommonPrefix3(strs, l, mid);
        String rightPrefix = longestCommonPrefix3(strs, mid + 1, r);
        return commonPrefix(leftPrefix, rightPrefix);
    }

    private static String commonPrefix(String leftPrefix, String rightPrefix) {
        int index = 0;
        int minLen = Math.min(leftPrefix.length(), rightPrefix.length());
        while (index < minLen && leftPrefix.charAt(index) == rightPrefix.charAt(index)) {
            index++;
        }
        return leftPrefix.substring(0, index);
    }

    /**
     * 使用二分法, 先获取最短的长度, 把最短字符当做公共的前缀, 进行二分匹配
     * @param strs
     * @return
     */
    public static String longestCommonPrefix4(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        int minLen = strs[0].length();
        //知道最短子串
        for (String s : strs) {
            minLen = Math.min(s.length(), minLen);
        }
        int l = 1;
        int r = minLen;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            if (isCommonPrefix(strs, mid)) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return strs[0].substring(0, (r + l) / 2);
    }

    private static boolean isCommonPrefix(String[] strs, int mid) {
        String str = strs[0].substring(0, mid);
        for (int i = 0; i < strs.length; i++) {
            if (!strs[i].startsWith(str)) {
                return false;
            }
        }
        return true;
    }
}
