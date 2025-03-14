package leetcode;

import java.util.Arrays;

/**
 * @author zpp
 */
public class Question_8 {
    public static void main(String[] args) {
//        System.out.println(myAtoi("42"));
//        System.out.println(myAtoi("1337c0d3"));
//        System.out.println(myAtoi("   -042"));
//        System.out.println(myAtoi("words and 987"));
        System.out.println(myAtoi("0-1"));
    }

    public static int myAtoi(String s) {
        if (s == null || s.equals("")) {
            return 0;
        }

        char[] str = removeHeadZero(s.trim()).toCharArray();
        if (str.length == 0) {
            return 0;
        }

        int ans = 0;

        if (!isValid(str)) {
            return 0;
        }
        boolean isNegative = str[0] == '-';
        int minD = Integer.MIN_VALUE / 10;
        int minM = Integer.MIN_VALUE % 10;
        int cur;
        for (int i = (str[0] == '-' || str[0] == '+') ? 1 : 0; i < str.length; i++) {
            cur = '0' - str[i];

            // 溢出处理
            if (ans < minD || (ans == minD && cur < minM)) {
                return isNegative ? Integer.MIN_VALUE : Integer.MAX_VALUE;
            }

            ans = ans * 10 + cur;
        }

        if (!isNegative && ans == Integer.MIN_VALUE) {
            return Integer.MAX_VALUE;
        }

        return isNegative ? ans : -ans;
    }

    public static String removeHeadZero(String str) {
        boolean existSign = str.startsWith("-") || str.startsWith("+");

        // start 记录 str 非正负号的一个不是数字 0 的位置
        int start = existSign ? 1 : 0;
        while (start < str.length()) {
            if (str.charAt(start) != '0') {
                break;
            }
            start++;
        }

        // end 记录第一个非数字字符的位置
        int end = -1;
        for (int i = str.length() - 1; i >= (existSign ? 1 : 0); i--) {
            if (str.charAt(i) < '0' || str.charAt(i) > '9') {
                end = i;
            }
        }


        return (existSign ? str.charAt(0) : "") + str.substring(start, (end == -1 ? str.length() : end));
    }

    public static boolean isValid(char[] str) {
        if (str[0] != '-' && str[0] != '+' && (str[0] < '0' || str[0] > '9')) {
            return false;
        }

        if ((str[0] == '-' || str[0] == '+') && str.length == 1) {
            return false;
        }

        for (int i = 1; i < str.length; i++) {
            if (str[i] < '0' || str[i] > '9') {
                return false;
            }
        }

        return true;
    }

}
