package interview.offer52.getIntersectionNode;


import java.util.HashMap;

/**
 * Create by LiShuang on 2020/12/7 12:15
 * 两个无环链表判断是否相交
 **/

public class getIntersectNode_Noloop {
    public static Node noLoop(Node head1, Node head2) {
        if (head1 == null || head2 == null) {
            return null;
        }
        Node cur1 = head1;
        Node cur2 = head2;
        int n = 0;
        //找到两个链表的最后一个元素
        while (cur1.next != null) {
            n++;
            cur1 = cur1.next;
        }
        while (cur2.next != null) {
            n--;
            cur2 = cur2.next;
        }
        //二者最后一个元素是否相同
        if (cur1 != cur2) {
            return null;
        }
        //cur1始终是短的那个链表
        //n>0则第一个链表长
        cur1 = n > 0 ? head1 : head2;
        //cur2是另外一个链表
        cur2 = cur1 == head1 ? head2 : head1;
        //两个链表的长度相差n
        n = Math.abs(n);
        //长链表向后移动n
        while (n != 0) {
            n--;
            cur1 = cur1.next;
        }
        //找到相同节点
        while (cur1 != cur2) {
            cur1 = cur1.next;
            cur2 = cur2.next;
        }
        return cur1;
    }

    public static void main(String[] args) {
        HashMap map=new HashMap();
        


    }
}


