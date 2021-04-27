package pers.wellhor.main;

import java.util.HashMap;
import java.util.Map;

/**
 * 3. 无重复字符的最长子串
 * <p>
 * 给定一个字符串，请你找出其中不含有重复字符的  最长子串  的长度。
 * <p>
 * <p>
 * <p>
 * 示例  1:
 * <p>
 * 输入: s = "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 * <p>
 * 输入: s = "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 * <p>
 * 输入: s = "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是  "wke"，所以其长度为 3。
 * 请注意，你的答案必须是 子串 的长度，"pwke"  是一个子序列，不是子串。
 * 示例 4:
 * <p>
 * 输入: s = ""
 * 输出: 0
 * <p>
 * <p>
 * 提示：
 * <p>
 * 0 <= s.length <= 5 * 104
 * s  由英文字母、数字、符号和空格组成
 *
 * @author wellhor Zhao
 * @version 1.0
 * @date 2021/4/21 5:41 下午
 **/
public class Question3 {

    public static void main(String[] args) {
        System.out.println(new Question3().lengthOfLongestSubstring("abba"));
//        System.out.println(new Question3().lengthOfLongestSubstring("dvdf"));
//        System.out.println(new Question3().lengthOfLongestSubstring("abcabcbb"));
//        System.out.println(new Question3().lengthOfLongestSubstring("bbbbb"));
//        System.out.println(new Question3().lengthOfLongestSubstring("pwwkew"));
    }

    public int lengthOfLongestSubstring(String s) {
        int max = 0;
        if(s.length() <= 1) {
            return s.length();
        }
        char[] chars = s.toCharArray();
        int count = 0;
        Map<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < chars.length; ++i) {
            char aChar = chars[i];
            if(map.containsKey(aChar)) {
                if(count > max) {
                    max = count;
                }
                Integer index = map.get(aChar);
                count = 0;
                map.clear();
                for (int j = index + 1; j < i; j++) {
                    map.put(chars[j], j);
                    ++count;
                }
            }
            map.put(aChar, i);
            ++count;
        }
        if(count > max) {
            max = count;
        }
        return max;
    }

}
