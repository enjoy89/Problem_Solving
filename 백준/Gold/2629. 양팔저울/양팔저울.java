import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	static int N;
	static boolean[][] visited;
	static boolean[] possible;
	static int[] weight;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		N = Integer.parseInt(br.readLine()); // 추의 개수
		weight = new int[N];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			weight[i] = Integer.parseInt(st.nextToken());
		}

		visited = new boolean[N + 1][15001];
		possible = new boolean[15001];

		dfs(0, 0);

		int M = Integer.parseInt(br.readLine()); // 구슬의 개수
		st = new StringTokenizer(br.readLine());
		StringBuilder sb = new StringBuilder();

		for (int i = 0; i < M; i++) {
			int target = Integer.parseInt(st.nextToken());
			if (target > 15000) {
				sb.append("N").append(' ');
			} else {
				sb.append(possible[target] ? "Y" : "N").append(' ');
			}
		}
		
		System.out.println(sb);
	}

	public static void dfs(int count, int pointer) {
		if (pointer > 15000) {
			return;
		}

		if (visited[count][pointer]) {
			return;
		}
		visited[count][pointer] = true;
		possible[pointer] = true;

		if (count == N) {
			return;
		}

		dfs(count + 1, pointer);
		dfs(count + 1, pointer + weight[count]);
		dfs(count + 1, Math.abs(pointer - weight[count]));

	}
}
