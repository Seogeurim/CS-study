import java.util.ArrayList;

public class BellmanFordTest {

    public static void main(String[] args) {
        BellmanFord bf = new BellmanFord(5);
        bf.addEdge(3, 5, 3);
        bf.addEdge(3, 4, 3);
        bf.addEdge(4, 2, 3);
        bf.addEdge(5, 3, 2);
        bf.addEdge(4, 5, -6);
        bf.addEdge(1, 4, 3);
        bf.addEdge(1, 3, 5);
        bf.addEdge(1, 2, 7);

//        bf.printEdges();
        bf.getShortestDistance(1);
    }
}

class BellmanFord {
    private int N;
    private ArrayList<Edge> edges;

    private final static int INF = Integer.MAX_VALUE;
    private int[] D;

    public BellmanFord(int N) {
        this.N = N;
        edges = new ArrayList<>();
        D = new int[N+1];
    }

    public void addEdge(int from, int to, int weight) {
        edges.add(new Edge(from, to, weight));
    }

    public void printEdges() {
        for (Edge edge : edges) System.out.println(edge);
    }

    public void getShortestDistance(int S) {
        /* init */
        for (int i = 1; i <= N; i++) {
            if (i != S) D[i] = INF;
        }

        /* Bellman-Ford */
        boolean negCycle = false;
        for (int i = 1; i <= N; i++) {
            for (Edge edge : edges) {
                int from = edge.from;
                int to = edge.to;
                int weight = edge.weight;
                if (D[from] != INF && D[to] > D[from] + weight) {
                    if (i == N) {
                        negCycle = true;
                        break;
                    }
                    D[to] = D[from] + weight;
                }
            }
        }

        if (negCycle) System.out.println("음의 사이클이 존재합니다.");
        else printDistance();
    }

    private void printDistance() {
        for (int i = 1; i <= N; i++) {
            if (D[i] == INF) System.out.print("∞ ");
            else System.out.print(D[i] + " ");
        }
        System.out.println();
    }

    static class Edge {
        private int from;
        private int to;
        private int weight;

        private Edge(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }

        @Override
        public String toString() {
            return from + " --(" + weight + ")--> " + to;
        }
    }
}
