package MatrixChainMultiplication;

import java.io.*;
import java.util.ArrayList;

public class test {
    public static void main(String args[]) throws IOException {
        ArrayList<Integer> arrayList = new ArrayList<>();
        InputStream inputStream = new FileInputStream("./data10_matrix_chain.txt");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        String input = bufferedReader.readLine();
        int n = 0;

        if (input != null) {
            arrayList.add(Integer.parseInt(input.split(",")[0]));
            arrayList.add(Integer.parseInt(input.split(",")[1]));
            n = n + 2;
        }

        while (true) {
            input = bufferedReader.readLine();
            if (input == null)
                break;
            arrayList.add(Integer.parseInt(input.split(",")[1]));
            n++;
        }

        int[] p = new int[n];

        for (int i = 0; i < p.length; i++)
            p[i] = arrayList.get(i);

        int[][] m = new int[n][n];

        matrixChainMultiplication matrix = new matrixChainMultiplication();
        matrix.matrixChainInit(m);
        matrix.matrixChainTable(p, m);
        System.out.println("========= Matrix Chain Multiplication Table =========");
        System.out.println();
        matrix.matrixChainShow(m);
    }
}