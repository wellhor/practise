package pers.wellhor.main;

import java.util.Arrays;

/**
 * 1433. 检查一个字符串是否可以打破另一个字符串
 * 给你两个字符串  s1  和  s2  ，它们长度相等，请你检查是否存在一个  s1   的排列可以打破 s2  的一个排列，或者是否存在一个  s2  的排列可以打破 s1 的一个排列。
 * <p>
 * 字符串  x  可以打破字符串  y  （两者长度都为  n  ）需满足对于所有  i（在  0  到  n - 1  之间）都有  x[i] >= y[i]（字典序意义下的顺序）。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：s1 = "abc", s2 = "xya"
 * 输出：true
 * 解释："ayx" 是 s2="xya" 的一个排列，"abc" 是字符串 s1="abc" 的一个排列，且 "ayx" 可以打破 "abc" 。
 * 示例 2：
 * <p>
 * 输入：s1 = "abe", s2 = "acd"
 * 输出：false
 * 解释：s1="abe" 的所有排列包括："abe"，"aeb"，"bae"，"bea"，"eab" 和 "eba" ，s2="acd" 的所有排列包括："acd"，"adc"，"cad"，"cda"，"dac" 和 "dca"。然而没有任何 s1 的排列可以打破 s2 的排列。也没有 s2 的排列能打破 s1 的排列。
 * 示例 3：
 * <p>
 * 输入：s1 = "leetcodee", s2 = "interview"
 * 输出：true
 * <p>
 * <p>
 * 提示：
 * <p>
 * s1.length == n
 * s2.length == n
 * 1 <= n <= 10^5
 * 所有字符串都只包含小写英文字母。
 *
 * @author wellhor Zhao
 * @version 1.0
 * @date 2021/4/18 6:27 下午
 **/
public class Question1433 {

    public static void main(String[] args) {
//        System.out.println(new Question1433().checkIfCanBreak("abc","xya"));
//        System.out.println(new Question1433().checkIfCanBreak("abe","acd"));
//        System.out.println(new Question1433().checkIfCanBreak("leetcodee","interview"));
        System.out.println(new Question1433().checkIfCanBreak("qvgjjsp", "qmsbphx"));
    }

    public boolean checkIfCanBreak(String s1, String s2) {
        char[] s1Chars = s1.toCharArray();
        char[] s2Chars = s2.toCharArray();
        Arrays.sort(s1Chars);
        Arrays.sort(s2Chars);
        int i = 0;
        for (; i < s1Chars.length; i++) {
            if(s1Chars[i] < s2Chars[i]) {
                break;
            }
        }
        if(i == s1Chars.length) {
            return true;
        }
        for (i = 0; i < s1Chars.length; i++) {
            if(s1Chars[i] > s2Chars[i]) {
                return false;
            }
        }
        return true;
    }

}
