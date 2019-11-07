import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class test {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new FileReader("./data08.txt"));
        String line = bufferedReader.readLine();
        StringTokenizer str = new StringTokenizer(line, ",");
        float[] M = new float[str.countTokens()];
        int n = 0;
        while (str.hasMoreTokens()) {
            double num = Double.parseDouble(str.nextToken().trim());
            M[n++] = (float) num;
        }
        SLS s = new SLS();
        s.SegmentedLeastSquares(M);
    }

}
