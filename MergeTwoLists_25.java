//合并两个有序链表
//题目描述：将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个
//          链表的所有节点组成的。 

//示例：
//输入：1->2->4, 1->3->4
//输出：1->1->2->3->4->4

public class MergeTwoLists_25 {
    //方法一：迭代
    /*复杂度分析：
           时间复杂度：O(n+m);
           空间复杂度：O(n+m);
     */
    public ListNode mergeTwoLists1(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        ListNode result = null;
        ListNode last = null;
        ListNode cur1 = l1;
        ListNode cur2 = l2;

        while (cur1 != null && cur2 != null) {
            if (cur1.val <= cur2.val) {
                ListNode next = cur1.next;
                if (result == null) {
                    result = cur1;
                } else {
                    last.next = cur1;
                }
                last = cur1;  //记得及时更新last
                cur1 = next;
            } else {
                ListNode next = cur2.next;
                if (result == null) {
                    result = cur2;
                } else {
                    last.next = cur2;
                }
                last = cur2;  //记得及时更新last
                cur2 = next;
            }
        }
        if (cur1 != null) {
            last.next = cur1;
        } else {
            last.next = cur2;
        }
        return result;
    }

    //方法二：
    /*
    时间复杂度：O(n + m) ，其中 n 和 m 分别为两个链表的长度。因为每次循环迭代中，
            l1 和 l2 只有一个元素会被放进合并链表中， 因此 while 循环的次数不会超过
            两个链表的长度之和。所有其他操作的时间复杂度都是常数级别的，因此总的时间
            复杂度为 O(n+m)。
    空间复杂度：O(1),我们只需要常数的空间存放若干变量。

     */
    public ListNode mergeTwoList2(ListNode l1,ListNode l2){
        ListNode prehead = new ListNode(-1);

        ListNode prev = prehead;
        while (l1 != null && l2 != null) {
            if (l1.val <= l2.val) {
                prev.next = l1;
                l1 = l1.next;
            } else {
                prev.next = l2;
                l2 = l2.next;
            }
            prev = prev.next;
        }
        // 合并后 l1 和 l2 最多只有一个还未被合并完，我们直接将链表末尾指向未合并完的
        // 链表即可
        prev.next = l1 == null ? l2 : l1;
        return prehead.next;
    }
    //方法三：递归实现
    /*
    复杂度分析
       时间复杂度：O(n + m)，其中 n 和 m 分别为两个链表的长度。因为每次调用递归都会去
              掉 l1 或者 l2 的头节点（直到至少有一个链表为空），函数 mergeTwoList 至多
              只会递归调用每个节点一次。因此，时间复杂度取决于合并后的链表长度，即 O(n+m)。
       空间复杂度：O(n + m)，其中 n 和 m 分别为两个链表的长度。递归调用 mergeTwoLists
              函数时需要消耗栈空间，栈空间的大小取决于递归调用的深度。结束递归调用时
              mergeTwoLists 函数最多调用 n+m 次，因此空间复杂度为 O(n+m)。

     */
    public ListNode mergeTwoLists3(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if(l2==null){
            return l1;
        }

        ListNode cur1=l1;
        ListNode cur2=l2;

        if(cur1.val<=cur2.val){
            l1.next=mergeTwoLists1(l1.next,l2);
            return l1;
        }else {
            l2.next=mergeTwoLists1(l1,l2.next);
            return l2;
        }
    }
}
