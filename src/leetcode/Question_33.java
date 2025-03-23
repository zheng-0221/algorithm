package leetcode;

/**
 * @author zpp
 */
public class Question_33 {
    public static void main(String[] args) {

        // eg: nums = [4,5,6,7,0,1,2], target = 0
        System.out.println(search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
        System.out.println(search(new int[]{4, 5, 6, 7, 0, 1, 2}, 1));
        System.out.println(search(new int[]{4, 5, 6, 7, 0, 1, 2}, 2));
        System.out.println(search(new int[]{4, 5, 6, 7, 0, 1, 2}, 3));
        System.out.println(search(new int[]{4, 5, 6, 7, 0, 1, 2}, 4));
        System.out.println(search(new int[]{4, 5, 6, 7, 0, 1, 2}, 5));
        System.out.println(search(new int[]{4, 5, 6, 7, 0, 1, 2}, 6));
        System.out.println(search(new int[]{4, 5, 6, 7, 0, 1, 2}, 7));
    }

    public static int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int mid;

        // 二分
        while (left <= right) {
            mid = (left + right) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            if (nums[left] > nums[mid]) {

                // 此时 mid 右侧有序
                if (nums[mid] < target && nums[right] >= target) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            } else {

                // 此时 mid 左侧有序
                if (nums[mid] > target && nums[left] <= target) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
            }
        }

        return -1;
    }

}
