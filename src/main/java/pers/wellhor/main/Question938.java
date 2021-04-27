package pers.wellhor.main;

import java.util.Objects;

/**
 * 938. 二叉搜索树的范围和
 * <p>
 * 给定二叉搜索树的根结点 root，返回值位于范围 [low, high] 之间的所有结点的值的和。
 * 输入：root = [10,5,15,3,7,null,18], low = 7, high = 15
 * 输出：32
 * <p>
 * 输入：root = [10,5,15,3,7,13,18,1,null,6], low = 6, high = 10
 * 输出：23
 *
 * @author wellhor Zhao
 * @version 1.0
 * @date 2021/4/27 3:55 下午
 **/
public class Question938 {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(10);
        root.left = new TreeNode(5);
        root.right = new TreeNode(15);

        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(7);

        root.right.right = new TreeNode(18);

        System.out.println(new Question938().rangeSumBST(root, 7, 15));

    }

    public int rangeSumBST(TreeNode root, int low, int high) {
        int val = ((root.val >= low && root.val <= high) ? root.val : 0);
        int left = Objects.nonNull(root.left) ? rangeSumBST(root.left, low, high) : 0;
        int right = Objects.nonNull(root.right) ? rangeSumBST(root.right, low, high) : 0;
        return val + left + right;
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
