import java.util.ArrayList;
import java.util.List;

//回文链表（或链表的回文结构）——推荐第二种解法

//题目描述：请判断一个链表是否为回文链表。
//
//示例 1:
//输入: 1->2
//输出: false
//示例 2:
//输入: 1->2->2->1
//输出: true
//进阶：能否用 O(n) 时间复杂度和 O(1) 空间复杂度解决此题？

public class PalindromeList_234 {
    //方法一：将值复制到数组中后用双指针法
    //    时间O(n)  空间O(n)
    //思路：我们可以分为两个步骤：
    //      1、复制链表值到数组列表中。
    //      2、使用双指针法判断是否为回文。
    public boolean isPalindrome1(ListNode head){
        List<Integer> list=new ArrayList<>();

        ListNode cur=head;
        while (cur!=null){
            list.add(cur.val);
            cur=cur.next;
        }
        int left=0;
        int right=list.size()-1;

        while (left<right){
            if(!list.get(left).equals(list.get(right))){
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
//————————————————推荐此用法————————————————————————————————————
    //方法二：快慢指针
    //   时间O(n)  空间O(1)
    //思路：避免使用 O(n) 额外空间的方法就是改变输入。
    //      我们可以将链表的后半部分反转（修改链表结构），然后将前半部分和后半部分
    //      进行比较。比较完成后(我们应该将链表恢复原样。虽然不需要恢复也能通过测试
    //      用例，因为使用该函数的人不希望链表结构被更改)返回结果，下面没有写出恢复链表代码 。
    //我们可以分为以下几个步骤：
    //找到前半部分链表的尾节点。
    //反转后半部分链表。
    //判断是否为回文。
    //返回结果。
    //
    // 复杂度分析：时间复杂度：O(n)，其中 n 指的是链表的大小。
    //空间复杂度：O(1)，我们是一个接着一个的改变指针，我们在堆栈上的堆栈帧不超过 O(1)。
    //该方法的缺点是，在并发环境下，函数运行时需要锁定其他线程或进程对链表的访问，因为在函数执执行过程中链表暂时断开。

    public boolean isPalindrome2(ListNode head){
        // ***注意点1：极端情况考虑
        if(head == null) {
            return false; //牛客上若为空链表，返回真或假都正确，但是力扣上只能通过真
        }
        if(head.next == null){
            return true;
        }
        //1、找到前半部分链表的尾节点。（也就是链表中间节点）
        ListNode fast=head;
        ListNode slow=head;
        while (fast!=null){
            fast=fast.next;
            // ***注意点2：考虑空指针情况
            if(fast==null){
                break;
            }
            slow=slow.next;
            fast=fast.next;
        }
        //2、反转后半部分链表。
        ListNode cur=slow;  //这时候的slow指向的就是原链表的中间节点
        ListNode result=null;
        while (cur!=null){
            ListNode next=cur.next;
            cur.next=result;
            result=cur;

            cur=next;
        }
        //3、判断是否为回文。
        ListNode n1=head; //前半部分链表的头结点
        ListNode n2=result;//逆置后的后半部分链表的头结点
        while (n1!=null&&n2!=null){
            if(n1.val!=n2.val){
                return false;
            }
            n1=n1.next;
            n2=n2.next;
        }
        return true;
    }

//——————————————————————————————————————————————————————————
    //方法三：递归实现
    //   时间O(n)  空间O(n)
    //思路：如果使用递归反向迭代节点，同时使用递归函数外的变量向前迭代，就可以判断链表
    //     是否为回文。
    //currentNode 指针是先到尾节点，由于递归的特性再从后往前进行比较。frontPointer 是
    //       递归函数外的指针。若 currentNode.val != frontPointer.val 则返回 false。
    //       反之，frontPointer 向前移动并返回 true。
    //之所以起作用的原因是递归处理节点的顺序是相反的（记住上面打印的算法）。由于递归，
    //      从本质上，我们同时在正向和逆向迭代。
    //
    //计算机在递归的过程将使用堆栈的空间，这就是为什么递归并不是O(1) 的空间复杂度。

    private ListNode frontPointer;

    private boolean recursivelyCheck(ListNode currentNode) {
        if (currentNode != null) {
            if (!recursivelyCheck(currentNode.next)) {
                return false;
            }
            if (currentNode.val != frontPointer.val){
                return false;
            }
            frontPointer = frontPointer.next;
        }
        return true;
    }
    public boolean isPalindrome3(ListNode head) {
        frontPointer = head;
        return recursivelyCheck(head);
    }
}
//复杂度分析
//时间复杂度：O(n)，其中 n指的是链表的大小。
//空间复杂度：O(n)，其中 n指的是链表的大小。我们要理解计算机如何运行递归函数，在一个函数
//            中调用一个函数时，计算机需要在进入被调用函数之前跟踪它在当前函数中的位置
//           （以及任何局部变量的值），通过运行时存放在堆栈中来实现（堆栈帧）。在堆栈中
//           存放好了数据后就可以进入被调用的函数。在完成被调用函数之后，他会弹出堆栈顶部
//          元素，以恢复在进行函数调用之前所在的函数。在进行回文检查之前，递归函数将在堆
//          栈中创建n 个堆栈帧，计算机会逐个弹出进行处理。所以在使用递归时要考虑堆栈的使用情况。
//
// 这种方法不仅使用了 O(n) 的空间，且比第一种方法更差，
// 因为在许多语言中，堆栈帧很大（如 Python），并且最大的运行时堆栈深度为 1000（可以增加，
// 但是有可能导致底层解释程序内存出错）。为每个节点创建堆栈帧极大的限制了算法能够处理的
// 最大链表大小。
