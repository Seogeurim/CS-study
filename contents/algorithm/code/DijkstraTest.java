public class DijkstraTest {

    public static void main(String[] args) {
        Dijkstra d = new Dijkstra(7);
        d.setGraph(1, 2, 7);
        d.setGraph(1, 3, 5);
        d.setGraph(1, 4, 3);
        d.setGraph(3, 4, 3);
        d.setGraph(3, 5, 3);
        d.setGraph(4, 5, 9);
        d.setGraph(4, 7, 7);
        d.setGraph(5, 3, 2);
        d.setGraph(5, 7, 1);
        d.setGraph(6, 2, 3);
        d.setGraph(6, 4, 1);
        d.setGraph(6, 7, 7);

//        d.printGraph();
        d.getShortestDistance(1);
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