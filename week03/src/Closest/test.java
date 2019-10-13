package Closest;

import java.io.*;

public class test {
    public static void main(String args[]) throws IOException {
        InputStream inputStream = new FileInputStream("./data04_closest.txt");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        int n = 0;
        while (true) {
            String str = bufferedReader.readLine();
            if (str == null) break;
            n++;
        }
        double[] x = new double[n];
        double[] y = new double[n];

        InputStream inputStream2 = new FileInputStream("./data04_closest.txt");
        BufferedReader bufferedReader2 = new BufferedReader(new InputStreamReader(inputStream2));
        for (int i = 0; i < n; i++) {
            String str = bufferedReader2.readLine();
            String[] s = str.split(",");
            x[i] = Double.parseDouble(s[0]);
            y[i] = Double.parseDouble(s[1]);
        }

        closest c = new closest();
        c.quickSort(x, y, 0, n - 1);
        System.out.println("Output Data : " + c.closestPair(x, y, n));
    }

}
