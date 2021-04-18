package pers.wellhor.main;

import java.util.HashMap;
import java.util.Map;

/**
 * 87. 扰乱字符串
 * 使用下面描述的算法可以扰乱字符串 s 得到字符串 t ：
 * 如果字符串的长度为 1 ，算法停止
 * 如果字符串的长度 > 1 ，执行下述步骤：
 * 在一个随机下标处将字符串分割成两个非空的子字符串。即，如果已知字符串 s ，则可以将其分成两个子字符串 x 和 y ，且满足 s = x + y 。
 * 随机 决定是要「交换两个子字符串」还是要「保持这两个子字符串的顺序不变」。即，在执行这一步骤之后，s 可能是 s = x + y 或者 s = y + x 。
 * 在 x 和 y 这两个子字符串上继续从步骤 1 开始递归执行此算法。
 * 给你两个 长度相等 的字符串 s1 和s2，判断s2是否是s1的扰乱字符串。如果是，返回 true ；否则，返回 false 。
 * <p>
 * 示例 1：
 * <p>
 * 输入：s1 = "great", s2 = "rgeat"
 * 输出：true
 * 解释：s1 上可能发生的一种情形是：
 * "great" --> "gr/eat" // 在一个随机下标处分割得到两个子字符串
 * "gr/eat" --> "gr/eat" // 随机决定：「保持这两个子字符串的顺序不变」
 * "gr/eat" --> "g/r / e/at" // 在子字符串上递归执行此算法。两个子字符串分别在随机下标处进行一轮分割
 * "g/r / e/at" --> "r/g / e/at" // 随机决定：第一组「交换两个子字符串」，第二组「保持这两个子字符串的顺序不变」
 * "r/g / e/at" --> "r/g / e/ a/t" // 继续递归执行此算法，将 "at" 分割得到 "a/t"
 * "r/g / e/ a/t" --> "r/g / e/ a/t" // 随机决定：「保持这两个子字符串的顺序不变」
 * 算法终止，结果字符串和 s2 相同，都是 "rgeat"
 * 这是一种能够扰乱 s1 得到 s2 的情形，可以认为 s2 是 s1 的扰乱字符串，返回 true
 * 示例 2：
 * <p>
 * 输入：s1 = "abcde", s2 = "caebd"
 * 输出：false
 * 示例 3：
 * <p>
 * 输入：s1 = "a", s2 = "a"
 * 输出：true
 * <p>
 * <p>
 * 提示：
 * <p>
 * s1.length == s2.length
 * 1 <= s1.length <= 30
 * s1 和 s2 由小写英文字母组成
 *
 * @author wellhor Zhao
 * @version 1.0
 * @date 2021/4/16 10:11 上午
 **/
public class Question87 {

    public static void main(String[] args) {
//        System.out.println(new Question87().isScramble("abcde","caebd"));
//        System.out.println(new Question87().isScramble("a","a"));
//        System.out.println(new Question87().isScramble("great","rgeat"));
        System.out.println(new Question87().isScramble("eebaacbcbcadaaedceaaacadccd", "eadcaacabaddaceacbceaabeccd"));
    }

    /**
     * @param s1 字符串1
     * @param s2 字符串2
     * @return 是否为扰乱字符串
     */
    public boolean isScramble(String s1, String s2) {
        if(s1.length() != s2.length()) {
            return false;
        } else if(s1.equals(s2)) {
            return true;
        } else {
            int[][][] momo = new int[s1.length()][s1.length()][s1.length() + 1];
            return dfs(momo, 0, 0, s1, s2, s1.length());
        }
    }

    /**
     * f(s1, s2) = f(s1(0, i), s2(0, i)) & f(s1(i, n), s2(0, n))   .....  1
     * f(s1, s2) = f(s1(0, i), s2(n - i, n)) & f(s1(i, n), s2(0, n-i)) ..... 2
     * 1 | 2
     * 动态规划判断是否满足要求
     *
     * @param momo   记忆数组 0 未知 1 子串是扰乱字符串 -1 子串不是扰乱字符串
     * @param i      第一个数组的开始位置 截取length长度
     * @param j      第二个数组的开始位置 截取length长度
     * @param s1     字符1
     * @param s2     字符2
     * @param length 长度
     * @return 是否满足
     */
    private boolean dfs(int[][][] momo, int i, int j, String s1, String s2, int length) {
        if(momo[i][j][length] != 0) {
            return momo[i][j][length] == 1;
        }

        if(isSame(s1, s2, i, j, length)) {
            momo[i][j][length] = 1;
            return true;
        }

        if(!checkCharacter(s1, s2, i, j, length)) {
            momo[i][j][length] = -1;
            return false;
        }

        for (int k = 1; k < length; k++) {
            // 不交换 f(s1, s2) = f(s1(0, k), s2(0, k)) & f(s1(i, n-k), s2(i, n-k))
            if(dfs(momo, i, j, s1, s2, k) && dfs(momo, i + k, j + k, s1, s2, length - k)) {
                momo[i][j][length] = 1;
                return true;
            }

            // 交换 f(s1, s2) = f(s1(0, k), s2(n - k, k)) & f(s1(k, n), s2(0, n-k))
            if(dfs(momo, i, j + length - k, s1, s2, k) && dfs(momo, i + k, j, s1, s2, length - k)) {
                momo[i][j][length] = 1;
                return true;
            }
        }

        momo[i][j][length] = -1;
        return false;
    }

    /**
     * 检查字符个数
     *
     * @param s1     字符串1
     * @param s2     字符串2
     * @param i      字符串1子串起点
     * @param j      字符串2子串起点
     * @param length 子串长度
     * @return 是否字符个数一致
     */
    private boolean checkCharacter(String s1, String s2, int i, int j, int length) {
        Map<Character, Integer> characterIntegerMap = new HashMap<>();
        for (int k = 0; k < i + length; k++) {
            char c = s1.charAt(k);
            characterIntegerMap.put(c, characterIntegerMap.getOrDefault(c, 0) + 1);
        }
        for (int k = 0; k < j + length; k++) {
            char c = s2.charAt(k);
            characterIntegerMap.put(c, characterIntegerMap.getOrDefault(c, 0) - 1);
        }
        for (Character c : characterIntegerMap.keySet()) {
            Integer count = characterIntegerMap.get(c);
            if(count != 0) {
                return false;
            }
        }
        return true;
    }

    private boolean isSame(String s1, String s2, int i, int j, int length) {
        for (int k = 0; k < length; k++) {
            char c1 = s1.charAt(k + i);
            char c2 = s2.charAt(k + j);
            if(c1 != c2) {
                return false;
            }
        }
        return true;
    }

}
