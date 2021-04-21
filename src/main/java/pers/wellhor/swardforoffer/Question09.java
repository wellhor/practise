package pers.wellhor.swardforoffer;

import java.util.Stack;

/**
 * 剑指 Offer 09. 用两个栈实现队列
 * <p>
 * 用两个栈实现一个队列。队列的声明如下，请实现它的两个函数 appendTail 和 deleteHead ，分别完成在队列尾部插入整数和在队列头部删除整数的功能。(若队列中没有元素，deleteHead 操作返回 -1 )
 * <p>
 * <p>
 * <p>
 * 示例 1：
 * <p>
 * 输入：
 * ["CQueue","appendTail","deleteHead","deleteHead"]
 * [[],[3],[],[]]
 * 输出：[null,null,3,-1]
 * 示例 2：
 * <p>
 * 输入：
 * ["CQueue","deleteHead","appendTail","appendTail","deleteHead","deleteHead"]
 * [[],[],[5],[2],[],[]]
 * 输出：[null,-1,null,null,5,2]
 * 提示：
 * <p>
 * 1 <= values <= 10000
 * 最多会对 appendTail、deleteHead 进行 10000 次调用
 *
 * @author wellhor Zhao
 * @version 1.0
 * @date 2021/4/21 1:55 下午
 **/
public class Question09 {

    public static void main(String[] args) {
        CQueue obj = new CQueue();
        System.out.println(obj.deleteHead());
        obj.appendTail(5);
        obj.appendTail(2);
        System.out.println(obj.deleteHead());
        System.out.println(obj.deleteHead());
    }

    static class CQueue {

        private Stack<Integer> stackIn = new Stack<>();
        private Stack<Integer> stackOut = new Stack<>();

        public CQueue() {

        }

        public void appendTail(int value) {
            stackIn.push(value);
        }

        public int deleteHead() {
            if(!stackOut.isEmpty()) {
                return stackOut.pop();
            }
            while (!stackIn.isEmpty()) {
                stackOut.push(stackIn.pop());
            }
            if(!stackOut.isEmpty()) {
                return stackOut.pop();
            }
            return -1;
        }
    }

}
