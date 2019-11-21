package BellmanFord;
public class Test {
    public static void main(String[] args) {
        Bellman firstBellman = new Bellman("./data10_bellman_ford_1.txt");
        Bellman secondBellman = new Bellman("./data10_bellman_ford_2.txt");

        System.out.println("========== data10_bellman_ford_1 ==========");
        firstBellman.doBellmanFord(0);
        System.out.println("\n\n========== data10_bellman_ford_2 ==========");
        secondBellman.doBellmanFord(0);
    }
}