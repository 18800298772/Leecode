package SwordToOffer.Easy.offer25;

import java.util.List;

/**
 * Create by LiShuang on 2020/11/22 20:06
 **/

public class mergeTwoLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode First=new ListNode(0);
        ListNode Tmp=First;
        ListNode Re=Tmp;
        while (l1!=null && l2!=null){
            if(l1.val<l2.val){
                Tmp.next=l1;
                l1=l1.next;
            }else
            {
                Tmp.next=l2;
                l2=l2.next;
            }
            Tmp=Tmp.next;
        }
        if(l1!=null){
            Tmp.next=l1;
        }else{
            Tmp.next=l2;
        }
        return Re.next;
    }

}
 class ListNode {
     int val;
     ListNode next;
     ListNode(int x) { val = x; }
 }