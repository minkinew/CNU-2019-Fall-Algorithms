package MergeSort;

import java.io.*;
import java.util.stream.Stream;

public class test {
    public static void main(String[] args) {
        try (FileReader fileReader = new FileReader(new File("./data02.txt"))) {
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String inputValue = bufferedReader.readLine();
            int[] numberArray = Stream.of(inputValue.split(",")).mapToInt(Integer::parseInt).toArray();

            String fileName = "./hw01_06_201502023_merge.txt";
            FileWriter fileWriter = new FileWriter(fileName);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            StringBuilder sb = new StringBuilder();

            MergeSort m = new MergeSort();

            System.out.print("합병 정렬로 정렬할 원소 : ");
            for (int i = 0; i <= numberArray.length - 1; i++)
                System.out.print(" " + numberArray[i]);
            System.out.println();

            m.mergeSort(numberArray, 0, numberArray.length - 1);

            int cnt = 0;
            for (int value : numberArray) {
                if (cnt == numberArray.length - 1) {
                    sb.append(value + "," + cnt);
                } else {
                    sb.append(value + ",");
                }
                cnt++;
            }

            bufferedWriter.write(sb.toString());

            bufferedWriter.close();
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
