package pers.wellhor.swardforoffer;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 剑指 Offer 15. 二进制中1的个数
 * <p>
 * 请实现一个函数，输入一个整数（以二进制串形式），输出该数二进制表示中 1 的个数。例如，把 9  表示成二进制是 1001，有 2 位是 1。因此，如果输入 9，则该函数输出 2。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：00000000000000000000000000001011
 * 输出：3
 * 解释：输入的二进制串 00000000000000000000000000001011  中，共有三位为 '1'。
 * 示例 2：
 * <p>
 * 输入：00000000000000000000000010000000
 * 输出：1
 * 解释：输入的二进制串 00000000000000000000000010000000  中，共有一位为 '1'。
 * 示例 3：
 * <p>
 * 输入：11111111111111111111111111111101
 * 输出：31
 * 解释：输入的二进制串 11111111111111111111111111111101 中，共有 31 位为 '1'。
 * <p>
 * <p>
 * 提示：
 * <p>
 * 输入必须是长度为 32 的 二进制串 。
 *
 * @author wellhor Zhao
 * @version 1.0
 * @date 2021/4/18 12:28 上午
 **/
public class Question15 {

    private final static Pattern PATTERN = Pattern.compile("1");

    public static void main(String[] args) {
        System.out.println(new Question15().hammingWeight(10));
        System.out.println(new Question15().hammingWeight(200));
    }

    public int hammingWeight(int n) {
        String binaryString = Integer.toBinaryString(n);
        int count = 0;
        Matcher matcher = PATTERN.matcher(binaryString);
        while (matcher.find()) {
            ++count;
        }
        return count;
    }


}
