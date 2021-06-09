package SwordToOffer.Easy.Offer09;

import java.util.Stack;

/**
 * Create by LiShuang on 2020/11/21 19:43
 **/

 class CQueue {
     Stack<Integer> stack1;
     Stack<Integer> stack2;

    public CQueue() {
        stack1=new Stack();
        stack2=new Stack();
    }

    public void appendTail(int value) {
        stack1.push(value);
    }

    public int deleteHead() {
        if(stack2.isEmpty()){
            while(!stack1.empty()){
                stack2.push(stack1.pop());
            }
        }
        if(stack2.isEmpty()){
            return -1;
        }else {

          return stack2.pop();
        }
    }

}
