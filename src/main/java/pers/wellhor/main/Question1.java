package pers.wellhor.main;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 1. 两数之和
 * <p>
 * <p>
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 的那 两个 整数，并返回它们的数组下标。
 * <p>
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 * <p>
 * 你可以按任意顺序返回答案。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 * 示例 2：
 * <p>
 * 输入：nums = [3,2,4], target = 6
 * 输出：[1,2]
 * 示例 3：
 * <p>
 * 输入：nums = [3,3], target = 6
 * 输出：[0,1]
 * <p>
 * <p>
 * 提示：
 * <p>
 * 2 <= nums.length <= 103
 * -109 <= nums[i] <= 109
 * -109 <= target <= 109
 * 只会存在一个有效答案
 *
 * @author wellhor Zhao
 * @version 1.0
 * @date 2021/4/21 5:01 下午
 **/
public class Question1 {

    public static void main(String[] args) {
        Arrays.stream(new Question1().twoSum(new int[]{2, 7, 11, 15}, 9)).forEach(item -> System.out.print(item + " "));
        System.out.println();
        Arrays.stream(new Question1().twoSum(new int[]{3, 2, 4}, 6)).forEach(item -> System.out.print(item + " "));
        System.out.println();
        Arrays.stream(new Question1().twoSum(new int[]{3, 3}, 6)).forEach(item -> System.out.print(item + " "));
        System.out.println();
    }

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            int subVal = target - nums[i];
            if(map.containsKey(subVal)) {
                return new int[]{i, map.get(subVal)};
            } else {
                map.put(nums[i], i);
            }
        }
        return null;
    }

}
