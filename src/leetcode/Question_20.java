package leetcode;

/**
 * @author zpp
 */
public class Question_20 {

    public static void main(String[] args) {
        System.out.println(isValid("[[[[[[[[[[[[[[[[[[["));
    }

    public static boolean isValid(String s) {
        if (s == null || s.equals("")) {
            return true;
        }
        char[] str = s.toCharArray();

        char[] stack = new char[s.length()];
        int top = -1;

        for (char c : str) {
            if (c == '(' || c == '{' || c == '[') {
                stack[++top] = c;
            } else {
                if (top == -1) {
                    return false;
                } else {
                    if (
                            (c == ')' && stack[top--] != '(')
                            || (c == '}' && stack[top--] != '{')
                            || (c == ']' && stack[top--] != '[')
                    ) {
                        return false;
                    }
                }
            }
        }

        return top == -1;
    }

}
