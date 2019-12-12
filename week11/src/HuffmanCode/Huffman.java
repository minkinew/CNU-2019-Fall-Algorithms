package HuffmanCode;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Huffman {
    public static ArrayList<BitCode> bitCodeTable = new ArrayList<>();

    public static void makeDecodedFile(BufferedWriter decodedFile_bw, StringBuffer decodedData) throws IOException {
        decodedFile_bw.write(decodedData.toString());
        decodedFile_bw.close();
    }

    public static void makeDecodedData(BufferedReader encodedFile_br, StringBuffer decodedData, Trecord[] huffmanTree) throws IOException {
        String line;
        while ((line = encodedFile_br.readLine()) != null) {
            int pointer = 1;
            for (int i = 0; i < line.length(); i++) {
                char bit = line.charAt(i);
                if(bit == '0')
                    pointer *= 2;
                else if(bit == '1')
                    pointer = pointer * 2 + 1;
                if(huffmanTree[pointer] != null) {
                    decodedData.append(huffmanTree[pointer].alpha);
                    pointer = 1;
                }
            }
            decodedData.append("\n");
        }
    }

    public static void makeHuffmanTree(Trecord[] huffmanTree) {
        for (BitCode b : bitCodeTable) {
            int pointer = 1;
            for (int i = 0; i < b.code.length(); i++) {
                if (b.code.charAt(i) == '0')
                    pointer *= 2;
                else if (b.code.charAt(i) == '1')
                    pointer = pointer * 2 + 1;
                if (i == b.code.length() - 1) {
                    huffmanTree[pointer] = new Trecord(b.alpha);
                }
            }
        }
    }

    public static void inputTableInformation(BufferedReader tableFile_br) throws IOException {
        String line;
        while ((line = tableFile_br.readLine()) != null) {
            StringTokenizer stringTokenizer = new StringTokenizer(line, ",");
            char ch = stringTokenizer.nextToken().charAt(0);
            StringBuffer bitCode = new StringBuffer(stringTokenizer.nextToken());
            bitCodeTable.add(new BitCode(ch, bitCode));
        }
    }

    public static void addAllTrecordToMinHeap(int[] frequencyTable, MinHeap minHeap) {
        for (int i = 1; i <= 26; i++)
            if (frequencyTable[i] != 0)
                minHeap.add(new Trecord(numToChar(i), frequencyTable[i]));
    }

    public static void estimateFrequency(BufferedReader br_data, int[] frequencyTable, StringBuffer inputData) throws IOException {
        String line;
        while ((line = br_data.readLine()) != null) {
            inputData.append(line);
            for (int i = 0; i < line.length(); i++)
                frequencyTable[charToNum(line.charAt(i))]++;
        }
        br_data.close();
    }

    public static Trecord makeHuffmanTree(MinHeap minHeap) {
        while (!(minHeap.size() == 1)) {
            Trecord tNode = new Trecord();
            tNode.left = minHeap.poll();
            tNode.right = minHeap.poll();
            tNode.freq = tNode.left.freq + tNode.right.freq;
            minHeap.add(tNode);
        }

        return minHeap.poll();
    }

    public static void makeTableFile(BufferedWriter bw_table) throws IOException {
        bitCodeTable.sort((b1, b2) -> Character.compare(b1.alpha, b2.alpha));
        for (BitCode b : bitCodeTable)
            bw_table.write(b.toString() + "\n");
        bw_table.close();
    }

    public static void makeEncodedFile(BufferedWriter bw_encoded, StringBuffer inputData) throws IOException {
        for (int i = 0; i < inputData.length(); i++) {
            for (BitCode b : bitCodeTable) {
                if (inputData.charAt(i) == b.alpha) {
                    bw_encoded.write(String.valueOf(b.code));
                    break;
                }
            }
        }
        bw_encoded.close();
    }

    public static void makeHuffmanCode(Trecord tNode, StringBuffer buf) {
        if (isLeafNode(tNode))
            bitCodeTable.add(new BitCode(tNode.alpha, buf));

        if (hasLeftChild(tNode))
            makeHuffmanCode(tNode.left, new StringBuffer(buf + "0"));

        if (hasRightChild(tNode))
            makeHuffmanCode(tNode.right, new StringBuffer(buf + "1"));
    }

    public static boolean hasRightChild(Trecord tNode) {
        return tNode.right != null;
    }

    public static boolean hasLeftChild(Trecord tNode) {
        return tNode.left != null;
    }

    public static boolean isLeafNode(Trecord tNode) {
        return tNode.left == null && tNode.right == null;
    }

    public static int charToNum(char alpha) {
        if (alpha == ' ') return 0;
        return alpha - 'a' + 1;
    }

    public static char numToChar(int num) {
        return (char) (num + 'a' - 1);
    }

}