package SwordToOffer.Easy.offer22getKthFromEnd;

/**
 * Create by LiShuang on 2020/11/22 19:43
 *
 *链表中倒数第k个节点
 * 快慢指针，第一个指针先走k-1步，两个指针再一起走，则放第一个指针到底，后一个指针就在倒数第k个
 *
 **/

class getKthFromEnd {
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode L1=head;
        ListNode L2=head;
        for(int i=1;i<k;i++){
            L1=L1.next;
        }
        while (L1.next!=null){
            L1=L1.next;
            L2=L2.next;
        }
        return L2;
    }

}
public class ListNode {
      int val;
      ListNode next;
      ListNode(int x) { val = x; }
  }
