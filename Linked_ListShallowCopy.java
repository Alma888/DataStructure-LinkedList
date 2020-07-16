//链表的浅拷贝——时间复杂度O(n) 空间复杂度O(n)
public class Linked_ListShallowCopy {
    //链表的浅拷贝，只是将将引用拷贝了一份
    public Node Copy(Node head){
        Node cur=head;
        Node result=null; //创建新链表
        Node last=null;  //新链表的尾结点

        while (cur!=null){
            Node node=new Node(cur.val);
            if(result==null){
                result=node;
            }else {
                last.next=node;
            }
            last=node;
            cur=cur.next;
        }
        return result;
    }
}
