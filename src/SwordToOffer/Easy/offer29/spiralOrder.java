package SwordToOffer.Easy.offer29;


/**
 * Create by LiShuang on 2020/11/25 9:34
 **/

public class spiralOrder {
    public static int[] spiralOrder(int[][] matrix) {
        if(matrix.length==0){
            return new int[]{};
        }
        int begin=0;
        int[] Re=new  int[matrix.length*matrix[0].length];
        int index=0;
        int M=matrix.length-1;
        int N=matrix[0].length-1;
        while(begin<=M && begin<=N){
            for(int i=begin;i<=N;i++){
                Re[index++]=matrix[begin][i];
            }
            for (int i = begin+1; i <= M; i++) {
                Re[index++]=matrix[i][N];
            }

            for (int i = N-1; i >begin && M>begin; i--) {
                Re[index++]=matrix[M][i];
            }

            for (int i = M; i > begin && N>begin ; i--) {
                Re[index++]=matrix[i][begin];
            }
            begin++;
            M--;
            N--;
        }
        return Re;
    }

    public static void main(String[] args) {
        int[][] Nums={{3},{2}};
        int[] Result=spiralOrder(Nums);
        System.out.println(Result);
    }
}
