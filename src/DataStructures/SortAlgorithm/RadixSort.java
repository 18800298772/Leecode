package DataStructures.SortAlgorithm;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Create by LiShuang on 2021/6/8 14:28
 * 基数排序；
 * 不能是负数或小数
 * 解决负数的问题：如果含有负数，则求出最小值，如果最小值小于0，则在排序前将数组每个数减去最小值，排序后每个数加上最小值
 **/

public  class RadixSort {

    public static void main(String[] args) {
        int[] arr={53,3,542,748,-14,214,0};
        //radix(arr);
        radix_list(arr);
        System.out.println(Arrays.toString(arr));
    }

    //基数排序方法
    public static void radix(int[] arr) {
        //1. 得到数组中最大的数的位数
        int max=arr[0];
        for (int a:arr) if(a>max)max=a;
        //得到最大数是几位数
        int maxLength=(max+"").length();
        //定义一个二维数组，表示10个桶, 每个桶就是一个一维数组
        //说明
        //1. 二维数组包含10个一维数组
        //2. 为了防止在放入数的时候，数据溢出，则每个一维数组(桶)，大小定为arr.length
        int[][] bucket=new int[10][arr.length];
        //为了记录每个桶中，实际存放了多少个数据,我们定义一个一维数组来记录各个桶的每次放入的数据个数
        //可以这里理解
        //比如：bucketElementCounts[0] , 记录的就是  bucket[0] 桶的放入数据个数
        int[] bucketElementCounts=new int[10];
        //对数组中的数的每一位执行相同的入桶和出桶的操作
        for(int i=0,n=1;i<maxLength;i++,n*=10){
            for(int j=0;j<arr.length;j++){
                //入桶
                //取出个(arr[j]/1%10)/十(arr[j]/10%10)/百(arr[j]/100%10)的数字
                int digitofElement=arr[j]/n%10;
                //放入到对应的桶中
                bucket[digitofElement][bucketElementCounts[digitofElement]]=arr[j];
                bucketElementCounts[digitofElement]++;
            }
            //出桶
            //按照这个桶的顺序(一维数组的下标依次取出数据，放入原来数组)
            int index=0;
            for(int j=0;j< bucketElementCounts.length;j++){
                //如果桶中，有数据，我们才放入到原数组
                if(bucketElementCounts[j]!=0){
                    //将该桶中的每一个数取出
                    for(int k=0;k<bucketElementCounts[j];k++){
                        //取出元素放入到arr
                        arr[index]=bucket[j][k];
                        index++;
                    }
                    //第一轮处理后，需要将桶清空
                    //必须将bucketElementCounts[j]=0;就表示这个桶中没有元素了
                    bucketElementCounts[j]=0;
                }
            }
        }
    }
    //优化前当数组长度过长时，需要创建二维数组占用过大n*10，不可以处理负数
    //基数排序方法
    //优化，使用ArrayList[] bucket，只占用额外内存n，可以处理负数
    public static void radix_list(int[] arr) {
        //如果含有负数，则求出最小值，如果最小值小于0，则在排序前将数组每个数减去最小值，排序后每个数加上最小值
        int min=arr[0];
        for (int a:arr) if(a<min) min=a;
        //1. 得到数组中最大的数的位数
        int max=arr[0];
        for (int a:arr) if(a>max) max=a;

        if(min<0){
            for(int i=0;i<arr.length;i++)arr[i]-=min;
        }

        //得到最大数是几位数
        int maxLength=(max+"").length();

        //定义一个ArrayList[]，表示10个桶, 每个桶就是ArrayList
        //说明
        //1. ArrayList[]包含10个ArrayList
        //2. 每次通过ArrayList.add的方式添加元素，一定要通过new ArrayList()初始化，不然bucket为null
        ArrayList[] bucket={new ArrayList(),new ArrayList(),new ArrayList(), new ArrayList(),new ArrayList(),new ArrayList(), new ArrayList(),new ArrayList(),new ArrayList(),new ArrayList()};
        //不需要记录每个桶的数量，当ArrayList为空（size==0）时说明这个桶为空
        //对数组中的数的每一位执行相同的入桶和出桶的操作
        for(int i=0,n=1;i<maxLength;i++,n*=10){
            for(int j=0;j<arr.length;j++){
                //入桶
                //取出个(arr[j]/1%10)/十(arr[j]/10%10)/百(arr[j]/100%10)的数字
                int digitofElement=arr[j]/n%10;
                //放入到对应的桶中
                bucket[digitofElement].add(arr[j]);
            }
            //出桶
            //按照这个桶的顺序，每次去除数据后remove,每次都是取ArrayList中的第一个数，当size为0时说明ArrayList为空，其中数全部被取出
            int index=0;
            for(int j=0;j<bucket.length;j++){
                //如果桶中，有数据，我们才放入到原数组
                    //将该桶中的每一个数取出
                   while (bucket[j].size()!=0){
                        //取出元素放入到arr
                        arr[index]= (int) bucket[j].remove(0);
                        index++;
                    }
                    //第一轮处理后，需要将桶清空
                    //必须将bucketElementCounts[j]=0;就表示这个桶中没有元素
            }
        }
        //如果含有负数，则求出最小值，如果最小值小于0，则在排序前将数组每个数减去最小值，排序后每个数加上最小值
        if(min<0){
            for(int i=0;i<arr.length;i++)arr[i]+=min;
        }
    }
}
