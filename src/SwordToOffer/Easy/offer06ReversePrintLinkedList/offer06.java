package SwordToOffer.Easy.offer06ReversePrintLinkedList;

import java.util.Stack;

/**
 * Create by LiShuang on 2021/5/26 22:02
 *从尾到头打印链表
 **/

public class offer06 {
    //方法1：将每个节点的内容压入栈中，在出栈，就是倒叙了
    public int[] reversePrint(ListNode head) {
        Stack stack=new Stack();
        ListNode temp=head;
        int Count=0;
        if(temp==null){
            return new int[0];
        }
        while(temp!=null){
            //不可以stack.push(temp);
            stack.push(temp.val);
            temp=temp.next;
            Count++;
        }
        int[] L=new int[Count];
        for(int i=0;i<Count;i++){
            L[i]=(int)stack.pop();
        }
        return L;
    }
    //方法2：结合倒叙链表的思想，将链表倒过来再逐一打印
    public int[] reversePrint_1(ListNode head){
        if(head==null){
            return new int[0];
        }
        int count=0;
        ListNode cur=null;
        while (head!=null){
            ListNode pre=head.next;
            head.next=cur;
            cur=head;
            head=pre;
            count++;
        }
        int[] L=new int[count];
        for(int i=0;i<count;i++){
            L[i]=cur.val;
            cur=cur.next;
        }
        return L;
    }
}
