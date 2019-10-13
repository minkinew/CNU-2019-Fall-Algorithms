package Inversion;

import java.io.*;
import java.util.stream.Stream;

public class test {
    public static void main(String[] args) {
        try (FileReader fileReader = new FileReader(new File("./data04_inversion.txt"))) {
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String inputValue = bufferedReader.readLine();
            int[] numberArray = Stream.of(inputValue.split(",")).mapToInt(Integer::parseInt).toArray();
            inversion ic = new inversion();

            System.out.print("inversion counting 할 원소 : ");
            for (int i = 0; i <= numberArray.length - 1; i++)
                System.out.print(" " + numberArray[i]);
            System.out.println();

            System.out.println("Output Data : " + ic.mergeSort(numberArray, 0, numberArray.length - 1));

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
