import java.io.*;
import java.util.*;

public class Main {
    public static class Node implements Comparable<Node> {
        int vertex;
        int cost;

        public Node(int vertex, int cost) {
            this.vertex = vertex;
            this.cost = cost;
        }

        @Override
        public int compareTo(Node o) {
            return Integer.compare(this.cost, o.cost);
        }
    }

    static final int INF = Integer.MAX_VALUE;
    static int N, E;
    static List<Node>[] graph;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken()); // 정점의 개수
        E = Integer.parseInt(st.nextToken()); // 간선의 개수
        graph = new ArrayList[N+1];
        for(int i=1; i<N+1; i++) {
            graph[i] = new ArrayList<>();
        }

        for(int i=0; i<E; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            // 양방향 추가
            graph[a].add(new Node(b, c));
            graph[b].add(new Node(a, c));
        }

        // 반드시 거쳐야 하는 두 개의 정점
        st = new StringTokenizer(br.readLine());
        int v1 =  Integer.parseInt(st.nextToken());
        int v2 =  Integer.parseInt(st.nextToken());

        int[] dist1 = dijkstra(1);
        int[] distV1 = dijkstra(v1);
        int[] distV2 = dijkstra(v2);

        // 1 -> v1 -> v2 -> N
        long route1 = (long) dist1[v1] + distV1[v2] + distV2[N];
        // 1 -> v2 -> v1 -> N
        long route2 = (long) dist1[v2] + distV2[v1] + distV1[N];
        long answer = Math.min(route1, route2);

        if(answer >= INF) {
            answer = -1;
        }
        System.out.println(answer);

    }

    public static int[] dijkstra(int start) {
        int[] dist = new int[N+1];
        Arrays.fill(dist, INF);
        PriorityQueue<Node> pq = new PriorityQueue<>();

        dist[start] = 0;
        pq.offer(new Node(start, 0));

        while(!pq.isEmpty()) {
            Node cur = pq.poll();
            if(cur.cost < dist[cur.vertex]) {
                continue;
            }

            for(Node next : graph[cur.vertex]) {
                int newCost = cur.cost + next.cost;
                if(newCost < dist[next.vertex]) {
                    dist[next.vertex] = newCost;
                    pq.add(new Node(next.vertex, newCost));
                }
            }
        }
        return dist;
    }
}
