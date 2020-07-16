//反转单链表
//题目描述：定义一个函数，输入一个链表的头节点，反转该链表并输出反转后链表的头节点。

//示例:
//输入: 1->2->3->4->5->NULL
//输出: 5->4->3->2->1->NULL

public class ReverseList_24 {
    public ListNode reverseList(ListNode head) {
        ListNode result = null;//新的链表
        ListNode cur = head;//保存头结点

        while (cur != null) {
            ListNode next = cur.next;//保存头结点的下一个结点

            cur.next = result;//cur.next指向新链表的空域（新链表是空链表）
            result = cur;//空链表的头指针再指向当前原链表的头结点（第一个结点cur）

            cur = next;//再cur指向原cur所指向的第二个结点
        }

        return result;//返回新链表
    }
}
