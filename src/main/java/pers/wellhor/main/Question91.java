package pers.wellhor.main;

/**
 * 91. 解码方法
 * <p>
 * 一条包含字母A-Z 的消息通过以下映射进行了 编码 ：
 * <p>
 * 'A' -> 1
 * 'B' -> 2
 * ...
 * 'Z' -> 26
 * 要 解码 已编码的消息，所有数字必须基于上述映射的方法，反向映射回字母（可能有多种方法）。例如，"11106" 可以映射为：
 * <p>
 * "AAJF" ，将消息分组为 (1 1 10 6)
 * "KJF" ，将消息分组为 (11 10 6)
 * 注意，消息不能分组为 (1 11 06) ，因为 "06" 不能映射为 "F" ，这是由于 "6" 和 "06" 在映射中并不等价。
 * <p>
 * 给你一个只含数字的 非空 字符串 s ，请计算并返回 解码 方法的 总数 。
 * <p>
 * 题目数据保证答案肯定是一个 32 位 的整数。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s = "12"
 * 输出：2
 * 解释：它可以解码为 "AB"（1 2）或者 "L"（12）。
 * 示例 2：
 * <p>
 * 输入：s = "226"
 * 输出：3
 * 解释：它可以解码为 "BZ" (2 26), "VF" (22 6), 或者 "BBF" (2 2 6) 。
 * 示例 3：
 * <p>
 * 输入：s = "0"
 * 输出：0
 * 解释：没有字符映射到以 0 开头的数字。
 * 含有 0 的有效映射是 'J' -> "10" 和 'T'-> "20" 。
 * 由于没有字符，因此没有有效的方法对此进行解码，因为所有数字都需要映射。
 * 示例 4：
 * <p>
 * 输入：s = "06"
 * 输出：0
 * 解释："06" 不能映射到 "F" ，因为字符串含有前导 0（"6" 和 "06" 在映射中并不等价）。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 1 <= s.length <= 100
 * s 只包含数字，并且可能包含前导零。
 *
 * @author wellhor Zhao
 * @version 1.0
 * @date 2021/4/21 9:45 上午
 **/
public class Question91 {

    private final static char ZERO = '0';
    private final static char ONE = '1';
    private final static char TWO = '2';
    private final static char SIX = '6';

    public static void main(String[] args) {
        System.out.println(new Question91().numDecodings("12"));
    }

    public int numDecodings(String s) {
        int length = s.length();
        int[] count = new int[length];
        char[] chars = s.toCharArray();

        if(length == 0) {
            return 0;
        } else {
            char firstChar = chars[0];
            if(ZERO != firstChar) {
                count[0] = 1;
            } else {
                return 0;
            }
        }

        if(length > 1) {
            if(chars[1] != ZERO) {
                count[1]++;
            }
            if(chars[0] == ONE || (chars[0] == TWO && chars[1] <= SIX)) {
                count[1]++;
            }
            for (int i = 2; i < length; i++) {
                char c = chars[i];
                char lastC = chars[i - 1];
                if(c != ZERO) {
                    count[i] += count[i - 1];
                }
                if(lastC == ONE || (lastC == TWO && c <= SIX)) {
                    count[i] += count[i - 2];
                }
            }
        }
        return count[length - 1];
    }

}
