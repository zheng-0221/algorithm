package question;

/**
 * @author zpp
 * @version 1.0
 * @description
 */
public class Question_1 {

    // 定长绳子覆盖最多的点数
    // 给定一个有序数组arr，代表坐落在X轴上的点，给定一个正数K，代表绳子长度，返回绳子最多压中几个点，绳子边缘处盖住绳子也算盖住。
    public int solution(int[] arr, int k) {

        // 记录结果
        int ans = 0;

        // 样本具有单调性，用滑动窗口法
        int left = 0;
        int right = 0;

        while (left < arr.length) {

            // 从当前 left 位置往右扩 k 距离
            while (right < arr.length && arr[right] - arr[left] <= k) {
                right++;
            }

            // 如果往右扩不动，记录此时覆盖的点数，左边界向右推一格，继续右扩
            ans = Math.max(ans, right - left);
            left++;
        }

        return ans;
    }
}
