//两个链表的第一个公共节点
//输入两个链表，找出它们的第一个公共节点。

public class FindFirstCommonNode_52 {

    //方法一：双指针法——时间复杂度O(m+n) 空间复杂度O(1)
    //解题思路：
    // 我们使用两个指针 p1，p2 分别指向两个链表 headA，headB 的头结点，然后同时分别逐结点
    // 遍历，当 p1 到达链表 headA 的末尾时，重新定位到链表 headB 的头结点；
    //       当 p2 到达链表 headB 的末尾时，重新定位到链表 headA 的头结点。
    //这样，当它们相遇时，所指向的结点就是第一个公共结点。
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null||headB==null){
            return null;
        }
        ListNode p1=headA;
        ListNode p2=headB;
        while(p1!=p2){
            p1=p1==null?headB:p1.next;
            p2=p2==null?headA:p2.next;
        }
        return p1;
    }

    //方法二：哈希表法——时间复杂度O(m+n) 空间复杂度O(m)或O(n)
    //思路：遍历链表 A 并将每个结点的地址/引用存储在哈希表中。然后检查链表 B 中
    //      的某一个结点是否在哈希表中。若在，则该节点 为相交结点。

    //方法三：暴力法——时间复杂度O(mn) 空间复杂度O(1)
    //思路：对链表A中的每一个结点，遍历整个链表 B 并检查链表 B 中是否存在
    //      结点和 链表A中的该节点相同。
}
