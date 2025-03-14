package leetcode;

import javax.jws.Oneway;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author zpp
 */
public class Question_15 {

    public static void main(String[] args) {
        System.out.println(threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }

    public static List<List<Integer>> threeSum(int[] nums) {
        if (nums == null || nums.length < 3) {
            return new LinkedList<>();
        }

        List<List<Integer>> ans = new LinkedList<>();

        Arrays.sort(nums);

        for (int i = 0; i < nums.length - 2; i++) {

            // 注意去重
            if (i == 0 || nums[i] != nums[i - 1]) {
                List<List<Integer>> twoSums = twoSum(nums, i + 1, -nums[i]);
                for (List<Integer> aThree : twoSums) {
                    aThree.add(0, nums[i]);
                    ans.add(aThree);
                }
            }
        }

        return ans;
    }

    // 两和问题
    // nums 已经有序，在 nums[begin...] 上找累加和为 target 的二元组
    public static List<List<Integer>> twoSum(int[] nums, int begin, int target) {
        List<List<Integer>> ans = new LinkedList<>();

        int left = begin;
        int right = nums.length - 1;
        while (left < right) {
            int curSum = nums[left] + nums[right];
            if (curSum < target) {
                left++;
            } else if (curSum > target) {
                right--;
            } else {

                // 如果当前二元组满足条件，那么需要去重
                // 如果 left 不在开始位置，或者 left 与左边不等，则不需要去重
                if (left == begin || nums[left] != nums[left - 1]) {
                    List<Integer> aTwo = new LinkedList<>();
                    aTwo.add(nums[left]);
                    aTwo.add(nums[right]);
                    ans.add(aTwo);
                }
                left++;
            }
        }

        return ans;
    }

}
