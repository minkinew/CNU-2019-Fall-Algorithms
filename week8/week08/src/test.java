import java.io.*;
import java.util.Scanner;

public class test {
    public static void main(String args[]) throws IOException {
        InputStream inputStream = new FileInputStream("./data09_knapsack.txt");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
        int n = 0;

        while (true) {
            String line = bufferedReader.readLine();
            if (line == null)
                break;
            n++;
        }

        int[][] array = new int[n][3];

        inputStream = new FileInputStream("./data09_knapsack.txt");
        bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        for (int i = 0; i < n; i++) {
            String line = bufferedReader.readLine();
            String[] stringArray = line.split(",");
            array[i][0] = Integer.parseInt(stringArray[0]); // item
            array[i][1] = Integer.parseInt(stringArray[1]); // value
            array[i][2] = Integer.parseInt(stringArray[2]); // weight
        }
        Scanner scanner = new Scanner(System.in);
        System.out.print("배낭의 사이즈를 입력하세요(0~50) : ");
        int number = scanner.nextInt();

        knapsack k = new knapsack(array, array.length, number);
        k.makeTable();
        k.showTable();
        k.findMax();
        k.findItems();
    }
}