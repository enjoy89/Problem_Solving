import java.io.*;
import java.util.*;

public class Main {

    static class Node implements Comparable<Node> {
        int vertex; // 도착 정점
        int cost;   // 거리

        public Node(int vertex, int cost) {
            this.vertex = vertex;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.cost, o.cost); // 오름차순 정렬
        }
    }

    static final int INF = Integer.MAX_VALUE;
    static int V, E, K;
    static List<Node>[] graph;
    static int[] dist;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken()); // 정점의 개수
        E = Integer.parseInt(st.nextToken()); // 간선의 개수
        K = Integer.parseInt(br.readLine());  // 시작 정점의 번호

        graph = new ArrayList[V+1];
        for(int i=1; i<=V; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i=0; i<E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[u].add(new Node(v, w));
        }

        dist = new int[V+1];
        Arrays.fill(dist, INF);
        dijkstra(K);
        for(int i=1; i<=V; i++) {
            if(dist[i] == INF) {
                System.out.println("INF");
            } else {
                System.out.println(dist[i]);
            }
        }
    }

    public static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.add(new Node(start, 0));
        dist[start] = 0;

        while(!pq.isEmpty()) {
            Node cur = pq.poll();
            if(cur.cost > dist[cur.vertex]) {
                continue;
            }

            for(Node next: graph[cur.vertex]) {
                int newCost = cur.cost + next.cost;
                if(newCost < dist[next.vertex]) {
                    dist[next.vertex] = newCost;
                    pq.add(new Node(next.vertex, newCost));
                }
            }
        }

    }
}
