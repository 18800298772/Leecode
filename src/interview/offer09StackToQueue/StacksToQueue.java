package interview.offer09StackToQueue;

import java.util.Stack;

/**
 * Create by LiShuang on 2020/12/7 13:06
 **/

public class StacksToQueue {
    Stack s1=new Stack();
    Stack s2=new Stack();
    //添加
    public void add(int x){
        s2.push(x);
    }
    //删除
    public int  remove(){
        if(s2.isEmpty() && s1.isEmpty()){
            System.out.println("队列为空");
            return -1;
        }else{
            if(s2.isEmpty()){
             while(!s1.isEmpty()){
                 s2.push(s1.pop());
             }
            }else{
                return (int) s2.pop();
            }
        }
        return -1;
    }
    //查看队头
    public int  peek(){
        if(s2.isEmpty() && s1.isEmpty()){
            System.out.println("队列为空");
            return -1;
        }else{
            if(s2.isEmpty()){
                while(!s1.isEmpty()){
                    s2.push(s1.pop());
                }
            }else{
                return (int) s2.peek();
            }
        }
        return -1;
    }
    //队列长度
    public  int size(){
        return s1.size()+s2.size();
    }

}
