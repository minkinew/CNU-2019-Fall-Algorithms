package HuffmanCode;

import java.io.*;

public class Test {
    public static void main(String[] args) throws IOException {
        // Encoding
        BufferedReader br_data = new BufferedReader(new FileReader("data12.txt"));
        BufferedWriter bw_encoded = new BufferedWriter(new FileWriter("hw12_06_201502023_encoded.txt"));
        BufferedWriter bw_table = new BufferedWriter(new FileWriter("hw12_06_201502023_table.txt"));

        int[] frequencyTable = new int[27];
        MinHeap minHeap = new MinHeap();
        StringBuffer inputData = new StringBuffer();
        Huffman h = new Huffman();
        h.bitCodeTable.clear();

        h.estimateFrequency(br_data, frequencyTable, inputData);
        h.addAllTrecordToMinHeap(frequencyTable, minHeap);
        Trecord huffmanTree = h.makeHuffmanTree(minHeap);
        h.makeHuffmanCode(huffmanTree, new StringBuffer());
        h.makeTableFile(bw_encoded);
        h.makeEncodedFile(bw_table, inputData);

        System.out.println("Encoded Complete.");


        // Decoding
        BufferedReader br_encoded = new BufferedReader(new FileReader("data12_encoded.txt"));
        BufferedReader br_table = new BufferedReader(new FileReader("data12_table.txt"));
        BufferedWriter bw_decoded = new BufferedWriter(new FileWriter("hw12_06_201502023_decoded.txt"));

        StringBuffer decodedData = new StringBuffer();
        Trecord[] huffmanTree2 = new Trecord[100000];
        h.bitCodeTable.clear();

        h.inputTableInformation(br_table);
        h.makeHuffmanTree(huffmanTree2);
        h.makeDecodedData(br_encoded, decodedData, huffmanTree2);
        h.makeDecodedFile(bw_decoded, decodedData);

        System.out.println("Decoded Comelete.");
    }
}