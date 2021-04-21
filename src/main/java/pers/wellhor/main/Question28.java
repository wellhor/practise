package pers.wellhor.main;

/**
 * 28. 实现 strStr()
 * <p>
 * 实现strStr()函数。
 * <p>
 * 给你两个字符串haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串出现的第一个位置（下标从 0 开始）。如果不存在，则返回 -1 。
 * <p>
 * <p>
 * <p>
 * 说明：
 * <p>
 * 当needle是空字符串时，我们应当返回什么值呢？这是一个在面试中很好的问题。
 * <p>
 * 对于本题而言，当needle是空字符串时我们应当返回 0 。这与 C 语言的strstr()以及 Java 的indexOf()定义相符。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：haystack = "hello", needle = "ll"
 * 输出：2
 * 示例 2：
 * <p>
 * 输入：haystack = "aaaaa", needle = "bba"
 * 输出：-1
 * 示例 3：
 * <p>
 * 输入：haystack = "", needle = ""
 * 输出：0
 *
 * @author wellhor Zhao
 * @version 1.0
 * @date 2021/4/21 11:33 上午
 **/
public class Question28 {

    public static void main(String[] args) {
//        System.out.println(new Question28().strStr("hello", "ll"));
//        System.out.println(new Question28().strStr("aaaaa", "bba"));
//        System.out.println(new Question28().strStr("", "a"));
//        System.out.println(new Question28().strStr("a", ""));
        System.out.println(new Question28().strStr("abc", "c"));
    }

    public int strStr(String haystack, String needle) {
        if(haystack.length() == 0 && needle.length() == 0) {
            return 0;
        }
        if(needle.length() == 0) {
            return 0;
        }
        if(haystack.length() == needle.length() && haystack.equals(needle)) {
            return 0;
        }
        char c = needle.charAt(0);
        for (int j = 0; j < haystack.length(); j++) {
            if(c == haystack.charAt(j) && j + needle.length() <= haystack.length()) {
                String subString = haystack.substring(j, j + needle.length());
                if(subString.equals(needle)) {
                    return j;
                }
            }
        }
        return -1;
    }


}
