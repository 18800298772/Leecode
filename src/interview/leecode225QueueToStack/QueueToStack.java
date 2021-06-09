package interview.leecode225QueueToStack;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Create by LiShuang on 2020/12/7 13:28
 **/

public class QueueToStack {
    Queue q1=new ArrayDeque();
    Queue q2=new ArrayDeque();
    //进栈
    public void push(int x){
        if(q1.isEmpty()&&q2.isEmpty())
        {
            q1.offer(x);
        }else if(!q1.isEmpty()){
            q1.offer(x);
        }else if(!q2.isEmpty()){
            q2.offer(x);
        }
    }
    //出栈
    public int pop(){
        if(q1.isEmpty()&&q2.isEmpty()){
            System.out.println("队列为空");
            return -1;
        }else if(q1.isEmpty()){
            while (q2.size()>1){
                q1.offer(q2.poll());
            }
            return (int) q2.poll();
        }else if(q2.isEmpty()){
            while (q1.size()>1){
                q2.offer(q1.poll());
            }
            return (int) q1.poll();
        }
        return -1;
    }
    //查看栈顶
    public int peek(){
        int peek = -1;
        if(q1.isEmpty()&&q2.isEmpty()){
            System.out.println("队列为空");
            return -1;
        }else if(q1.isEmpty()){
            while (q2.size()>1){
                q1.offer(q2.poll());
            }
            peek= (int) q2.peek();
        }else if(q2.isEmpty()){
            while (q1.size()>1){
                q2.offer(q1.poll());
            }
            peek= (int) q1.peek();
        }
        return peek;
    }
    //查看长度
    public int count(){
        return q1.size()+ q2.size();
    }
}
