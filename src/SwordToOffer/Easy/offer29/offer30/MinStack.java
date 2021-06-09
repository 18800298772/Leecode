package SwordToOffer.Easy.offer29.offer30;

import java.util.Stack;

/**
 * Create by LiShuang on 2020/11/26 11:21
 **/

public class MinStack {


    Stack<Integer> A,B;
    /** initialize your data structure here. */
    public MinStack() {
        A = new Stack();
        B = new Stack();
    }

    public void push(int x) {
        A.push(x);
        if (B.empty() || B.peek() >= x) {
            B.push(x);
        }
    }

    public void pop() {
        if(A.pop()==B.peek()){
            B.pop();
        }
    }

    public int top() {
        return A.peek();
    }

    public int min() {
        return B.peek();
    }
}
