//从尾到头打印链表
//题目描述：输入一个链表的头节点，从尾到头反过来返回每个节点的值（用数组返回）。
//示例 1：
//输入：head = [1,3,2]
//输出：[2,3,1]
//
//解题思路：——方法一：栈
//栈的特点是后进先出，即最后压入栈的元素最先弹出。考虑到栈的这一特点，使用栈将链表
//         元素顺序倒置。从链表的头节点开始，依次将每个节点压入栈内，然后依次弹出栈
//         内的元素并存储到数组中。
//
//创建一个栈，用于存储链表的节点
//创建一个指针，初始时指向链表的头节点
//当指针指向的元素非空时，重复下列操作：将指针指向的节点压入栈内
//                                      将指针移到当前节点的下一个节点
//获得栈的大小 size，创建一个数组 print，其大小为 size
//创建下标并初始化 index = 0
//重复 size 次下列操作：从栈内弹出一个节点，将该节点的值存到 print[index]
//                      将 index 的值加 1
//                      返回 print
//

import java.util.Stack;

class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
             val = x;
      }
  }

public class PrintListFromTailToHead_6 {

    //方法一：用栈实现——复度性分析
    //
    //时间复杂度：O(n)。正向遍历一遍链表，然后从栈弹出全部节点，等于又反向遍历一遍链表。
    //空间复杂度：O(n)。额外使用一个栈存储链表中的每个节点。

    public int[] reversePrint1(ListNode head) {
        Stack<ListNode> stack = new Stack<>();
        ListNode temp=head;
        while (temp!=null){
            stack.push(temp);
            temp=temp.next;
        }
        int size=stack.size();
        int[] nums=new int[size];
        for(int i=0;i<size;i++){
            nums[i]=stack.pop().val;
        }
        return nums;
    }

    //方法二：不需要借助Stack 或者 ArrayList 双100解法
    //  时间复杂度——O(n)   空间复杂度——O(n)
    public int[] reversePrint2(ListNode head) {
        //先获取链表长度，创建对应长度数组
        ListNode currNode = head;
        int len = 0;
        while(currNode != null){
            len ++;
            currNode = currNode.next;
        }
        int[] result = new int[len];

        //再次遍历链表，将值倒序填充至结果数组
        currNode = head;
        while(currNode != null){
            result[len - 1] = currNode.val;
            len --;
            currNode = currNode.next;
        }
        return result;
    }
}
