package leetcode;

/**
 * @author zpp
 */
public class Question_7 {

    public static int reverse(int x) {

        // 把 x 转为负数，以便后续溢出情况的处理
        boolean isNegative = ((x >>> 31) & 1) == 1;
        x = isNegative ? x : -x;

        int m = Integer.MIN_VALUE / 10;
        int o = Integer.MIN_VALUE % 10;

        int ans = 0;
        while (x != 0) {

            // 溢出情况：ans = (ans * 10) + (x % 10) 的过程中 ans 溢出
            if (ans < m || (ans == m && x % 10 < o)) {
                return 0;
            }

            ans = (ans * 10) + (x % 10);
            x /= 10;
        }
        return isNegative ? ans : -ans;
    }

}
