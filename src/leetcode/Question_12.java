package leetcode;

/**
 * @author zpp
 */
public class Question_12 {

    public static void main(String[] args) {
        System.out.println(intToRoman(1994));
    }

    public static String intToRoman(int num) {

        // 根据题目 num 的范围，定义数字到字母的映射表
        String[][] c = {
                {"", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX"}, // 个位 0 ~ 9
                {"", "X", "XX", "XXX", "XL", "L", "LX", "LXX", "LXXX", "XC"}, // 十位 0 ~ 9
                {"", "C", "CC", "CCC", "CD", "D", "DC", "DCC", "DCCC", "CM"}, // 百位 0 ~ 9
                {"", "M", "MM", "MMM"} // 千位 0 ~ 3
        };

        return "" +
                c[3][num / 1000] +
                c[2][num / 100 % 10] +
                c[1][num / 10 % 10] +
                c[0][num % 10];
    }

}
