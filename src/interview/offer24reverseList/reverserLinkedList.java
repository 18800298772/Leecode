package interview.offer24reverseList;

/**
 * Create by LiShuang on 2020/12/7 12:56
 **/

public class reverserLinkedList {

    //创建一个空指针，头结点指向这个空指针
    public static Node reverseListNode(Node head){
        if (head == null || head.next == null){
            return head;
        }
        //前一个节点指针
        Node preNode = null;
        //当前节点指针
        Node curNode = head;
        //下一个节点指针
        Node nextNode ;

        while (curNode != null){
            nextNode = curNode.next;//nextNode 指向下一个节点
            preNode.next=curNode;//将当前节点next域指向前一个节点
            preNode = curNode;//preNode 指针向后移动
            curNode = nextNode;//curNode指针向后移动
        }
        return preNode;
    }

}
