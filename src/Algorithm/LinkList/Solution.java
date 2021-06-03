package Algorithm.LinkList;
//给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。
//
//        你可以假设除了数字 0 之外，这两个数字都不会以零开头。
//
//
//
//        进阶：
//
//        如果输入链表不能修改该如何处理？换句话说，你不能对列表中的节点进行翻转。
//
//
//        示例：
//
//        输入：(7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
//        输出：7 -> 8 -> 0 -> 7
//https://leetcode-cn.com/problems/add-two-numbers-ii/solution/liang-shu-xiang-jia-ii-by-leetcode-solution/
import java.util.Deque;
import java.util.LinkedList;
import java.util.Stack;

public class Solution {
    static Stack<ListNode> stack1;
    static Stack<ListNode> stack2;

//    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        ListNode root = null;
//        ListNode pre = root;
//        stack1 = new Stack();
//        stack2 = new Stack();
//        ListNode r1 = l1;
//        ListNode r2 = l2;
//        while(r1!=null){
//            stack1.push(r1);
//            r1 = r1.next;
//        }
//        while(r2!=null){
//            stack2.push(r2);
//            r2 = r2.next;
//        }
//        int flag = 0;
//        while(!stack1.isEmpty()||!stack2.isEmpty()){
//            ListNode node1;
//            ListNode node2;
//            if(stack1.isEmpty())
//                node1 = null;
//            else{
//                node1 = stack1.pop();
//            }
//            if(stack2.isEmpty())
//                node2 = null;
//            else{
//                node2 = stack2.pop();
//            }
//
//            int n1 = node1!=null?node1.val:0;
//            int n2 = node2!=null?node2.val:0;
//
//            int sum = n1 + n2 + flag;
//
//            if(root==null){
//                pre=root=new ListNode(sum%10);
//            }else{
//                ListNode temp = new ListNode(sum%10);
//                temp.next = pre;
//                pre = temp;
//            }
//            flag = sum/10;
//        }
//        if(flag>0){
//            ListNode temp = new ListNode(flag);
//            temp.next = pre;
//            pre = temp;
//        }
//        return pre;
//    }

    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        Deque<Integer> stack1 = new LinkedList<Integer>();
        Deque<Integer> stack2 = new LinkedList<Integer>();
        while (l1 != null) {
            stack1.push(l1.val);
            l1 = l1.next;
        }
        while (l2 != null) {
            stack2.push(l2.val);
            l2 = l2.next;
        }
        int carry = 0;
        ListNode ans = null;
        while (!stack1.isEmpty() || !stack2.isEmpty() || carry != 0) {
            int a = stack1.isEmpty() ? 0 : stack1.pop();
            int b = stack2.isEmpty() ? 0 : stack2.pop();
            int cur = a + b + carry;
            carry = cur / 10;
            cur %= 10;
            ListNode curnode = new ListNode(cur);
            curnode.next = ans;
            ans = curnode;
        }
        return ans;
    }

}
