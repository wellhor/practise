package pers.wellhor.swardforoffer;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * 剑指 Offer 38. 字符串的排列
 *
 * @author wellhor Zhao
 * @version 1.0
 * @date 2021/4/18 12:52 上午
 **/
public class Question38 {

    public static void main(String[] args) {
        Arrays.stream(new Question38().permutation("aabc")).forEach(System.out::println);
    }

    public String[] permutation(String s) {
        Set<String> set = new HashSet<>();
        char[] chars = s.toCharArray();
        int[] flag = new int[s.length()];
        travel(chars, flag, "", set);
        return set.toArray(new String[0]);
    }

    private void travel(char[] chars, int[] flag, String str, Set<String> set) {
        for (int i = 0; i < flag.length; i++) {
            if(flag[i] == 0) {
                String newString = str + chars[i];
                if(newString.length() == flag.length) {
                    set.add(newString);
                    return;
                }
                int[] newFlag = flag.clone();
                newFlag[i] = 1;
                travel(chars, newFlag, newString, set);
            }
        }
    }

}
