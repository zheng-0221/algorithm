package leetcode;

import java.util.Arrays;

/**
 * @author zpp
 */
public class Question_26 {
    public static void main(String[] args) {
//        int[] arr = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int[] arr = {1, 1, 2};
        System.out.println(removeDuplicates(arr));
        System.out.println(Arrays.toString(arr));
    }

    public static int removeDuplicates(int[] nums) {

        int index = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[index] != nums[i]) {
                nums[++index] = nums[i];
            }
        }

        return index + 1;
    }

}
