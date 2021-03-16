import java.util.PriorityQueue;

public class KruskalTest {

    public static void main(String[] args) {
        Kruskal kruskal = new Kruskal();

        kruskal.setV(3);
        kruskal.setEdges(1, 2, 1);
        kruskal.setEdges(2, 3, 2);
        kruskal.setEdges(1, 3, 3);

        System.out.println(kruskal.getMSTCost());
    }
}

class Kruskal {

    private int V;
    private PriorityQueue<Edge> pq;
    private int[] root;

    public Kruskal() {
        pq = new PriorityQueue<>(((o1, o2) -> o1.c - o2.c));
    }

    public void setV(int v) {
        V = v;
        setRoot();
    }

    public void setEdges(int a, int b, int c) {
        pq.offer(new Edge(a, b, c));
    }

    private void setRoot() {
        root = new int[V+1];
        for (int i = 1; i <= V; i++) root[i] = i;
    }

    public int getMSTCost() {
        int cost = 0;
        while (!pq.isEmpty()) {
            Edge e = pq.poll();
            if (find(e.a) == find(e.b)) continue;
            merge(e.a, e.b);
            cost += e.c;
        }
        return cost;
    }

    private int find(int n) {
        if (root[n] == n) return n;
        return root[n] = find(root[n]);
    }

    private void merge(int a, int b) {
        root[find(b)] = find(a);
    }

    static class Edge {
        int a, b, c;

        public Edge(int a, int b, int c) {
            this.a = a;
            this.b = b;
            this.c = c;
        }
    }
}