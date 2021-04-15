package pers.wellhor.swardforoffer;

import java.util.Objects;

/**
 * 剑指 Offer 18. 删除链表的节点
 *
 * @author wellhor Zhao
 * @version 1.0
 * @date 2021/4/15 10:38 下午
 **/
public class Question8 {

    public static void main(String[] args) {
        int[] arr = new int[]{4, 5, 1, 9};
        ListNode head = new ListNode(arr[0]);
        ListNode curs = head;
        for (int i = 1; i < arr.length; i++) {
            ListNode next = new ListNode(arr[i]);
            curs.next = next;
            curs = next;
        }

        curs = new Question8().deleteNode(head, 5);
        while (Objects.nonNull(curs)) {
            System.out.print(curs.val + " ");
            curs = curs.next;
        }
    }

    /**
     * 给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
     * <p>
     * 返回删除后的链表的头节点。
     * <p>
     * 注意：此题对比原题有改动
     * 示例 1:
     * <p>
     * 输入: head = [4,5,1,9], val = 5
     * 输出: [4,1,9]
     * 解释: 给定你链表中值为5的第二个节点，那么在调用了你的函数之后，该链表应变为 4 -> 1 -> 9.
     * 示例 2:
     * <p>
     * 输入: head = [4,5,1,9], val = 1
     * 输出: [4,5,9]
     * 解释: 给定你链表中值为1的第三个节点，那么在调用了你的函数之后，该链表应变为 4 -> 5 -> 9.
     * <p>
     * <p>
     * 说明：
     * <p>
     * 题目保证链表中节点的值互不相同
     * 若使用 C 或 C++ 语言，你不需要 free 或 delete 被删除的节点
     */
    public ListNode deleteNode(ListNode head, int val) {
        if(head.val == val) {
            return head.next;
        } else {
            ListNode curs = head;
            while (Objects.nonNull(curs.next)) {
                if(curs.next.val == val) {
                    curs.next = curs.next.next;
                    break;
                }
                curs = curs.next;
            }
            return head;
        }
    }

    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
