package leetcode;

/**
 * @author zpp
 */
public class Question_13 {

    public static void main(String[] args) {
        System.out.println(romanToInt("III"));
        System.out.println(romanToInt("LVIII"));
        System.out.println(romanToInt("MCMXCIV"));
    }

    public static int romanToInt(String s) {
        if (s == null || s.equals("")) {
            return 0;
        }

        char[] str = s.toCharArray();
        int[] nums = new int[str.length];
        for (int i = 0; i < str.length; i++) {
            switch (str[i]) {
                case 'I':
                    nums[i] = 1;
                    break;
                case 'V':
                    nums[i] = 5;
                    break;
                case 'X':
                    nums[i] = 10;
                    break;
                case 'L':
                    nums[i] = 50;
                    break;
                case 'C':
                    nums[i] = 100;
                    break;
                case 'D':
                    nums[i] = 500;
                    break;
                case 'M':
                    nums[i] = 1000;
                    break;
            }
        }

        int ans = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] < nums[i + 1]) {
                ans -= nums[i];
            } else {
                ans += nums[i];
            }
        }

        return ans + nums[nums.length - 1];
    }

}
