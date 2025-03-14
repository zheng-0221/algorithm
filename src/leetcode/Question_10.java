package leetcode;

/**
 * @author zpp
 */
public class Question_10 {
    public static void main(String[] args) {
        System.out.println(isMatch("ab", ".*"));
    }


    /**
     * 递归方法 + 记忆化搜索（缓存数组）
     */
    public static boolean isMatch(String s, String p) {
        char[] str = s.toCharArray();
        char[] pattern = p.toCharArray();

        int[][] dp = new int[s.length() + 1][p.length() + 1];

        // 初始化 dp ，-1 代表未被处理过
        for (int i = 0; i <= s.length(); i++) {
            for (int j = 0; j <= p.length(); j++) {
                dp[i][j] = -1;
            }
        }

        return isValid(str, pattern) && process(str, pattern, 0, 0, dp);
    }

    // 有效性检查，保证 str 中没有 . 和 * ，以及 pattern 中没有连续的 *
    public static boolean isValid(char[] str, char[] pattern) {
        for (char c : str) {
            if (c == '.' || c == '*') {
                return false;
            }
        }

        for (int i = 0; i < pattern.length; i++) {
            if (pattern[i] == '*' && (i == 0 || pattern[i - 1] == '*')) {
                return false;
            }
        }

        return true;
    }

    // str[si...] 能否匹配 pattern[pi...]
    // 加缓存 dp ，-1 表示没缓存，1 表示 true ，0 表示 false
    public static boolean process(char[] str, char[] pattern, int si, int pi, int[][] dp) {

        // 先看缓存
        if (dp[si][pi] != -1) {
            return dp[si][pi] == 1;
        }

        // base case 1
        // 当 si 来到 str 终止位置，pattern 只能匹配空串，两种情况
        if (si == str.length) {

            // 1. 当 pattern 也来到终止位置
            if (pi == pattern.length) {
                dp[si][pi] = 1;
                return true;
            }

            // 2. pi + 1 没有越界且为 * ，还要保证 pi + 2 往后的位置能匹配空串
            if (pi + 1 < pattern.length && pattern[pi + 1] == '*') {
                boolean cur = process(str, pattern, si, pi + 2, dp);
                dp[si][pi] = cur ? 1 : 0;
                return cur;
            }

            // 否则匹配失败
            dp[si][pi] = 0;
            return false;
        }

        // base case 2
        // base case 1 不成立，即当 pi 来到 pattern 终止位置，无法匹配
        if (pi == pattern.length) {
            dp[si][pi] = 0;
            return false;
        }

        // si 和 pi 都没有终止

        // 如果 pi + 1 不是 * 或越界
        if (pi + 1 >= pattern.length || pattern[pi + 1] != '*') {
            boolean cur = (str[si] == pattern[pi] || pattern[pi] == '.') && process(str, pattern, si + 1, pi + 1, dp);
            dp[si][pi] = cur ? 1 : 0;
            return cur;
        }

        // 如果 pi + 1 是 * ，str[si] 无法匹配 pattern[pi]
        if (pattern[pi] != '.' && str[si] != pattern[pi]) {
            boolean cur = process(str, pattern, si, pi + 2, dp);
            dp[si][pi] = cur ? 1 : 0;
            return cur;
        }

        // 如果 pi + 1 是 * ，str[si] 能匹配 pattern[pi]
        if (process(str, pattern, si, pi + 2, dp)) { // pi + 1 的这个 * 匹配零个字符
            dp[si][pi] = 1;
            return true;
        }
        while (si < str.length && (str[si] == pattern[pi] || pattern[pi] == '.')) { // pi + 1 的这个 * 开始匹配能匹配的字符

            // 跳过 * 向后匹配
            if (process(str, pattern, si + 1, pi + 2, dp)) {
                dp[si][pi] = 1;
                return true;
            }

            // 继续匹配这个 * 能匹配的字符
            si++;
        }

        // 所有正确结果讨论完毕，则返回 false
        dp[si][pi] = 0;
        return false;
    }
}
