package DataStructures.Hashtab;

import java.util.Scanner;

/**
 * Create by LiShuang on 2021/6/9 20:09
 * 实现hashtable
 **/
public class hashTabDemo{
    public static void main(String[] args) {
        hashTab hashTab=new hashTab(7);
        String key="";
        Scanner scanner=new Scanner(System.in);
        while (true){
            System.out.println("add:  添加雇员");
            System.out.println("list: 显示雇员");
            System.out.println("find: 查找雇员");
            System.out.println("exit: 退出系统");

            key=scanner.next();
            switch (key){
                case "add":
                    System.out.println("输入id");
                    int id=scanner.nextInt();
                    System.out.println("输入名字");
                    String name = scanner.next();
                    Emp emp=new Emp(id,name);
                    hashTab.add(emp);
                    break;
                case "list":
                    hashTab.list();
                    break;
            }
        }

    }
}


class hashTab {
    private EmpLinkedList[] empLinkedListArray;
    private int size;


    //构造器
    public hashTab(int size) {
        this. size= size;
        //现在每个链表都是空，整个数组也都是空的，都不可以被访问，必须初始化每个链表
        empLinkedListArray=new EmpLinkedList[size];
        for(int i=0;i<size;i++){
            empLinkedListArray[i]=new EmpLinkedList();
        }
    }
    //添加雇员
    public void add(Emp emp){
        //根据员工的id ,得到该员工应当添加到哪条链表
        int empLinkedListNO=HashFun(emp.id);
        //将emp 添加到对应的链表中
        empLinkedListArray[empLinkedListNO].add(emp);
    }

    //遍历所有的链表,遍历hashtab
    public void list(){
        for(int i=0;i<size;i++){
            empLinkedListArray[i].list(i);
        }
    }

    //编写散列函数, 使用一个简单取模法
    public int HashFun(int id) {return id%size;}

}
//表示一个雇员
class Emp{
    public  int  id;
    public String name;
    public Emp next;

    public Emp(int id, String name) {
        super();
        this.id = id;
        this.name = name;
    }
}
//创建EmpLinkedList ,表示链表
class EmpLinkedList{
    //头指针，执行第一个Emp,因此我们这个链表的head 是直接指向第一个Emp
    private Emp head;//默认null
    //添加雇员到链表
    //说明
    //1. 假定，当添加雇员时，id 是自增长，即id的分配总是从小到大
    //   因此我们将该雇员直接加入到本链表的最后即可
    public void add(Emp emp){
        //如果是添加第一个雇
        if(head==null){
            head=emp;
            return;
        }
        //如果不是第一个雇员，则使用一个辅助的指针，帮助定位到最后
        Emp curEmp=head;
        while (true){
            if(curEmp.next==null){
                break;
            }
            curEmp=curEmp.next;
        }
        //退出时直接将emp 加入链表
        curEmp.next=emp;
    }
    public void list(int no){
        if(head==null){
            System.out.println("第 "+(no+1)+" 链表为空");
            return;
        }
        System.out.println("第 "+(no+1)+" 链表的信息为");
        Emp curEmp=head;
        while (true){
            System.out.printf("=> id = %d , name = %s \t",curEmp.id,curEmp.name);
            if(curEmp.name==null){
                break;
            }
            curEmp=curEmp.next;
        }
        System.out.println();
    }
}
