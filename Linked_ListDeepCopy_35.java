//复杂链表的复制（或单链表的深度拷贝）
//题目描述：请实现 copyRandomList 函数，复制一个复杂链表。在复杂链表中，每个
//          节点除了有一个 next 指针指向下一个节点，还有一个 random 指针指向
//          链表中的任意节点或者 null。

//示例1：
//输入：head = [[7,null],[13,0],[11,4],[10,2],[1,0]]
//输出：[[7,null],[13,0],[11,4],[10,2],[1,0]]
//示例 2：
//输入：head = [[3,null],[3,0],[3,null]]
//输出：[[3,null],[3,0],[3,null]]
//示例 3：
//输入：head = []
//输出：[]
//解释：给定的链表为空（空指针），因此返回 null。


class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}

public class Linked_ListDeepCopy_35 {
    //解题思路：1、先复制所有的结点
    //          2、处理random指向
    //      时间复杂度：O(N)。
    //      空间复杂度：O(N)。
    public Node copyRandomList(Node head) {
        //先复制链表并将复制的新链表连接到旧链表上
        if(head==null){
            return null;
        }
        Node p1=head;
        while (p1!=null){
            Node p2=new Node(p1.val);
            p2.next=p1.next;
            p1.next=p2;

            p1=p2.next;
        }
        //处理新链表random的指向
        p1=head;
        while (p1!=null){
            Node p2=p1.next;
            if (p1.random!=null){
                p2.random=p1.random.next;
            }
            p1=p2.next;
        }
        //将新旧链表分开，最终返回新链表
        p1=head;
        Node newHead=head.next;
        while (p1!=null){
            Node p2=p1.next;

            p1.next=p2.next;
            if (p2.next!=null){
                p2.next=p2.next.next;
            }
            p1=p1.next;
        }
        return newHead;
    }
}
