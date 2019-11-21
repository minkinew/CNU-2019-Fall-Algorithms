package MatrixChainMultiplication;

public class matrixChainMultiplication {
    public matrixChainMultiplication() {
    }

    public void matrixChainTable(int[] p, int[][] m) {
        int n = p.length - 1;
        for (int i = 1; i <= n; i++)
            m[i][i] = 0;
        for (int l = 2; l <= n; l++) {
            for (int i = 1; i <= n - l + 1; i++) {
                int j = i + l - 1;
                m[i][j] = Integer.MAX_VALUE;
                for (int k = i; k <= j - 1; k++) {
                    int q = m[i][k] + m[k + 1][j] + p[i - 1] * p[k] * p[j];
                    if (q < m[i][j]) {
                        m[i][j] = q;
                    }
                }
            }
        }
    }

    public void matrixChainInit(int[][] m) {
        for (int i = 0; i < m.length; i++)
            for (int j = 0; j < m[0].length; j++)
                m[i][j] = -1;
    }

    public void matrixChainShow(int[][] m) {
        for (int i = 1; i < m.length; i++) {
            for (int j = 1; j < m[0].length; j++) {
                if (m[i][j] != -1)
                    System.out.print(String.format("%8d", m[i][j]));
                else
                    System.out.print("        ");
            }
            System.out.println();
        }
    }

}