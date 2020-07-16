//删除排序链表中的重复元素II

//题目描述：给定一个排序链表，删除所有含有重复数字的节点，只保留原始链表中没有重复
//          出现的数字，返回链表头指针。。
//示例 1:
//输入: 1->2->3->3->4->4->5
//输出: 1->2->5
//示例 2:
//输入: 1->1->1->2->3
//输出: 2->3

//三指针解法——时间O(n)  空间O(1)
//
public class DeleteDuplication_82 {
    public ListNode deleteDuplicates(ListNode head) {
        // 注意1：极端情况考虑
        if(head==null){
            return null;
        }
        ListNode prev=null;
        ListNode p1=head;
        ListNode p2=head.next;

        while (p2!=null){
            if(p2.val==p1.val){
                while (p2!=null&&p2.val==p1.val){ //双重保证
                    p2=p2.next;
                }
                if(prev==null){ //看是否从第一个节点开始就重复
                    head=p2;
                }else {
                    prev.next=p2;
                }
                p1=p2;
                if(p2!=null){
                    p2=p2.next;
                }
            }else {
                prev=p1;
                p1=p2;
                p2=p2.next;
            }
        }
        return head;
    }
}
