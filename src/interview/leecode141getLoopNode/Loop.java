package interview.leecode141getLoopNode;

/**
 * Create by LiShuang on 2020/12/7 12:42
 **/

public class Loop {
    /*环形链表
     * 判断是否存在环，如果存在，则找出环的入口点。
     * 入口点找法：快慢指针，块指针走两步，满指针走一步，如果存在循环，则在慢指针走完环前，总会和快指针相遇。
     * 从头指针和相遇点同时向后走，相遇的点必定是入口点。
     *
     * 推理过程：
     * 当fast若与slow相遇时，slow肯定没有走遍历完链表，见注释（１）而fast已经在环内循环了n圈(1<=n)
     * 假设slow走了s步，则fast走了2s步（fast步数还等于s 加上在环上多转的n圈），设环长为r，则：
     * 2s = s + nr 　 　s= nr
     * 设整个链表长L，入口环与相遇点距离为x，起点到环入口点的距离为a。 　　
     * * a + x = nr 　　a + x = (n – 1)r +r = (n-1)r + L - a 　　a = (n-1)r + (L – a – x)
     * (L – a – x)为相遇点到环入口点的距离，由此可知，从链表头到环入口点等于(n-1)循环内环+相遇点到环入口点，
     * 于是我们从链表头、与相遇点分别设一个指针，每次各走一步，两个指针必定相遇，且相遇第一点为环入口点。
     * */
    public static Node getLoopNode(Node head) {
        if (head == null || head.next == null || head.next.next == null) {
            return null;
        }
        Node n1 = head.next; // n1 -> slow
        Node n2 = head.next.next; // n2 -> fast
        while (n1 != n2) {
            if (n2.next == null || n2.next.next == null) {
                return null;
            }
            n2 = n2.next.next;
            n1 = n1.next;
        }
        n2 = head; // n2 -> walk again from head
        while (n1 != n2) {
            n1 = n1.next;
            n2 = n2.next;
        }
        return n1;
    }
}
