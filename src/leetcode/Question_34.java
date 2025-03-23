package leetcode;

import java.util.Arrays;

/**
 * @author zpp
 */
public class Question_34 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(searchRange(new int[]{5, 7, 7, 8, 8, 10}, 8)));
        System.out.println(Arrays.toString(searchRange(new int[]{5, 7, 7, 8, 8, 10}, 6)));
        System.out.println(Arrays.toString(searchRange(new int[]{5, 7, 7, 8, 8, 10}, 5)));
    }

    public static int[] searchRange(int[] nums, int target) {

        if (nums == null || nums.length == 0) {
            return new int[]{-1, -1};
        }

        int[] ans = new int[2];
        ans[0] = findFirst(nums, target);
        ans[1] = findLast(nums, target);;
        return ans;
    }

    public static int findFirst(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;
        int pos = -1;

        int mid;
        while (left <= right) {
            mid = ((right - left) >> 1) + left;
            if (nums[mid] == target) {
                pos = mid;
                right = mid - 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return pos;
    }

    public static int findLast(int[] nums, int target) {

        int left = 0;
        int right = nums.length - 1;
        int pos = -1;

        int mid;
        while (left <= right) {
            mid = ((right - left) >> 1) + left;
            if (nums[mid] == target) {
                pos = mid;
                left = mid + 1;
            } else if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return pos;
    }

}
