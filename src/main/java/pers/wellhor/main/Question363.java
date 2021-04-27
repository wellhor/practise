package pers.wellhor.main;

/**
 * 363. 矩形区域不超过 K 的最大数值和
 * <p>
 * 给你一个 m x n 的矩阵 matrix 和一个整数 k ，找出并返回矩阵内部矩形区域的不超过 k 的最大数值和。
 * <p>
 * 题目数据保证总会存在一个数值和不超过 k 的矩形区域。
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * <p>
 * 输入：matrix = [[1,0,1],[0,-2,3]], k = 2
 * 输出：2
 * 解释：蓝色边框圈出来的矩形区域  [[0, 1], [-2, 3]]  的数值和是 2，且 2 是不超过 k 的最大数字（k = 2）。
 * 示例 2：
 * <p>
 * 输入：matrix = [[2,2,-1]], k = 3
 * 输出：3
 * <p>
 * <p>
 * 提示：
 * <p>
 * m == matrix.length
 * n == matrix[i].length
 * 1 <= m, n <= 100
 * -100 <= matrix[i][j] <= 100
 * -105 <= k <= 105
 * <p>
 * <p>
 * 进阶：如果行数远大于列数，该如何设计解决方案？
 *
 * @author wellhor Zhao
 * @version 1.0
 * @date 2021/4/22 9:36 上午
 **/
public class Question363 {

    public static void main(String[] args) {
        System.out.println(new Question363().maxSumSubmatrix(new int[][]{
                {1, 0, 1},
                {0, -2, 3}
        }, 2));

        System.out.println(new Question363().maxSumSubmatrix(new int[][]{
                {2, 2, -1}
        }, 3));
        System.out.println(new Question363().maxSumSubmatrix(new int[][]{
                {2, 2, -1}
        }, 0));

        System.out.println(new Question363().maxSumSubmatrix(new int[][]{
                {5, -4, -3, 4},
                {-3, -4, 4, 5},
                {5, 1, 5, -4}
        }, 8));
    }

    public int maxSumSubmatrix(int[][] matrix, int k) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < matrix.length; i++) {
            int[] row = matrix[i];
            for (int j = 0; j < row.length; j++) {
                int[][] renArr = new int[matrix.length][matrix[0].length];
                int val = renArr[0][0] = matrix[i][j];
                if(val == k) {
                    return k;
                } else if(val <= k && val > max) {
                    max = val;
                }
                for (int l = 1; l < matrix.length - i; l++) {
                    val = renArr[l][0] = renArr[l - 1][0] + matrix[i + l][j];
                    if(val == k) {
                        return k;
                    } else if(val <= k && val > max) {
                        max = val;
                    }
                }
                for (int m = 1; m < row.length - j; m++) {
                    val = renArr[0][m] = renArr[0][m - 1] + matrix[i][j + m];
                    if(val == k) {
                        return k;
                    } else if(val <= k && val > max) {
                        max = val;
                    }
                }
                for (int l = 1; l < matrix.length - i; l++) {
                    for (int m = 1; m < row.length - j; m++) {
                        val = renArr[l][m] = renArr[l - 1][m] + renArr[l][m - 1] - renArr[l - 1][m - 1] + matrix[i + l][j + m];
                        if(val == k) {
                            return k;
                        } else if(val <= k && val > max) {
                            max = val;
                        }
                    }
                }
            }
        }
        return max;
    }

}
