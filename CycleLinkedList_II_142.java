//环形链表II
//题目描述：给定一个链表，返回链表开始入环的第一个节点。
//         如果链表无环，则返回null。
//为了表示给定链表中的环，我们使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。 如果 pos 是 -1，则在该链表中没有环。
//说明：不允许修改给定的链表。

//示例 1：
//输入：head = [3,2,0,-4], pos = 1
//输出：tail connects to node index 1
//解释：链表中有一个环，其尾部连接到第二个节点。

//示例 2：
//输入：head = [1,2], pos = 0
//输出：tail connects to node index 0
//解释：链表中有一个环，其尾部连接到第一个节点。

//示例 3：
//输入：head = [1], pos = -1
//输出：no cycle
//解释：链表中没有环。

//进阶：你是否可以不用额外空间解决此题？

import java.util.HashSet;
import java.util.Set;

public class CycleLinkedList_II_142 {
    //方法一：快慢指针——时间复杂度O(n)  空间复杂度O(1)

    //思路：当然一个跑得快的人和一个跑得慢的人在一个圆形的赛道上赛跑，会发生什么？
    //      在某一个时刻，跑得快的人一定会从后面赶上跑得慢的人。
    //过程：该算法被划分成两个不同的阶段 。
    //     在第一阶段，找出列表中是否有环，如果没有环，可以直接返回 null 并退出。
    //     否则，用相遇节点来找到环的入口。
    //阶段 1
    //这里我们初始化两个指针 - 快指针和慢指针。我们每次移动慢指针一步、快指针两步，
    //直到快指针无法继续往前移动。如果在某次移动后，快慢指针指向了同一个节点，我们
    //就返回它。否则，我们继续，直到 while 循环终止且没有返回任何节点，这种情况说
    // 明没有成环，我们返回 null 。

    //阶段 2
    //给定阶段 1 找到的相遇点，阶段 2 将找到环的入口。
    //首先我们初始化额外的两个指针： p 指向链表的头， q指向相遇点。然后，我们每次将
    // 它们往前移动一步，直到它们相遇，它们相遇的点就是环的入口，返回这个节点。

    public ListNode detectCycle1(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        // fast 遇到 null，表示不带环，返回 null
        // fast == slow，表示遇到相遇点了

        // 1、求相遇点
        // 2、如果快的遇到 null，表示没有环，直接返回 null
        do {
            if (fast == null) {
                return null;
            }
            fast = fast.next;
            if (fast == null) {
                return null;
            }
            fast = fast.next;
            slow = slow.next;
        } while (fast != slow);

        // 3、相遇点出发 + 起点出发，最终相遇
        ListNode p = head;
        ListNode q = slow; //第一次环内相遇点
        while (p != q) {
            p = p.next;
            q = q.next;
        }
        return p;
    }

    //方法二：哈希表——时间复杂度O(n) 空间复杂度O(n)
    //思路：如果我们用一个 Set 保存已经访问过的节点，我们可以遍历整个列表并返回
    //      第一个出现重复的节点。
    public ListNode detectCycle2(ListNode head) {
        if(head==null||head.next==null){
            return null;
        }
        Set<ListNode> set=new HashSet<>();
        while (head!=null){
            if(set.contains(head)){
                return head;
            }else {
                set.add(head);
                head=head.next;
            }
        }
        return null;
    }
}
