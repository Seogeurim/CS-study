public class FloydWarshallTest {

    public static void main(String[] args) {
        FloydWarshall fw = new FloydWarshall(5);
        fw.setWeight(1, 3, 5);
        fw.setWeight(1, 2, 7);
        fw.setWeight(1, 4, -3);
        fw.setWeight(3, 4, 3);
        fw.setWeight(3, 5, 3);
        fw.setWeight(4, 2, 3);
        fw.setWeight(4, 5, 6);
        fw.setWeight(5, 3, 2);

        fw.getShortestDistance();
    }
}

class FloydWarshall {
    private int N;
    private int[][] D;
    private final static int INF = Integer.MAX_VALUE;

    public FloydWarshall(int N) {
        this.N = N;
        D = new int[N+1][N+1];
        initDistance();
    }

    private void initDistance() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (i != j) D[i][j] = INF;
            }
        }
    }

    public void setWeight(int i, int j, int w) {
        D[i][j] = w;
    }

    public void getShortestDistance() {
        /* Floyd-Warshall */
        for (int k = 1; k <= N; k++){
            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if (D[i][k] == INF || D[k][j] == INF) continue;
                    D[i][j] = Math.min(D[i][j], D[i][k] + D[k][j]);
                }
            }
        }

        printDistance();
    }

    private void printDistance() {
        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N; j++) {
                if (D[i][j] == INF) System.out.print("∞ ");
                else System.out.print(D[i][j] + " ");
            }
            System.out.println();
        }
    }
}
