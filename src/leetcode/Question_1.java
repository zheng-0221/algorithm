package leetcode;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zpp
 */
public class Question_1 {

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int gapIndex = target - nums[i];
            if (map.containsKey(gapIndex)) {
                return new int[]{map.get(gapIndex), i};
            }
            map.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }
}
