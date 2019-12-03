import java.util.PriorityQueue;

public class Test {
    public static void main(String args[]) {
        int M = Integer.MAX_VALUE;
        MinHeap minHeap = new MinHeap();
        int[][] w = new int[5][5];
        int[] d = new int[5];
        boolean[] S = new boolean[5];
        boolean[] V = new boolean[5];

        int s = 0;

        Dijkstra.dataGenerate(w);

        System.out.println("dijkstra's algorithm으로 계산한 결과는 다음과 같습니다.");

        for (int i = 0; i < d.length; i++) {
            d[i] = M;
            S[i] = false;
            V[i] = true;
        }
        d[s] = 0;

        for (int i = 0; i < V.length; i++) {
            if (V[i]) {
                int[] temp = new int[2];
                temp[0] = i;
                temp[1] = d[i];
                minHeap.add(temp);
            }
        }

        int Sindex = 0;
        int Qindex = 0;
        while (minHeap.size() != 0) {
            int[] element = minHeap.delete();
            int u = element[0];
            int distanceOfU = element[1];
            S[u] = true;
            System.out.println("________________________________________________");
            System.out.print("S[" + Sindex + "] :  d[");
            System.out.print(Dijkstra.getCh(u));
            System.out.println("] = " + distanceOfU);
            System.out.println("------------------------------------------------");

            for (int i = 0; i < minHeap.size(); i++) {
                int[][] temp = minHeap.getArray();
                System.out.print("Q[" + i + "] : d[" + Dijkstra.getCh(temp[i][0]) + "] = " + d[temp[i][0]]);
                if (w[u][temp[i][0]] != M) {
                    if (d[temp[i][0]] > d[u] + w[u][temp[i][0]]) {
                        System.out.print("   ->   d[" + Dijkstra.getCh(temp[i][0]) + "] = " + (d[u] + w[u][temp[i][0]]));
                    }
                }
                System.out.println();
            }
            System.out.println();

            for (int i = 0; i < w[u].length; i++) {
                if (w[u][i] != M) {
                    if (d[i] > d[u] + w[u][i]) {
                        d[i] = d[u] + w[u][i];
                        int[][] elementOfQ = minHeap.getArray();
                        int[] updateElement = new int[2];
                        updateElement[0] = i;
                        updateElement[1] = d[i];
                        for (int searchIndex = 0; searchIndex < minHeap.size(); ++searchIndex) {
                            if (elementOfQ[searchIndex][0] == i)
                                minHeap.setElement(searchIndex, updateElement);
                        }

                    }
                }
            }
            minHeap.buildMinHeap();

            Sindex++;
            V[u] = false;
            Qindex++;
        }

    }
}
