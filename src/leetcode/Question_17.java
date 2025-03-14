package leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author zpp
 */
public class Question_17 {

    public static void main(String[] args) {
        System.out.println(letterCombinations("23"));
    }

    public static char[][] keys = {
            {'a', 'b', 'c'},
            {'d', 'e', 'f'},
            {'g', 'h', 'i'},
            {'j', 'k', 'l'},
            {'m', 'n', 'o'},
            {'p', 'q', 'r', 's'},
            {'t', 'u', 'v'},
            {'w', 'x', 'y', 'z'}
    };

    public static List<String> letterCombinations(String digits) {
        List<String> ans = new LinkedList<>();

        if (digits == null || digits.equals("")) {
            return ans;
        }

        char[] nums = digits.toCharArray();

        process(nums, 0, new char[digits.length()], ans);

        return ans;
    }

    public static void process(char[] digits, int index, char[] path, List<String> ans) {
        if (index == digits.length) {
            ans.add(String.valueOf(path));
        } else {
            char[] chars = keys[digits[index] - '2'];
            for (int i = 0; i < chars.length; i++) {
                path[index] = chars[i];
                process(digits, index + 1, path, ans);
            }
        }

    }

}
