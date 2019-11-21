package BellmanFord;

public class Bellman {
    Graph graph;

    public Bellman() {
    }

    public Bellman(String filePath) {
        graph = new Graph(filePath);
    }

    private boolean bellmanFord(Graph g, int start) {
        // Init
        int[] distance = new int[g.vertexs.length]; // start부터 해당 정점까지의 거리
        for (int index = 0; index < distance.length; ++index)
            distance[index] = Integer.MAX_VALUE;

        distance[start] = 0;
        int tempDistance;
        int src, dst, weight;

        System.out.println("==========iteration 0 ==========");

        for (int j = 0; j < g.edges.size(); ++j) {
            src = g.edges.get(j).getSource(); // u
            dst = g.edges.get(j).getDest(); // v
            weight = g.edges.get(j).getWeight(); // weight for that u to v
            if (distance[src] == Integer.MAX_VALUE) // 출발지점이 무한대이므로 계산x
                continue;

            tempDistance = distance[src] + weight;
            if (distance[dst] > tempDistance) {
                System.out.print("Update distance of " + dst + " from ");
                if (distance[dst] == Integer.MAX_VALUE)
                    System.out.println("inf to " + tempDistance);
                else
                    System.out.println(distance[dst] + " to " + tempDistance);

                distance[dst] = tempDistance;
            }
        }

        System.out.print("iteration 0 distance : [");
        for (int k = 0; k < g.vertexs.length - 1; ++k) {
            System.out.print(distance[k] + ", ");
        }
        System.out.println(distance[distance.length - 1] + "]");

        for (int i = 1; i < g.vertexs.length; ++i) {
            System.out.println("\n==========iteration " + i + " ==========");
            for (int j = 0; j < g.edges.size(); ++j) {
                src = g.edges.get(j).getSource();
                dst = g.edges.get(j).getDest();
                weight = g.edges.get(j).getWeight();
                tempDistance = distance[src] + weight;
                if (distance[dst] > tempDistance) {
                    System.out.print("Update distance of " + dst + " from ");
                    System.out.println(distance[dst] + " to " + tempDistance);
                    distance[dst] = tempDistance;
                }
            }
            System.out.print("iteration " + i + " distance : [");
            for (int k = 0; k < g.vertexs.length - 1; ++k) {
                System.out.print(distance[k] + ", ");
            }
            System.out.println(distance[distance.length - 1] + "]");
        }

        // 마지막 확인(cycle 확인)
        for (int j = 0; j < g.edges.size(); ++j) {
            src = g.edges.get(j).getSource();
            dst = g.edges.get(j).getDest();
            weight = g.edges.get(j).getWeight();
            tempDistance = distance[src] + weight;
            if (distance[dst] > tempDistance) {
                System.out.println("The graph has negative cycle");
                return false;
            }
        }
        System.out.print("\nFinal distance : [");
        for (int k = 0; k < g.vertexs.length - 1; ++k) {
            System.out.print(distance[k] + ", ");
        }
        System.out.println(distance[distance.length - 1] + "]");
        return true;
    }

    public void doBellmanFord(int startPoint) {
        this.bellmanFord(this.graph, startPoint);
    }
}