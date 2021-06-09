package SwordToOffer.Easy.offer24ReverseList;

/**
 * Create by LiShuang on 2021/5/26 21:40
 * 反转链表
 **/

public class offer24 {
    /**
     * Definition for singly-linked list.*/
        public ListNode reverseList(ListNode head) {
            if(head==null){
                System.out.println("空链表");
                return null;
            }
            if(head.next==null){
                return head;
            }
            ListNode temp=head;
            ListNode next=head.next;
            head.next=null;
            head=next;
            while(head!=null){
                next=head.next;
                head.next=temp;
                temp=head;
                head=next;
            }
            return temp;
        }

}
