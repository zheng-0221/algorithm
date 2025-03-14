package leetcode;


/**
 * @author zpp
 */
public class Question_3 {
    public static void main(String[] args) {
        int res = lengthOfLongestSubstring("au");
        System.out.println(res);
    }

    public static int lengthOfLongestSubstring(String s) {
        if (s == null || s.equals("")) {
            return 0;
        }
        int length = s.length();
        char[] str = s.toCharArray();

        // 结尾法 每个位置只需要前一个位置的信息，所以不需要 pre 数组，只需要一个前提变量 pre
        int pre = -1;
        int ans = 1;
        int[] lastPosition = new int[256];
        for (int i = 0; i < 256; i++) {
            lastPosition[i] = -1;
        }
        for (int i = 0; i < length; i++) {
            pre = Math.max(pre, lastPosition[str[i]]);
            int curLen = i - pre;
            ans = Math.max(ans, curLen);
            lastPosition[str[i]] = i;
        }
        return ans;
    }
}
