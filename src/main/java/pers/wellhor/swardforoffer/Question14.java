package pers.wellhor.swardforoffer;

/**
 * 剑指 Offer 14- II. 剪绳子 II
 *
 * @author wellhor Zhao
 * @version 1.0
 * @date 2021/4/14 1:58 下午
 **/
public class Question14 {

    /**
     * 给你一根长度为 n 的绳子，请把绳子剪成整数长度的 m 段（m、n都是整数，n>1并且m>1），
     * 每段绳子的长度记为 k[0],k[1]...k[m - 1] 。请问 k[0]*k[1]*...*k[m - 1]
     * 可能的最大乘积是多少？
     * <p>
     * 例如，当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此时得到的最大乘积是18。
     * 答案需要取模 1e9+7（1000000007），如计算初始结果为：1000000008，请返回 1。
     * <p>
     * 示例 1：
     * 输入: 2
     * 输出: 1
     * 解释: 2 = 1 + 1, 1 × 1 = 1
     * <p>
     * 示例 2:
     * 输入: 10
     * 输出: 36
     * 解释: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36
     * <p>
     * 提示：
     * 2 <= n <= 1000
     *
     * @param n 总长度
     */
    private static int cuttingRope(int n) {
        if(n == 2) {
            return 1;
        } else if(n == 3) {
            return 2;
        } else {
            long result = 1;
            while (n > 4) {
                n = n - 3;
                result = (result * 3) % 1000000007;
            }
            return (int) ((result * n) % 1000000007);
        }
    }

    public static void main(String[] args) {
//        Question14.valid(2);
        Question14.valid(10);
        Question14.valid(36);
        Question14.valid(1000);
    }

    /**
     * 验证值是否正确
     *
     * @param length 长度
     */
    private static void valid(int length) {
        System.out.println("总长度:" + length);
        int max = Question14.cuttingRope(length);
        System.out.println("最大乘积:" + max);
        System.out.println();
    }

}
