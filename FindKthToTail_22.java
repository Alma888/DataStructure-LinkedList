//链表中倒数第K个结点

//题目描述：输入一个链表，输出该链表中倒数第k个结点。
//         为了符合大多数人的习惯，本题从1开始计数，即链表的尾节点是倒数第1个节点。
//         例如，一个链表有6个节点，从头节点开始，它们的值依次是1、2、3、4、5、6。
//         这个链表的倒数第3个节点是值为4的节点。
public class FindKthToTail_22 {
    //方法一：迭代 ——时间复杂度O(n) 空间复杂度O(1)
    //  思路：第一时间想到的解法
    //        先遍历统计链表长度，记为 n ；
    //        设置一个指针走 (n-k)步，即可找到链表倒数第 k 个节点。
    public ListNode FindKthToTail1(ListNode head,int k) {
        ListNode cur=head;
        int len=0;
        while (cur!=null){
            len++;
            cur=cur.next;
        }
        if(len<k){
            return null;
        }
        int step=len-k;

        ListNode node=head;
        for(int i=0;i<3;i++){
            node=node.next;
        }
        return node;
    }
//————————————————推荐快慢指针解法——————————————————————————
    //方法二：快慢指针——时间复杂度O(n) 空间复杂度O(1)
    //使用双指针则可以不用统计链表长度。

    //算法思路：
    //初始化： 前指针 fast 、后指针 slow ，双指针都指向头节点 head​ 。
    //构建双指针距离： 前指针 fast 先向前走 k 步（结束后，双指针 fast 和 slow 间相距 k 步）。
    //双指针共同移动： 循环中，双指针 fast 和 slow 每轮都向前走一步，直至 fast 走过链表尾节
    //                 点时跳出（跳出后， slow 与尾节点距离为 k-1，即 slow 指向倒数第 k 个节点）。
    //***（在具体编码的时候，还是有一些细节要注意的，特别是空指针的判断上。）***
    // 对一些极端情况的讨论（下面代码中的注意点 2 ）。

    //返回值： 返回 slow 即可。

    //复杂度分析：
    //时间复杂度 O(N) ： N 为链表长度；总体看， fast 走了 N 步， slow 走了 (N−k) 步。
    //空间复杂度 O(1) ： 双指针 fast , slow 使用常数大小的额外空间。

    public ListNode FindKthToTail2(ListNode head,int k) {
        // 注意点1：极端输入，直接输出结果
        if (head == null) {
            return null;
        }
        ListNode fast = head;   //快指针
        for (int i = 0; i < k; i++) {
            // 注意点2：对不符合要求的输入的判断
            if (fast == null) {
                return null;
            }
            fast = fast.next;
        }
        ListNode slow = head;  //慢指针
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
