import java.io.*;
import java.util.*;

public class Main {
	static class Node implements Comparable<Node> {
		int vertex;
		int distance;

		Node(int vertex, int distance) {
			this.vertex = vertex;
			this.distance = distance;
		}

		@Override
		public int compareTo(Node o) {
			return this.distance - o.distance;
		}
	}

	static List<List<Node>> graph;
	static int[] dist; // 최소 비용을 저장
	static int[] route; // 지나온 경로를 저장
	static final int INF = Integer.MAX_VALUE;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		int m = Integer.parseInt(br.readLine());

		graph = new ArrayList<>();
		for (int i = 0; i < n + 1; i++) {
			graph.add(new ArrayList<>());
		}
		dist = new int[n + 1];
		route = new int[n + 1];
		Arrays.fill(dist, INF);
		Arrays.fill(route, -1);

		StringTokenizer st;
		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int start = Integer.parseInt(st.nextToken());
			int end = Integer.parseInt(st.nextToken());
			int distance = Integer.parseInt(st.nextToken());
			graph.get(start).add(new Node(end, distance));
		}
		st = new StringTokenizer(br.readLine());
		int start = Integer.parseInt(st.nextToken());
		int end = Integer.parseInt(st.nextToken());

		dijkstra(start);

		List<Integer> path = new ArrayList<>();
		int cur = end;
		while (cur != -1) {
			path.add(cur);
			if (cur == start) {
				break;
			}
			cur = route[cur];
		}

		Collections.reverse(path);

		StringBuilder sb = new StringBuilder();
		sb.append(dist[end]).append("\n");
		sb.append(path.size()).append("\n");
		for (int i : path) {
			sb.append(i).append(" ");
		}

		sb.append("\n");
		System.out.println(sb);
	}

	public static void dijkstra(int start) {
		PriorityQueue<Node> pq = new PriorityQueue<>();
		pq.offer(new Node(start, 0));
		dist[start] = 0;

		while (!pq.isEmpty()) {
			Node cur = pq.poll();
			if (cur.distance > dist[cur.vertex]) {
				continue;
			}
			for (Node next : graph.get(cur.vertex)) {
				int newDistance = cur.distance + next.distance;
				if (newDistance < dist[next.vertex]) {
					dist[next.vertex] = newDistance;
					route[next.vertex] = cur.vertex;
					pq.offer(new Node(next.vertex, newDistance));
				}
			}

		}
	}
}
