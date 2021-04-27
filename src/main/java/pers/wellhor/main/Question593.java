package pers.wellhor.main;

import java.util.Arrays;

/**
 * 593. 有效的正方形
 * <p>
 * 给定二维空间中四点的坐标，返回四点是否可以构造一个正方形。
 * <p>
 * 一个点的坐标（x，y）由一个有两个整数的整数数组表示。
 * <p>
 * 示例:
 * <p>
 * 输入: p1 = [0,0], p2 = [1,1], p3 = [1,0], p4 = [0,1]
 * 输出: True
 * <p>
 * <p>
 * 注意:
 * <p>
 * 所有输入整数都在 [-10000，10000] 范围内。
 * 一个有效的正方形有四个等长的正长和四个等角（90度角）。
 * 输入点没有顺序。
 *
 * @author wellhor Zhao
 * @version 1.0
 * @date 2021/4/21 3:31 下午
 **/
public class Question593 {

    public static void main(String[] args) {
        int[] p1 = new int[]{0, 0};
        int[] p2 = new int[]{5, 0};
        int[] p3 = new int[]{5, 4};
        int[] p4 = new int[]{0, 4};
        System.out.println(new Question593().validSquare(p1, p2, p3, p4));
    }

    public boolean validSquare(int[] p1, int[] p2, int[] p3, int[] p4) {
        int p1P2Length = calc(p1, p2);
        int p1P3Length = calc(p1, p3);
        int p1P4Length = calc(p1, p4);
        int p2P3Length = calc(p2, p3);
        int p3P4Length = calc(p3, p4);
        int p2P4Length = calc(p2, p4);


        int[] arr = new int[]{
                p1P2Length,
                p1P3Length,
                p1P4Length,
                p2P3Length,
                p3P4Length,
                p2P4Length
        };

        for (int val : arr) {
            if(val <= 0) {
                return false;
            }
        }

        Arrays.sort(arr);

        if(
                arr[0] == arr[1] && arr[2] == arr[3] && arr[0] == arr[2] &&
                        arr[4] == arr[5]
        ) {
            return arr[0] + arr[2] == arr[4];
        } else {
            return false;
        }
    }

    private int calc(int[] a, int[] b) {
        int xLength = b[0] - a[0];
        int yLength = b[1] - a[1];
        return xLength * xLength + yLength * yLength;
    }

}
