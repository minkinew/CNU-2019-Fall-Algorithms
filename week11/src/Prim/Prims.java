package Prim;

public class Prims {
    public static void main(String args[]) {
        Minheap minheap = new Minheap();
        int[][] graph = new int[9][9];
        int currentIndex = 0;
        boolean[] visitedIndex = new boolean[9];
        int currentVertex;
        int numOfVisit = 0;
        char v1, v2;
        int totalWeight = 0;

        setGraph(graph);
        for (int i = 0; i < 9; i++)
            visitedIndex[i] = false;
        visitedIndex[0] = true;

        for (int i = currentIndex; i < 9; i++)
            if (graph[currentIndex][i] != 0)
                minheap.insert(graph[currentIndex][i]);
        numOfVisit++;
        System.out.println("w< ," + vertexName(0) + "> = " + 0);

        while (numOfVisit != 9) {
            currentVertex = minheap.extractMin();
            totalWeight += currentVertex;
            int[] vertexPair = findVertex(graph, currentVertex, visitedIndex);
            v1 = vertexName(vertexPair[0]);
            v2 = vertexName(vertexPair[1]);
            printPair(v1, v2, currentVertex);
            visitedIndex[vertexPair[1]] = true;
            minheap = new Minheap();
            for (int i = 0; i < 9; i++)
                for (int j = 0; j < 9; j++)
                    if (visitedIndex[i])
                        if (!visitedIndex[j] && graph[i][j] != 0)
                            minheap.insert(graph[i][j]);
            numOfVisit++;
        }

        System.out.println("\nw<MST> = " + totalWeight);
    }

    public static void setGraph(int[][] graph) {
        /*
             [a] [b] [c] [d] [e] [f] [g] [h] [i]
          [a] 0   4   0   0   0   0   0   8   0
          [b] 4   0   8   0   0   0   0   11  0
          [c] 0   8   0   7   0   4   0   0   2
          [d] 0   0   7   0   9   14  0   0   0
          [e] 0   0   0   9   0   10  0   0   0
          [f] 0   0   4   14  10  0   2   0   0
          [g] 0   0   0   0   0   2   0   1   6
          [h] 8   11  0   0   0   0   1   0   7
          [i] 0   0   2   0   0   0   6   7   0
         */
        for (int i = 0; i < 9; i++)
            for (int j = 0; j < 9; j++)
                graph[i][j] = 0;

        graph[0][1] = 4;
        graph[1][0] = 4;
        graph[0][7] = 8;
        graph[7][0] = 8;
        graph[1][2] = 8;
        graph[2][1] = 8;
        graph[1][7] = 11;
        graph[7][1] = 11;
        graph[2][3] = 7;
        graph[3][2] = 7;
        graph[2][5] = 4;
        graph[5][2] = 4;
        graph[2][8] = 2;
        graph[8][2] = 2;
        graph[3][4] = 9;
        graph[4][3] = 9;
        graph[3][5] = 14;
        graph[5][3] = 14;
        graph[4][5] = 10;
        graph[5][4] = 10;
        graph[5][6] = 2;
        graph[6][5] = 2;
        graph[6][7] = 1;
        graph[7][6] = 1;
        graph[6][8] = 6;
        graph[8][6] = 6;
        graph[7][8] = 7;
        graph[8][7] = 7;
    }

    public static int[] findVertex(int[][] graph, int currentVertex, boolean[] visitedIndex) {
        for (int i = 0; i < 9; i++) {
            if (visitedIndex[i]) {
                for (int j = 0; j < 9; j++) {
                    if (graph[i][j] == currentVertex && !visitedIndex[j]) {
                        int[] vertexPair = new int[2];
                        vertexPair[0] = i;
                        vertexPair[1] = j;
                        return vertexPair;
                    }
                }
            }
        }
        return null;
    }

    public static char vertexName(int num) {
        return (char) (num + 'a');
    }

    public static void printPair(char v1, char v2, int edge) {
        System.out.println("w<" + v1 + "," + v2 + "> = " + edge);
    }
}