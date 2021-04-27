package pers.wellhor.main;

import java.util.Objects;

/**
 * 2. 两数相加
 * <p>
 * 给你两个  非空 的链表，表示两个非负的整数。它们每位数字都是按照  逆序  的方式存储的，并且每个节点只能存储  一位  数字。
 * <p>
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 * <p>
 * 你可以假设除了数字 0 之外，这两个数都不会以 0  开头。
 * <p>
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807.
 * 示例 2：
 * <p>
 * 输入：l1 = [0], l2 = [0]
 * 输出：[0]
 * 示例 3：
 * <p>
 * 输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
 * 输出：[8,9,9,9,0,0,0,1]
 * <p>
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 *
 * @author wellhor Zhao
 * @version 1.0
 * @date 2021/4/21 5:20 下午
 **/
public class Question2 {

    public static void main(String[] args) {
        valid(new int[]{2, 4, 3}, new int[]{5, 6, 4});
        valid(new int[]{0}, new int[]{0});
        valid(new int[]{9, 9, 9, 9, 9, 9, 9}, new int[]{9, 9, 9, 9});
    }

    public static void valid(int[] l1, int[] l2) {
        ListNode n1 = toNode(l1);
        ListNode n2 = toNode(l2);
        ListNode node = new Question2().addTwoNumbers(n1, n2);
        while (Objects.nonNull(node)) {
            System.out.println(node.val);
            node = node.next;
        }
        System.out.println();
    }

    public static ListNode toNode(int[] nums) {
        ListNode head = new ListNode();
        ListNode node = null;
        for (int val : nums) {
            if(Objects.isNull(node)) {
                node = head;
                head.val = val;
            } else {
                node.next = new ListNode();
                node = node.next;
                node.val = val;
            }
        }
        return head;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = null, node = null;
        boolean over = false;
        while (Objects.nonNull(l1) || Objects.nonNull(l2)) {
            if(Objects.isNull(head)) {
                head = node = new ListNode();
            } else {
                node.next = new ListNode();
                node = node.next;
            }
            if(Objects.nonNull(l1)) {
                node.val += l1.val;
                l1 = l1.next;
            }
            if(Objects.nonNull(l2)) {
                node.val += l2.val;
                l2 = l2.next;
            }
            if(over) {
                node.val++;
                over = false;
            }

            if(node.val >= 10) {
                node.val %= 10;
                over = true;
            }
        }
        if(over) {
            node.next = new ListNode();
            node.next.val = 1;
        }
        return head;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}
