package DataStructures.Stack;

/**
 * Create by LiShuang on 2021/5/30 21:16
 * 用单链表实现栈
 * 头结点是栈顶，不是栈的一部分，真正的栈顶的值是top.next
 **/

public class SingleLinkedListSrackMedo {
    public static void main(String[] args) {

        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        Node node4 = new Node(4);
        SingleLinkedListStack singleLinkedListStack = new SingleLinkedListStack();
        singleLinkedListStack.push(node1);
        singleLinkedListStack.push(node2);
        singleLinkedListStack.push(node3);
        singleLinkedListStack.push(node4);
        singleLinkedListStack.pop();
        singleLinkedListStack.show();

    }

}

class SingleLinkedListStack {
    private Node top = new Node(-1);// 定义一个头指针代表栈顶

    // 判断栈是否为空
    public boolean isEmpty() {
        return top.getNext() == null;
    }

    // 入栈，入栈的时候采用头插法
    public void push(Node node) {

        if (top.getNext() == null) {// 第一个节点的插入
            top.setNext(node);
            return;
        }
        // 头插法
        Node temp = top.getNext();// 定义一个临时变量使其指向top节点的下一个节点
        top.setNext(node);
        node.setNext(temp);

    }

    // 出栈
    public void pop() {
        if (top.getNext() == null) {
            System.out.println("栈为空！不能出栈！");
            return;
        }
        System.out.println("节点为：" + top.getNext().getValue());
        top = top.getNext();
    }

    // 遍历栈
    public void show() {
        if (isEmpty()) {
            System.out.println("栈为空！");
            return;
        }
        Node temp = top;
        while (temp.getNext() != null) {
            System.out.println("节点为：" + temp.getNext().getValue());
            temp = temp.getNext();
        }
    }

    /**
     * Create by LiShuang on 2021/5/30 21:10
     **/
}
class Node {
    private  int value;
    private Node Next;

    public Node(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public Node getNext() {
        return Next;
    }

    public void setNext(Node next) {
        this.Next = next;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                ", Next=" + Next +
                '}';
    }
}

