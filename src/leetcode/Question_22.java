package leetcode;

import java.util.LinkedList;
import java.util.List;

/**
 * @author zpp
 */
public class Question_22 {

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3));
    }

    public static List<String> generateParenthesis(int n) {

        char[] path = new char[n << 1];
        List<String> ans = new LinkedList<>();

        process(path, 0, 0, 0, n, ans);

        return ans;
    }

    public static void process(char[] path, int index, int leftP, int rightP, int n, List<String> ans) {
        if (index == n << 1) {
            ans.add(new String(path));
            return;
        }

        if (leftP < n) {
            path[index] = '(';
            process(path, index + 1, leftP + 1, rightP, n, ans);
        }

        if (leftP > rightP) {
            path[index] = ')';
            process(path, index + 1, leftP, rightP + 1, n, ans);
        }
    }

}
