package BellmanFord;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Graph{
    int[] vertexs;
    ArrayList<Edge> edges;

    public Graph() {
    }

    public Graph(String filePath) {
        BufferedReader br;
        try {
            br = new BufferedReader(new FileReader(filePath));
            edges = new ArrayList<>();
            String line = br.readLine();
            String[] splittedData;
            int[] data = new int[3];
            Edge addedEdge;
            if (line != null) {
                splittedData = line.split(",");
                vertexs = new int[splittedData.length];
                for(int index = 0; index < splittedData.length; ++index)
                    vertexs[index] = Integer.parseInt(splittedData[index]);

                line = br.readLine();
            }
            int src, dst, weight;
            while (line != null) {
                splittedData = line.split(",");
                for(int i = 0; i < 3; ++i)
                    data[i] = Integer.parseInt(splittedData[i]);

                src = data[0];
                dst = data[1];
                weight = data[2];
                addedEdge = new Edge(src, dst, weight);
                edges.add(addedEdge);
                line = br.readLine();
            }

            br.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public class Edge {
        int source, dest, weight;

        public Edge() {}

        public Edge(int source, int dest, int weight) {
            this.source = source;
            this.dest = dest;
            this.weight = weight;
        }

        public int getSource() {
            return source;
        }

        public void setSource(int source) {
            this.source = source;
        }

        public int getDest() {
            return dest;
        }

        public void setDest(int dest) {
            this.dest = dest;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }
    }
}
