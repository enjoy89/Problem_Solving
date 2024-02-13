import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static class Node implements Comparable<Node> {
        int end, weight;

        public Node(int end, int weight) {
            this.end = end;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node n) {
            return this.weight - n.weight;
        }
    }

    static final int INF = Integer.MAX_VALUE;
    static int V, E, start;
    static ArrayList<Node>[] graph;
    static int[] distance;
    static boolean[] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        start = Integer.parseInt(br.readLine());

        graph = new ArrayList[V+1];
        distance = new int[V+1];
        visited = new boolean[V+1];

        for(int i=1; i<=V; i++) {
            graph[i] = new ArrayList<>();
        }

        // 최단 거리 배열 초기화
        Arrays.fill(distance, INF);

        for(int i=0; i<E; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph[u].add(new Node(v, w));
        }

        dijkstra(start);

        for(int i=1; i<=V; i++) {
            if(distance[i] == INF) {
                System.out.println("INF");
            } else {
                System.out.println(distance[i]);
            }
        }

    }

    public static void dijkstra(int start) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        pq.offer(new Node(start, 0));
        distance[start] = 0;

        while(!pq.isEmpty()) {
            Node curNode = pq.poll();

            visited[curNode.end] = true;

            for(int i=0; i<graph[curNode.end].size(); i++) {
                Node node = graph[curNode.end].get(i);

                if(!visited[node.end] && distance[node.end] > distance[curNode.end] + node.weight) {
                    distance[node.end] = distance[curNode.end] + node.weight;
                    pq.offer(new Node(node.end, distance[node.end]));
                }

            }
        }
    }
}


