package interview.offer40FindKMinNums;

import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 *题目：选取数组中最小的k个数
 * 使用最大堆
 *
 * 如果用普通的排序算法，排序之后自然可以得到最小的k个数，但时间复杂度高达O(NlogN)，
 * 且普通的排序算法均属于内部排序，需要一次性将全部数据装入内存，对于求解海量数据的top k问题是无能为力的。
 * 这里实现了一种时间复杂度为O(Nlogk)的有效算法：
 * 初始时一次性从文件中读取k个数据，并建立一个有k个数的最大堆，代表目前选出的最小的k个数。
 * 然后从文件中一个一个的读取剩余数据，如果读取的数据比堆顶元素小，则把堆顶元素替换成当前的数，然后从堆顶向下重新进行堆调整；
 * 否则不进行任何操作，继续读取下一个数据。
 * 直到文件中的所有数据读取完毕，堆中的k个数就是海量数据中最小的k个数
 * （如果是找最大的k个数，则使用最小堆）
 * Create by LiShuang on 2020/12/7 9:16
 *
 **/

public class FindKMinNums {
    //堆排序算法，构建最大堆。时间复杂度为O(nlogk)
    /**
     * 维护一个有k个数的最大堆，代表目前选出的最小的k个数
     *
     * @param read 实际场景中，read提供的数据需要从文件中读取，这里为了方便用数组表示
     * @param k
     * @return
     */
    public static int[] getKMinsByHeap(int[] read, int k) {
        if (k < 1 || k > read.length) {
            return read;
        }
        int[] kHeap = new int[k];
        for (int i = 0; i < k; i++) {   // 初始时一次性从文件中读取k个数据
            kHeap[i] = read[i];
        }
        buildHeap(kHeap, k);            // 建堆，时间复杂度O(k)
        for (int i = k; i < read.length; i++) { // 从文件中一个一个的读取剩余数据
            if (read[i] < kHeap[0]) {
                kHeap[0] = read[i];
                heapify(kHeap, 0, k);   // 从堆顶开始向下进行调整，时间复杂度O(logk)
            }
        }
        return kHeap;
    }

    /**
     * 建堆函数
     *
     * @param arr
     * @param n
     */
    public static void buildHeap(int[] arr, int n) {
        for (int i = (n  - 1)/2; i >= 0; i--) {
            heapify(arr, i, n);
        }
    }
    /**
     * 从arr[i]向下进行堆调整
     *
     * @param arr
     * @param i
     * @param heapSize
     */
    public static void heapify(int[] arr, int i, int heapSize) {
        int leftChild = 2 * i + 1;
        int rightChild = 2 * i + 2;
        int max = i;
        if (leftChild < heapSize && arr[leftChild] > arr[max]) {
            max = leftChild;
        }
        if (rightChild < heapSize && arr[rightChild] > arr[max]) {
            max = rightChild;
        }
        if (max != i) {
            swap(arr, i, max);
            heapify(arr, max, heapSize);  // 堆结构发生了变化，继续向下进行堆调整
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i <= arr.length-1; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }


//    使用PriorityQueue当作Heap，每次返回最大的值。
//    Time complexity is O(nlogk)

    public static int[] GetLeastNumbers_Solution(int[] input, int k) {
        int[] arr=new int[k];
        if (input == null || k <= 0 || k > input.length) {
            return new int[]{};
        }
        Queue<Integer> queue = new PriorityQueue<>(k, Collections.reverseOrder());

        for (int i = 0; i < input.length; i++) {

            if (queue.size() < k) {
                queue.offer(input[i]); //添加元素
            } else {
                if (input[i] < queue.peek()) {   //返回第一个元素
                    queue.poll();  //删除元素
                    queue.offer(input[i]);
                }
            }
        }
        for (int i=0;i<k;i++){
            arr[i]=queue.poll();
        }
        return arr;
    }
    public static void main(String[] args) {
        int[] arr = {6, 9, 1, 3, 1, 2, 2, 5, 6, 1, 3, 5, 9, 7, 2, 5, 6, 1, 9};
        // sorted : { 1, 1, 1, 1, 2, 2, 2, 3, 3, 5, 5, 5, 6, 6, 6, 7, 9, 9, 9 }
        printArray(getKMinsByHeap(arr, 10));
        int[] result = GetLeastNumbers_Solution(arr, 10);
        for (int re : result) {
            System.out.println(re);
        }
    }
}


// *题目：选取数组中最大的k个数
class FindKMaxNums {
    //堆排序算法，构建最大堆。时间复杂度为O(nlogk)

    /**
     * 维护一个有k个数的最大堆，代表目前选出的最小的k个数
     *
     * @param read 实际场景中，read提供的数据需要从文件中读取，这里为了方便用数组表示
     * @param k
     * @return
     */
    public static int[] getKMaxsByHeaps(int[] read, int k) {
        if (k < 1 || k > read.length) {
            return read;
        }
        int[] kHeap = new int[k];
        for (int i = 0; i < k; i++) {   // 初始时一次性从文件中读取k个数据
            kHeap[i] = read[i];
        }
        buildHeap(kHeap, k);            // 建堆，时间复杂度O(k)
        for (int i = k; i < read.length; i++) { // 从文件中一个一个的读取剩余数据
            if (read[i] > kHeap[0]) {
                kHeap[0] = read[i];
                heapify(kHeap, 0, k);   // 从堆顶开始向下进行调整，时间复杂度O(logk)
            }
        }
        return kHeap;
    }

    /**
     * 建堆函数
     *
     * @param arr
     * @param n
     */
    public static void buildHeap(int[] arr, int n) {
        for (int i = (n - 1) / 2; i >= 0; i--) {
            heapify(arr, i, n);
        }
    }

    /**
     * 从arr[i]向下进行堆调整
     *
     * @param arr
     * @param i
     * @param heapSize
     */
    public static void heapify(int[] arr, int i, int heapSize) {
        int leftChild = 2 * i + 1;
        int rightChild = 2 * i + 2;
        int max = i;
        if (leftChild < heapSize && arr[leftChild] < arr[max]) {
            max = leftChild;
        }
        if (rightChild < heapSize && arr[rightChild] < arr[max]) {
            max = rightChild;
        }
        if (max != i) {
            swap(arr, i, max);
            heapify(arr, max, heapSize);  // 堆结构发生了变化，继续向下进行堆调整
        }
    }

    public static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    public static void printArray(int[] arr) {
        for (int i = 0; i <= arr.length - 1; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }


//    使用PriorityQueue当作Heap，每次返回最大的值。
//    Time complexity is O(nlogk)

    public static int[] GetLeastNumbers_Solution(int[] input, int k) {
        int[] arr = new int[k];
        if (input == null || k <= 0 || k > input.length) {
            return new int[]{};
        }
        Queue<Integer> queue = new PriorityQueue<>(k);

        for (int i = 0; i < input.length; i++) {

            if (queue.size() < k) {
                queue.offer(input[i]); //添加元素
            } else {
                if (input[i] > queue.peek()) {   //返回第一个元素
                    queue.poll();  //删除元素
                    queue.offer(input[i]);
                }
            }
        }
        for (int i = 0; i < k ; i++) {
            arr[i] = queue.poll();
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {6, 9, 1, 3, 1, 2, 2, 5, 6, 1, 3, 5, 9, 7, 2, 5, 6, 1, 9};
        // sorted : { 1, 1, 1, 1, 2, 2, 2, 3, 3, 5, 5, 5, 6, 6, 6, 7, 9, 9, 9 }
        printArray(getKMaxsByHeaps(arr, 10));
        int[] result = GetLeastNumbers_Solution(arr, 10);
        for (int re : result) {
            System.out.println(re);
        }
    }
}
