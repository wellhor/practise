package pers.wellhor.main;

import java.util.Arrays;

/**
 * 213打家劫舍
 *
 * @author wellhor Zhao
 * @version 1.0
 * @date 2021/4/15 9:36 下午
 **/
public class Question213 {

    public static void main(String[] args) {
        int[] nums = new int[]{200, 3, 140, 20, 10};
        System.out.println(new Question213().rob(nums));
    }

    /**
     * a0 a1 a2 a3 a4 ... an
     * max(a0...an) = max(max(a0...an-1), max(a1...an))
     * <p>
     * 你是一个专业的小偷，计划偷窃沿街的房屋，每间房内都藏有一定的现金。
     * 这个地方所有的房屋都 围成一圈 ，
     * 这意味着第一个房屋和最后一个房屋是紧挨着的。
     * 同时，相邻的房屋装有相互连通的防盗系统，如果两间相邻的房屋在同一晚上被小偷闯入，系统会自动报警 。
     * <p>
     * 给定一个代表每个房屋存放金额的非负整数数组，计算你 在不触动警报装置的情况下 ，能够偷窃到的最高金额。
     *
     * @param nums 每个房间的钱
     */
    public int rob(int[] nums) {
        if(nums.length == 0) {
            return 0;
        } else if(nums.length == 1) {
            return nums[0];
        } else if(nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        } else {
            int leftMax = getMax(Arrays.copyOf(nums, nums.length - 1));
            int rightMax = getMax(Arrays.copyOfRange(nums, 1, nums.length));
            return Math.max(leftMax, rightMax);
        }
    }

    /**
     * 最大值 不考虑 收尾为相邻的情况
     * max(a0...an) = max(max(a0...an-2) + an, max(a0...an-1))
     *
     * @param nums 房间的钱
     * @return 最大值
     */
    private int getMax(int[] nums) {
        if(nums.length == 0) {
            return 0;
        } else if(nums.length == 1) {
            return nums[0];
        } else if(nums.length == 2) {
            return Math.max(nums[0], nums[1]);
        } else {
            int[] res = new int[nums.length];
            res[0] = nums[0];
            res[1] = Math.max(nums[0], nums[1]);
            for (int i = 2; i < res.length; i++) {
                res[i] = Math.max(res[i - 2] + nums[i], res[i - 1]);
            }
            return res[nums.length - 1];
        }
    }

}
