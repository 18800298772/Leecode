package interview.offer25mergeTwoLists;

/**
 * Create by LiShuang on 2020/12/20 15:18
 * 合并两个排序的链表
 * 输入两个单调递增的链表，输出两个链表合成后的链表，当然我们需要合成后的链表满足单调不减规则。
 **/
class ListNode{
    int val;
    ListNode next=null;

    public ListNode(int val) {
        this.val = val;
    }
}
//      1.题目告诉两个链表，那你首先应想到，如果给你的两个链表的其中一个是空的，则返回另外一个链表节点头就好了。
//       2.新定义一个链表的头节点，该结点就是要返回的结点哦。
//        3.定义三个指针，用来跑链表。
//        4.如果整个循环跳出，则表示其中一个链表为空，则把新链表尾节点的next域设置为不为空链表的指针就?了。
public class Merge {
    public ListNode Merge(ListNode list1,ListNode list2) {
        if (list1 == null) return list2;
        if (list2==null) return list1;
        ListNode newheadnode=null;
        if(list1.val<list2.val){
            newheadnode=list1;
            list1=list1.next;
        }else {
            newheadnode=list2;
            list2=list2.next;
        }
        ListNode temp=newheadnode;
        while (list1!=null && list2!=null){
            if(list1.val<list2.val){
                temp.next=list1;
                list1=list1.next;
            }else {
                temp.next=list2;
                list2=list2.next;
            }
            temp=temp.next;
        }
        if(list1==null){
            temp.next=list2;
        }else {
            temp.next=list1;}
        return newheadnode;
    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l2==null) return l1;
        if(l1==null) return l2;
        ListNode head=null;
        ListNode temp=head;
        while(l1!=null && l2!=null){
            if(l1.val<l2.val){
                temp.next=l1;
                l1=l1.next;
            }
            else{
                temp.next=l2;
                l2=l2.next;
            }
            temp=temp.next;
        }
        if(l1==null){
            temp.next=l2;
        }else{
            temp.next=l1;
        }
        return head.next;
    }
//    递归思想
//    每次合并之前都要比较两个链表的头节点值的大小，故能通过递归去做这个题。
    public ListNode Merge2(ListNode list1,ListNode list2) {
        if (list1 == null) return list2;
        if (list2==null) return list1;
        ListNode newheadnode=null;
        if(list1.val < list2.val){
            newheadnode = list1;
            //看清楚递归进去是确定 newHead.next 的值！！！
            newheadnode.next = Merge(list1.next,list2);
        }else{
            newheadnode = list2;
            newheadnode.next = Merge(list1,list2.next);
        }
        return newheadnode;
    }

    public static void main(String[] args) {
    }
//    public ListNode mergeTwoLists(ListNode l1(1-4-5), ListNode l2(1-2-3-6)) {函数return:1-2-3-4-5-6
//        l1.next=mergeTwoLists(l1:4-5,l2:1-2-3-6){ 函数return:1-2-3-4-5-6
//            l2.next=mergeTwoLists(l1:4-5,l2:2-3-6){ 函数return:2-3-5-6
//                l2.next=mergeTwoLists(l1:4-5,l2:3-6){ 函数return:3-4-5-6
//                    l2.next=mergeTwoLists(l1:4-5,l2:6){ 函数return:4-5-6
//                        l1.next=mergeTwoLists(l1:5,l2:6){ 函数return:5-6
//                            l1.next=mergeTwoLists(l1:null,l2:6){  函数return:6
//                                return l2:6
//                            }
//                            return l1;
//                        }
//                        return l1;
//                    }
//                    return l2;
//                }
//                return l2;
//            }
//            return l2;
//        }
//        return l1;
//    }

}
