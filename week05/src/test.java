import java.io.*;

public class test {
    public static void main(String args[]) throws IOException {
        quickSort q = new quickSort();
        int[] data = dataRead("data06.txt");
        String str = "";

        // quick sort output
        q.quickSort(data, 0, data.length - 1);
        str = str + data[0];
        for (int i = 1; i < data.length - 1; i++) {
            str = str + "," + data[i];
        }
        str = str + "," + data[data.length - 1];
        q.saveFile("week06_06_201502023_quick.txt", str);


        // Ramdomized quick sort output
        data = dataRead("data06.txt");
        q.quickSort_withRandom(data, 0, data.length - 1);
        str = str + data[0];
        for (int i = 1; i < data.length - 1; i++) {
            str = str + "," + data[i];
        }
        str = str + "," + data[data.length - 1];
        q.saveFile("week06_06_201502023_quickRandom.txt", str);
    }

    public static int[] dataRead(String fileName) throws IOException {
        InputStream inputStream = new FileInputStream(fileName);
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));

        String str = bufferedReader.readLine();
        String[] stringArray = str.split(",");
        int[] intArray = new int[stringArray.length];

        for (int i = 0; i < stringArray.length; i++) {
            intArray[i] = Integer.parseInt(stringArray[i]);
        }
        return intArray;
    }

}
