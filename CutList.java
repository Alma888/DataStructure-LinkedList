//链表分割

//题目描述:编写代码，以给定值x为基准将链表分割成两部分，所有小于x的结点排在
//          大于或等于x的结点之前.
//给定一个链表的头指针 ListNode* pHead，请返回重新排列后的链表的头指针。
//  注意：分割以后保持原来的数据顺序不变。
public class CutList {
    public ListNode partition(ListNode pHead, int x) {
        //考虑三点：1.有两个新链表（都需要尾插）
        //          2.可能有一个链表是不存在的
        //          3.保证最终链表的最后一个结点的next是null
        if(pHead==null){
            return null;
        }
        ListNode cur=pHead;
        ListNode result1=null;  //小于给定值x的放result1
        ListNode result2=null;  //大于或等于给定值x的放result2
        ListNode last1=null;
        ListNode last2=null;

        while (cur!=null){
            ListNode next=cur.next;
            if(cur.val<x){
                if(result1==null){
                    result1=cur;
                }else {
                    last1.next=cur;
                }
                last1=cur;
            }else {
                if(result2==null){
                    result2=cur;
                }else {
                    last2.next=cur;
                }
                last2=cur;
            }
            cur=next;
        }
        if (result1==null){
            return result2;
        }else {
            last1.next=result2;
            if(last2!=null){
                last2.next=null;//保证最终链表的最后一个结点的next是null
            }
            return result1;
        }
    }
}
