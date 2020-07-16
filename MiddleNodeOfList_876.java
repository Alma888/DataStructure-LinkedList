//链表中间结点

//题目描述：给定一个带有头结点 head 的非空单链表，返回链表的中间结点。
//如果有两个中间结点，则返回第二个中间结点。
//
//示例 1：
//输入：[1,2,3,4,5]
//输出：此列表中的结点 3 (序列化形式：[3,4,5])
//返回的结点值为 3 。 (测评系统对该结点序列化表述是 [3,4,5])。
//注意，我们返回了一个 ListNode 类型的对象 ans，这样：
//ans.val = 3, ans.next.val = 4, ans.next.next.val = 5, 以及 ans.next.next.next = NULL.
//示例 2：
//输入：[1,2,3,4,5,6]
//输出：此列表中的结点 4 (序列化形式：[4,5,6])
//由于该列表有两个中间结点，值分别为 3 和 4，我们返回第二个结点。

public class MiddleNodeOfList_876 {
    //方法一：迭代
    //思路：先遍历一次，计算链表的长度，进而计算链表中间结点的下标（注意偶数结点
    //      的时候，得到的是中间的第二个结点），然后再遍历一次，来到所要求结点的
    //      位置。
    //缺点：必须先遍历完整个链表，然后才可以「干正事」，再遍历到一半，找到中间结点；
    //      在链表的长度很长的时候，这种方法之前的等待会很久。
    //复杂度分析：时间复杂度—O(n) 空间复杂度O(1)
    public ListNode middleNode1(ListNode head) {
        ListNode cur = head;
        int len = 0;
        while (cur != null) {
            len++;
            cur = cur.next;
        }
        int midLen = len / 2;

        ListNode node = head;
        for (int i = 0; i < midLen; i++) {
            node = node.next;
        }
        return node;
    }

    //方法二：快慢双指
    //  使用两个指针变量，刚开始都位于链表的第1个结点，一个永远一次只走 1 步，
    //  一个永远一次只走 2 步，一个在前，一个在后，同时走。这样当快指针走完的时候，
    //  慢指针就来到了链表的中间位置。
    //思想是：快慢指针的前进方向相同，且它们步伐的「差」是恒定的，根据这种确定性去
    //    解决链表中的一些问题。

    public ListNode middleNode2(ListNode head) {
        ListNode cur=head;
        ListNode fast=head;
        ListNode low=head;

        while (fast!=null){
            fast=fast.next;
            if(fast==null){
                break;
            }
            low=low.next;
            fast=fast.next;
        }
        return low;
    }
}
//为链表编写测试函数，进行调试（在下面的参考代码中有），主要是：
//从数组得到一个链表；
//根据当前结点打印当前结点以及后面的结点。
//这两个方法可以非常方便地帮助我们调试关于链表的程序。
//    大家还可以在「力扣」的新手场：「探索」 板块里，学习链表的相关知识和问题。
//  「力扣」上的链表问题，和我们在教科书里学习的链表是有一点点不一样的，「力扣」
//    的链表是以结点类 ListNode 为中心进行编程。而一般教科书上则是将 ListNode
//   作为链表的内部类进行编程，差别就是这些。其它处理链表问题的技巧是完全一样的。
