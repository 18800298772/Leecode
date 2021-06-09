package SwordToOffer.Easy.offer52GetIntersectionNode;


/**
 * Create by LiShuang on 2020/12/10 15:23
 * 两个链表的第一个公共节点
 * 1.先算出两个链表的长度，如果最后的节点不是一个同一个，则不想交
 * 2.让长的链表先走abs(count1-count2)步.
 * 3.再让两个链表都往前走，一直到第一个相同的节点
 **/

public class getIntersectionNode {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        if(headA==null || headB==null){
            return null;
        }
        ListNode val1=headA;
        ListNode val2=headB;
        int count1=0;
        int count2=0;
        while(val1.next!=null){
            val1=val1.next;
            count1++;
        }
        while (val2.next!=null){
            val2=val2.next;
            count2++;
        }
        if(val1!=val2){
            return null;
        }
        if(count1<count2){
            val1=headA;
            val2=headB;
        }else {
            val1=headB;
            val2=headA;
        }
        int N=Math.abs(count1-count2);
        while (N>0){
            val2=val2.next;
            N--;
        }
        while (val1!=val2){
            val1=val1.next;
            val2=val2.next;
        }
        return val1;
    }
}
