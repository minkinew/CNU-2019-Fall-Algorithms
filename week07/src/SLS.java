import java.util.Stack;

public class SLS {
    public static float SegmentedLeastSquares(float[] matrix) {
        int N = (int) matrix[0];
        int[] opt_segment = new int[N + 1];
        int infinite = Integer.MAX_VALUE;

        float[] x_cumulative = new float[N + 1];
        float[] y_cumulative = new float[N + 1];
        float[] xy_cumulative = new float[N + 1];
        float[] xSqr_cumulative = new float[N + 1];

        float[] OPT = new float[N + 1];
        float[][] SSE_a = new float[N + 1][N + 1];
        float[][] SSE_b = new float[N + 1][N + 1];
        float[][] e = new float[N + 1][N + 1];
        float c = matrix[matrix.length - 1];

        x_cumulative[0] = 0;
        y_cumulative[0] = 0;
        xy_cumulative[0] = 0;
        xSqr_cumulative[0] = 0;

        for (int j = 1; j <= N; j++) {
            x_cumulative[j] = x_cumulative[j - 1] + matrix[j * 2 - 1];
            y_cumulative[j] = y_cumulative[j - 1] + matrix[j * 2];
            xy_cumulative[j] = xy_cumulative[j - 1] + matrix[j * 2 - 1] * matrix[j * 2];
            xSqr_cumulative[j] = xSqr_cumulative[j - 1] + matrix[j * 2 - 1] * matrix[j * 2 - 1];

            for (int i = 1; i < j; i++) {
                float n = j - i + 1;
                float x_sum = x_cumulative[j] - x_cumulative[i - 1];
                float y_sum = y_cumulative[j] - y_cumulative[i - 1];
                float xy_sum = xy_cumulative[j] - xy_cumulative[i - 1];
                float xSqr_sum = xSqr_cumulative[j] - xSqr_cumulative[i - 1];

                SSE_a[i][j] = ((n * xy_sum - x_sum * y_sum) / (n * xSqr_sum - x_sum * x_sum));
                SSE_b[i][j] = ((y_sum - SSE_a[i][j] * x_sum) / n);

                for (int k = i; k <= j; k++) {
                    e[i][j] += Math.pow(matrix[k * 2] - SSE_a[i][j] * matrix[k * 2 - 1] - SSE_b[i][j], 2);
                }
            }
        }

        OPT[0] = 0;
        opt_segment[0] = 0;

        int a = 1;
        while (a <= N) {
            float min = infinite;
            int k = 0;
            for (int b = 1; b <= a; b++) {
                float OPT_real = e[b][a] + OPT[b - 1];
                if (OPT_real < min) {
                    min = OPT_real;
                    k = b;
                }
            }
            OPT[a] = (min + c);
            opt_segment[a] = k;
            a++;
        }

        Stack<Object> stack = new Stack<>();

        int i = N;
        while (i > 0) {
            stack.push(i);
            int j = opt_segment[i];
            stack.push(j);
            i = j - 1;
        }

        System.out.println("Cost of the optimal solution : " + OPT[N]);
        System.out.println();
        System.out.println("An optimal solution : ");
        while (!stack.empty()) {
            int alpha = (int) stack.peek();
            stack.pop();
            int beta = (int) stack.peek();
            stack.pop();
            System.out.println("Segment : " + alpha + " - " + beta + " with square error " + e[alpha][beta] + ".");
        }
        return OPT[N];
    }
}