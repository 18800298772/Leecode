package SwordToOffer.Middle.offer35copyRandomList;

import java.util.HashMap;

/**
 * Create by LiShuang on 2021/5/27 22:52
 * 复杂链表的复制
 *
 **/

public class Solution {
 /*   方法一：哈希表
    利用哈希表的查询特点，考虑构建 原链表节点 和 新链表对应节点 的键值对映射关系，再遍历构建新链表各节点的 next 和 random 引用指向即可。
    算法流程：
    1.若头节点 head 为空节点，直接返回 null；
    2.初始化： 哈希表 dic ， 节点 cur 指向头节点；
    3.复制链表：
        3.1 建立新节点，并向 dic 添加键值对 (原 cur 节点, 新 cur 节点） ；
        3.2 cur 遍历至原链表下一节点；
    4.构建新链表的引用指向：
        4.1 构建新节点的 next 和 random 引用指向；
        4.2 cur 遍历至原链表下一节点；
    5. 返回值： 新链表的头节点 dic[cur] ；
    复杂度分析：
    1. 时间复杂度 O(N)： 两轮遍历链表，使用 O(N)时间。
    2. 空间复杂度 O(N) ： 哈希表 dic 使用线性大小的额外空间。*/
    public Node copyRandomList(Node head) {
        if(head==null)return null;
        HashMap<Node,Node> map=new HashMap();
        Node temp=head;
        //复制链表到哈希表
        while(temp!=null){
            map.put(temp,new Node(temp.val));
            temp=temp.next;
        }
        temp=head;
        //构建新的链表的指向
        while(temp!=null){
            map.get(temp).next=map.get(temp.next);
            map.get(temp).random=map.get(temp.random);
            temp=temp.next;
        }
        return map.get(head);
    }
   /* 方法二：拼接 + 拆分
    考虑构建 原节点 1 -> 新节点 1 -> 原节点 2 -> 新节点 2 -> …… 的拼接链表，如此便可在访问原节点的 random 指向节点的同时找到新对应新节点的 random 指向节点。

    算法流程：
    1.复制各节点，构建拼接链表:
        1.1设原链表为 node1→node2→⋯ ，构建的拼接链表如下所示：
            node1→node1new→node2→node2new→⋯
    2.构建新链表各节点的 random 指向：
        当访问原节点 cur 的随机指向节点 cur.random 时，对应新节点 cur.next 的随机指向节点为 cur.random.next 。
    3.拆分原 / 新链表：
        设置 pre / cur 分别指向原 / 新链表头节点，遍历执行 pre.next = pre.next.next 和 cur.next = cur.next.next 将两链表拆分开。
    4.返回新链表的头节点 res 即可。
    复杂度分析：
    时间复杂度 O(N)： 三轮遍历链表，使用 O(N)时间。
    空间复杂度 O(1)： 节点引用变量使用常数大小的额外空间。*/
   public Node copyRandomList_1(Node head) {
       if(head==null)return null;
       /*1.复制各节点，构建拼接链表:
       1.1设原链表为 node1→node2→⋯ ，构建的拼接链表如下所示：
       node1→node1new→node2→node2new→⋯*/
       Node temp=head;
       while (temp!=null){
           Node newCode=new Node(temp.val);
           newCode.next=temp.next;
           temp.next=newCode;
           temp=newCode.next;
       }
      /* 2.构建新链表各节点的 random 指向：
       当访问原节点 cur 的随机指向节点 cur.random 时，对应新节点 cur.next 的随机指向节点为 cur.random.next 。*/
       temp=head;
       while (temp!=null){
           if(temp.random!=null)
               temp.next.random=temp.random.next;
           temp=temp.next.next;
       }
       /*3.拆分原 / 新链表：
       设置 pre / cur 分别指向原 / 新链表头节点，遍历执行 pre.next = pre.next.next 和 cur.next = cur.next.next 将两链表拆分开。*/
       //新链表的临时指针
       temp=head.next;
       Node newHead=head.next;
       //原链表的临时指针
       Node pre=head;
       while (temp.next!=null){
           pre.next=pre.next.next;
           temp.next=temp.next.next;
           pre=pre.next;
           temp=temp.next;
           //下面这样是错误的
//           temp.next=temp.next.next;
//           pre.next=pre.next.next;
//           temp=temp.next;
//           pre=pre.next;
       }
       pre.next=null;  // 单独处理原链表尾节点
       return newHead;
   }

   //方法2官方题解
   public Node copyRandomList_2(Node head) {
       if(head == null) return null;
       Node cur = head;
       // 1. 复制各节点，并构建拼接链表
       while(cur != null) {
           Node tmp = new Node(cur.val);
           tmp.next = cur.next;
           cur.next = tmp;
           cur = tmp.next;
       }
       // 2. 构建各新节点的 random 指向
       cur = head;
       while(cur != null) {
           if(cur.random != null)
               cur.next.random = cur.random.next;
           cur = cur.next.next;
       }
       // 3. 拆分两链表
       cur = head.next;
       Node pre = head, res = head.next;
       while(cur.next != null) {
           pre.next = pre.next.next;
           cur.next = cur.next.next;
           pre = pre.next;
           cur = cur.next;
       }
       pre.next = null; // 单独处理原链表尾节点
       return res;      // 返回新链表头节点
   }


   //3.
   public Node copyRandomList_3(Node head) {
       //判断边界条件
       if(head == null){
           return null;
       }
       //1.复制next指针
       copy(head);
       //2.辅助random指针
       copyRandom(head);
       //3.分离
       return divide(head);

   }
    /*

    复制next节点
    */
    private void copy(Node head){
        // 7 8 9 -> 7 7' 8 8' 9 9'
        while(head != null){
            //创建一个新的节点
            Node clone = new Node(head.val);
            //定义一个临时变量，保存head.next
            Node temp = head.next;
            head.next = clone;
            clone.next = temp;
            //往下继续遍历
            head = clone.next;
        }
    }
    private void copyRandom(Node head){
        //遍历链表
        while(head != null){
            Node clone = head.next;
            if(head.random != null){
                Node temp = head.random;
                clone.random = temp.next;
            }
            //挑两步
            head = clone.next;
        }
    }
    private Node divide(Node head){
        Node cloneNode = head.next;
        Node cloneHead = cloneNode;
        head.next = cloneNode.next;
        head = head.next;
        while(head != null){
            //类似于双指针的用法 不符按更新cloneNode和head的位置
            cloneNode.next = head.next;
            head.next = head.next.next;
            head = head.next;
            cloneNode = cloneNode.next;

        }
        System.out.println();
        return cloneHead;
    }


}
