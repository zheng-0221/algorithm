package leetcode;

/**
 * @author zpp
 */
public class Question_14 {
    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"flower", "flow", "flight"}));
        System.out.println(longestCommonPrefix(new String[]{"cir", "car"}));
    }

    public static String longestCommonPrefix(String[] strs) {
        if (strs == null) {
            return "";
        }

        char[] sample = strs[0].toCharArray();
        int rear = 0;
        for (int i = 0; i < sample.length; i++) {

            for (int j = 1; j < strs.length; j++) {

                char[] correspondence = strs[j].toCharArray();

                if (i == correspondence.length || sample[i] != correspondence[i]) {
                    return rear == 0 ? "" : strs[0].substring(0, rear);
                }

            }
            rear++;
        }
        return rear == 0 ? "" : strs[0].substring(0, rear);
    }

}
