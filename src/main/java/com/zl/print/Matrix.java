package com.zl.print;

//打印矩阵
public class Matrix {
    public static void main(String[] args) {
        spiralMatrix(4);
    }

    /**
     * 打印螺旋矩阵，跟定数字n 打印n * n矩阵
     */
    public static void spiralMatrix(int n) {
        if (n <= 1) System.out.println(n);
        //首行
        int fr = 0;
        //最后一行
        int lr = n - 1;
        //第一列
        int fc = 0;
        //最后一列
        int lc = n - 1;
        int i = 1;
        int[][] res = new int[n][n];
        while (fr <= lr || fc <= lc) {
            if (fr == lr) {
                for (;fc <= lc; fc ++) {
                    res[fr][fc] = i++;
                }
            } else if (fc == lc) {
                for (;fr <= lr; fr ++) {
                    res[fr][fc] = i++;
                }
            } else {
                int tmpFc = fc;
                int tmpFr = fr;
                while (fc < lc) {
                    res[fr][fc] = i++;
                    fc++;
                }
                while (fr < lr) {
                    res[fr][fc] = i++;
                    fr++;
                }
                while (fc > tmpFc) {
                    res[fr][fc] = i++;
                    fc--;
                }
                while (fr > tmpFr) {
                    res[fr][fc] = i++;
                    fr--;
                }
            }
            ++fc;
            ++fr;
            --lc;
            --lr;
        }
        for (int j = 0; j < res.length; j++) {
            for (int k = 0; k < res[0].length; k++) {
                System.out.print(res[j][k] + " ");
            }
            System.out.println();
        }
    }
}
