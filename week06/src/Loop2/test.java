package Loop2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class test {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("./data07_a.txt"));
        String s = bufferedReader.readLine();
        StringTokenizer tokenizer = new StringTokenizer(s, ",");

        BufferedReader bufferedReader2 = new BufferedReader(new FileReader("./data07_b.txt"));
        String s2 = bufferedReader2.readLine();
        StringTokenizer tokenizer2 = new StringTokenizer(s2, ",");

        int a[] = new int[tokenizer.countTokens()];
        int i = 0;
        while (tokenizer.hasMoreTokens()) {
            int n = Integer.parseInt(tokenizer.nextToken().trim());
            a[i++] = n;
        }

        int b[] = new int[tokenizer2.countTokens()];
        int j = 0;
        while (tokenizer2.hasMoreTokens()) {
            int n2 = Integer.parseInt(tokenizer2.nextToken().trim());
            b[j++] = n2;
        }

        invariant inv = new invariant();
        int result = inv.sort(a, b);
        System.out.print(result);
    }
}
