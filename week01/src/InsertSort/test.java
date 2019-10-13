package InsertSort;

import java.io.*;
import java.util.stream.Stream;

public class test {
    public static void main(String[] args) {
        try (FileReader fileReader = new FileReader(new File("./data02.txt"))) {
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String inputValue = bufferedReader.readLine();
            int[] numberArray = Stream.of(inputValue.split(",")).mapToInt(Integer::parseInt).toArray();

            String fileName = "./hw01_06_201502023_insertion.txt";
            FileWriter fileWriter = new FileWriter(fileName);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            StringBuilder sb = new StringBuilder();
            InsertSort s = new InsertSort();

            System.out.print("삽입 정렬로 정렬할 원소 : ");
            for (int i = 0; i <= numberArray.length - 1; i++)
                System.out.print(" " + numberArray[i]);
            System.out.println();

            s.insert(numberArray);
            int cnt = 0;
            for (int value : numberArray) {
                if (cnt == numberArray.length - 1) {
                    sb.append(value);
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
