import java.util.ArrayList;
import java.util.PriorityQueue;

public class DijkstraTest {

    static int[][] weights = {
            {1, 2, 7},
            {1, 3, 5},
            {1, 4, 3},
            {3, 4, 3},
            {3, 5, 3},
            {4, 5, 9},
            {4, 7, 7},
            {5, 3, 2},
            {5, 7, 1},
            {6, 2, 3},
            {6, 4, 1},
            {6, 7, 7}
    };

    public static void main(String[] args) {
        /* Simple Dijkstra */
        Dijkstra d = new Dijkstra(7);
        for (int[] w : weights) d.setGraph(w[0], w[1], w[2]);
//        d.printGraph();
        d.getShortestDistance(1);

        /* Improved Dijkstra */
        ImprovedDijkstra d2 = new ImprovedDijkstra(7);
        for (int[] w : weights) d2.setGraph(w[0], w[1], w[2]);
//        d2.printGraph();
        d2.getShortestDistance(1);
    }
}

class Dijkstra {
    private int N;
    private int[][] graph;

    private final static int INF = Integer.MAX_VALUE;
    private int[] D;
    private boolean[] visited;

    public Dijkstra(int N) {
        this.N = N;
        graph = new int[N+1][N+1];
        D = new int[N+1];
        visited = new boolean[N+1];
    }

    public void setGraph(int i, int j, int w) {
        graph[i][j] = w;
    }

    public void printGraph() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
    }

    public void getShortestDistance(int S) {
        /* init */
        for (int i = 1; i <= N; i++) {
            if (i != S) D[i] = INF;
        }

        /* 출발 정점 초기화 */
        visited[S] = true;
        for (int i = 1; i <= N; i++) {
            if (i != S && graph[S][i] > 0) D[i] = graph[S][i];
        }

        /* dijkstra */
        for (int i = 0; i < N-1; i++) {
            int current = getNextNode();
            visited[current] = true;
            for (int j = 1; j <= N; j++) {
                if (graph[current][j] > 0) {
                    D[j] = Math.min(D[j], D[current] + graph[current][j]);
                }
            }
        }

        printDistance();
    }

    private int getNextNode() {
        int min_value = INF;
        int node_idx = 0;
        for (int i = 1; i <= N; i++) {
            if (!visited[i] && D[i] < min_value) {
                min_value = D[i];
                node_idx = i;
            }
        }
        return node_idx;
    }

    private void printDistance() {
        for (int i = 1; i <= N; i++) {
            if (D[i] == INF) System.out.print("∞ ");
            else System.out.print(D[i] + " ");
        }
        System.out.println();
    }
}

class ImprovedDijkstra {
    private int N;
    private ArrayList<Node>[] graph;

    private final static int INF = Integer.MAX_VALUE;
    private int[] D;

    public ImprovedDijkstra(int N) {
        this.N = N;
        graph = new ArrayList[N+1];
        for (int i = 1; i <= N; i++) graph[i] = new ArrayList<>();
        D = new int[N+1];
        for (int i = 1; i <= N; i++) D[i] = INF;
    }

    public void setGraph(int i, int j, int w) {
        graph[i].add(new Node(j, w));
    }

    public void printGraph() {
        for (int i = 1; i <= N; i++) {
            for (Node n : graph[i]) {
                System.out.println(i + " --" + n.distance + "--> " + n.index);
            }
        }
    }

    public void getShortestDistance(int S) {
        PriorityQueue<Node> pq = new PriorityQueue<>(((o1, o2) -> o1.distance - o2.distance));

        D[S] = 0;
        pq.offer(new Node(S, 0));

        while (!pq.isEmpty()) {
            Node current = pq.poll();
            if (current.distance > D[current.index]) continue;

            for (Node next : graph[current.index]) {
                if (D[next.index] > D[current.index] + next.distance) {
                    D[next.index] = D[current.index] + next.distance;
                    pq.offer(new Node(next.index, D[next.index]));
                }
            }
        }

        printDistance();
    }

    private void printDistance() {
        for (int i = 1; i <= N; i++) {
            if (D[i] == INF) System.out.print("∞ ");
            else System.out.print(D[i] + " ");
        }
        System.out.println();
    }

    static class Node {
        int index;
        int distance;

        public Node(int index, int distance) {
            this.index = index;
            this.distance = distance;
        }
    }
}