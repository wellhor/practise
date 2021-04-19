package pers.wellhor.swardforoffer;

import java.util.Objects;
import java.util.Stack;

/**
 * 剑指 Offer 24. 反转链表
 * 定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。
 * 示例:
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 * 限制：
 * 0 <= 节点个数 <= 5000
 *
 * @author wellhor Zhao
 * @version 1.0
 * @date 2021/4/19 10:00 上午
 **/
public class Question24 {

    public static void main(String[] args) {
        valid(new int[]{1, 2, 3, 4, 5});
    }

    private static void valid(int[] nums) {
        ListNode listNode = null, head = null;
        for (int i = 0; i < nums.length; i++) {
            if(Objects.isNull(listNode)) {
                head = listNode = new ListNode(nums[i]);
            } else {
                listNode.next = new ListNode(nums[i]);
                listNode = listNode.next;
            }
        }
        head = new Question24().reverseList(head);
        while (Objects.nonNull(head)) {
            System.out.print(head.val + " ");
            head = head.next;
        }
    }

    public ListNode reverseList(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        while (Objects.nonNull(head)) {
            stack.push(head);
            head = head.next;
        }
        ListNode newHead = null, newListNode = null;
        while (!stack.isEmpty()) {
            if(Objects.isNull(newHead)) {
                newHead = newListNode = stack.pop();
            } else {
                newListNode.next = stack.pop();
                newListNode = newListNode.next;
            }
            newListNode.next = null;
        }
        return newHead;
    }

    static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

}
