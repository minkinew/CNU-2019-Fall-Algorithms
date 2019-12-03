public class Dijkstra {
    public static void dataGenerate(int[][] w) {
        int M = Integer.MAX_VALUE;

        w[0][0] = 0;
        w[0][1] = 10;
        w[0][2] = 3;
        w[0][3] = M;
        w[0][4] = M;

        w[1][0] = M;
        w[1][1] = 0;
        w[1][2] = 1;
        w[1][3] = 2;
        w[1][4] = M;

        w[2][0] = M;
        w[2][1] = 4;
        w[2][2] = 0;
        w[2][3] = 8;
        w[2][4] = 2;

        w[3][0] = M;
        w[3][1] = M;
        w[3][2] = M;
        w[3][3] = 0;
        w[3][4] = 7;

        w[4][0] = M;
        w[4][1] = M;
        w[4][2] = M;
        w[4][3] = 9;
        w[4][4] = 0;

    }

    public static char getCh(int ch) {
        return (char) (ch + 'A');
    }
}