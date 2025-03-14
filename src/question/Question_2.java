package question;

/**
 * @author zpp
 * @version 1.0
 * @description
 */
public class Question_2 {

    // 括号有效配对是指:
    // 1)任何一个左括号都能找到和其正确配对的右括号
    // 2)任何一个右括号都能找到和其正确配对的左括号

    // 问题一
    // 怎么判断一个括号字符串有效?
    public boolean solution1(char[] s) {
        int length = s.length;

        // 有效性检查
        // 声明一个变量 count ，从左到右遍历字符串，遇到左括号 +1 ，遇到右括号 -1，
        // 如果过程中 count < 0，则无效，遍历结束 count != 0 也是无效
        int count = 0;
        for (int i = 0; i < length; i++) {
            count += s[i] == '(' ? 1 : -1;
            if (count < 0) {
                return false;
            }
        }

        return count == 0;
    }

    // 问题二：如果一个括号字符串无效，返回至少填几个字符能让其整体有效
    public int solution2(char[] s) {
        int length = s.length;

        // 同有效性检查类似，当 count < 0 也就是 count == -1 的时候，need++ ， count 重置
        int count = 0;
        int need = 0;
        for (int i = 0; i < length; i++) {
            count += s[i] == '(' ? 1 : -1;
            if (count < 0) {
                need++;
                count = 0;
            }
        }

        // 最后得到的 count + need 是实际最少需要的字符数
        return count + need;
    }

    // 问题三：返回一个括号字符串中，最长的括号有效子串的长度
    public int solution3(char[] s) {
        int length = s.length;
        int ans = 0;

        // 子数组问题，讨论开头结尾，运用动态规划的思想
        // 这里用结尾法
        int[] dp = new int[length];
        dp[0] = 0;
        for (int i = 1; i < length; i++) {

            // 如果当前位置是左括号，dp 直接为 0
            if (s[i] == '(') {
                dp[i] = 0;
            } else {

                // 如果是右括号，看 dp[i - 1] 的有效串的前一个位置
                int pre = i - dp[i - 1] - 1;
                if (pre >= 0 && s[pre] == '(') {
                    dp[i] = dp[i - 1] + 2 + (pre > 0 ? dp[pre - 1] : 0);
                }
            }

            ans = Math.max(ans, dp[i]);
        }

        return ans;
    }
}
