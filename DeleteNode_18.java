//移除链表元素_203  /  删除链表的节点_18  (两个题是一样的意思，一样的解法)

//题目描述：删除链表中等于给定值 val 的所有节点。
//   给定单向链表的头指针和一个要删除的节点的值，定义一个函数删除该节点。
//   返回删除后的链表的头节点。

//示例1:
//输入: 1->2->6->3->4->5->6, val = 6
//输出: 1->2->3->4->5
//示例2：
//输入: head = [4,5,1,9], val = 5
//输出: [4,1,9]
//解释: 给定你链表中值为5的第二个节点，那么在调用了你的函数之后，
//      该链表应变为 4 -> 1 -> 9.

//这里给了四种方法
public class DeleteNode_18 {
//———————时间复杂度O(n) 空间复杂度O(1)——————————————————————————————
    public ListNode deleteNode1(ListNode head, int val) {
        //1、强行给第一个结点找一个前驱
        ListNode node=new ListNode(0);
        node.next=head;

        ListNode prev=node;
        ListNode cur=head;
        while(cur!=null){
            if(cur.val==val){
                prev.next=cur.next;
            }else{
                prev=cur;
            }
            cur=cur.next;
        }
        return node.next;
    }

//———————时间复杂度O(n) 空间复杂度O(1)——————————————————————————————
        public static ListNode deleteNode2(ListNode head,int val){
            //2、判断如果是第一个结点，特殊处理  //见********
            ListNode cur=head;
            ListNode prev=null;
            while (cur!=null){
                if(cur.val==val){
                    if (cur == head) {//********
                        head = cur.next;
                    } else {
                        prev.next = cur.next;
                    }
                } else {
                    prev = cur;
                }
                cur = cur.next;
            }

            return head;
        }

//———————时间复杂度O(n) 空间复杂度O(n)——————————————————————————————
        public ListNode deleteNode3(ListNode head, int val) {
            //3、将不是和指定元素相等的其他元素结点插入到新链表中  //见********
            ListNode result = null;
            ListNode last = null;   // 记录目前 result 中的最后一个结点

            ListNode cur = head;
            while (cur != null) {
                if (cur.val == val) {
                    cur = cur.next;
                    continue;
                }

                ListNode next = cur.next;

                cur.next = null;
                if (result == null) {
                    result = cur;  //********
                } else {
                    last.next = cur;  //尾插
                }

                last = cur;

                cur = next;
            }
            return result;
        }

//———————时间复杂度O(n) 空间复杂度O(1)——————————————————————————————
        public ListNode deleteNode4(ListNode head, int val) {
            // 4、先避开第一个结点，回头再说  //见********
            if (head == null) {
                return null;
            }
            ListNode prev = head;//********
            ListNode cur = head.next;//********

            while (cur != null) {
                if (cur.val == val) {
                    prev.next = cur.next;
                } else {
                    prev = cur;
                }

                cur = cur.next;
            }

            if (head.val == val) {
                head = head.next;
            }

            return head;
    }
}
