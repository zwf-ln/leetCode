package com.zl.num;

//判断是否是回文数
// 121 是回文数  -121 不是回文数
public class Palindrome {

    public static void main(String[] args) {

    }

    /**
     * 可以考虑只翻转一半的数字, 然后和左边一半比较, 如果相等  说明是回文数
     * 终止条件, 翻转后的数字比左边一半要大,说明翻转的区域已经大于等于左边的区域
     *
     * @param x
     * @return
     */
    public static boolean isPalindrome(int x) {
        //如果是负数, 肯定不是回文数, 个位是0, 但不是0的肯定不是回文数
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }
        int reverse = 0;
        while (x > reverse) {
            reverse = reverse * 10 + x % 10;
            x /= 10;
        }
        //如果是奇位数,结果reverse > x,reverse会多出一位中位数, 中位数不影响回文数, 因此除去最后一位后比较
        //如果是偶位数,直接比较结果.
        return x == reverse ||x == reverse / 10;
    }
}
