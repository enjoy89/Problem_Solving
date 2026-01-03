import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	static List<Integer>[] connected;
	static int[] size;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(st.nextToken());
		int Q = Integer.parseInt(st.nextToken());

		connected = new ArrayList[N + 1];
		for (int i = 0; i <= N; i++) {
			connected[i] = new ArrayList<>();
		}

		for (int i = 0; i < N - 1; i++) {
			st = new StringTokenizer(br.readLine());
			int u = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());

			connected[u].add(v);
			connected[v].add(u);
		}
		size = new int[N + 1];
		countSubtreeNodes(R, -1);

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < Q; i++) {
			int U = Integer.parseInt(br.readLine());
			sb.append(size[U]).append('\n');
		}

		System.out.println(sb);
	}

	// public static void makeTree(int currentNode, int parent) {
	// 	for (int node : connected[currentNode]) {
	// 		if (node != parent) {
	// 			tree.add(new Node(currentNode, node)); // Node(parent, child)
	// 			makeTree(node, currentNode);
	// 		}
	// 	}
	// }

	public static void countSubtreeNodes(int currentNode, int parent) {
		size[currentNode] = 1;

		for (int next : connected[currentNode]) {
			if (next != parent) {
				countSubtreeNodes(next, currentNode);
				size[currentNode] += size[next];
			}
		}
	}
}
